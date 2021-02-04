<%-- 
    Document   : enroll_main
    Created on : 02 4, 21, 3:57:18 PM
    Author     : ccslearner
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choose Courses</title>
    </head>
    <body>
        <h1>Choose the course you want to enroll in</h1>
        <jsp:useBean id="studentBean" class="enrollment.students" scope="request" />
        <jsp:useBean id="enrollBean" class="enrollment.enroll" scope="page" />
        <jsp:useBean id="coursedegreeBean" class="enrollment.coursedegree" scope="page" />
        <% 
            studentBean.studentid = Integer.parseInt(request.getParameter("studentid"));
            studentBean.viewRecord();
            enrollBean.Student = studentBean;
            enrollBean.loadCourses();
        %>
        <p> Student ID: <%=studentBean.studentid  %> </p>
        <p> Student Name: <%=studentBean.completename  %> </p>
        <p> Student Degree: <%=studentBean.degreeid %> </p>
         <form name="selectCourses" action="enrollcart.jsp" method="POST">
            Select course -
                <select name="courses" id="courses"> 
                    <% for (int i = 0; i < enrollBean.CourseList.size(); i++) {
                        String cd = enrollBean.CourseList.get(i).courseid;
                    %>
                        <option value="<%= cd %>"><%= cd %></option> 
                    <% } %>
                </select><br>
            <input type="submit" value="enrollcart" name="enrollcart" />
            <input type ="hidden" value="<%=request.getParameter("studentid")%>" name="studentid">
            <input type ="hidden" value="<%=request.getParameter("term")%>" name="term">
            <input type ="hidden" value="<%=request.getParameter("schoolyear")%>" name="schoolyear">
        </form>
                
        <form name="submitenroll" action="enroll_process.jsp" method = "POST">
            <input type ="hidden" value="<%=request.getParameter("studentid")%>" name="studentid">
            <input type="submit" value="confirm enroll" name="confirm_enroll" />
        </form>      
        <br>
    </body>
</html>