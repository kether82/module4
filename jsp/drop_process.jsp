<%-- 
    Document   : drop_process
    Created on : 02 4, 21, 5:20:22 PM
    Author     : Nathan Von
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processing of Adding Courses</title>
    </head>
    <body>
        <h1>Dropping Course</h1>
        <jsp:useBean id="dropBean" class="enrollment.drop" scope="session" />
        <%
            
            if(dropBean.confirmDrop() == 1) {
        %>
        <p>Dropping Course was successful.</p>
        <%
            } else {
        %>
                <p>Dropping the course was not successful.</p>
        <%
            }
        %>
        <br/>
        <a href="index.html">Back to Enrollment Menu</a>
    </body>
</html>
