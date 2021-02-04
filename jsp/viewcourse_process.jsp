<%-- 
    Document   : viewcourse_process
    Created on : 02 4, 21, 10:57:36 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Course</title>
    </head>
    <body>
       <h1>Delete Student Record</h1>
        <jsp:useBean id="courseBean" class="enrollment.courses" scope="page" />
        <%
            courseBean.courseid = request.getParameter("courseid");
            
            if(courseBean.viewRecord() == 1) {
        %>
        
        <p>Course ID: <strong> <%=courseBean.courseid%></strong></p>
        <p>Course Name: <strong> <%=courseBean.coursename %></strong></p>
         <p>Department: <strong> <%=courseBean.department %></strong></p>
        <%
            } else {
        %>
                <p> Viewing Course was not Successful.</p>
        <%
            }
        %>
        <br/>
        <a href="coursemaint.jsp">Back to Course Maintenance Menu</a>
    </body>
</html>
