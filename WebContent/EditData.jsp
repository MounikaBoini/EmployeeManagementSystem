<!DOCTYPE html>
<%@page import="model.*"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Data</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet" type="text/CSS">
<style>
	*{
		font-family:Calibri;
	 }
	h2{
		position:relative;
		left:15%;
		top:-2.7em;
	}
   form{
		position:relative;
		top:2em;
		left:30%;
		border:1px solid #aaa;
		padding:5%;
		width:25%;
 	}
 	input,select{
 	    border:none;
 		border-bottom:1px solid #aaa;
 		width:75%;
 		color:#888;
 	}
 	label{
 		color:#444;
 	}
 	.btn{
 		position:inherit;
 		background-color:navy;
 		padding:5px;
 		color:#eee;
 		border:none;
 		width:35%;
 	}
 	.btn:hover{
 	background-color:purple;
 	}
 	p{
 		position:inherit;
 		top:-2em;
 		Font-weight:bold;
 		color:purple;
 	}
 	a{
 	  color:#444;
 	}
 	#logout{
 		position:relative;
 		left:95%;
		text-decoration:none;
		color:#6C3483;
		font-size:x-large;
		font-weight:bold;
 	}
 	#logout:hover{
 		color:#A569BD ;
 	}
 	i{
 		font-size:xx-large;
 	}
</style>
</head>
<body>
<%!
	String fname,lname,dob,doj,email,phn,desig;
	int id,sal,amt;
 %>
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
	    		 desig=(String)s1.getAttribute("desig");
	    		if(desig.equals("Sales Manager")) {
	    			SalesManager sm=(SalesManager)s1.getAttribute("employee");
	    			id=sm.getId();
	    			fname=sm.getFname();
	    			lname=sm.getLname();
	    			dob=sm.getDob();
	    			email=sm.getEmail();
	    			phn=sm.getPhn();
	    			doj=sm.getDoj();
	    			sal=sm.getSal();
	    			amt=sm.getIncen();
				}
				else if(desig.equals("HR")) {
					HR hr=(HR)s1.getAttribute("employee");
					id=hr.getId();
	    			fname=hr.getFname();
	    			lname=hr.getLname();
	    			dob=hr.getDob();
	    			email=hr.getEmail();
	    			phn=hr.getPhn();
	    			doj=hr.getDoj();
	    			sal=hr.getSal();
	    			amt=hr.getComm();
				}
				else {
					Admin a=(Admin)s1.getAttribute("employee");
					id=a.getId();
	    			fname=a.getFname();
	    			lname=a.getLname();
	    			dob=a.getDob();
	    			email=a.getEmail();
	    			phn=a.getPhn();
	    			doj=a.getDoj();
	    			sal=a.getSal();
	    			amt=a.getAllow();
				}
%>
	<a href="Home.jsp"><i class="fa fa-home" aria-hidden="true"></i></a>
	<a href="Logout" id="logout">Logout</a>
	<form action="UpdateControl" method="post">
	 <!--${param.errmsg}<br><br>  Expression language -->
    <h2>Add Employee Details</h2>
     <p>${param.msg}</p><br>
    <label> Enter Employee ID:<b style='color:red;'>*</b><br>
	<input type="number" name="id" value=<%=id %> required="required" readonly="readonly"></label><br><br><br>
	
	
	
	<label> Enter Firstname:<b style='color:red;'>*</b><br>
	<input type="text" name="fname" value=<%=fname %> required="required"></label><br><br><br>

	
	<label>Enter Lastname:<b style='color:red;'>*</b><br>
	<input type="text" name="lname" value=<%=lname %> required="required"></label><br><br><br>
	
	
	<label>Enter DOB:<b style='color:red;'>*</b><br>
	<input type="date" name="dob" value=<%=dob %> required="required"></label><br><br><br>
	
	
	<label>Enter email:<b style='color:red;'>*</b><br>
	<input type="email" name="email" value=<%=email %> required="required"></label><br><br><br>
	
	
	<label>Enter Phone No:<b style='color:red;'>*</b><br>
	<input type="number" name="phn" value=<%=phn %> required="required"></label><br><br><br>
	
	
	<label>Enter Date of Joining:<b style='color:red;'>*</b><br>
	<input type="date" name="doj" value=<%=doj %> required="required"></label><br><br><br>
	
	
	<label>Enter Designation:<b style='color:red;'>*</b><br>
	<select onchange="addbox()" id="select" name="desig" required="required">
	<option value="Sales Manager"<%if(desig.equals("Sales Manager")) {%>selected<%} else{%>disabled<%}%>>Sales Manager</option>
	<option value="HR"<%if(desig.equals("HR")) {%>selected<%}  else{%>disabled<%}%>>HR</option>
	<option value="Admin"<%if(desig.equals("Admin")) {%>selected<%} else{%>disabled<%}%>>Admin</option>
	</select><br><br></label><br>
	
	
	<label id="label" for="amt">Enter Incentives/Commission/Allowance:<br>
	</label>
	<input type="number" name="amt" value=<%=amt %> id="amt"><br><br><br>
	
	<label>Enter Salary (Basic pay):<b style='color:red;'>*</b><br>
	<input type="number" name="sal" value=<%=sal %> required="required"></label><br><br><br>
	<input type="submit" value="EDIT" class="btn">&nbsp; &nbsp;
	<input type="reset" value="CLEAR" class="btn"><br><br>
	</form>
	<% }
	catch(Exception e){
	    		response.sendRedirect("index.jsp?msg=You're logged out please login to access");
	    		e.printStackTrace();
	    	}
	} %>
</body>
</html>