package com.biz.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.entity.MyJedis;
import com.biz.entity.Student;

import redis.clients.jedis.Jedis;

public class UpDateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		String id = req.getParameter("id");
		Jedis jedis = MyJedis.getMyJedis();
		Map<String, String> map = jedis.hgetAll(id);
		if (map != null) {
			String name = map.get("name");
			String birthday = map.get("birthday");
			String description = map.get("description");
			String avgscore = map.get("avgscore");
			MyJedis.closeJedis();
			Student student = new Student(id, name, birthday, description, avgscore);
			req.setAttribute("student", student);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/update.jsp");
			dispatcher.forward(req, resp);
		}

	}
}
