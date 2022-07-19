<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE EMPLOYEE</title>
</head>
<body>
<form action="UpdateEmployee" method="post" > <!-- -need to mention method=put -->
		<center>
		<div>
			ID: <input type='text' name='id' ></div>
			<div>    <!--  key should be in lower case -->
			First Name: <input type='text' name='fname' ><div>
			<div>                       <!--  key should be in lower case -->
			Last Name: <input type='text' name='lname' >
			</div>
			<div>                       
			Email: <input type='text' name='email' >
			</div>			
			<div>                       
			Job_Id: <input type='text' name='jobid' >
			</div>
			<div>                       
			Hire Date: <input type='text' name='hdate' >
			</div>
			<div>                       
			Salary: <input type='text' name='salary' >
			</div>		
			<div>
			<input type='submit' value="Update Employee" name='submit'>  
			</div>         
		</center>
		</form>
</body>
</html>