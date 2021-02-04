<%-- 
    Document   : drop_cart
    Created on : 02 4, 21, 7:09:29 PM
    Author     : ccslearner
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
        <jsp:useBean id="studentBean" class="enrollment.students" scope="page" />
        <jsp:useBean id="enrollmenttemp" class="enrollment.enrollment" scope="page" />
        
        <%
            studentBean.studentid = Integer.parseInt(request.getParameter("studentid"));
            studentBean.getAStudent(); 
            dropBean.Student = studentBean;
        %>
       <table style="width:75%" border="1">
            <tr>
                <td>Course ID</td>        
            </tr>
            <tr>
            <%  dropBean.loadEnrollment();
                
                for (int i=0; i<dropBean.EnrollmentList.size(); i++) {
                    enrollmenttemp = dropBean.EnrollmentList.get(i);
            %>
            <tr>
                <td><%=enrollmenttemp.courseid%></td>
            </tr>
            <% }
               
            %>
        </table>
        <br/>
        There are currently <%=dropBean.DropList.size()%> courses in the cart.<br/>
        
        <form name="selectCourses" action="addtodropcart.jsp" method="POST">
            <input type ="text" name="courseid" id="courseid"><br>
            <input type="submit" value="add to cart" name="addtodropcart" />
            <input type ="hidden" value="<%=request.getParameter("studentid")%>" name="studentid">
            <input type ="hidden" value="<%=request.getParameter("term")%>" name="term">
            <input type ="hidden" value="<%=request.getParameter("schoolyear")%>" name="schoolyear">
        </form>
        <form name="selectCourses" action="drop_process.jsp" method="POST">
            <input type="submit" value="confirm droplist" name="confirmdroplist" />
            <input type ="hidden" value="<%=request.getParameter("studentid")%>" name="studentid">
            <input type ="hidden" value="<%=request.getParameter("term")%>" name="term">
            <input type ="hidden" value="<%=request.getParameter("schoolyear")%>" name="schoolyear">
        </form>
        <a href="index.html">Back to Enrollment Menu</a>
    </body>
</html>
