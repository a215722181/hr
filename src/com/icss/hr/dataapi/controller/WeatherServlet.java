package com.icss.hr.dataapi.controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;


/**
 * 天气查询
 */
@WebServlet("/WeatherServlet")
public class WeatherServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//响应输出流
		PrintWriter out = response.getWriter();
		
		//请求参数
		String cityName = request.getParameter("cityName");
		
		//创建默认的httpclient实例
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		//创建httpcost，阿凡达平台现在必须发送https请求
		String url = "http://api.avatardata.cn/Weather/Query";
		HttpPost httpPost = new HttpPost(url);
		
		//创建参数队列
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("key", "cb64829d9b9148f292730a8bef934c9f"));
		params.add(new BasicNameValuePair("cityName", cityName));
		params.add(new BasicNameValuePair("format", "true"));
		
		//设置请求内容
		UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(params,"utf-8");
		httpPost.setEntity(uefEntity);
		
		//打印请求地址
		System.out.println("请求地址:" + httpPost.getURI());
		
		//发出post请求
		CloseableHttpResponse resp = httpClient.execute(httpPost);
		
		//打印响应状态
		System.out.println("状态码：" + resp.getStatusLine().getStatusCode());
		
		//响应实体
		HttpEntity entity = resp.getEntity();
		
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
