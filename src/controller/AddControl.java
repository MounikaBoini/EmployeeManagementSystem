package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import db.*;

public class AddControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int id,salary,amt=0;
    private String fname,lname,dob,doj,email,desig,phn,ch;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.id=Integer.parseInt(request.getParameter("id"));
		this.fname=request.getParameter("fname").trim();
		this.lname=request.getParameter("lname").trim();
		this.dob=request.getParameter("dob");
		this.email=request.getParameter("email").trim();
		this.phn=request.getParameter("phn");
		this.doj=request.getParameter("doj");
		this.desig=request.getParameter("desig");
		this.ch=request.getParameter("amt");
		this.salary=Integer.parseInt(request.getParameter("sal"));
		if(validate()) {
		  try {
			 EmployeeDAO ed=new EmployeeDAO();
			if(ed.validate(id)==null) {
				if(desig.equals("Sales Manager")) {
					SalesManager sm=new SalesManager(id,fname,lname,dob,email,doj,phn,desig,salary,amt);
					ed.insertSM(sm);
					}
				else if(desig.equals("HR")) {
					HR hr=new HR(id,fname,lname,dob,email,doj,phn,desig,salary,amt);
					ed.insertHR(hr);
				}
				else {
					Admin a=new Admin(id,fname,lname,dob,email,doj,phn,desig,salary,amt);
					ed.insertAdmin(a);
				}
				response.sendRedirect("Add.jsp?msg=Data inserted successfully");
				}
			else {
				response.sendRedirect("Add.jsp?msg=Employee ID already exists with name "+ed.validate(id));
			}
		 }
		 catch(Exception e) {
				response.sendRedirect("Add.jsp?msg=Could not insert please try after some time");
		}
	 }
	else {
			response.sendRedirect("Add.jsp?msg=All fields with star are manadatory");
	   }
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}
	//validate
	boolean validate() {
		if( this.fname.equals("") || this.lname.equals("") || this.email.equals(""))
			return false;
		else if(phn.length()!=10)
			return false;
		else if(!ch.equals("")) {
			this.amt=Integer.parseInt(ch);
			return true;
		}
		else {
			return true;
		}
		
	}
}
