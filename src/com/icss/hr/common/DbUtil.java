package com.icss.hr.common;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ���ݿ⹤����
 * 
 * @author Administrator
 *
 */
public class DbUtil {
	// ��������Դ����
	private static ComboPooledDataSource dataSource;

	//�̱߳��ر���
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
	
	static {

		try {
			dataSource = new ComboPooledDataSource();

			// ���Ӳ���
			// ע������
			dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
			// jdbc����url
			dataSource.setUser("myhr");
			// �û���
			dataSource.setPassword("myhr");
			// ����
			dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");

			// ���ӳ�����
			dataSource.setInitialPoolSize(10);// ��ʼ���ӳ�
			dataSource.setMaxPoolSize(20);// ���������
			dataSource.setMinPoolSize(10);// ���ٱ�����������
			dataSource.setMaxIdleTime(60);// �����������60��û�б�ʹ�ã�������

		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

	}

	/**
	 * �������ݿ����Ӷ���
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {

		//�ȷ����̱߳��ر����е����Ӷ���
		Connection conn = threadLocal.get();
		
		//������Ӷ��󲻴��ڣ��������Ӷ����ѹرգ������ӳط���һ��������,Ȼ��洢���̱߳��ر���
		if (conn == null || conn.isClosed()) {
			conn = dataSource.getConnection();
			threadLocal.set(conn);
		}
		
		//������Ӷ����ڵ�ǰ�����߳����Ѵ��ڣ�ֱ�ӷ���ԭ�������Ӷ���
		return conn;
	}
	
	/**
	 * �ر�����
	 */
	public static void close() {
		
		//�ȷ����̱߳��ر����е����Ӷ���
		Connection conn = threadLocal.get();
		
		try {
			//������Ӷ�����ڣ����Ҳ��ǹر�״̬
			if (conn != null && !conn.isClosed()) {
				conn.close();
				threadLocal.remove();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
