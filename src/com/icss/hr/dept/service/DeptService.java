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
 * ����Service
 * @author Administrator
 *
 */
public class DeptService {
	
	private DeptDao dao = new DeptDao();
	
	/**
	 * �����²���
	 * @throws SQLException 
	 */
	public void addDept(Dept dept) throws SQLException {
		dao.insert(dept);
	}
	
	/**
	 * �޸Ĳ���
	 * @throws SQLException 
	 */
	public void updateDept(Dept dept) throws SQLException {
		dao.update(dept);
	}
	
	/**
	 * ɾ������
	 * @throws SQLException 
	 */
	public void deleteDept(Integer deptId) throws SQLException {
		dao.delete(deptId);
	}
	
	/**
	 * ��ѯ��������
	 * @throws SQLException 
	 */
	public Dept queryDeptById(Integer deptId) throws SQLException {
		return dao.queryById(deptId);
	}
	
	/**
	 * ��ѯ���в���
	 * @throws SQLException 
	 */
	public ArrayList<Dept> queryDept() throws SQLException {
		return dao.query();
	}
	
	/**
	 * ���ݴ������������Ѳ��ű�����ת��Ϊexcel�ļ�����
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void writeExcel(OutputStream out) throws SQLException, IOException {
		
		//���ز������ݼ���
		ArrayList<Dept> list = dao.query();
		
		//����������
		HSSFWorkbook wb = new HSSFWorkbook();
		
		//���������
		HSSFSheet sheet = wb.createSheet("��������");
		
		//������
		HSSFRow titleRow = sheet.createRow(0);
		
		titleRow.createCell(0).setCellValue("���ű��");
		titleRow.createCell(1).setCellValue("��������");
		titleRow.createCell(2).setCellValue("���ŵ�ַ");
		
		//������
		for (int i = 1;i <= list.size();i ++) {
			Dept dept = list.get(i - 1);
			HSSFRow row = sheet.createRow(i);
			row.createCell(0).setCellValue(dept.getDeptId());
			row.createCell(1).setCellValue(dept.getDeptName());
			row.createCell(2).setCellValue(dept.getDeptLoc());
		}
		
		//д��������
		wb.write(out);
		
	}

}
