<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
UserDetails user3 = (UserDetails) session.getAttribute("userD");

if (user3 == null) {

	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error","Please Login");

}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
<h1 class="text-center"> All Notes</h1>
	<div class="row">
	<div class="col-md-12">
	<%@ page import="com.DAO.PostDAO" %>
	<%@ page import="com.Db.DBConnect" %>
	<%@ page import="java.util.*" %>
	<%@ page import="com.User.Post" %>
	
	
	
	
	<div class="card mt-3">
		
		<img alt="" src="img/n2.jpg" class="card-img-top mt-2 mx-auto" style="max-width:100px;">
		<div class="card-body p-4">
		<h5 class="card-title"> </h5>
		<p></p>
		<p>
		<b > Title:</b> </b>
		<b class="text-primary"></b>
		</p>
		<p>
		<b> Content:<br></b>
		<b class="text-primary"></b>
		<b class="text-success"> Notes By:</b> </b>
		<b class="text-primary"></b>
		</p>
		
		</div>
		</div>
	
	<%
	if(user3!=null)
	{
	
	PostDAO ob=new PostDAO(DBConnect.getConn());
	List<Post> post=ob.getData(user3.getId());
	for( Post po:post)
	{ %>
	
		
	
		<div class="card mt-3">
		
		<img alt="" src="img/n2.jpg" class="card-img-top mt-2 mx-auto" style="max-width:100px;">
		<div class="card-body p-4">
		<h5 class="card-title"> </h5>
		<p></p>
		<p>
		<b > Title:</b> </b>
		<b class="text-primary"></b>
		</p>
		<p>
		<b> Content:</b> </b>
		<b class="text-primary"></b>
		<b class="text-success"> Notes By:</b> </b>
		<b class="text-primary"></b>
		</p>
		
		</div>
		</div>
		
	<%}
	}
	
	%>
	
	
	
	</div>
	
	</div>