<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
    <link rel="stylesheet" type="text/css" href="cshome.css">
</head>
<body>
<div id="logout">
<form:form method="GET" action="/SpringMVCExample/logOut">
        <td colspan="2">
            <input type="submit" value="logOut"/>
        </td>
</form:form>
<form:form method="POST" action="/SpringMVCExample/returnAdminHome">
        <td colspan="2">
            <input type="submit" value="Return"/>
        </td>
</form:form>
</div>
<h1>Movie</h1>
<div id="div">
<form:form method="POST" action="/SpringMVCExample/addMovie">
   <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="genre">Genre</form:label></td>
        <td><form:input path="genre" /></td>
    </tr>
    <tr>
        <td><form:label path="description">Description</form:label></td>
        <td><form:input path="description" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</div>
</body>
</html>