package com.icss.hr.job.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;

/**
 * 查询单条职务数据
 * @author Administrator
 *
 */
@WebServlet("/GetJobServlet")
public class GetJobServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置编码
		response.setContentType("text/html;charset=utf-8");
		
		//获得部门id
		String jobId = request.getParameter("jobId");
		
		//获得输出流
		PrintWriter out = response.getWriter();
		
		//调用业务功能
		JobService service = new JobService();
		
		try {
			Job job = service.queryJobById(Integer.parseInt(jobId));
			
			//转换为json
			Gson gson = new Gson();
			String jsonStr = gson.toJson(job);
			out.print(jsonStr);
			
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
