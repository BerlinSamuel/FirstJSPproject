package com.chainsys.jspproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.jspproject.dao.EmployeeDao;
import com.chainsys.jspproject.pojo.Employee;
import com.chainsys.jspproject.commonutil.ExceptionManager;
import com.chainsys.jspproject.commonutil.InvalidInputDataException;
import com.chainsys.jspproject.commonutil.Validator;


@WebServlet("/Employees")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmployeeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  List<Employee> allEmployee = EmployeeDao.getAllEmployee();
	request.setAttribute("emplist", allEmployee);
	RequestDispatcher rd = request.getRequestDispatcher("/viewEmployee.jsp");
	rd.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 String submitvalue = request.getParameter("submit");
	 if(submitvalue.equals("Add Employee")) {
		 String source = "Add New Employee";
		 String message = "<h1> Error while "+source +"</h1>";
		 PrintWriter out = response.getWriter();
		 Employee newEmp = new Employee();
		 String id = request.getParameter("id");
		 int empId;
		 try { 
			 Validator.checkStringForParseInt(id);
			 empId = Integer.parseInt(id);
		 }catch(InvalidInputDataException err) {
			 message += "Error in Employee id :</p>";
			 String errorPage = ExceptionManager.handleException(err, source, message);
			 out.print(errorPage);
			 return ;
			 
		 }
		 try {
				Validator.checkNumberForGreaterThanZero(empId);
				newEmp.setEmployee_Id(empId);
			} catch (InvalidInputDataException err) {
				message += " Error in Employee id input: </p>";
				String errorPage = ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
				return;
			}
		 String Fname = request.getParameter("fname");
		 try {
				Validator.checkStringOnly(Fname);
				Validator.checklengthOfString(Fname);
				newEmp.setFirst_name(Fname);
			} catch (InvalidInputDataException err) {
				message += " Error in Employee first name input: </p>";
				String errorPage = ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
				return;			
				}
			String Lname = request.getParameter("lname");
			try {
				Validator.checkStringOnly(Lname);
				Validator.checklengthOfString(Lname);
				newEmp.setLast_name(Lname);
			} catch (InvalidInputDataException err) {
				message += " Error in Employee last name input: </p>";
				String errorPage = ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
				return;

			}

		
			String email = request.getParameter("email");
			try {
				Validator.checkEmail(email);
				newEmp.setEmail(email);
			} catch (InvalidInputDataException e) {
				message += " Error in Employee email input: </p>";
				String errorPage = ExceptionManager.handleException(e, source, message);
				out.print(errorPage);
				return;
			}

			

			String jobid = request.getParameter("jobid");
			try {
				Validator.checkJobId(jobid);
				newEmp.setJob_id(jobid);
			} catch (InvalidInputDataException err) {
				message += " Error in Employee job_id input: </p>";
				String errorPage = ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
				return;
				}		
			String sDate = request.getParameter("hdate");
			Date date = null;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);

			} catch (ParseException e) {
				message += " Error in Employee hire_date input: </p>";
				String errorPage = ExceptionManager.handleException(e, source, message);
				out.print(errorPage);
				return;
			}
			try {
				Validator.checkDateFormat(sDate);
				newEmp.setHire_date(date);
			} catch (InvalidInputDataException err) {
				message += " Error in Employee hire_date input: </p>";
				String errorPage = ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
				return;			}

			
			String salary = request.getParameter("salary");
			Float fsalary;
			try {
				Validator.checkStringForParseFloat(salary);
				fsalary = Float.parseFloat(salary);

			} catch (InvalidInputDataException err) {
				message += " Error in Employee salary input: </p>";
				String errorPage = ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
				return;
			}
			try {
				Validator.checkSalLimit(fsalary);
				newEmp.setSalary(fsalary);
			} catch (InvalidInputDataException err) {
				message += " Error in Employee salary input: </p>";
				String errorPage = ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
				return;
			}
