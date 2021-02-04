<%-- 
    Document   : addcourse
    Created on : 02 4, 21, 10:28:06 PM
    Author     : Ivan Lim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Course</title>
    </head>
    <body>
        <h1>Add a Course</h1>
        <form name="addcourse" action="addcourse_process.jsp" method="POST">
            Course ID    - <input type="text" name="courseid" id="courseid" /><br />
            Course Name  - <input type="text" name="coursename" id="coursename" /><br />
            Department   - <input type="text" name="department" id="department" /><br />
            <input type="submit" value="Add Course" name="add_course" />
        </form>
        <br />
        <a href="coursemaint.jsp">Back to student maintenance Menu</a>
    </body>
</html>