<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action = "navigationServlet"> 
<table> 
<tr> 
	<td> Select </td>
	<td> Make </td>
	<td> Model </td>
	<td> Arrangement </td>
	<td> Displacement </td>
	<td> Horsepower </td>
	<td> Series </td>
</tr>
<c:forEach items = "${requestScope.allItems}" var="currentcar"> 
<tr> 
	<td> <input type = "radio" name = "id" value="${currentcar.id}"> </td>
	<td> ${currentcar.make}</td>
	<td> ${currentcar.model}</td>
	<td> ${currentcar.arrangement}</td>
	<td> ${currentcar.displacement}</td>
	<td> ${currentcar.horsePower}</td>
	<td> ${currentcar.series}</td>
</tr>
</c:forEach>
</table>
<input type = "submit" value="edit" name="doThisToCar"> 
<input type = "submit" value="delete" name="doThisToCar"> 
<input type = "submit" value="add" name="doThisToCar"> 
</form>
</body>
</html>