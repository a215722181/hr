package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.hr.emp.service.EmpService;

/**
 * 用户登录
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		// 获得用户名和密码
		String empLoginName = request.getParameter("empLoginName");
		String empPwd = request.getParameter("empPwd");

		// 调用业务层
		EmpService service = new EmpService();

		try {
			// 返回登录结果数字
			int result = service.checkLogin(empLoginName, empPwd);

			// 判断如果登录成功，在session中存储用户名
			if (result == 3) {
				HttpSession session = request.getSession();
				session.setAttribute("empLoginName", empLoginName);

			}

			out.print(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
