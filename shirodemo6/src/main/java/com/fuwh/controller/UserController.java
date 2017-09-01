package com.fuwh.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fuwh.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request) {
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), user.getPassword());
		subject.login(token);
		return "redirect:/static/success.jsp";
	}
	
	@RequestMapping("/info")
	public String info() {
		return "redirect:/static/info.jsp";
	}
}
