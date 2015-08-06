<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginPage</title>
</head>
<body>
<center>
	<h1>HomePage </h1>
        <form method="Post" action="LoginServlet">
        User Name:<input type="text" name="name" /><br><br>
        
        Password:<input type="password" name="pass" /><br><br>
	
        <input type="submit" value="Login" /><br>
<br>
<a href="forgotpwd.html">Forgot password ?</a>
	
        </form>
</center>
</body>
</html>