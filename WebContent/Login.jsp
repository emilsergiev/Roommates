<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h1>-= Login Page =-</h1>
	<p>${msg}</p>
	<form action="LoginServlet" method="post">
		<table>
			<tr>
				<td>username</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td>...</td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>