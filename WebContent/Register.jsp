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
		<div id="pagetop">
			<jsp:include page="_pageTop.jsp"></jsp:include>
		</div>
		<div id="pagemiddle">
			<h2>Registration Page</h2>
			<p>${msg}</p>
			<div id="register">
				<form action="Register" method="post">
					<table>
						<tr>
							<td class="right">* Username:</td>
							<td class="left"><input type="text" name="uname" value="${uname}"
								required></td>
						</tr>
						<tr>
							<td class="right">* Email:</td>
							<td class="left"><input type="email" name="email" value="${email}"
								required></td>
						</tr>
						<tr>
							<td class="right">* Create Password:</td>
							<td class="left"><input type="password" name="pass" value="${pass}"
								required></td>
						</tr>
						<tr>
							<td class="right">* Reenter Password:</td>
							<td class="left"><input type="password" name="rpass" value="${rpass}"
								required></td>
						</tr>
						<tr>
							<td class="right">* Gender:</td>
							<td class="left"><select name="gender" required>
									<option value="${gender}">${gender}</option>
									<option value="Male">Male</option>
									<option value="Female">Female</option>
							</select></td>
						</tr>
						<tr>
							<td class="right">* City:</td>
							<td class="left"><input type="text" name="city" value="${city}" required></td>
						</tr>
						<tr>
							<td class="right">* Country:</td>
							<td class="left"><select name="country" required>
									<option value="${country}">${country}</option>
									<jsp:include page="CountryList.jsp"></jsp:include>
							</select></td>
						</tr>
						<tr>
							<td class="right">Phone:</td>
							<td class="left"><input type="text" name="phone" value="${phone}"></td>
						</tr>
						<tr>
							<td class="right">* Account Type:</td>
							<td class="left"><select name="type" required>
									<option value="${type}">${type}</option>
									<option value="buyer">BUYER (looking for a room)</option>
									<option value="seller">SELLER (renting/sharing a room)</option>
							</select></td>
						</tr>
						<tr>
							<td class="right"><a href="${pageContext.request.contextPath}/">Cancel</a></td>
							<td class="left"><input type="submit" value="Register"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="pagebottom">@Copyright Roommate's Network (R)</div>
	</div>
</body>
</html>