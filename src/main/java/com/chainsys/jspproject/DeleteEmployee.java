package com.chainsys.jspproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.jspproject.commonutil.ExceptionManager;
import com.chainsys.jspproject.commonutil.InvalidInputDataException;
import com.chainsys.jspproject.commonutil.Validator;
import com.chainsys.jspproject.dao.EmployeeDao;

/**
 * Servlet implementation class DeleteEmployee
 */
@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source = "Delete Employee";
		String message = "<h1>Error while " + source + "</h1>";
		int result ;

		PrintWriter out = response.getWriter();
		String s1 = request.getParameter("id");
		int empId ;
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
//		 result = EmployeeDao.deleteEmployee(empId);
//		out.println("<div> Delete The Employee " + result + "<div>");
		}
		result = EmployeeDao.deleteEmployee(empId);
        request.setAttribute("deleteemp", result);
        RequestDispatcher rd = request.getRequestDispatcher("deleteemp.jsp");
        rd.forward(request, response);
		}
	}
	