package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


import model.*;
import db.*;

public class RemoveControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int id;
    private String desig,msg;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.id=Integer.parseInt(request.getParameter("id"));
		this.desig=request.getParameter("desig");
		EmployeeDAO ed=new EmployeeDAO();
		try {
			if(ed.validateDelete(id)!=null)
			{
				msg="Record deleted successfully";
				if(desig.equals("Sales Manager") && ed.validateDelete(id).equals("Sales Manager")) {
					ed.deleteSM(id);
				}
				else if(desig.equals("HR") && ed.validateDelete(id).equals("HR")) {
					ed.deleteHR(id);
				}
				else if(desig.equals("Admin") && ed.validateDelete(id).equals("Admin"))
				{
					ed.deleteAdmin(id);
				}
				else {
					msg="Please enter valid data";
				}
			  response.sendRedirect("Remove.jsp?msg="+msg);
			}
			else {
				response.sendRedirect("Remove.jsp?msg=Employee ID doesn't exist");
			}
		}	
		catch(Exception e) {
			response.sendRedirect("Remove.jsp?msg=Could not delete please try after some time");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doGet(request, response);
	}

}
