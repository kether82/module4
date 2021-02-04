<%-- 
    Document   : addstudent_process.jsp
    Created on : 02 4, 21, 6:44:04 PM
    Author     : Patrick Ong, Jethro Tsai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processing of Adding Students</title>
    </head>
    <body>
        <h1>Adding New Student Record</h1>
        <jsp:useBean id="studentBean" class="enrollment.students" scope="page" />
        <%
            studentBean.studentid=Integer.parseInt(request.getParameter("studentid"));
            studentBean.completename=(request.getParameter("completename"));
            studentBean.degreeid=(request.getParameter("degreeid"));
            if(studentBean.addRecord() == 1) {
        %>
        <p>Adding the new student with student id <strong><%=studentBean.studentid%></strong> was successful.</p>
        <%
            } else {
        %>
                <p>Adding the new student was not successful.</p>
        <%
            }
        %>
        <br/>
        <a href="studentmaintenance.jsp">Back to student maintenance Menu</a>
    </body>
</html>
