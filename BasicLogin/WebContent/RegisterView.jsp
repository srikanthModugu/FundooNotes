<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>RegisterView</title>
<link rel="stylesheet" type="text/css" href="CssFiles/RegisterView.css" />
<script type="text/javascript" src="JavaScript/RegisterView.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body style="background-color: #E0E0E0;">
	<div class="container">
		<div class="card card-container">

			<h1 class="add" align="center">Sign Up</h1>


			<p align="center" style="color: red">${errorMsg}</p>
			<form action="registerServ" name="registerForm" method="post">
				<label id="emailMsg"><b>Email</b></label> <input id="rEmail"
					type="email" placeholder="me@example.com"
					onkeypress="emailValidation()" onfocus="emailValidation()"
					onblur="emailValidation()" name="email" required> <label
					id="pswMsg"><b>Password</b></label> <input type="password" id="psw"
					placeholder="Password" name="password" onfocus="display()"
					onblur="hide()" onkeyup="validation()"
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required>
				<div id="message">
					<h6>Password should contain the following:</h6>
					<p id="capital" class="unchecked">Minimum one capital UpperCase
						letter</p>
					<p id="letter" class="unchecked">Minimum one LowerCase letter</p>
					<p id="number" class="unchecked">Minimum one number</p>
					<p id="length" class="unchecked">
						Minimum <b>8 characters</b>
					</p>
				</div>
				<label id="rePswMsg"><b>Repeat Password</b></label> <input
					id="rePsw" type="password" onblur="rePassWordValidation()"
					onkeydown="rePassWordValidation()" placeholder="Repeat Password"
					name="rPsw_repeat" required>
				<p id="rePassWord" style="color: red"></p>
				<label><b>Phone Number</b></label> <input id="rPhoneNo" type="tel"
					placeholder=" phone No" onkeydown="" name="phnNo" required>

				<p id="rPhoneNo" style="color: red"></p>
				<p>
					By creating an account you agree to our <a href="#">Terms &
						Privacy</a>.
				</p>
				<input type="submit" class="button" value="Sign Up" />
			</form>

		</div>
	</div>

</body>

</html>