<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
    <link rel="stylesheet" type="text/css" href="cshome.css">
</head>
<body>
<h1>Movie</h1>
<div id="div">
   <table>
    <tr>
    <form:form method="GET" action="/SpringMVCExample/signUpp">
        <td colspan="2">
            <input id="input" type="submit" value="SignUpp"/>
        </td>
    </form:form>
    </tr>
    <tr>
    <form:form method="GET" action="/SpringMVCExample/logInMVC">
        <td colspan="2">
            <input id="input" type="submit" value="logIn"/>
        </td>
    </form:form>
    </tr>
</table>
</div>
</body>
</html>