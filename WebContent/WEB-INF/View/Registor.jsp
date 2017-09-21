<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2><%= request.getAttribute("msgRegistor") != null ? request.getAttribute("msgRegistor") : " " %></h2>
	<form action = "registerController" method = "POST">  
	Username :	<input type = "text" name = "uname" />
		</br>
		</br>
	Password :	<input type = "text" name = "password" />
		</br>
		</br>
		<input type = "submit" value = "Register" />
	</form>
</body>
</html>