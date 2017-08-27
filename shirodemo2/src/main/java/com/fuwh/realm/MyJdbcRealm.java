package com.fuwh.realm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.fuwh.util.DbUtil;

public class MyJdbcRealm extends AuthorizingRealm{

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		Connection conn=DbUtil.getConnection();
		String sql="select * from members2 where username=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, token.getPrincipal().toString());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				AuthenticationInfo info=new SimpleAuthenticationInfo(rs.getString("username"),rs.getString("password"),"salt");
				return info;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
