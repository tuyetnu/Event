<%-- 
    Document   : register
    Created on : Oct 8, 2017, 3:06:56 PM
    Author     : NUNTTSE62525
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <script src="mytool/valid.js"></script>
    </head>
    <body>
        <jsp:include page="HTML/header.jsp"/>
        <br/>
    <center>
        <s:form action="Register" method="POST" theme="simple">
            <table>
                <tr>
                    <th>Username:&nbsp;&nbsp;&nbsp;</th>
                    <td><s:textfield name="username" id="user"/></td>
                </tr>
                <tr>
                    <th>&nbsp;Fullname:</th>
                    <td><s:textfield name="fullname" id="name"/></td>
                </tr>
                <tr>
                    <th>Password:</th>
                    <td><s:password name="password" id="pass"/></td>
                </tr>
                <tr>
                    <th align="left">&nbsp;&nbsp;Confirm:</th>
                    <td><s:password name="confirm" id="confirm"/></td>
                </tr>
                <tr>
                    <td><s:submit value="Register" onclick="return checkEmptyRegister()"/></td>
                    <td align="center"><s:submit value="Reset"/></td>
                </tr>
            </table>
        </s:form>
    </center>
    <br/>
    <jsp:include page="HTML/footer.html"/>
</body>
</html>
