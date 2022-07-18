<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Employees" method="post">
		<!-- -need to mention method=post -->
		<center>
			<div>
				ID: <input type='text' name='id'>
			</div>
			<div>
				<!--  key should be in lower case -->
				First Name: <input type='text' name='fname'>
				<div>
					<div>
						<!--  key should be in lower case -->
						Last Name: <input type='text' name='lname'>
					</div>
					<div>
						Email: <input type='text' name='email'>
					</div>
					<div>
						Job_Id: <input type='text' name='jobid'>
					</div>
					<div>
						Hire Date: <input type='text' name='hdate'>
					</div>
					<div>
						Salary: <input type='text' name='salary'>
					</div>
					<div>
						<input type='submit' value='Add Employee' name='submit'> <input
							type='submit' value='Update Employee' name='submit'>
					</div>
		</center>
		<h1>Delete Employee</h1>
		<center>
			<div>
				ID: <input type='text' name='empid'> <input type='submit'
					value='Delete' name='submit'>
			</div>
		</center>
	</form>
</body>
</html>