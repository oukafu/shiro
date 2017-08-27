package com.fuwh.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbUtil {

	private final static String DRIVER_CLASS="com.mysql.jdbc.Driver";
	private final static String JDBC_URL="jdbc:mysql://localhost:3306/db_shiro";
	private final static String USERNAME="root";
	private final static String PASSWORD="rootadmin";
	
	private static ComboPooledDataSource dataSource=DbUtil.getDataSource();
	
	private static ComboPooledDataSource getDataSource() {
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(DRIVER_CLASS);
			dataSource.setJdbcUrl(JDBC_URL);
			dataSource.setUser(USERNAME);
			dataSource.setPassword(PASSWORD);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataSource;
	}
	
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		try {
			Connection conn=DbUtil.getConnection();
			System.out.println("数据库连接成功!!!"+conn);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("数据库连接失败!!!");
		}
	}
	
}
