<%-- 
    Document   : modifystudentprocess
    Created on : 02 4, 21, 7:03:31 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify student process</title>
    </head>
    <body>
        <h1>Modify Student Record</h1>
        <jsp:useBean id="studentBean" class="enrollment.students" scope="page" />
        <%
            studentBean.studentid=Integer.parseInt(request.getParameter("studentid"));
            studentBean.completename=(request.getParameter("completename"));
            studentBean.degreeid=(request.getParameter("degreeid"));
            if(studentBean.modRecord() == 1) {
        %>
        <p>Modifying student with student id <strong><%=studentBean.studentid%></strong> was successful.</p>
        <%
            } else {
        %>
                <p>Modifying student details was not successful.</p>
        <%
            }
        %>
        <br/>
        <a href="studentmaintenance.jsp">Back to Enrollment Menu</a>
    </body>
</html>
