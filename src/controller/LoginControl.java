package controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import model.Manager;

public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u=request.getParameter("username");
		String p=request.getParameter("pass");
		
		Manager m1=new Manager(u,p);
		db.DAO d=new db.DAO();  //fully qualified name
	    try {
			Manager m= d.Validate(m1);
			if(m!=null) 
			{
				HttpSession s=request.getSession();
				s.setAttribute("Manager", m);
				response.sendRedirect("Home.jsp");
			}
		    else 
		    {
					response.sendRedirect("index.jsp?msg=Invalid Email/Password");
			}
		} 
		catch (Exception e1) {
			response.sendRedirect("index.jsp?msg=Could not login please try after some time");
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
