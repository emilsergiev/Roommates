<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="logo">
	<h1>Roommate's Network (R)</h1>
</div>
<div id="userinfo">
	<%
		if (session == null || session.getAttribute("loggedInUser") == null) {
			out.print("<form action='Login' method='post'>"
					+ "<input type='text' name='uname' placeholder='Username' required>"
					+ "<input type='password' name='pass' placeholder='Password' required>"
					+ "<button type='submit' class='button'>Log In</button></form><br>");
		} else {
			out.print("<form action='Logout' method='post'>Hello " + session.getAttribute("loggedInUser")
					+ " <button type='submit' class='button'>Log Out</button></form><br>");
		}
	%>
</div>