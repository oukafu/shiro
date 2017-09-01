<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/user/login.do" method="post">
	用户名：<input type="text" name="username"/><br/> 
	密&nbsp;码：<input type="password" name="password"/><br/>
	<input type="checkbox" name="rememberMe" value="true"/>记住我&nbsp;&nbsp;
	<input type="submit" value="登陆">
</form>
<shiro:authenticated>你已经被认证</shiro:authenticated>
<shiro:guest>你还没有登陆</shiro:guest>
<shiro:notAuthenticated>你还没有被认证</shiro:notAuthenticated>
</body>
</html>