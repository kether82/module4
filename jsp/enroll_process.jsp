<%-- 
    Document   : enroll_main
    Created on : 02 4, 21, 3:57:18 PM
    Author     : Ivan Lim
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processing Enrollment</title>
    </head>
    <body>
        <p> ID: <%= request.getParameter("studentid") %> 
        <jsp:useBean id="enrollBean" class="enrollment.enroll" scope="session" />
        <% 
            if(enrollBean.confirmEnrollment() == 1){ 
        %>  
        <p> Enrollment successful </p> 
        <% } else {
        %>    
        <p> Enrollment unsuccessful </p>
        <% } %>
        <% enrollBean.clearEnrollment(); 
        %>
        <a href="enroll.jsp">Back to enroll</a><br>
    </body>
</html>