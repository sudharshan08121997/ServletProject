<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	response.setHeader("Cache-control", "no-cache,no-store,must-revalidate");
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("login.jsp");
	}
	
	%>

	Welcome ${username}
	<a href="videos.jsp">videos here</a>
	
	<form action="Logout" method="get">
		<input type="submit" value="Logout">
	</form>
</body>
</html>