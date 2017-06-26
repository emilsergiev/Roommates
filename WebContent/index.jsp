<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.roommates.dao.DaoMVC"%>
<%@ page import="com.roommates.model.ModelUser"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Roommate's Network</title>
</head>
<body> 
<h1>Welcome to our room-mates network ^.^</h1>
<p><a href="Register.jsp">Register</a></p>
<p>
<%
	List<ModelUser> list = (List<ModelUser>) DaoMVC.queryUsers();
	int n = list.size();
	for (ModelUser user : list) {
		out.print("<a href='Home?uname="+user.getUname()+"'>" + user.getUname() + "</a>" + " - " + user.getAvatar() + "<br>");
	}
%>
</p>
<p>Number of users: <%= n %></p>
<form action="${pageContext.request.contextPath}/Login.jsp" method="post">
    <input type="submit" value="Login" />
</form>
</body>
</html>
