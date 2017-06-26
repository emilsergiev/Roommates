<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<h1>Registration Page</h1>
	<p>${msg}</p>
	<form action="Register" method="post">
		<table>
			<tr>
				<td>* Username:</td>
				<td><input type="text" name="uname" value="${uname}" required></td>
			</tr>
			<tr>
				<td>* Email:</td>
				<td><input type="email" name="email" value="${email}" required></td>
			</tr>
			<tr>
				<td>* Create Password:</td>
				<td><input type="password" name="pass" value="${pass}" required></td>
			</tr>
			<tr>
				<td>* Reenter Password:</td>
				<td><input type="password" name="rpass" value="${rpass}" required></td>
			</tr>
			<tr>
				<td>* Gender:</td>
				<td><select name="gender" required>
					<option value="${gender}">${gender}</option>
					<option value="Male">Male</option>
					<option value="Female">Female</option>
				</select></td>
			</tr>
			<tr>
				<td>* City:</td>
				<td><input type="text" name="city" value="${city}" required></td>
			</tr>
			<tr>
				<td>* Country:</td>
				<td><select name="country" required>
					<option value="${country}">${country}</option>
					<jsp:include page="CountryList.jsp"></jsp:include>
				</select></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone" value="${phone}"></td>
			</tr>
			<tr>
				<td>* Account Type:</td>
				<td><select name="type" required>
					<option value="${type}">${type}</option>
					<option value="buyer">BUYER (looking for a room)</option>
					<option value="seller">SELLER (renting/sharing a room)</option>
				</select></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/">Cancel</a></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>
</body>
</html>