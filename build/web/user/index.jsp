<%-- 
    Document   : index
    Created on : Oct 15, 2017, 2:01:59 PM
    Author     : NUNTTSE62525
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <script src="mytool/valid.js"></script>
        <title>Admin Theme</title>
    </head>

    <body>
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
                            <tr>
                                <th>&nbsp;Fullname:</th>
                                <td><s:textfield name="fullname" id="name" value="%{#session.INFO.fullname}"/></td>
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
                                <td><s:submit value="Save" onclick="return checkEmptyRegister()"/></td>
                                <td align="center"><s:submit value="Reset"/></td>
                            </tr>
                        </table>
                    </s:form>
                </center>
            </div>
        </div>


    </body>

</html>