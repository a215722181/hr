package test;

import java.sql.SQLException;

import org.junit.Test;

import com.icss.hr.emp.service.EmpService;

/**
 * ≤‚ ‘‘±π§Service
 * @author Administrator
 *
 */
public class TestEmpService {
	
	private EmpService service = new EmpService();
	
	@Test
	public void testCheckLogin() throws SQLException {
		
		int result = service.checkLogin("jack1", "66666");
		
		System.out.println(result);
		
	}
	
	@Test
	public void testCheckLoginName() throws SQLException {
		
		boolean flag = service.checkLoginName("jack1");
		
		System.out.println(flag);
		
	}

}
