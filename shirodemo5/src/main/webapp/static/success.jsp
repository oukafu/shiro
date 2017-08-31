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
您已经登陆
<shiro:authenticated>
	<p>当您看到这句话的时候，表示你已经被认证了</p><shiro:principal></shiro:principal>
	<a href="${pageContext.request.contextPath }/myInfo">我的信息</a>
</shiro:authenticated>
</body>
</html>