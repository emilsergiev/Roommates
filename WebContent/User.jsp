<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css">
<title>${uname}</title>
</head>
<body>
	<div id="backgroundimage">
		<div id="pagetop">
			<jsp:include page="_pageTop.jsp"></jsp:include>
		</div>
		<div id="pagemiddle">
			<div>
				<p>${owner}</p>
				<p>${logged}</p>
				<p>${button}</p>
			</div>
			<p>${msg}</p>
			<p>User: ${uname}</p>
			<p>Email: ${email}</p>
			<p>Gender: ${gender}</p>
			<p>City: ${city}</p>
			<p>Country: ${country}</p>
			<p>Phone: ${phone}</p>
			<p>Account type: ${type}</p>
			<p>Picture: ${avatar}</p>
			<p>Sign-up date:${signup}</p>
			<p>Last login: ${lastlogin}</p>
			<p>Notification check: ${notescheck}</p>
			<p>
				<a href="${pageContext.request.contextPath}/">Home</a>
			</p>
		</div>
		<div id="pagebottom">@Copyright Roommate's Network (R)</div>
	</div>
</body>
</html>