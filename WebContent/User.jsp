<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${uname}</title>
</head>
<body>
	<div>
		<p>${owner} ${logged}</p>
		${button}
	</div>
	<p>${uname}</p>
	<p>${email}</p>
	<p>${gender}</p>
	<p>${city}</p>
	<p>${country}</p>
	<p>${phone}</p>
	<p>${type}</p>
	<p>${avatar}</p>
	<p>${signup}</p>
	<p>${lastlogin}</p>
	<p>${notescheck}</p>
	<p>
		<a href="${pageContext.request.contextPath}/">Home</a>
	</p>
</body>
</html>
