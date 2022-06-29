<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
	<style>
		.container{
			position:relative;
			top:5em;
			margin:auto;
			box-sizing:border-box;
			display:flex;
			padding:1%;
			justify-content:space-between;
			width:85%;
		}
		.container div{
			padding:10%;
			border-radius:15px;
			background:url("data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBw0QEA8NEA8NDQ8PDQ0NDw8NDQ8QDw8NFREWFhURFRUYHSggGBolGxUTITEhJSkrLi4uFx8zODMsNygtLisBCgoKDg0OFg8QFSsdFR0rKysrLSsrKy0rLSsrLS0rLSstKy0tLSstLSsrLSsrNys3Ky0tLSs3LSsrLSstNy0rN//AABEIALcBEwMBIgACEQEDEQH/xAAaAAEBAQEBAQEAAAAAAAAAAAAAAQIDBAUH/8QAKhABAQABAgUEAgAHAAAAAAAAAAECAxESITFBUQRhcZGBoRNSkrHB0fH/xAAYAQEBAQEBAAAAAAAAAAAAAAAAAQIDBP/EABwRAQEAAwADAQAAAAAAAAAAAAABAhESITFRQf/aAAwDAQACEQMRAD8A/TgHF6AAAAAAAAAAAoAAAKIAAAAAABu7aGnvzvT+7Glp7/Hd65Bm1Xk9T1/Eep5/VTpfbZKkcGcm4xl1ZVjYWpsqjzZ5b121cuWzhG8Z+pam6N7o0y+gAw6AAALARRAAAAAAACUIAAAAAAA3p4W327008Lb/AJerHGSbQS1cZJygAwOfqMeXxXQs7A8OyZRrLHa7Iy05EjeWLOpdoLt5tXLn+mCrHSMIhaND6+Xp725/LlljZ1mz2lc16eEerLQxvs5ZaF7bUa25DWWNnWVkUAAAAAAAAAAAABZLeU5gjpp6VvPpHTT0O9+nYZtTHGTlFAZAAAAc9fT35zrP28r3OOto78518JYrzZOGvl0n5d68ure64wrFSNM1tEsFAfdBWBBUAZuGN7RoByuhj7xm+n9/07gu6810MvZm6WXh6wOnjuN8X6R7kF6eEe3hnifRwY+J9QOniHt4MfE+oTGeJ9B08clva1uaOXjb5eoDpxx9PO93dsZJ05AM7VAAAAAAAAABx9Rpyz38vBq6OU957f6e7PLescTrMfDncvL5uyPpXa9ZL8xn+Hh/Lj9HK9vno+lwY/y4/wBMDk7exRHNsAQAAAAAAAAAAAAAAAAAAAAFBQQEBnUy2n6acdXLe/DWM3WcrqMMtObq5tCQqjWwyA9gDzuwAAAAKgAAAAAACiKKgIAAAAAAKgAAW7KJnltHnazy3ZdMZpyyu0rDdY2aQjSbCiAA9oDzuwAAoigAgAAAAAAqAAAADGpqTFRtjLWxnff4efUzuXXp4jjOVbmH1i5PVlr3tNmLqZeazsWNajG6syvm/Zd50t+6mLVUT+Jl5v2SsgOgQArFjYDmN7FgMDXCA9YDg7AAAAAAAAAqAAAAAAWgzqZ7fLzXm3bv1Sx2xmnO3bFcs+rvwuGc5qy66dbccHTEFUAcwoo3jVYi7oNCbm4KAAAD0io4OwAAAAAAoKIAgAAAAOetl2dMrtzeXLNvGM5Vnibc2sb2dHONuOtj3dZSiuOLpizcNujWIinVKSAcK8KgImUUoMAKLG2cWkANwHpAcHYAAAAAAAAAAAAAyu03UcPUZdvzXFbd+aO0mo427FiLj1UbUEUYybZzBJVYBG03ZWQFhksjOQIAo1i0xGt0FE3ANP1nbKbe86PVLvznP4fPuKaeeWHOdO87OWm5k+iMaWrjlN5+Z3jaNgqIAAAAAACgoOHqMu35rs82W1u7WM8s5VzG+Fmx0c0XHqjWANgCiVWc9+wMC8jYRFjUigMbVsBzG2bARUFAAGoWA4NOeUuN4p1n1Z4ezR1JlJlP+Xwoqz22gMtgAAAAAAAMa2W0+XmoOuPpyy9tY1dwaGOJcKAjYAoADNigIAAAAJVAcwAAFH//2Q==") no-repeat center center / cover;
			box-shadow:2px 1px 10px 0px grey;
		}
		.container div a{
			text-decoration:none;
			color:purple;
			font-size:larger;
			font-weight:bold;
			font-family:calibri;
		}
		.container div a:hover{
			font-size:xx-large;
		}
		.header{
		background-color:#333;
		color:white;
		display:flex;
		justify-content:space-between;
		width:100%;
		font-size:xx-large;
		font-family:calibri;
		}
		.header a{
		padding:2%;
		text-decoration:none;
		color:coral;
		font-size:x-large;
		font-weight:bold;
		}
	</style>
</head>
<body>
	<div class="header">
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
	    		out.print("<p>&nbsp;&nbsp;Welcome "+m.getUsername()+"</p><br>");
	    	}
	    	catch(Exception e){
	    		response.sendRedirect("index.jsp?msg=You're logged out please login to access");
	    	}
	    }
	%>
	<br>
	<a href="Logout">Logout</a>
	</div>
	<div class="container">
		<div>
		<a href="Add.jsp">Add</a>
		</div>
		<div>
		<a href="Remove.jsp">Remove</a>
		</div>
		<div>
		<a href="Edit.jsp">Edit</a>
		</div>
		<div>
		<a href="View.jsp">View</a>
		</div>
	</div>
</body>
</html>