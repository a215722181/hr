package com.icss.hr.pic.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.pic.pojo.Pic;
import com.icss.hr.pic.service.PicService;

/**
 * ͨ��id���ض�ӦͼƬ�ļ���������,�����ļ�
 */
@WebServlet("/DownloadPicServlet")
public class DownloadPicServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//���ͼƬid
		int picId = Integer.parseInt(request.getParameter("picId"));
		
		//����ҵ����
		PicService service = new PicService();
		
		try {
			Pic pic = service.queryPicById(picId);
			
			//���ñ�ͷΪ���ظ���
			String fileName = new String(pic.getPicName().getBytes("utf-8"),"iso-8859-1");
			response.setHeader("content-disposition", "attchment;filename=" + fileName);
			
			InputStream in = pic.getPicData();
			OutputStream out = response.getOutputStream();
			
			byte[] b = new byte[1024 * 8];
			
			int len = in.read(b);
			
			while (len != -1) {
				out.write(b, 0, len);
				len = in.read(b);
			}
			
			out.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
