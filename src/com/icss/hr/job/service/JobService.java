package com.icss.hr.job.service;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.pojo.Job;

/**
 * ְ��Service
 * @author Administrator
 *
 */
public class JobService {
	
	private JobDao dao = new JobDao();
	
	/**
	 * ����ְ��
	 * @throws SQLException 
	 */
	public void addJob(Job job) throws SQLException {
		dao.insert(job);
	}
	
	/**
	 * �޸�ְ��
	 * @throws SQLException 
	 */
	public void updateJob(Job job) throws SQLException {
		dao.update(job);
	}
	
	/**
	 * ɾ��ְ��
	 * @throws SQLException 
	 */
	public void deleteJob(Integer jobId) throws SQLException {
		dao.delete(jobId);
	}
	
	/**
	 * ��ѯ����ְ��
	 * @throws SQLException 
	 */
	public Job queryJobById(Integer jobId) throws SQLException {
		return dao.queryById(jobId);
	}
	
	/**
	 * ��ѯ����ְ��
	 * @throws SQLException 
	 */
	public ArrayList<Job> queryJob() throws SQLException {
		return dao.query();
	}
	
	/**
	 * ���ݴ������������Ѳ��ű�����ת��Ϊexcel�ļ�����
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void writeExcel(OutputStream out) throws SQLException, IOException {
		
		//���ز������ݼ���
		ArrayList<Job> list = dao.query();
		
		//����������
		HSSFWorkbook wb = new HSSFWorkbook();
		
		//���������
		HSSFSheet sheet = wb.createSheet("ְ������");
		
		//������
		HSSFRow titleRow = sheet.createRow(0);
		
		titleRow.createCell(0).setCellValue("ְ����");
		titleRow.createCell(1).setCellValue("ְ������");
		titleRow.createCell(2).setCellValue("��͹���");
		titleRow.createCell(3).setCellValue("��߹���");
		
		//������
		for (int i = 1;i <= list.size();i ++) {
			Job job = list.get(i - 1);
			HSSFRow row = sheet.createRow(i);
			row.createCell(0).setCellValue(job.getJobId());
			row.createCell(1).setCellValue(job.getJobName());
			row.createCell(2).setCellValue(job.getJobMinSal());
			row.createCell(3).setCellValue(job.getJobMaxSal());
		}
		
		//д��������
		wb.write(out);
		
	}

}
