<%-- 
    Document   : viewstudents
    Created on : 02 4, 21, 7:20:51 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view student page</title>
    </head>
    <body>
       <h1>modify student details</h1>
        <form name="viewStudent" action="viewstudent_process.jsp" method="POST">
            Student ID    - <input type="text" name="studentid" id="studentid" /><br />
            <input type="submit" value="view student" name="viewStudent" />
        </form>
       <a href="studentmaintenance.jsp">Back to student maintenance Menu</a>
    </body>
</html>