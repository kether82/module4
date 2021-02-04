<%-- 
    Document   : modifycourse
    Created on : 02 4, 21, 10:28:06 PM
    Author     : Ivan Lim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Course</title>
    </head>
    <body>
        <h1>Modify a Course</h1>
        <form name="modifycourse" action="modifycourse_process.jsp" method="POST">
            Course ID    - <input type="text" name="courseid" id="courseid" /><br />
            Course Name  - <input type="text" name="coursename" id="coursename" /><br />
            Department   - <input type="text" name="department" id="department" /><br />
            <input type="submit" value="Modify Course" name="mod_course" />
        </form>
        <br />
        <a href="coursemaint.jsp">Back to Course Maintenance Menu</a>
    </body>
</html>