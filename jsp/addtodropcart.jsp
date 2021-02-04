<%-- 
    Document   : addtodropcart
    Created on : 02 4, 21, 10:23:03 PM
    Author     : Nathan Von
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processing of Dropping Courses</title>
    </head>
    <body>
        <h1>Course was added to drop list</h1>
        <jsp:useBean id="dropBean" class="enrollment.drop" scope="session" />
        <jsp:useBean id="enrollmentBean" class="enrollment.enrollment" scope="page" />
    
        
        <%
            //Integer.parseInt(request.getParameter("studentid"))
            enrollmentBean.studentid = Integer.parseInt(request.getParameter("studentid"));
            enrollmentBean.term = Integer.parseInt(request.getParameter("term"));
            enrollmentBean.schoolyear = Integer.parseInt(request.getParameter("schoolyear"));
            enrollmentBean.courseid = request.getParameter("courseid");
            dropBean.DropList.add(enrollmentBean);
            
            
        %>
       
        
        <form name="selectCourses" action="drop_cart.jsp" method="POST">
           
            <input type="submit" value="add more courses to cart" name="dropcart" />
            <input type ="hidden" value="<%=request.getParameter("studentid")%>" name="studentid">
            <input type ="hidden" value="<%=request.getParameter("term")%>" name="term">
            <input type ="hidden" value="<%=request.getParameter("schoolyear")%>" name="schoolyear">
        </form>
       
        <a href="index.html">Back to Enrollment Menu</a>
    </body>
</html>