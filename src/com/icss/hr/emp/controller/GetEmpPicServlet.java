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
 * 通过用户名返回员工头像base64数据
 */
@WebServlet("/GetEmpPicServlet")
public class GetEmpPicServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		//获得当前用户的用户名
		HttpSession session = request.getSession();
		String empLoginName = (String) session.getAttribute("empLoginName");
		
		//调用业务功能
		EmpService service = new EmpService();
		
		try {
			//响应base64头像数据到前端
			String empPic = service.queryEmpPic(empLoginName);
			
			out.print(empPic);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
