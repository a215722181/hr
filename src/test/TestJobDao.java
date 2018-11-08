package test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.pojo.Job;

public class TestJobDao {
	
	JobDao dao = new JobDao();
	
	@Test
	public void testInsert() throws SQLException {
		
		Job job = new Job("��Ʒ����", 4500, 15000);
		
		dao.insert(job);
		
	}
	
	@Test
	public void testUpdate() throws SQLException {
		
		Job job = new Job(5, "���۾���", 5000, 30000);
		
		dao.update(job);
	}
	
	@Test
	public void testDelete() throws SQLException {
		
		dao.delete(5);
		
	}
	
	@Test
	public void testQueryById() throws SQLException {
		
		Job job = dao.queryById(2);
		System.out.println(job);
		
	}
	
	@Test
	public void testQuery() throws SQLException {
		
		ArrayList<Job> list = dao.query();
		
		for (Job job : list) {
			System.out.println(job);
		}
		
	}

}
