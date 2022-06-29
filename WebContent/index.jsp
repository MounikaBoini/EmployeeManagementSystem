<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
 	input{
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
 		left:-15%;
 		color:#555;
 	}
 	a{
 	  color:#444;
 	}
</style>
</head>
<body>
	<form action="LoginControl" method="post">
    <p style='color:#777; left:0%;font-weight:bold;'>${param.msg}</p><br>
	<label> Enter Username:<br>
	<input type="text" name="username" required="required"></label><br><br><br>
	<label>Enter Password:<br>
	<input type="password" name="pass" required="required"></label><br><br><br>
	<input type="submit" value="Login" id="sub"><br><br>
	<p>Don't have an account <a href="Signup.jsp">SignUp</a> here.
	</form>
</body>
</html>