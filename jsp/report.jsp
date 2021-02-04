<%-- 
    Document   : viewRecord
    Created on : 02 4, 21, 9:01:56 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enrollment report</title>
    </head>
    <body>
       <h1>Report details</h1>
        <form name="genReport" action="generatereport.jsp" method="POST">
            Term   - <input type="text" name="term" id="term" /><br />
     School Year   - <input type="text" name="schoolyear" id="schoolyear" /><br />
            <input type="submit" value="Generate report" name="genReport" />
        </form>
       <a href="index.jsp">Back to Main Menu</a>
    </body>
</html>
