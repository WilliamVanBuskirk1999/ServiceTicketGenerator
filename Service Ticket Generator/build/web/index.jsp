<%-- 
    Document   : index
    Created on : 15-Jan-2019
    Author     : billy
    Assignment 3
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="welcomeTag" uri="/WEB-INF/tlds/welcome.tld"%>


<!DOCTYPE html>
<style>
    p{
        display:inline-block;
        width:60%;
    }
    footer{
        text-align: center;
    }
    div{
        text-align:center;
    }
    h1{
        text-align:center;
    }
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Call Center</title>
    </head>
    
        <%@include file ="/WEB-INF/jspfs/header.jspf" %>
        <h1> Web Application for Call Center </h1>
        
            
        <welcomeTag:WelcomeMessage/>
            
        
        <hr>
        <%@include file="/WEB-INF/jspfs/footer.jspf" %>
    


</html>
