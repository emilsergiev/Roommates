<%@ page import="com.roommates.model.ModelUser"%>

<div id="logo">
	<h2>
		<a href="${pageContext.request.contextPath}" class="white">Roommate's Network (R)</a>
	</h2>
</div>
<div id="userinfo">
	<%
		if (session == null || session.getAttribute("loggedInUser") == null) {
			out.print("<form action='Login' method='post'>"
					+ "<input type='text' name='uname' placeholder='Username' required>"
					+ "<input type='password' name='pass' placeholder='Password' required>"
					+ "<button type='submit' class='button'>Log In</button></form><br>");
		} else {
			ModelUser loggedInUser = (ModelUser) session.getAttribute("loggedInUser");
			out.print("<form action='Logout' method='post' class='white'>"
					+ " <a href='UpdateUser.jsp' class='white'> Update your info </a> | "
					+ " <a href='ResetPass.jsp' class='white'> Reset your password </a> | "
					+ " <button type='submit' class='button'> Log Out </button></form>");
		}
	%>
</div>