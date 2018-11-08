package com.icss.hr.job.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;

/**
 * 更新职务数据
 */
@WebServlet("/UpdateJobServlet")
public class UpdateJobServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置编码
		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		
		//获得参数信息
		String jobId = request.getParameter("jobId");
		String jobName = request.getParameter("jobName");
		String jobMaxSal = request.getParameter("jobMaxSal");
		String jobMinSal = request.getParameter("jobMinSal");
		
		//封装为pojo对象
		Job job = new Job(Integer.parseInt(jobId), jobName, Integer.parseInt(jobMinSal), Integer.parseInt(jobMaxSal));
		
		//调用业务功能
		JobService service = new JobService();
		
		try {
			service.updateJob(job);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
