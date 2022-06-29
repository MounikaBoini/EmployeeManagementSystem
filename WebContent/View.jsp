<%@page import="db.EmployeeDAO"%>
<%@page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet" type="text/CSS">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
 	*{
		font-family:Calibri;
	 }
 	#logout{
 		position:relative;
 		left:90%;
		text-decoration:none;
		color:#6C3483;
		font-size:x-large;
		font-weight:bold;
 	}
 	#logout:hover{
 		color:#A569BD ;
 	}
 	i{
 		color:#444;
 		font-size:xx-large;
 	}
 </style>
</head>
<body>
<%
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); //http version 1.1 and above
		response.setHeader("Pragma","no-cache");//http older version 1.0
		response.setHeader("Expires","0");//for proxy servers
		
		HttpSession s1=request.getSession();
	    if(s1==null || s1.isNew())
	    	response.sendRedirect("index.jsp?msg=login to access");
	    else
	    {
	    	try{
	    		model.Manager m=(model.Manager)s1.getAttribute("Manager");
	    		String s=m.getUsername();
	    	}
	    	catch(Exception e){
	    		response.sendRedirect("index.jsp?msg=You're logged out please login to access");
	    		e.printStackTrace();
	    	}
	    }
%>
    <a href="Home.jsp"><i class="fa fa-home" aria-hidden="true"></i></a>
	<a href="Logout" id="logout">Logout</a><br><br>
	<div class="table-responsive">
	 <table class="table table-striped table-bordered">
	 <thead>
	 <tr>
	  <th>Employee ID</th>
	  <th>Employee First Name</th>
	  <th>Employee Last Name</th>
	  <th>Date of Birth</th>
	  <th>Email</th>
	  <th>Date of Joining</th>
	  <th>Phone Number</th>
	  <th>Designation</th>
	  <th>Salary</th>
	 </tr>
	</thead>
	<%
	 try{
		db.EmployeeDAO	emp =new EmployeeDAO();
		ResultSet rs=emp.selectAll();
		while(rs.next()){%>
		 <tr>
		 <td><%=rs.getInt("id") %></td>
		 <td><%=rs.getString("Firstname") %></td>
		 <td><%=rs.getString("Lastname") %></td>
		 <td><%=rs.getString("Dob") %></td>
		 <td><%=rs.getString("Email") %></td>
		 <td><%=rs.getString("Doj") %></td>
		 <td><%=rs.getString("PhoneNo") %></td>
		 <td><%=rs.getString("Designation") %></td>
		 <td><%=rs.getInt("Salary") %></td>
		 </tr>	
		<% }
		emp.closeResource();
	 }
	catch(Exception e){
		System.out.println(e);
		out.print("<p>Oops!! Something went wrong, please try after some time</p><br>");
	}
	%>
	</table>
  </div>
</body>
</html>