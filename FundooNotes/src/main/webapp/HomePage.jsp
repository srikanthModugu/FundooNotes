<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bridgeIt.fundooNotes.model.UserModel ,java.util.ArrayList,java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrprivate Singleton() { }apcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style type="text/css">
   .thumbnail {
      padding: 20px 20px 20px 20px;
      border-width :5px;
      border: black;
      border-radius: 1px;
      background-color:white; 
     
  }
  .crl{
  background-color: green;
  }
  .space{
  margin-right: -15px;
margin-left: 30px;
  }
    .btn {
      padding: 10px 20px;
      background-color: #333;
      color: #f1f1f1;
      border-radius: 0;
      transition: .2s;
  }
  .user{
   padding: 4px 4x 4px 4px;
   color:white;
   font-size: 20px;
  }
  </style>
</head>
<body style="background-color: orange;">
<nav  class = "navbar navbar-inverse" role = "navigation">
   
   <div class = "navbar-header">
      <a class = "navbar-brand" href = "#">FUNDOO NOTES</a>
   </div>
   
   <div>
      <ul  class = "nav navbar-nav">
         <li class = "active"><a href = "#">HOME</a></li>
         <li><a href = "#">Details</a></li>
         <li class = "dropdown">
            <a href = "#" class = "dropdown-toggle" >
               Java
               <b class = "caret"></b>
            </a>
            </ul>
             <ul  class = "nav navbar-nav navbar-right">
             <li class="user"><%=request.getAttribute("lEmail") %>
             <li><a href = "LoginView.jsp"> <span class="glyphicon glyphicon-log-out">LogOut</span></a></li>
             </ul>
            <ul class = "dropdown-menu">
               <li><a href = "#">Adress</a></li>
               <li><a href = "#">State</a></li>
               <li><a href = "#">Bank Details</a></li>
               <li class = "divider"></li>
               <li><a href = "#">Separated link</a></li>
               <li class = "divider"></li>
               <li><a href = "#">One more separated link</a></li>
            </ul>
           
         
      
      
   </div>
</nav>
<%
List<UserModel> userList = new ArrayList<UserModel>();
userList =  (List<UserModel>)request.getAttribute("user");
UserModel d = new UserModel();

 %>

 <div class="row text-center clr space">
  <% for(int i=0;i<userList.size();i++)
    {
    d = userList.get(i);
    		String l = d.getrEmail();
    		String s= d.getrPhnNo();
    %>
 
  <div class="col-sm-2">
    <div class="thumbnail">
      <p><strong><%=s%></strong></p>
      <p><%=l%></p>
      <button class="btn">Delete</button>
        
    </div>
   
  </div>
<%} %>
</div> 


</body>
</html>