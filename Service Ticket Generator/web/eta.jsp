<%-- 
    Document   : eta
    Created on : 19-Jan-2019
    Author     : billy
    Assignment 3
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    div{
        text-align:center;
    }
    h1,h2{
        text-align:center;
    }
    footer{
        text-align: center;
    }
</style>
<%!
    Calendar today = Calendar.getInstance();
    Calendar severe = Calendar.getInstance();
    Calendar high = Calendar.getInstance();
    Calendar medium = Calendar.getInstance();
    Calendar low = Calendar.getInstance();

    int year = Calendar.getInstance().get(Calendar.YEAR);
    Calendar cal = Calendar.getInstance();
    Date today2 = cal.getTime();
%>

<%
    severe.add(Calendar.DAY_OF_MONTH, 3);
    high.add(Calendar.DAY_OF_MONTH, 4);
    medium.add(Calendar.DAY_OF_MONTH, 5);
    low.add(Calendar.DAY_OF_MONTH, 5);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ETA of Service</title>
    </head>
    <body>
        <header>
            <nav>
                <a href="index.jsp"> Home </a>
                <a href="create_service_ticket.jsp">Create a Service Report Ticket</a>
                <a href="eta.jsp">View ETA</a>
            </nav>
        </header>
        <h1>Estimated Turnover Time</h1>
        <h2>Current Date: <%=today.getTime()%></h2>
        <Br>
        <div>
            <b>Severity</b><br>
            <label>Severe:</label>
            <%=severe.getTime()%>
            <br>

            <label>High</label>
            <%=high.getTime()%>
            <br>

            <label>Severe:</label>
            <%=medium.getTime()%>
            <br>

            <label>Severe:</label>
            <%=low.getTime()%>
            <br>


        </div>
        <footer>
            Copyright &copy; <%= year%> all rights reserved <br>
            Contact Us <Br>
            Todays date is <%= today2%>

        </footer>
    </body>
</html>
