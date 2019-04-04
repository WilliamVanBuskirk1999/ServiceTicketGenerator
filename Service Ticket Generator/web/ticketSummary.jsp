<%-- 
    Document   : ticketSummary
    Created on : 4-Mar-2019, 3:26:29 PM
    Author     : billy
    Assignment : 3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.nbcc.serviceticket.business.ServiceTicket"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ticket Summary</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspfs/header.jspf" %>
         <div id="results">
            <label>Short Description:</label>
            <b>${newTicket.shortDescription}</b>
            <br>

            <label>Assigned To:</label>
            <b>${newTicket.assignedTo}</b>
            <br>

            <label>Current State:</label>
            <b>${newTicket.currentState}</b>
            <br>

            <label>Status:</label>
            <b>${newTicket.status}</b>
            <br>

            <label>Severity:</label>
            <b>${newTicket.severity}</b>
            <br>

            <label>Date Opened:</label>
            <b>${newTicket.dateOpened}</b>
            <br>

            <label>Date of Last Action:</label>
            <b>${newTicket.dateLastActioned}</b>
            <br>

            <label>Date of ETA:</label>
            <b><${newTicket.dateETA}</b>
            <br>

            <label>Long Description:</label>
            <b>${newTicket.longDescription}</b>
            <br>

            <label>Diagnosis and action taken:</label>
            <b>${newTicket.actionTaken}</b>
        </div>

         <%@include file="/WEB-INF/jspfs/footer.jspf" %>
    </body>
</html>
