<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
<style>
	*{
		font-family:Calibri;
	 }
   form{
		position:relative;
		top:2em;
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
 		left:-15%;
 		color:#555;
 	}
 	a{
 	  color:#444;
 	}
</style>
</head>
<body>
	<form action="SignupControl" method="post">
	 <!--${param.errmsg}<br><br>  Expression language -->
    <p style='color:#777; left:0%;font-weight:bold;'>${param.msg}</p><br>
	<label> Enter Username:<br>
	<input type="text" name="username" required="required"></label><br><br>
	<label>Enter Password:<br>
	<input type="password" name="pass" required="required"></label><br><br><br>
	<label>Confirm Password:<br>
	<input type="password" name="cpass" required="required"></label><br><br><br>
	<input type="submit" value="SignUp" class="btn">&nbsp; &nbsp;
	<input type="reset" value="Clear" class="btn"><br><br>
	<p>Already have an account <a href="index.jsp">Login</a> here.
	</form>
</body>
</html>