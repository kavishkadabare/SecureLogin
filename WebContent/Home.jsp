<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<H1>Home </H1>;

<form action="WelcomeServlet" method="POST">
<%=session.getAttribute("crsfToken") %>
<input name="token" type ="hidden" value=<%=session.getAttribute("crsfToken")%>/>
<h4>Type something</h4><input type = "text"/>
<button type = "submit">Submit </button>
</form>

</body>
</html>