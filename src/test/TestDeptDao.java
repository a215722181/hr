package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;

import org.junit.Test;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;

import oracle.net.aso.l;

/**
 * ���Բ���Dao
 * @author Administrator
 *
 */
public class TestDeptDao {
	
	private DeptDao dao = new DeptDao();
	
	@Test
	public void testInsert() throws SQLException {
		Dept dept = new Dept("����","�Ϻ�������");
		dao.insert(dept);
	}
	
	@Test
	public void testUpdate() throws SQLException {
		Dept dept = new Dept(20,"���ڲ�","�Ͼ�");
		dao.update(dept);
	}
	
	@Test
	public void testDelete() throws SQLException {
		dao.delete(30);
	}
	
	@Test
	public void testQueryById() throws SQLException {
		
		Dept dept = dao.queryById(40);
		System.out.println(dept);
	}
	
	@Test
	public void testQuery() throws SQLException {
		ArrayList<Dept> list = new ArrayList<>();
		
		list = dao.query();
		
		for (Dept dept : list) {
			System.out.println(dept);
		}
		
	}
}
