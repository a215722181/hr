package com.icss.hr.analyze.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.icss.hr.analyze.dao.AnaDao;
import com.icss.hr.analyze.dto.DeptEmpCount;

/**
 * Êý¾Ý·ÖÎöservice
 * 
 * @author Administrator
 *
 */
public class AnaService {

	private AnaDao dao = new AnaDao();

	public ArrayList<DeptEmpCount> queryEmpCounts() throws SQLException {

		return dao.queryEmpCount();
	}

	public ArrayList<HashMap<String, Object>> queryAvgSal() throws SQLException {

		return dao.queryAvgSal();
	}

	public ArrayList<HashMap<String, Object>> queryMinMaxSal() throws SQLException {

		return dao.queryMinMaxSal();
	}

}
