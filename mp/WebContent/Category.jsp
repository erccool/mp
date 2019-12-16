<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="bootstrap-3.3.7-dist/jquery/jquery.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<style>
	.bg-company-blue {
    background-color: #5079D8;
	}
	
	li.borderless { border-top: 0 none;
					border-bottom: 0 none;
					border-left:0 none;
					border-right: 0 none; }
		
	.navbar-custom {
	    background-color: #3498DB;
	}	
</style>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose Category</title>
</head>
<body>
	<nav class="navbar navbar-custom">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" style="color: white">Address Book</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="Category.jsp" style="color: white">Add Contact</a></li>
			</ul>
		</div>
	</nav>
	
	<div class="container">
	  <h2>Choose Category</h2>
	  <a href="addEmployee.jsp" role="button" class="btn">Employee</a>
	  <a href="addFaculty.jsp"  role="button" class="btn btn-default">Faculty</a>
	  <a href="addStudent.jsp"  role="button" class="btn btn-primary">Student</a>
	</div>
	
	
</body>
</html>