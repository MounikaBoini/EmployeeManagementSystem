<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet" type="text/CSS">
<style>
	*{
		font-family:Calibri;
	 }
   form{
		position:relative;
		top:5em;
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
 	#sub{
 		position:inherit;
 	    left:18%;
 		background-color:navy;
 		padding:5px;
 		color:#eee;
 		border:none;
 		width:35%;
 	}
 	#sub:hover{
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
	<a href="Logout" id="logout">Logout</a>
	<form action="EditControl" method="post">
    <p>${param.msg}</p><br>
	<label> Enter Employee ID:<b style='color:red;'>*</b><br>
	<input type="number" name="id" required="required"></label><br><br><br>
	
	<label>Enter Designation:<b style='color:red;'>*</b><br>
	<select id="select" name="desig" required="required">
	<option>Sales Manager</option>
	<option>HR</option>
	<option>Admin</option>
	</select><br><br></label><br>
	<input type="submit" value="Edit Record" id="sub"><br><br>
	</form>
</body>
</html>