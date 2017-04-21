package com.biz.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.biz.entity.MyJedis;

import redis.clients.jedis.Jedis;

public class UpDateResultServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String birthday = req.getParameter("birthday");
		String description = req.getParameter("description");
		String avgscore = req.getParameter("avgscore");
		req.setAttribute("title", "修改结果");
		if (StringUtils.isBlank(id) || StringUtils.isBlank(name)
				|| StringUtils.isBlank(birthday)
				|| StringUtils.isBlank(description)
				|| StringUtils.isBlank(avgscore)) {
			req.setAttribute("result", "存在为空的请求参数");
		}else{
			Jedis jedis = MyJedis.getMyJedis();
			Double ismember = jedis.zscore("students", id);
			if (ismember == null) {
				req.setAttribute("result", "该学生已被删除");
			}else{
				jedis.zadd("students", Double.parseDouble(avgscore),id);
				jedis.hset(id, "name", name);
				jedis.hset(id, "birthday", birthday);
				jedis.hset(id, "description", description);
				jedis.hset(id, "avgscore", avgscore);
				req.setAttribute("result", "该学生的信息已成功更新");
			}
			MyJedis.closeJedis();
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/result.jsp");
		dispatcher.forward(req, resp);
	}
}
