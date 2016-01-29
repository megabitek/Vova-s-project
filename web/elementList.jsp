<%-- 
    Document   : elementList
    Created on : 29.01.2016, 13:24:37
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
        <table>
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Image</th>
              <c:forEach items="${list}" var="item">  
                  <tr><td>${item.getElementid}</td>
                  <td>${item.getName()}</td>
                  <td>${item.getDescription}</td>
                  <td>${item.getImage()}</td>
                  </tr>
              </c:foreach>
        </table>
                  
    </body>
</html>
