package controller;

import java.io.*;


import javax.servlet.ServletException;
import javax.servlet.http.*;

import model.Manager;

/**
 * Servlet implementation class RegisterControl
 */
public class SignupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u=request.getParameter("username");
		String p=request.getParameter("pass");
		String cp=request.getParameter("cpass");
		if(p.equals(cp))
		{
			
			Manager m=new Manager(u,p);
			db.DAO d=new db.DAO();  ///fully qualified name
			try {
				d.insert(m);
				response.sendRedirect("index.jsp?msg=Successfully Registered");
			} 
			catch (Exception e1) {
				response.sendRedirect("Signup.jsp?msg=Could not register please try after some time");
			}
			
		}
		else 
		{
			response.sendRedirect("Signup.jsp?msg=Password and Confirm Password should match");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