//			int result = EmployeeDao.insertEmployee(newEmp);
//
//			out.println("<div> Add New Employee: " + result + "</div>");// do not give object only browser response to
//																		// string
			int result = EmployeeDao.insertEmployee(newEmp);
            request.setAttribute("addemp", result);
            RequestDispatcher rd = request.getRequestDispatcher("/addemployees.jsp");
            rd.forward(request, response);
			}else if(submitvalue.equals("Update Employee")) {
				doPut(request, response);
			}else if(submitvalue.equals("Delete Employee")) {
				doDelete(request, response);
			}else if(submitvalue.equals("View All Employee")) {
				doGet(request, response);
			}
	}
	 protected void doPut(HttpServletRequest request, HttpServletResponse response ) throws IOException {
		 
			 String source = "Update Employee";
			 String message = "<h1> Error while "+source +"</h1>";
			 PrintWriter out = response.getWriter();
			 Employee newEmp = new Employee();
			 String id = request.getParameter("id");
			 int empId;
			 try {
				 Validator.checkStringForParseInt(id);
				 empId = Integer.parseInt(id);
			 }catch(InvalidInputDataException err) {
				 message += "Error in Employee id :</p>";
				 String errorPage = ExceptionManager.handleException(err, source, message);
				 out.print(errorPage);
				 return;
				 
			 }
			 try {
					Validator.checkNumberForGreaterThanZero(empId);
					newEmp.setEmployee_Id(empId);
				} catch (InvalidInputDataException err) {
					message += " Error in Employee id input: </p>";
					String errorPage = ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
					return;
				}
			 String Fname = request.getParameter("fname");
			 try {
					Validator.checkStringOnly(Fname);
					Validator.checklengthOfString(Fname);
					newEmp.setFirst_name(Fname);
				} catch (InvalidInputDataException err) {
					message += " Error in Employee first name input: </p>";
					String errorPage = ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
					return;			}

			

				String Lname = request.getParameter("lname");
				try {
					Validator.checkStringOnly(Lname);
					Validator.checklengthOfString(Lname);
					newEmp.setLast_name(Lname);
				} catch (InvalidInputDataException err) {
					message += " Error in Employee last name input: <p/>";
					String errorPage = ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
					return;

				}

			
				String email = request.getParameter("email");
				try {
					Validator.checkEmail(email);
					newEmp.setEmail(email);
				} catch (InvalidInputDataException e) {
					message += " Error in Employee email input: <p/>";
					String errorPage = ExceptionManager.handleException(e, source, message);
					out.print(errorPage);
					return;
				}

				

				String jobid = request.getParameter("jobid");
				try {
					Validator.checkJobId(jobid);
					newEmp.setJob_id(jobid);
				} catch (InvalidInputDataException err) {
					message += " Error in Employee job_id input: <p/>";
					String errorPage = ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
					return;}

			
				String sDate = request.getParameter("hdate");
				Date date = null;
				try {
					date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);

				} catch (ParseException e) {
					message += " Error in Employee hire_date input: <p/>";
					String errorPage = ExceptionManager.handleException(e, source, message);
					out.print(errorPage);
					return;
				}
				try {
					Validator.checkDateFormat(sDate);
					newEmp.setHire_date(date);
				} catch (InvalidInputDataException err) {
					message += " Error in Employee hire_date input: <p/>";
					String errorPage = ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
					return;			}

				
				String salary = request.getParameter("salary");
				Float fsalary;
				try {
					Validator.checkStringForParseFloat(salary);
					fsalary = Float.parseFloat(salary);

				} catch (InvalidInputDataException err) {
					message += " Error in Employee salary input: <p/>";
					String errorPage = ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
					return;
				}
				try {
					Validator.checkSalLimit(fsalary);
					newEmp.setSalary(fsalary);
				} catch (InvalidInputDataException err) {
					message += " Error in Employee salary input: <p/>";
					String errorPage = ExceptionManager.handleException(err, source, message);
					out.print(errorPage);
					return;
				}
//				int result = EmployeeDao.updateEmployee(newEmp);
//				out.println("<div> Update New Employee: " + result + "</div>");// do not give object only browser response to
				int result = EmployeeDao.updateEmployee(newEmp);
	            request.setAttribute("updateemp", result);
	            RequestDispatcher rd = request.getRequestDispatcher("updateemp.jsp");
	            try {
					rd.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	 }													
		 
	 public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String source = "Delete Employee";
			String message = "<h1>Error while " + source + "</h1>";
			int result ;

			PrintWriter out = response.getWriter();
			String s1 = request.getParameter("id");
			int empId = 0;
			try {
				Validator.checkStringForParseInt(s1);
				empId = Integer.parseInt(s1);

			} catch (InvalidInputDataException err) {
				message += " Error in Employee Emp_id input: <p/>";
				String errorPage = ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
				return;	
			}

			try {
				EmployeeDao.getEmployeeById(empId);
				Validator.checkNumberForGreaterThanZero(empId);
			} catch (InvalidInputDataException err) {
				message += " Error in Employee Emp_id input: <p/>";
				String errorPage = ExceptionManager.handleException(err, source, message);
				out.print(errorPage);
				return;	
			}
			 result = EmployeeDao.deleteEmployee(empId);
			out.println("<div> Delete The Employee " + result + "<div>");

		}

}
