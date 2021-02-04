<%-- 
    Document   : deletecourse
    Created on : 02 4, 21, 10:45:35 PM
    Author     : Ivan Lim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Course Page</title>
    </head>
    <body>
       <h1>Delete Course Details</h1>
        <form name="delCourse" action="deletecourse_process.jsp" method="POST">
            Course ID    - <input type="text" name="courseid" id="courseid" /><br />
            <input type="submit" value="delete course" name="delCourse" />
        </form>
       <a href="coursemaint.jsp">Back to Course Maintenance Menu</a>
    </body>
</html>
