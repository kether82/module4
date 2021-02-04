<%-- 
    Document   : drop_login
    Created on : 02 4, 21, 10:23:03 PM
    Author     : Nathan Von
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, enrollment.*" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log-in</title>
    </head>
    <body>
        <form name="login" action="drop_cart.jsp" method="POST">
            Student ID - <input type="text" name="studentid" id="studentid"><br>
            Current Term - <input type="text" name="term" id="term"><br>  
            School Year -<input type="text" name="schoolyear" id="schoolyear"><br>  
            <input type="submit" value="login" name="login" />
        </form>
        <br>
        <a href="index.jsp">Main Page</a><br>
        <%  session.invalidate() ;
        %>
    </body>
</html>
