<%@page import="org.omg.CORBA.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>LoginView</title>
 <link rel = "stylesheet"
   type = "text/css"
   href = "CssFiles/LoginView.css" />
  
  <script type="text/javascript" src="JavaScript/LoginView.js"></script>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
</style>
</head>

<body style="background-color:#E0E0E0; ">
<div class="container">
        <div class="card card-container">
<h1 align="center" >Log In</h1>



<% if(request.getAttribute("errorMesg") != null){%>
<p align = "center"><%=request.getAttribute("errorMesg")%></p><%} %>
<form name="loginForm" action="Login.do" method="post"  onsubmit="return validation()">
<img id="profile-img" class="profile-img-card" src="profile.png" />
<p id="profile-name" class="profile-name-card"></p>
<label>UserEmail:</label>
<input id="lEmail" type="email" name="lEmail" onkeypress="changeColor()" onblur="emptyEmailValidation()" onkeydown="emptyEmailValidation()" placeholder="Enter email..."  required><br>
<p  id="EmailMsg">  </p>
<label>PassWord:</label>
<input id = "lPassWord" type="password" name="lPassWord" onkeydown="emptyPassValidation()"  placeholder="Enter passWord..." required ><br>
<p id="PassMsg"></p>
<input type = "checkbox" id = "loged"/> <label> Remember me</label>  <br>
<input class="button button1" type="submit"  value="Login"/> 
</form>
<br>
<button  class= "button" type="button" onclick="location.href='RegisterView.jsp'">Registration</button>
</div>
</div>
</body>
</html>