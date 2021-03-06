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
			<h1>Update User Page</h1>
			<p>${msg}</p>
			<div id="form">
				<form action="Update" method="post">
					<table>
						<tr>
							<td>Username:</td>
							<td>${loggedInUser.uname}</td>
							<td><input type="hidden" name="uname" value="${loggedInUser.uname}"></td>
						</tr>
						<tr>
							<td>* Email:</td>
							<td><input type="email" name="email" value="${loggedInUser.email}"
								required></td>
						</tr>
						<tr>
							<td>* Gender:</td>
							<td><select name="gender" required>
									<option value="${loggedInUser.gender}">${loggedInUser.gender}</option>
									<option value="Male">Male</option>
									<option value="Female">Female</option>
							</select></td>
						</tr>
						<tr>
							<td>* City:</td>
							<td><input type="text" name="city" value="${loggedInUser.city}" required></td>
						</tr>
						<tr>
							<td>* Country:</td>
							<td><select name="country" required>
									<option value="${loggedInUser.country}">${loggedInUser.country}</option>
									<jsp:include page="CountryList.jsp"></jsp:include>
							</select></td>
						</tr>
						<tr>
							<td>Phone:</td>
							<td><input type="text" name="phone" value="${loggedInUser.phone}"></td>
						</tr>
						<tr>
							<td>* Account Type:</td>
							<td><select name="type" required>
									<option value="${loggedInUser.type}">${loggedInUser.type}</option>
									<option value="buyer">BUYER (looking for a room)</option>
									<option value="seller">SELLER (renting/sharing a room)</option>
							</select></td>
						</tr>
						<tr>
							<td><a href="${pageContext.request.contextPath}/">Cancel</a></td>
							<td><input type="submit" value="Update"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="pagebottom"><jsp:include page="_pageBottom.jsp"></jsp:include></div>
	</div>
</body>
</html>