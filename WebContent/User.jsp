<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css">
<title>${user.uname}</title>
</head>
<body>
	<div id="backgroundimage">
		<div id="pagetop">
			<jsp:include page="_pageTop.jsp"></jsp:include>
		</div>
		<div id="pagemiddle">
			<p>${msg}</p>
		</div>
		<div id="profile">
			<div id="profileinfo">
				<p>User: ${user.uname}</p>
				<p>Email: ${user.email}</p>
				<p>Gender: ${user.gender}</p>
				<p>City: ${user.city}</p>
				<p>Country: ${user.country}</p>
				<p>Phone: ${user.phone}</p>
				<p>Account type: ${user.type}</p>
				<p>Sign-up date: ${user.signup}</p>
				<p>Last login: ${user.lastLogin}</p>
				<p>Notification check: ${user.notesCheck}</p>
			</div>
			<img alt="avatar" src="${user.avatar}">
			<div>
				<p>${owner}</p>
				<p>${button}</p>
				<p>${deny}</p>
			</div>
		</div>
		<h3 class="center">Friends:</h3>
		<div id="users">${friends}</div>
		<div id="pagebottom"><jsp:include page="_pageBottom.jsp"></jsp:include></div>
	</div>
</body>
</html>