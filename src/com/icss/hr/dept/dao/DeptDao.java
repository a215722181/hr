package com.icss.hr.dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.icss.hr.common.DbUtil;
import com.icss.hr.dept.pojo.Dept;

/**
 * 部门Dao
 * @author Administrator
 *
 */
public class DeptDao {
	
	/**
	 * 插入数据
	 * @param dept
	 * @throws SQLException 
	 */
	public void insert(Dept dept) throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "insert into dept values(dept_seq.nextval,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, dept.getDeptName());
		pstmt.setString(2, dept.getDeptLoc());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	/**
	 * 修改数据
	 * @throws SQLException 
	 */
	public void update(Dept dept) throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "update dept set dept_name=?,dept_loc=? where dept_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, dept.getDeptName());
		pstmt.setString(2, dept.getDeptLoc());
		pstmt.setInt(3, dept.getDeptId());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
	}
	
	/**
	 * 删除数据
	 * @param deptId
	 * @throws SQLException 
	 */
	public void delete(Integer deptId) throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "delete from dept where dept_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, deptId);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
	}
	
	/**
	 * 根据id查询
	 * @throws SQLException 
	 */
	public Dept queryById(Integer deptId) throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "select * from dept where dept_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, deptId);
		
		ResultSet rs = pstmt.executeQuery();
		
		Dept dept = null;
		
		if ( rs.next() ) {
			dept = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return dept;
		
	}
	
	/**
	 * 查询所有数据
	 * @throws SQLException 
	 */
	public ArrayList<Dept> query() throws SQLException {
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "select * from dept";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Dept> list = new ArrayList<>();
		
		while (rs.next()) {
			Dept dept = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
			list.add(dept);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}
}
