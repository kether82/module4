<%-- 
    Document   : addcourse_process
    Created on : 02 4, 21, 10:30:29 PM
    Author     : Ivan Lim
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processing of Adding Courses</title>
    </head>
    <body>
        <h1>Adding New Course Record</h1>
        <jsp:useBean id="courseBean" class="enrollment.courses" scope="page" />
        <%
            courseBean.courseid = request.getParameter("courseid");
            courseBean.coursename = request.getParameter("coursename");
            courseBean.department = request.getParameter("department");
            if(courseBean.addRecord() == 1) {
        %>
        <p>Adding the new course with course name <strong><%=courseBean.courseid%></strong> was successful.</p>
        <%
            } else {
        %>
                <p>Adding the new course was not successful.</p>
        <%
            }
        %>
        <br/>
        <a href="coursemaint.jsp">Back to course maintenance Menu</a>
    </body>
</html>
