package com.icss.hr.emp.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;

/**
 * Ա��Service
 * @author Administrator
 *
 */
public class EmpService {
	
	private EmpDao dao = new EmpDao();
	
	/**
	 * ��¼��֤
	 * ����1���û���������  ����2���������
	 * ����3����½�ɹ�
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
	 * ����û����Ƿ����
	 * ���ڷ���true�������ڷ���false
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
	 * ������Ա��
	 * @throws SQLException 
	 */
	public void addEmp(Emp emp) throws SQLException {
		dao.insert(emp);
	}
	
	/**
	 * ͨ��id��ѯԱ������
	 * @throws SQLException 
	 */
	public Emp queryEmpById(Integer empId) throws SQLException {
		
		Emp emp = dao.queryById(empId);
		return emp;
		
	}
	
	/**
	 * ����Ա���ܼ�¼��
	 * @throws SQLException 
	 */
	public int getEmpCount() throws SQLException {
		
		return dao.getCount();
	}
	
	/**
	 * ��ҳ��ѯԱ��
	 * @throws SQLException 
	 */
	public ArrayList<Emp> queryEmpByPage(Pager pager) throws SQLException {
		
		return dao.queryByPage(pager);
		
	}
	
	/**
	 * �޸�Ա��
	 * @throws SQLException 
	 */
	public void updateEmp(Emp emp) throws SQLException {
		dao.update(emp);
	}
	
	/**
	 * ɾ��Ա��
	 * @throws SQLException 
	 */
	public void daleteEmp(Integer empId) throws SQLException {
		dao.delete(empId);
	}
	
	/**
	 * ����ͷ��
	 * @throws SQLException 
	 */
	public void updateEmpPic(String empLoginName,String empPic) throws SQLException {
		dao.updateEmpPic(empLoginName, empPic);
	}
	
	/**
	 * ��ѯ����ͷ��
	 * @throws SQLException 
	 */
	public String queryEmpPic(String empLoginName) throws SQLException {
		
		return dao.queryEmpPic(empLoginName);
	}
	
	/**
	 * �޸�����
	 * @throws SQLException 
	 */
	public void updateEmpPwd(String empLoginName,String empPwd) throws SQLException {
		dao.updateEmpPwd(empLoginName, empPwd);
	}
	
	/**
	 * ��ѯ����
	 * @throws SQLException 
	 */
	public String queryEmpPwd(String empLoginName) throws SQLException {
		
		return dao.queryByName(empLoginName).getEmpPwd();
	}
}
