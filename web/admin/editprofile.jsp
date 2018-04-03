<%-- 
    Document   : editprofile
    Created on : Oct 15, 2017, 2:50:06 PM
    Author     : NUNTTSE62525
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="mytool/valid.js"></script>
    </head>
    <body>
        <div>
            <jsp:include page="menu.jsp"/>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Edit Profile</h1>
                    </div>

                    <center>
                        <s:form action="SaveProfile" method="POST" theme="simple">
                            <table>
                                <tr>
                                    <th>Username:&nbsp;&nbsp;&nbsp;</th>
                                    <td><s:textfield name="username" id="user" value="%{#session.INFO.username}" readonly="true"/></td>
                                </tr>
                                <tr> </tr>
                                <tr>
                                    <th>&nbsp;Fullname:</th>
                                    <td><s:textfield name="fullname" id="name" value="%{#session.INFO.fullname}"/></td>
                                </tr>
                                                                <tr> </tr>
                                <tr>
                                    <th>Password:</th>
                                    <td><s:password name="password" id="pass"/></td>
                                </tr>
                                                                <tr> </tr>
                                <tr>
                                    <th align="left">&nbsp;&nbsp;Confirm:</th>
                                    <td><s:password name="confirm" id="confirm"/></td>
                                </tr>
                                                                <tr> </tr>
                                <tr>
                                    <td><s:submit value="Save" onclick="return checkEmptyRegister()"/></td>
                                <td align="center"><s:submit value="Reset"/></td>
                                </tr>
                            </table>
                        </s:form>
                    </center>
                </div>
            </div>
        </div>
    </body>
</html>
