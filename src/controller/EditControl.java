package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import db.EmployeeDAO;
import model.*;

public class EditControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id;
    private String desig;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.id=Integer.parseInt(request.getParameter("id"));
		this.desig=request.getParameter("desig");
		EmployeeDAO ed=new EmployeeDAO();
		HttpSession s1=request.getSession();
		try {
			if(ed.validateDelete(id)!=null)
			{
				if(desig.equals("Sales Manager") && ed.validateDelete(id).equals("Sales Manager")) {
					SalesManager sm=ed.selectRecordSM(id);
					s1.setAttribute("employee", sm);
					s1.setAttribute("desig", "Sales Manager");
					response.sendRedirect("EditData.jsp");
				}
				else if(desig.equals("HR") && ed.validateDelete(id).equals("HR")) {
					HR hr=ed.selectRecordHR(id);
					s1.setAttribute("employee", hr);
					s1.setAttribute("desig", "HR");
					response.sendRedirect("EditData.jsp");
				}
				else if(desig.equals("Admin") && ed.validateDelete(id).equals("Admin"))
				{
					Admin a=ed.selectRecordAdmin(id);
					s1.setAttribute("employee", a);
					s1.setAttribute("desig", "Admin");
					response.sendRedirect("EditData.jsp");
				}
				else {
					response.sendRedirect("Edit.jsp?msg=Please enter valid data");
				}
			}
			else {
				response.sendRedirect("Edit.jsp?msg=Employee ID doesn't exist");
			}
		}	
		catch(Exception e) {
			response.sendRedirect("Edit.jsp?msg=Could not edit please try after some time");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
