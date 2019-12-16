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
<title>Student</title>
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
	
	<form action = "AddStudentServlet" method = "POST" enctype="multipart/form-data" onsubmit="return checkForm(this);">
	
		<div class="form-group">
			<div>
				<label for="usr">Name:</label>
						<input type="text" class="form-control" id="usr" placeholder="Ex. Juan" name = "name" required>
					</div>
					<div>
				<label for="addr">Contact Number:</label>
						<input type="text" class="form-control" id="addr" placeholder="Ex. 09178093008" name = "contactnum" required>
			</div>
			<div>
				<label for="usrname">School:</label>
						<input type="text" class="form-control" id="usrname" placeholder="De La Salle University" name = "school" required>
					</div>
			<div>
				<label for="password">Degree:</label>
						<input type="text" class="form-control" id="password" placeholder="BS-CS" name = "degree" required>
			</div>
			<div>
				<label for="password">Year:</label>
						<input type="text" class="form-control" id="password" placeholder="2019" name = "year" required>
			</div>
			<div class="col-sm-3">
				<div style = "padding-top: 1em">
					<input type="submit" class="btn btn-lg btn-primary" value="Save">
				</div>
			</div>
	
		</div>
	</form>

</body>
</html>