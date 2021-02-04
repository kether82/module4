<%-- 
    Document   : deletestudent
    Created on : 02 4, 21, 7:30:31 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>delete student page</title>
    </head>
    <body>
       <h1>delete student details</h1>
        <form name="delStudent" action="deletestudent_process.jsp" method="POST">
            Student ID    - <input type="text" name="studentid" id="studentid" /><br />
            <input type="submit" value="delete student" name="delStudent" />
        </form>
       <a href="studentmaintenance.jsp">Back to student maintenance Menu</a>
    </body>
</html>
