package com.biz.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.entity.MyJedis;

import redis.clients.jedis.Jedis;

public class DeleteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		String id = req.getParameter("id");
		if (id != null) {
			req.setAttribute("title", "删除结果");
			Jedis jedis = MyJedis.getMyJedis();
			jedis.zrem("students", id);
			jedis.del(id);
			MyJedis.closeJedis();
			req.setAttribute("result", "该学生的信息已成功删除.");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/result.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
