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
<h3>Hello ${name}</h3>
<div id="logout">
<form:form method="GET" action="/SpringMVCExample/logOut">
        <td colspan="2">
            <input type="submit" value="logOut"/>
        </td>
</form:form>
<form:form method="GET" action="/SpringMVCExample/showReservations">
        <td colspan="2">
            <input type="submit" value="MyReservations"/>
        </td>
</form:form>
</div>
</header>
<div id="main">
<form:form method="GET" action="/SpringMVCExample/makeReservation">
   <table>
   	<c:forEach items="${mList}" var="movies">
    		  <table>
    		  	<tr><td>ID: <c:out value="${movies.getId()}"/></td></tr>
        		<tr><td>Name: <c:out value="${movies.getName()}"/></td></tr>
        		<tr><td>Genre: <c:out value="${movies.getGenre()}"/></td></tr>  
        		<tr><td>Description: <c:out value="${movies.getDescription()}"/><hr></td></tr> 
   		 </table>
	</c:forEach>
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