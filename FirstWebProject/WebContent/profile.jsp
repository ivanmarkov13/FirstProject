<%@page import="java.time.LocalDate"%>
<%@page import="users.User"%>
<%@page import="daoObjs.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title></title>
<link rel="stylesheet" type="text/css" href="profile.css">
<link href='http://fonts.googleapis.com/css?family=Cuprum' rel='stylesheet' type='text/css'>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script>
<script src="http://www.bitstorm.org/jquery/color-animation/jquery.animate-colors-min.js"></script>
<script src="stil.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>


<body>

<form align="right" form action="logout" method="get">
  <label class="logoutLblPos">
  <input name="submit2" type="submit" id="submit2" value="Log out">
  </label>
</form>

<form action="login" method="get">
  <label class="logoutLblPos2">
  <input name="submit3" type="submit" id="submit3" value="Start shopping">
  </label>
</form>

<form action="AddProduct" method="get">
  <label class="logoutLblPos3">
  <input name="submit4" type="submit" id="submit4" value="Add product">
  </label>
</form>

<form action="" method="">
  <label class="logoutLblPos4">
  <input name="submit5" type="submit" id="submit5" value="View your products">
  </label>
</form>

<form action="UploadPhotoServlet" method="post">
  <label class="logoutLblPos5">
  <input name="submit6" type="submit" id="submit6" value="Upload Photo">
  </label>
</form>

<div id="photo"><img src="https://help.sketchbook.com/knowledgebase/wp-content/plugins/all-in-one-seo-pack/images/default-user-image.png"></div>
<div id="about">

<%! String name = null; %>
<%! LocalDate birthDate = null; %>
<%! String username = null; %>
<%! String email = null; %>
<%! String phoneNum = null; %>
<%! Double money = null; %>

<table>
	<tr><td>
	<%
		if(!(Boolean)session.getAttribute("logged") || session.isNew()){
			response.sendRedirect("regis.html");
		}
		else{
			if(session.getAttribute("user") != null){
				User u = (User)session.getAttribute("user");
				name = u.getName();
			}
			else{
				response.sendRedirect("regis.html");
			}
		}
	%>
	<%= name %>
	</td></tr>
	<tr><td>
		<%
		if(!(Boolean)session.getAttribute("logged") || session.isNew()){
			response.sendRedirect("regis.html");
		}
		else{
			if(session.getAttribute("user") != null){
				User u = (User)session.getAttribute("user");
				birthDate = u.getBirthDate();
			}
			else{
				response.sendRedirect("regis.html");
			}
		}
		%>
	<%= birthDate %>
	</td></tr>
	<tr><td>
		<%
		if(!(Boolean)session.getAttribute("logged") || session.isNew()){
			response.sendRedirect("regis.html");
		}
		else{
			if(session.getAttribute("user") != null){
				User u = (User)session.getAttribute("user");
				username = u.getUsername();
			}
			else{
				response.sendRedirect("regis.html");
			}
		}
	%>
	<%= username %>
	</td></tr>
	<tr><td>
		<%
		if(!(Boolean)session.getAttribute("logged") || session.isNew()){
			response.sendRedirect("regis.html");
		}
		else{
			if(session.getAttribute("user") != null){
				User u = (User)session.getAttribute("user");
				email = u.getEmail();
			}
			else{
				response.sendRedirect("regis.html");
			}
		}
	%>
	<a href="mailto:<%= email %>">
		<%= email %>
	</a>  
	</td></tr>
	<tr><td> 
		<%
		if(!(Boolean)session.getAttribute("logged") || session.isNew()){
			response.sendRedirect("regis.html");
		}
		else{
			if(session.getAttribute("user") != null){
				User u = (User)session.getAttribute("user");
				phoneNum = u.getPhoneNumber();
			}
			else{
				response.sendRedirect("regis.html");
			}
		}
	%>
	<%= phoneNum %>
	</td></tr>
	<tr><td> 
		<%
		if(!(Boolean)session.getAttribute("logged") || session.isNew()){
			response.sendRedirect("regis.html");
		}
		else{
			if(session.getAttribute("user") != null){
				User u = (User)session.getAttribute("user");
				money = u.getMoney();
			}
			else{
				response.sendRedirect("regis.html");
			}
		}
	%>
	Money:  <%= money %>
	</td></tr>
</table>



</div>
</body>
</html>
