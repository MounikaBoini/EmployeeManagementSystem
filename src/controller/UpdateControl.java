package controller;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

import db.EmployeeDAO;
import model.Admin;
import model.HR;
import model.SalesManager;

public class UpdateControl extends HttpServlet {
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
				if(desig.equals("Sales Manager")) {
					SalesManager sm=new SalesManager(id,fname,lname,dob,email,doj,phn,desig,salary,amt);
					ed.updateSM(sm);
				 }
				else if(desig.equals("HR")) {
					HR hr=new HR(id,fname,lname,dob,email,doj,phn,desig,salary,amt);
					ed.updateHR(hr);
				}
				else {
					Admin a=new Admin(id,fname,lname,dob,email,doj,phn,desig,salary,amt);
					ed.updateAdmin(a);;
				}
				response.sendRedirect("Edit.jsp?msg=Data edited successfully");
		  }
		 catch(Exception e) {
				response.sendRedirect("EditData.jsp?msg=Could not update please try after some time");
		}
	 }
	else {
			response.sendRedirect("EditData.jsp?msg=All fields with star are manadatory");
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
