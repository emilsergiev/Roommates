<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${uname}</title>
</head>
<body>
	<h1>${uname}</h1>
	<p>Welcome :: ${uname}</p>
	<p>${avatar}</p>
	<p>${msg}</p>
	<p><a href="UpdateUser.jsp">click here to update your info</a></p>
	<p><a href="ResetPass.jsp">click here to reset your password</a></p>
	<form action="${pageContext.request.contextPath}/Logout" method="post">
    <input type="submit" value="Logout" />
</form>
</body>
</html>