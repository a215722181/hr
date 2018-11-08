package com.icss.hr.emp.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;

/**
 * 员工Service
 * @author Administrator
 *
 */
public class EmpService {
	
	private EmpDao dao = new EmpDao();
	
	/**
	 * 登录验证
	 * 返回1：用户名不存在  返回2：密码错误
	 * 返回3：登陆成功
	 * @throws SQLException 
	 */
	public int checkLogin(String empLoginName,String empPwd) throws SQLException {
		
		Emp emp = dao.queryByName(empLoginName);
		
		if (emp == null) {
			return 1;
		} else if (!empPwd.equals(emp.getEmpPwd())) {
			return 2;
		} else {
			return 3;
		}
		
	}
	
	/**
	 * 检查用户名是否存在
	 * 存在返回true，不存在返回false
	 * @throws SQLException 
	 */
	public boolean checkLoginName(String empLoginName) throws SQLException {
		
		Emp emp = dao.queryByName(empLoginName);
		
		if (emp == null) {
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * 增加新员工
	 * @throws SQLException 
	 */
	public void addEmp(Emp emp) throws SQLException {
		dao.insert(emp);
	}
	
	/**
	 * 通过id查询员工数据
	 * @throws SQLException 
	 */
	public Emp queryEmpById(Integer empId) throws SQLException {
		
		Emp emp = dao.queryById(empId);
		return emp;
		
	}
	
	/**
	 * 返回员工总记录数
	 * @throws SQLException 
	 */
	public int getEmpCount() throws SQLException {
		
		return dao.getCount();
	}
	
	/**
	 * 分页查询员工
	 * @throws SQLException 
	 */
	public ArrayList<Emp> queryEmpByPage(Pager pager) throws SQLException {
		
		return dao.queryByPage(pager);
		
	}
	
	/**
	 * 修改员工
	 * @throws SQLException 
	 */
	public void updateEmp(Emp emp) throws SQLException {
		dao.update(emp);
	}
	
	/**
	 * 删除员工
	 * @throws SQLException 
	 */
	public void daleteEmp(Integer empId) throws SQLException {
		dao.delete(empId);
	}
	
	/**
	 * 更新头像
	 * @throws SQLException 
	 */
	public void updateEmpPic(String empLoginName,String empPic) throws SQLException {
		dao.updateEmpPic(empLoginName, empPic);
	}
	
	/**
	 * 查询返回头像
	 * @throws SQLException 
	 */
	public String queryEmpPic(String empLoginName) throws SQLException {
		
		return dao.queryEmpPic(empLoginName);
	}
	
	/**
	 * 修改密码
	 * @throws SQLException 
	 */
	public void updateEmpPwd(String empLoginName,String empPwd) throws SQLException {
		dao.updateEmpPwd(empLoginName, empPwd);
	}
	
	/**
	 * 查询密码
	 * @throws SQLException 
	 */
	public String queryEmpPwd(String empLoginName) throws SQLException {
		
		return dao.queryByName(empLoginName).getEmpPwd();
	}
}
