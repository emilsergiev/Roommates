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
			<h2>Welcome to our roommate's network ^.^</h2>
			<p>
				<strong>It's free to join... <a href="Register.jsp">Register</a>
					today!
				</strong>
			</p>
			<div id="home">
				<h3>Search for users by country:</h3>
				<form action="Country" method="post">
					<select name="country" required>
						<option value="${loggedInUser.country}">${loggedInUser.country}</option>
						<jsp:include page="CountryList.jsp"></jsp:include>
					</select> <input type="submit" value="Search">
				</form>
				<p>${byCountry}</p>
				<h3>Search for users by city:</h3>
				<form action="City" method="post">
					<input type="text" name="city" value="${loggedInUser.city}"
						required> <input type="submit" value="Search">
				</form>
				${byCity}
				<h3>Search for users by gender:</h3>
				<form action="Gender" method="post">
					<select name="gender" required>
						<option value="${loggedInUser.gender}">${loggedInUser.gender}</option>
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select> <input type="submit" value="Search">
				</form>
				${byGender}
				<h3>Search for users by account type:</h3>
				<form action="Type" method="post">
					<select name="type" required>
						<option value=""></option>
						<option value="buyer">BUYER (looking for a room)</option>
						<option value="seller">SELLER (renting/sharing a room)</option>
					</select> <input type="submit" value="Search">
				</form>
				${byType}
			</div>
			<div id="etc"></div>
		</div>
		<div id="pagebottom"><jsp:include page="_pageBottom.jsp"></jsp:include></div>
	</div>
</body>
</html>