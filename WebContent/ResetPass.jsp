<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reset Password</title>
</head>
<body>
	<h1>Reset Password Page</h1>
	<p>${msg}</p>
	<form action="ResetPassServlet" method="post">
		<table>
			<tr>
				<td>username</td>
				<td>${uname}</td>
			</tr>
			<tr>
				<td>old password</td>
				<td><input type="password" name="oldpass"></td>
			</tr>
			<tr>
				<td>new password</td>
				<td><input type="password" name="newpass"></td>
			</tr>
			<tr>
				<td>reenter password</td>
				<td><input type="password" name="renewpass"></td>
			</tr>
			<tr>
				<td>...</td>
				<td><input type="submit" value="RESET"></td>
			</tr>
		</table>
	</form>
</body>
</html>