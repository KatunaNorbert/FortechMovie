<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Spring MVC Form Handling</title>
    <link rel="stylesheet" type="text/css" href="csmain.css">
</head>
<body>
<header>
<h1>Movies</h1>
<h3>${name}'s reservations</h3>
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
</header>
<div id="main">
<form:form method="GET" action="/SpringMVCExample/makeReservation">
   <table>
   	<c:forEach items="${mList}" var="res">
    		  <table>
    		  	<tr><td>ID: <c:out value="${res.getId()}"/></td></tr>
        		<tr><td>Date: <c:out value="${res.getDate()}"/></td></tr>
        		<tr><td>Remaining Seats: <c:out value="${res.getSeats()}"/></td></tr>  
        		<tr><td>MovieID: <c:out value="${res.getIdMovie()}"/><hr></td></tr> 
   		 </table>
	</c:forEach>
</table>
</form:form>
</div>  
</body>
</html>