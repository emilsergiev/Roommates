<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.roommates.dao.DaoMVC"%>
<%@ page import="com.roommates.model.ModelUser"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css">
<title>Roommate's Network (R)</title>
</head>
<body>
	<div id="backgroundimage">
		<div id="pagetop">
			<jsp:include page="_pageTop.jsp"></jsp:include>
		</div>
		<div id="pagemiddle">
			<h2>Welcome to our roommate's network ^.^</h2>
			<p>
				It's free to join... <a href="Register.jsp">Register</a> today!
			</p>
			<p>
				<%
					List<ModelUser> list = (List<ModelUser>) DaoMVC.queryUsers();
					int n = list.size();
					for (ModelUser user : list) {
						out.print("<a href='Home?uname=" + user.getUname() + "'>" + user.getUname() + "</a>" + " - "
								+ user.getAvatar() + "<br>");
					}
				%>
			</p>
			<p>
				Number of users:
				<%=n%></p>
			<p>
				<a href="${pageContext.request.contextPath}/">Home</a>
			</p>
			<p>
				<a href="${pageContext.request.contextPath}/Login.jsp">Login</a>
			</p>
			<p>
				<a href="${pageContext.request.contextPath}/Logout">Logout</a>
			</p>
		</div>
		<div id="pagebottom">@Copyright Roommate's Network (R)</div>
	</div>
</body>
</html>
