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
 * 职务Service
 * @author Administrator
 *
 */
public class JobService {
	
	private JobDao dao = new JobDao();
	
	/**
	 * 增加职务
	 * @throws SQLException 
	 */
	public void addJob(Job job) throws SQLException {
		dao.insert(job);
	}
	
	/**
	 * 修改职务
	 * @throws SQLException 
	 */
	public void updateJob(Job job) throws SQLException {
		dao.update(job);
	}
	
	/**
	 * 删除职务
	 * @throws SQLException 
	 */
	public void deleteJob(Integer jobId) throws SQLException {
		dao.delete(jobId);
	}
	
	/**
	 * 查询单个职务
	 * @throws SQLException 
	 */
	public Job queryJobById(Integer jobId) throws SQLException {
		return dao.queryById(jobId);
	}
	
	/**
	 * 查询所有职务
	 * @throws SQLException 
	 */
	public ArrayList<Job> queryJob() throws SQLException {
		return dao.query();
	}
	
	/**
	 * 根据传入的输出流，把部门表数据转换为excel文件数据
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void writeExcel(OutputStream out) throws SQLException, IOException {
		
		//返回部门数据集合
		ArrayList<Job> list = dao.query();
		
		//工作簿对象
		HSSFWorkbook wb = new HSSFWorkbook();
		
		//工作表对象
		HSSFSheet sheet = wb.createSheet("职务数据");
		
		//标题行
		HSSFRow titleRow = sheet.createRow(0);
		
		titleRow.createCell(0).setCellValue("职务编号");
		titleRow.createCell(1).setCellValue("职务名称");
		titleRow.createCell(2).setCellValue("最低工资");
		titleRow.createCell(3).setCellValue("最高工资");
		
		//数据行
		for (int i = 1;i <= list.size();i ++) {
			Job job = list.get(i - 1);
			HSSFRow row = sheet.createRow(i);
			row.createCell(0).setCellValue(job.getJobId());
			row.createCell(1).setCellValue(job.getJobName());
			row.createCell(2).setCellValue(job.getJobMinSal());
			row.createCell(3).setCellValue(job.getJobMaxSal());
		}
		
		//写入数据流
		wb.write(out);
		
	}

}
