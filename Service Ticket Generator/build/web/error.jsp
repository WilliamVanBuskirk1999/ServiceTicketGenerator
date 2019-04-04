<%-- 
    Document   : error
    Created on : 29-Jan-2019, 7:02:22 PM
    Author     : billy
    Assignment : 3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title Error Page Page</title>
    </head>
    <body>
        <h1>Errors</h1>
       <%=exception.toString()%>
       <%=exception.getMessage()%>
               
    </body>
</html>
