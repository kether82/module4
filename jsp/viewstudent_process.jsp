<%-- 
    Document   : viewstudent_process.jsp
    Created on : 02 4, 21, 7:23:00 PM
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
       <h1>View Student Record</h1>
        <jsp:useBean id="studentBean" class="enrollment.students" scope="page" />
        <%
            studentBean.studentid=Integer.parseInt(request.getParameter("studentid"));
            
            if(studentBean.viewRecord() == 1) {
        %>
        
        <p>Student id: <strong> <%=studentBean.studentid%></strong></p>
        <p>Student name: <strong> <%=studentBean.completename%></strong></p>
         <p>Student degree: <strong> <%=studentBean.degreeid%></strong></p>
        <%
            } else {
        %>
                <p>viewing student details was not successful.</p>
        <%
            }
        %>
        <br/>
        <a href="studentmaintenance.jsp">Back to student maintenance Menu</a>
    </body>
</html>
