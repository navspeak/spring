<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>    
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello There</title>
</head>
<body>

<p><a href="${pageContext.request.contextPath}/offers"> show offers</a></p>
<p><a href="${pageContext.request.contextPath}/createoffer"> Add a new offer</a></p>

Hello There!

Session : <%= session.getAttribute("name") %> <p/>

Request : <%= request.getAttribute("name") %> <p/>

Request (using EL): ${name} </p>
Request (using JSTL) : <c:out value="${name}" ></c:out> </p>
<!--  
<sql:query var="rs" dataSource="jdbc/spring">
select id, name, email, text from offers
</sql:query>

<c:forEach var="row" items="${rs.rows}">
    Id  ${row.id}<br/>
    Name ${row.name}<br/>
</c:forEach>
-->

<c:forEach var="row" items="${offers}">
    Id  ${row.id}<br/>
    Name ${row.name}<br/>
    Email ${row.email}<br/>
    Text ${row.text}<br/>
</c:forEach>
</body>
</html>