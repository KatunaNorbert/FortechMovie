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
</div>
<h1>Movie</h1>
<div id="div">
<form:form method="POST" action="/SpringMVCExample/logIn">
   <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
        <td>${message1}</td>
    </tr>
    <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input type="password" visible="false" path="password" /></td>
        <td>${message2}</td>
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