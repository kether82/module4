<%-- 
    Document   : deletecourse_process
    Created on : 02 4, 21, 10:49:12 PM
    Author     : Ivan Lim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Course</title>
    </head>
    <body>
       <h1>Delete Course Record</h1>
        <jsp:useBean id="courseBean" class="enrollment.courses" scope="page" />
        <%
            courseBean.courseid = request.getParameter("courseid");
            
            if(courseBean.delRecord() == 1) {
        %>
        
        <p>Deletion of course with course id <strong><%=courseBean.courseid%></strong> was successful.</p>
        <%
            } else {
        %>
                <p> deleting course was not successful.</p>
        <%
            }
        %>
        <br/>
        <a href="coursemaint.jsp">Back to Course Maintenance Menu</a>
    </body>
</html>
