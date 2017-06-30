<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<h2>-= Login Page =-</h2>
			<p>${msg}</p>
			<div id="form">
				<form action="Login" method="post">
					<table>
						<tr>
							<td>* Username:</td>
							<td><input type="text" name="uname" required></td>
						</tr>
						<tr>
							<td>* Password:</td>
							<td><input type="password" name="pass" required></td>
						</tr>
						<tr>
							<td><a href="${pageContext.request.contextPath}/">Cancel</a></td>
							<td><input type="submit" value="Login"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="pagebottom"><jsp:include page="_pageBottom.jsp"></jsp:include></div>
	</div>
</body>
</html>