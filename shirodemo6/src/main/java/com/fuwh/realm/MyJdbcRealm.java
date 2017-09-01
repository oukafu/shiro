package com.fuwh.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fuwh.entity.User;
import com.fuwh.service.UserService;

@Component
public class MyJdbcRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.setRoles(userService.getRoles(principals.getPrimaryPrincipal().toString()));
		info.setStringPermissions(userService.getPermissions(info.getRoles()));
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		User user=new User();
		user.setUsername(token.getPrincipal().toString());
		User currUser=userService.getUser(user);
		if(currUser!=null) {
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(currUser.getUsername(),currUser.getPassword(),"xx");
			return info;
		}else{
			return null;
		}
	}

}
