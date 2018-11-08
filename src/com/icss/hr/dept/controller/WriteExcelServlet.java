package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.service.DeptService;

/**
 * 下载excel报表
 */
@WebServlet("/WriteExcelServlet")
public class WriteExcelServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//中文文件名转码
		String filename = new String("部门数据.xls".getBytes(),"iso-8859-1");
		
		//设置浏览器以附件形式接收数据（下载文件）
		response.setHeader("content-disposition", "attachment;filename=" + filename);
		
		//设置响应类型为二进制类型
		response.setContentType("application/octet-stream");
		
		//响应输出流
		OutputStream out = response.getOutputStream();
		
		//调用业务功能
		DeptService service = new DeptService();
		
		try {
			service.writeExcel(out);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
