<%-- 
    Document   : error
    Created on : Nov 2, 2017, 8:34:31 AM
    Author     : NUNTTSE62525
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <jsp:include page="HTML/header.jsp"/>
    <center>
        <h1>Error page</h1>
        <br/><br/>
        <s:property value="%{#request.ERROR}"/>
        <br/><br/>
    </center>
        <jsp:include page="HTML/footer.html"/>
    </body>
</html>
