package com.icss.hr.job.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;

/**
 * 查询职务信息
 * @author Administrator
 *
 */
@WebServlet("/QueryJobServlet")
public class QueryJobServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置编码
		response.setContentType("text/html;charset=utf-8");
		
		//获得输出流
		PrintWriter out = response.getWriter();
		
		//调用业务功能
		JobService service = new JobService();
		
		//获得数据集合
		try {
			ArrayList<Job> list = service.queryJob();
			
			//json转换
			Gson gson = new Gson();
			String jsonStr = gson.toJson(list);
			out.print(jsonStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
