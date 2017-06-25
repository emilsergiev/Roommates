<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<h1>Registration Page</h1>
	<p>${msg}</p>
	<form action="RegisterServlet" method="post">
		<table>
			<tr>
				<td>username</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td>reenter password</td>
				<td><input type="password" name="rpass"></td>
			</tr>
			<tr>
				<td>first name</td>
				<td><input type="text" name="fname"></td>
			</tr>
			<tr>
				<td>last name</td>
				<td><input type="text" name="lname"></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>security question</td>
				<td><input type="text" name="sques"></td>
			</tr>
			<tr>
				<td>answer</td>
				<td><input type="text" name="ans"></td>
			</tr>
			<tr>
				<td>phone</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>account type</td>
				<td><select name="type">
					<option value="buyer">BUYER (looking for a room)</option>
					<option value="seller">SELLER (renting/sharing a room)</option>
				</select></td>
			</tr>
			<tr>
				<td>...</td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>
</body>
</html>