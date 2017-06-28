<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css">
<title>Reset Password</title>
</head>
<body>
	<div id="backgroundimage">
		<div id="pagetop">
			<jsp:include page="_pageTop.jsp"></jsp:include>
		</div>
		<div id="pagemiddle">
			<h1>Reset Password Page</h1>
			<p>${msg}</p>
			<form action="ResetPass" method="post">
				<table>
					<tr>
						<td>Username:</td>
						<td>${uname}</td>
					</tr>
					<tr>
						<td>* Old Password:</td>
						<td><input type="password" name="oldpass"></td>
					</tr>
					<tr>
						<td>* New Password:</td>
						<td><input type="password" name="newpass"></td>
					</tr>
					<tr>
						<td>* Reenter Password:</td>
						<td><input type="password" name="renewpass"></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/">Cancel</a></td>
						<td><input type="submit" value="RESET"></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="pagebottom">@Copyright Roommate's Network (R)</div>
	</div>
</body>
</html>