<%-- 
    Document   : enroll_main
    Author     : Ivan Lim, Jethro Tsai
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add courses to cart</title>
    </head>
    <body>
        <jsp:useBean id="enrollBean" class="enrollment.enroll" scope="session" />
        <jsp:useBean id="enrollmentBean" class="enrollment.enrollment" scope="page" />
        <% 
            
            enrollmentBean.studentid = Integer.parseInt(request.getParameter("studentid"));
            enrollmentBean.term = Integer.parseInt(request.getParameter("term"));
            enrollmentBean.schoolyear = Integer.parseInt(request.getParameter("schoolyear"));
            enrollmentBean.courseid = request.getParameter("courses");
            enrollBean.EnrollmentList.add(enrollmentBean);
        %>
        Cart:
        <br>
        <ul>
        <% for (int i = 0; i < enrollBean.EnrollmentList.size(); i++) {
                        String cd = enrollBean.EnrollmentList.get(i).courseid;
                    %>
                        <li> Course : <%= cd %>
                    <% } %>
        </ul>
        <br>
  
        <form name="go_back" action="enroll_main.jsp" method = "POST">
        <input type ="hidden" value="<%=request.getParameter("studentid")%>" name="studentid">
        <input type ="hidden" value="<%=request.getParameter("term")%>" name="term">
        <input type ="hidden" value="<%=request.getParameter("schoolyear")%>" name="schoolyear">
        <input type="submit" value="Go Back" name="go_back" />
        </form>
    </body>
</html>