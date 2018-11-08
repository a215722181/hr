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
 * ��ѯ����ְ������
 * @author Administrator
 *
 */
@WebServlet("/GetJobServlet")
public class GetJobServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//���ñ���
		response.setContentType("text/html;charset=utf-8");
		
		//��ò���id
		String jobId = request.getParameter("jobId");
		
		//��������
		PrintWriter out = response.getWriter();
		
		//����ҵ����
		JobService service = new JobService();
		
		try {
			Job job = service.queryJobById(Integer.parseInt(jobId));
			
			//ת��Ϊjson
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
