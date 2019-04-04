<%-- 
    Document   : Create Service Ticket
    Created on : 18-Jan-2019
    Author     : billy
    Assignment 3
--%>


<%@page import="java.time.Month"%>
<%--<%@page import="jdk.management.resource.ResourceRequest"%>--%>
<%@page import="java.util.*"%>
<%@page import="java.util.Calendar.*"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="com.nbcc.serviceticket.business.ServiceTicket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@taglib prefix="customDDL" uri="/WEB-INF/tlds/customDDL.tld"%>
<style>
    div{
        text-align: center;
    }
    form{
        display:inline-block;
    }
    h1,h2{
        text-align:center;
    }
    footer{
        text-align: center;
    }
</style>

<%!
    int year = Calendar.getInstance().get(Calendar.YEAR);
    Calendar cal = Calendar.getInstance();
    Date today = cal.getTime();

    String[] months = new DateFormatSymbols().getMonths();
    String monthsForList = "";

    String days = "";
    String years = "";
%>
<%
    //Dynamically generating list box options
    for (String month : months) {
        monthsForList += "<option value=\"" + month + "\">" + month + "</option>";
    }

    for (int i = 1; i <= 31; i++) {
        days += "<option value=\"" + i + "\">" + i + "</option>";
    }

    for (int i = 2017; i < 2020; i++) {
        years += "<option value=\"" + i + "\">" + i + "</option>";
    }

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Service Ticket</title>
    </head>
    <header>
        <nav>
            <a href="index.jsp"> Home </a>
            <a href="#">Create a Service Report Ticket</a>
            <a href="eta.jsp">View ETA</a>
        </nav>
    </header>
    <body>
         <%@include file ="/WEB-INF/jspfs/header.jspf" %>
        ${message}
        <h1>Service Report Ticket</h1>
        <h2>Technician Service Report</h2>
        <div>
            <form action="CreateServiceTicketServlet" method="post">
                <label>
                    Short Description:
                </label>
                <input type="text" name="txtShortDescription">
                <br><br>

                <label>
                    Assigned To:
                </label>
                <customDDL:AssignedToDropDownList
                    valueField="FirstName + \" \" + LastName"
                    textField="FirstName + \" \" + LastName"
                    controlName="ddlEngingeers"/>
                    
                    
                <br><br>

                <label>
                    Current State:
                </label>
                <customDDL:TicketStateDropDownList
                    valueField="Id"
                    textField="Name"
                    controlName="ddlState"/>
                    
                <br><br>

                <label>
                    Status:
                </label>
                <input type="radio" value="open" name="status">
                <label>Open</label>

                <input type="radio" value="closed" name="status">
                <label>Closed</label>
                <br><br>

                <label>
                    Severity:
                </label>
               <customDDL:SeverityDropDownList
                    valueField="Id"
                    textField="Name"
                    controlName="ddlSeverity"/>
                <br><br>

                <label>
                    Date Opened:
                </label>
                <select name="ddlMonthOpened">
                    <option>--Month--</option>
                    <%=monthsForList%>
                </select>
                <select name="ddlDayOpened">
                    <option>--Day--</option>
                    <%= days%>
                </select>
                <select name="ddlYearOpened">
                    <option>--Years--</option>
                    <%= years%>
                </select>
                <br><br>

                <label>
                    Date of last Action:
                </label>
                <select name="ddlMonthOfLast">
                    <option>--Month--</option>
                    <%=monthsForList%>
                </select>
                <select name="ddlDayOfLast">
                    <option>--Day--</option>
                    <%= days%>
                </select>
                <select name="ddlYearOfLast">
                    <option>--Years--</option>
                    <%= years%>
                </select>
                <br><br>

                <label>Long Description of Issue</label>
                <textarea rows="4" cols="50" name="txtLongDesc">

                </textarea>
                <br><br>

                <label>Diagnosis and Actions Taken:</label>
                <textarea rows="4" cols="50" name="txtDiagnostic">

                </textarea>
                <br><br>

                <input type="reset" name="reset" value="Reset">
                <input type="submit" name="submit" value="Submit">

            </form>
        </div>
     
   
        <hr>
         <%@include file="/WEB-INF/jspfs/footer.jspf" %>
    </body>
</html>
