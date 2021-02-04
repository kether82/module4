<%-- 
    Document   : deletestudent_process.jsp
    Created on : 02 4, 21, 7:32:03 PM
    Author     : Patrick Ong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View student</title>
    </head>
    <body>
       <h1>Delete Student Record</h1>
        <jsp:useBean id="studentBean" class="enrollment.students" scope="page" />
        <%
            studentBean.studentid=Integer.parseInt(request.getParameter("studentid"));
            
            if(studentBean.delRecord() == 1) {
        %>
        
        <p>Deletion of student with student id <strong><%=studentBean.studentid%></strong> was successful.</p>
        <%
            } else {
        %>
                <p> deleting student details was not successful.</p>
        <%
            }
        %>
        <br/>
        <a href="studentmaintenance.jsp">Back to student maintenance Menu</a>
    </body>
</html>
