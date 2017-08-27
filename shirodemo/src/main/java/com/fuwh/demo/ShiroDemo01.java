package com.fuwh.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroDemo01 {
	
	private static Logger log=LoggerFactory.getLogger(ShiroDemo01.class);
	public static void main(String[] args) {
		//取得SecurityManager工厂
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
		//取得SecurityManager实例
		SecurityManager securityManager=factory.getInstance();
		//将securityManager绑定到SecurityUtil
		SecurityUtils.setSecurityManager(securityManager);
		
		/*	至此为止，简单的shiro环境就配置好了	*/

		//取得当前用户
		Subject currentUser=SecurityUtils.getSubject();
		//取得当前用户的session
		Session session=currentUser.getSession();
		//可以在web容器中一样使用session
		session.setAttribute("attr","value");
		log.info("取得的值："+session.getAttribute("attr").toString());
		
		//使用shiro来进行登陆验证
		if(!currentUser.isAuthenticated()) {
			UsernamePasswordToken token=new UsernamePasswordToken("fuwh","fuwh1234");
			try {
				currentUser.login(token);
				log.info("登陆成功！！！");
			} catch (Exception e) {
				e.printStackTrace();
				log.error("认证失败...");
			}
		}
		
		log.info("角色认证开始....");
		if(currentUser.hasRole("admin")) {
			log.info("当前用户有admin角色");
		}else {
			log.info("当前用户没有admin角色");
		}
		
		log.info("权限认证开始....");
		if(currentUser.isPermitted("lightsaber:debug")) {
			log.info("当前用户有lightsaber:debug权限");
		}else {
			log.info("当前用户没有lightsaber:debug权限");
		}
		
		currentUser.logout();
	}
}
