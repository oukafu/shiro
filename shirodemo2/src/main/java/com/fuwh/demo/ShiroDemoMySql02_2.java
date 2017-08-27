package com.fuwh.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroDemoMySql02_2 {
	
	private static Logger log=LoggerFactory.getLogger(ShiroDemoMySql02_2.class);
	public static void main(String[] args) {
		//取得SecurityManager工厂
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro_jdbc_my_sql_2.ini");
		//取得SecurityManager实例
		SecurityManager securityManager=factory.getInstance();
		//将securityManager绑定到SecurityUtil
		SecurityUtils.setSecurityManager(securityManager);

		/*	至此为止，简单的从mysql数据库读取realm信息的shiro环境就配置好了	*/
		
		//取得当前用户
		Subject currentUser=SecurityUtils.getSubject();
		
		//使用shiro来进行登陆验证
		if(!currentUser.isAuthenticated()) {
			UsernamePasswordToken token=new UsernamePasswordToken("fuwh","123");
			try {
				currentUser.login(token);
				log.info("登陆成功！！！");
			} catch (Exception e) {
				e.printStackTrace();
				log.error("认证失败...");
			}
		}
		
		currentUser.logout();
	}
}
