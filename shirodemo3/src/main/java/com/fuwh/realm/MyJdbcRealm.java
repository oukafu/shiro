package com.fuwh.realm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.fuwh.util.DbUtil;

public class MyJdbcRealm extends AuthorizingRealm{

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		Set<String> roleNames=new LinkedHashSet<String>();
		Connection conn=DbUtil.getConnection();
		String sql="select role_name from member_roles where membername=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, principals.toString());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				roleNames.add(rs.getString(1));
			}
			rs.close();
			info.setRoles(roleNames);
			try {
				Set<String> permissions=getPermissions(conn,roleNames);
				info.setStringPermissions(permissions);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}

	
	protected Set<String> getPermissions(Connection conn,Set<String> roleNames) throws Exception{
		Set<String> permissions=new LinkedHashSet<String>();
		String sql="select permission from roles_permissions where role_name=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		for (String roleName : roleNames) {
			ps.setString(1,roleName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				permissions.add(rs.getString("permission"));
			}
			rs.close();
		}
		ps.close();
		return permissions;
	}
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		Connection conn=DbUtil.getConnection();
		String sql="select * from members where userName=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, token.getPrincipal().toString());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				AuthenticationInfo info=new SimpleAuthenticationInfo(rs.getString("userName"),rs.getString("pass"),"salt");
				return info;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
