<%-- 
    Document   : generatereport
    Created on : 02 4, 21, 9:08:37 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generated report</title>
    </head>
    <body>
       <jsp:useBean id="reportBean" class="enrollment.report" scope="page" />
        <%
            reportBean.term=Integer.parseInt(request.getParameter("term"));
            reportBean.schoolyear=Integer.parseInt(request.getParameter("schoolyear"));
           
            if(reportBean.generateReport() == 1) {
        %>
       
        <%
            for(int i=0; i<reportBean.courseList.size(); i++)
            {
                String e = reportBean.courseList.get(i).courseid;
                int num= reportBean.countList.get(i);
          %>
          <p>  <%=e%>   #enrolled :  <%=num%>  </p> 
          
          <%  }
            
            
            } else {
        %>
                <p>generating report was not successful.</p>
        <%
            }
        %>
        <br/>
        <a href="report.jsp">Back to Enrollment Menu</a>
    </body>
</html>
