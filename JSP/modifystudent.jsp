<%-- 
    Document   : modifystudent
    Created on : 02 4, 21, 6:59:29 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>modify student page</title>
    </head>
    <body>
       <h1>modify student details</h1>
        <form name="modstudent" action="modifystudent_process.jsp" method="POST">
            Student ID    - <input type="text" name="studentid" id="studentid" /><br />
            Complete Name - <input type="text" name="completename" id="completename" /><br />
            Degree ID     - <input type="text" name="degreeid" id="degreeid" /><br />
            <input type="submit" value="Modify Student" name="modstudent" />
        </form>
       <a href="studentmaintenance.jsp">Back to student maintenance Menu</a>
    </body>
</html>
