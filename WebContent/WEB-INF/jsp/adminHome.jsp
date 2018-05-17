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
   <table>
    <tr>
    <form:form method="GET" action="/SpringMVCExample/addMovieMVC">
        <td colspan="2">
            <input type="submit" value="AddMovie"/>
        </td>
    </form:form>
    </tr>
    <tr>
    <form:form method="GET" action="/SpringMVCExample/deleteMovieMVC">
        <td colspan="2">
            <input type="submit" value="DeleteMovie"/>
        </td>
    </form:form>
    </tr>
     <tr>
    <form:form method="GET" action="/SpringMVCExample/addUserMVC">
        <td colspan="2">
            <input type="submit" value="AddUser"/>
        </td>
    </form:form>
    </tr>
    <tr>
    <form:form method="GET" action="/SpringMVCExample/updateMovieMVC">
        <td colspan="2">
            <input type="submit" value="UpdateMovie"/>
        </td>
    </form:form>
    </tr>
     <tr>
    <form:form method="GET" action="/SpringMVCExample/deleteUserMVC">
        <td colspan="2">
            <input type="submit" value="DeleteUser"/>
        </td>
    </form:form>
    </tr>
    <tr>
    <form:form method="GET" action="/SpringMVCExample/addShowMVC">
        <td colspan="2">
            <input type="submit" value="AddShow"/>
        </td>
    </form:form>
    </tr>
    <tr>
    <form:form method="GET" action="/SpringMVCExample/deleteShowMVC">
        <td colspan="2">
            <input type="submit" value="DeleteShow"/>
        </td>
    </form:form>
    </tr>
    </tr>
</div>
</table>  
</body>
</html>