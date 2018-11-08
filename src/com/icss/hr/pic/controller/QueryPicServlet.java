package com.icss.hr.pic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.hr.common.Pager;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.pic.pojo.Pic;
import com.icss.hr.pic.service.PicService;

/**
 * ��ҳ��ѯͼ��
 */
@WebServlet("/QueryPicServlet")
public class QueryPicServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		// ����������
		String pageNumStr = request.getParameter("pageNum");

		int pageNum = 1;

		try {
			pageNum = Integer.parseInt(pageNumStr);
		} catch (Exception e) {

		}

		String pageSizeStr = request.getParameter("pageSize");

		int pageSize = 10;

		try {
			pageSize = Integer.parseInt(pageSizeStr);
		} catch (Exception e) {

		}

		// ����ҵ����
		PicService service = new PicService();

		try {
			// ����Pager����
			Pager pager = new Pager(service.getPicCount(), pageSize, pageNum);

			// �������ݼ���
			ArrayList<Pic> list = service.queryPicByPage(pager);

			HashMap<String, Object> map = new HashMap<>();
			
			map.put("pager", pager);
			map.put("list", list);
			
			Gson gson = new GsonBuilder().
					setDateFormat("yyyy-MM-dd").create();
			
			String json = gson.toJson(map);
			
			out.print(json);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
