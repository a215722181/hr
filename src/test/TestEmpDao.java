package test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.icss.hr.common.Pager;
import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.job.pojo.Job;

/**
 * 测试员工Dao
 * @author Administrator
 *
 */
public class TestEmpDao {
	
	private EmpDao dao = new EmpDao();
	
	@Test
	public void testInsert() throws SQLException {
		
		Dept dept = new Dept();
		dept.setDeptId(10);
		
		Job job = new Job();
		job.setJobId(1);
		
		Emp emp = new Emp("tom","tom","123456","tom@163.com",
				"10086",Date.valueOf("1995-01-01"),8000.0,dept,job,
				null,"无");
		
		dao.insert(emp);
		
	}
	
	@Test
	public void testInsert2() throws SQLException {
		
		Dept dept = new Dept();
		dept.setDeptId(10);
		
		Job job = new Job();
		job.setJobId(2);
		
		for (int i = 1;i <= 20;i ++) {
			Emp emp = new Emp("jack" + i,"jack" + i,"123456","jack" + i + "@163.com",
					"13812345678",Date.valueOf("1997-01-01"),7000.0,dept,job,
					null,"无");
			
			dao.insert(emp);
		}
		
	}
	
	@Test
	public void testDelete() throws SQLException {
		dao.delete(1);
	}
	
	@Test
	public void testQueryByPage() throws SQLException {
		
		Pager pager = new Pager(20, 7, 1);
		
		ArrayList<Emp> list = dao.queryByPage(pager);
		
		for (Emp emp : list) {
			System.out.println(emp);
		}
		
	}
	
	@Test
	public void testUpdate() throws SQLException {
		
		Dept dept = new Dept();
		dept.setDeptId(20);
		
		Job job = new Job();
		job.setJobId(4);
		
		Emp emp = new Emp(2, "jack1", "jack", "123456", "jack1@email.com", "10086", Date.valueOf("2018-01-01"), 15000.0, dept, job, null, "我是jack1");
		dao.update(emp);
		
	}
	
	@Test
	public void testQueryById() throws SQLException {
		
		Emp emp = dao.queryById(2);
		System.out.println(emp);
		
	}
	
	@Test
	public void testGetCount() throws SQLException {
		
		System.out.println(dao.getCount());
		
	}
	
	@Test
	public void testQueryByName() throws SQLException {
		
		Emp emp = dao.queryByName("jack1");
		System.out.println(emp.getEmpPwd());
		
	}
	
	@Test
	public void testUpdateEmpPwd() throws SQLException {
		
		dao.updateEmpPwd("jack1", "666666");
		
	}
	
	@Test
	public void testUpdateEmpPic() throws SQLException {
		
		dao.updateEmpPic("jack1", "aaa");
		
	}
	
	@Test
	public void testQueryEmpPic() throws SQLException {
		
		String empPic = dao.queryEmpPic("jack1");
		System.out.println(empPic);
		
	}
	
}
