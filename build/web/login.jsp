<%-- 
    Document   : login
    Created on : Oct 8, 2017, 1:39:47 PM
    Author     : NUNTTSE62525
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="mytool/valid.js"></script>
        <title>Login Page</title>
    </head>
    <body>
        <jsp:include page="HTML/header.jsp"/>
        <br/>
    <center>
        <s:form action="Login" method="POST" theme="simple">
            <b>Username:</b>&nbsp;&nbsp;&nbsp;<s:textfield name="username" id="user"/>
            <br/>
            <b>Password:</b>&nbsp;&nbsp;&nbsp;<s:password name="password" id="pass"/>
            <br/>
            <s:submit value="Login" onclick="return checkEmpty()"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <s:reset value="Reset"/>
        </s:form>
    </center>
    <br/>
    <jsp:include page="HTML/footer.html"/>
</body>
</html>
