package com.fuwh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.fuwh.dao.UserDao;
import com.fuwh.entity.User;

@Component("userDao")
public class UserDaoImpl implements UserDao{
	
	@Autowired
	DriverManagerDataSource dataSource;
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
			
	public User getUser(User user) {
		// TODO Auto-generated method stub
		User currUser=new User();
		String sql="select * from users where username=?";
		try {
			conn=dataSource.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			rs=ps.executeQuery();
			while(rs.next()) {
				currUser.setUsername(rs.getString("username"));
				currUser.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return currUser;
	}

	public Set<String> getRoles(String username) {
		// TODO Auto-generated method stub
		Set<String> roleSet=new LinkedHashSet<String>();
		String sql="select role_name from user_roles where username=?";
		try {
			conn=dataSource.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();
			while(rs.next()) {
				roleSet.add(rs.getString("role_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return roleSet;
	}

	public Set<String> getPermissions(Set<String> roles) {
		// TODO Auto-generated method stub
		Set<String> permissionSet=new LinkedHashSet<String>();
		String sql="select permission from  roles_permissions where role_name=?";
		
		try {
			conn=dataSource.getConnection();
			ps=conn.prepareStatement(sql);
			for (String role : roles) {
				ps.setString(1, role);
				rs=ps.executeQuery();
				while(rs.next()) {
					permissionSet.add(rs.getString("role_name"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return permissionSet;
	}

}
