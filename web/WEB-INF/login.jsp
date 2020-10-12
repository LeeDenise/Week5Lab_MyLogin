<%-- 
    Document   : login
    Created on : Oct 12, 2020, 9:34:23 AM
    Author     : 807785
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action="login">
            Username: <input type="text" name="username" value="${user.username}"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Log In">
        </form>
        <p>${message}</p>
    </body>
</html>
