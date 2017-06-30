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
		<div id="pagetop"><jsp:include page="_pageTop.jsp"></jsp:include></div>
		<div id="pagemiddle">
			<h2>Notifications for ${loggedInUser.uname}</h2>
			<p>${msg}</p>
			<form action="Friends" method="post">
				<p>New Friend Requests: ${loggedInUser.requests} - <input type="submit" value="Check"></p>
			</form>
			<p>${friendRequests}</p>
			<form action="PMs" method="post">
				<p>New Private Messages: ${loggedInUser.pms} - <input type="submit" value="Check"></p>
			</form>
			<p>${pms}</p>
		</div>
		<div id="pagebottom"><jsp:include page="_pageBottom.jsp"></jsp:include></div>
	</div>
</body>
</html>