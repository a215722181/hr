package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.icss.hr.analyze.dao.AnaDao;
import com.icss.hr.analyze.dto.DeptEmpCount;

/**
 * ≤‚ ‘ ˝æ›∑÷ŒˆDao
 * @author Administrator
 *
 */
public class TestAnaDao {
	
	AnaDao dao = new AnaDao();
	
	@Test
	public void testQueryEmpCount() throws SQLException {
		
		ArrayList<DeptEmpCount> list = dao.queryEmpCount();
		
		for (DeptEmpCount dec : list) {
			System.out.println(dec);
		}
	}
	
	@Test
	public void testQueryAvgSal() throws SQLException {
		
		ArrayList<HashMap<String, Object>> list = dao.queryAvgSal();
		
		for (HashMap<String, Object> map : list) {
			System.out.println(map);
		}
	}
	
	@Test
	public void testQueryMinMaxSal() throws SQLException {
		
		ArrayList<HashMap<String, Object>> list = dao.queryMinMaxSal();
		
		for (HashMap<String, Object> map : list) {
			System.out.println(map);
		}
	}

}
