<%-- 
    Document   : Login
    Created on : 29.01.2016, 10:40:23
    Author     : vl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method = "post" action = "LoginServlet"  >
            <h1>${message}</h1>
            <ul>
                <li><label> Login:    <input type='text'     name ="login"    id = "login"/>   </label></li>
                <li><label> Password: <input type='password' name ="password" id = "password"/></label></li>
                <li><input type = "submit" name ="action" value = "Enter"></li>
                <li><input type = "submit" name ="action" value = "Add"></li>
            </ul>
        </form>>
    </body>
</html>
