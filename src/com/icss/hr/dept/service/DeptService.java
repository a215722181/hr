package com.icss.hr.dept.service;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;

/**
 * 部门Service
 * @author Administrator
 *
 */
public class DeptService {
	
	private DeptDao dao = new DeptDao();
	
	/**
	 * 增加新部门
	 * @throws SQLException 
	 */
	public void addDept(Dept dept) throws SQLException {
		dao.insert(dept);
	}
	
	/**
	 * 修改部门
	 * @throws SQLException 
	 */
	public void updateDept(Dept dept) throws SQLException {
		dao.update(dept);
	}
	
	/**
	 * 删除部门
	 * @throws SQLException 
	 */
	public void deleteDept(Integer deptId) throws SQLException {
		dao.delete(deptId);
	}
	
	/**
	 * 查询单个部门
	 * @throws SQLException 
	 */
	public Dept queryDeptById(Integer deptId) throws SQLException {
		return dao.queryById(deptId);
	}
	
	/**
	 * 查询所有部门
	 * @throws SQLException 
	 */
	public ArrayList<Dept> queryDept() throws SQLException {
		return dao.query();
	}
	
	/**
	 * 根据传入的输出流，把部门表数据转换为excel文件数据
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void writeExcel(OutputStream out) throws SQLException, IOException {
		
		//返回部门数据集合
		ArrayList<Dept> list = dao.query();
		
		//工作簿对象
		HSSFWorkbook wb = new HSSFWorkbook();
		
		//工作表对象
		HSSFSheet sheet = wb.createSheet("部门数据");
		
		//标题行
		HSSFRow titleRow = sheet.createRow(0);
		
		titleRow.createCell(0).setCellValue("部门编号");
		titleRow.createCell(1).setCellValue("部门名称");
		titleRow.createCell(2).setCellValue("部门地址");
		
		//数据行
		for (int i = 1;i <= list.size();i ++) {
			Dept dept = list.get(i - 1);
			HSSFRow row = sheet.createRow(i);
			row.createCell(0).setCellValue(dept.getDeptId());
			row.createCell(1).setCellValue(dept.getDeptName());
			row.createCell(2).setCellValue(dept.getDeptLoc());
		}
		
		//写入数据流
		wb.write(out);
		
	}

}
