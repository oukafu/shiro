package com.fuwh.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroDemoMyJdbc03 {
	
	private static Logger log=LoggerFactory.getLogger(ShiroDemoMyJdbc03.class);
	public static void main(String[] args) {
		//取得SecurityManager工厂
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro_my_jdbc.ini");
		//取得SecurityManager实例
		SecurityManager securityManager=factory.getInstance();
		//将securityManager绑定到SecurityUtil
		SecurityUtils.setSecurityManager(securityManager);

		/*	至此为止，简单的从mysql数据库读取realm信息的shiro环境就配置好了	*/
		
		//取得当前用户
		Subject subject=SecurityUtils.getSubject();
		
		//使用fuwh来进行登陆验证
				if(!subject.isAuthenticated()) {
					UsernamePasswordToken token=new UsernamePasswordToken("fuwh","123456");
					try {
						subject.login(token);
						log.info(token.getPrincipal()+"登陆成功！！！");
						if(subject.hasRole("admin")) {
							log.info(token.getPrincipal()+"有admin的角色");
							Permission p1=new WildcardPermission("bumen:*:query");
							if(subject.isPermitted(p1)) {
								log.info(token.getPrincipal()+"有bumen:*:query的权限");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						log.error("认证失败...");
					}
				}
				subject.logout();
				
				log.debug("*****************************************************************");
				
				if(!subject.isAuthenticated()) {
					UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","123");
					try {
						subject.login(token);
						log.info(token.getPrincipal()+"登陆成功！！！");
						if(subject.hasRole("yuangong")) {
							log.info(token.getPrincipal()+"有yuangong的角色");
							Permission p1=new WildcardPermission("bumen:diwubu:query");
							if(subject.isPermitted(p1)) {
								log.info(token.getPrincipal()+"有bumen:diwubu:query的权限");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						log.error("认证失败...");
					}
				}
				subject.logout();
				
				log.debug("*****************************************************************");
				
				if(!subject.isAuthenticated()) {
					UsernamePasswordToken token=new UsernamePasswordToken("lisi","12");
					try {
						subject.login(token);
						log.info(token.getPrincipal()+"登陆成功！！！");
						if(subject.hasRole("yuangong")) {
							log.info(token.getPrincipal()+"有yuangong的角色");
							Permission p1=new WildcardPermission("bumen:diwubu:update");
							if(subject.isPermitted(p1)) {
								log.info(token.getPrincipal()+"有bumen:diwubu:update的权限");
							}else {
								log.info(token.getPrincipal()+"没有bumen:diwubu:update的权限");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						log.error("认证失败...");
					}
				}
				subject.logout();
	}
}
