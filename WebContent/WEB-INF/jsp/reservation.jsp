<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Spring MVC Form Handling</title>
    <link rel="stylesheet" type="text/css" href="csmain.css">
</head>
<body>
<div id="logout">
<form:form method="GET" action="/SpringMVCExample/logOut">
        <td colspan="2">
            <input type="submit" value="logOut"/>
        </td>
</form:form>
<form:form method="POST" action="/SpringMVCExample/returnMain">
        <td colspan="2">
            <input type="submit" value="Return"/>
        </td>
</form:form>
</div>
<h1>Movies</h1>
<div id="main">
<h2>Shows</h2>
<form:form>
   <table>
   	<c:forEach items="${myList}" var="shows">
    		  <table>
    		  	<tr><td>ID: <c:out value="${shows.getId()}"/></td></tr>
        		<tr><td>Date: <c:out value="${shows.getDate()}"/></td></tr>
        		<tr><td>Number of seats: <c:out value="${shows.getSeats()}"/></td></tr>  
        		<tr><td>Movie id: <c:out value="${shows.getIdMovie()}"/><hr></td></tr> 
   		 </table>
	</c:forEach>
</table>
</form:form>
<h2>Reservation</h2>
<form:form method="GET" action="/SpringMVCExample/addReservation">
   <table>
   <tr>
        <td><form:label path="idShow">Enter show id</form:label></td>
        <td><form:input path="idShow" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Make Reservation"/>
        </td>
    </tr>
</table>  
</form:form>
</div>
</body>
</html>