<%-- 
    Document   : viewcourses
    Created on : 02 4, 21, 10:53:34 PM
    Author     : Ivan Lim
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Course Page</title>
    </head>
    <body>
       <h1>View Course Details</h1>
        <form name="viewCourse" action="viewcourse_process.jsp" method="POST">
            Course ID    - <input type="text" name="courseid" id="courseid" /><br />
            <input type="submit" value="view course" name="viewcourse" />
        </form>
       <a href="coursemaint.jsp">Back to Course Maintenance Menu</a>
    </body>
</html>
