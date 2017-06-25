<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${uname}</title>
</head>
<body>
	<h1>Update User Page</h1>
	<p>${msg}</p>
	<form action="UpdateServlet" method="post">
		<table>
			<tr>
				<td>username</td>
				<td>${uname}</td>
				<td><input type="hidden" name="uname" value="${uname}"></td>
			</tr>
			<tr>
				<td>first name</td>
				<td><input type="text" name="fname" value="${fname}"></td>
			</tr>
			<tr>
				<td>last name</td>
				<td><input type="text" name="lname" value="${lname}"></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="email" name="email" value="${email}"></td>
			</tr>
			<tr>
				<td>security question</td>
				<td><input type="text" name="sques" value="${sques}"></td>
			</tr>
			<tr>
				<td>answer</td>
				<td><input type="text" name="ans" value="${ans}"></td>
			</tr>
			<tr>
				<td>phone</td>
				<td><input type="text" name="phone" value="${phone}"></td>
			</tr>
			<tr>
				<td>account type</td>
				<td><select name="type">
					<option value="${type}">${type}</option>
					<option value="buyer">BUYER (looking for a room)</option>
					<option value="seller">SELLER (renting/sharing a room)</option>
				</select></td>
			</tr>
			<tr>
				<td>...</td>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>