package com.biz.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.biz.entity.MyJedis;
import com.biz.entity.Student;

import redis.clients.jedis.Jedis;

public class InfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		String spage = req.getParameter("page");
		int page = Integer.parseInt(StringUtils.isBlank(spage) ? "1" : spage);
		Jedis jedis = MyJedis.getMyJedis();
		Long zcard = jedis.zcard("students");
		if (zcard > 0) {
			long pageCount = (zcard%10 == 0 ? zcard/10 : zcard/10 + 1);
			req.setAttribute("pageCount", pageCount);
			Set<String> ids = jedis.zrevrange("students", (page - 1) * 10, page * 10 - 1);
			List<Student> students = new ArrayList<Student>();
			for (String id : ids) {
				Map<String, String> map = jedis.hgetAll(id);
				String name = map.get("name");
				String birthday = map.get("birthday");
				String description = map.get("description");
				String avgscore = map.get("avgscore");
				Student student = new Student(id, name, birthday, description, avgscore);
				students.add(student);
				req.setAttribute("students", students);
			}
		} else {
			req.setAttribute("pageCount", 0);
		}
		MyJedis.closeJedis();
		RequestDispatcher rd = req.getRequestDispatcher("/info.jsp");
		rd.forward(req, resp);
	}
}
