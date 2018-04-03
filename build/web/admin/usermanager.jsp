<%-- 
    Document   : usermanager
    Created on : Oct 15, 2017, 2:48:09 PM
    Author     : NUNTTSE62525
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/Event/css/bootstrap.css">
        <script src="/Event/js/jquery.min.js"></script>
        <script src="/Event/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div>
            <jsp:include page="menu.jsp"/>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">List User</h1>
                    </div>


                    <div class="input-group" style="width: 40%">
                        <s:form action="SearchUser" method="POST" theme="simple">
                            <s:textfield cssClass="form-control" placeholder="Search like by fullname..." name="searchValue"/>
                            <s:submit value="Search" cssClass="btn btn-default"><i class="fa fa-search"></i></s:submit>
                        </s:form>      
                    </div>

                    <s:if test="%{result != null}">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>No</th>
                                    <th>Username</th>
                                    <th>Fullname</th>
                                    <th>Role</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="result" status="counter">
                                    <tr>
                                        <td><s:property value="%{#counter.count}"/></td>
                                        <td><s:property value="username"/></td>
                                        <td><s:property value="fullname"/></td>
                                        <td><s:property value="role"/></td>
                                        <td>
                                            <s:form action="EditUser" method="POST">
                                                <s:hidden name="userEdit" value="%{username}"/>
                                                <s:hidden name="searchValue" value="%{searchValue}"/>
                                                <s:submit value="Edit"/>
                                            </s:form>
                                        </td>
                                        <td>
                                            <s:form action="DeleteUser" method="POST">
                                                <s:hidden name="userDelete" value="%{username}"/>
                                                <s:hidden name="searchValue" value="%{searchValue}"/>
                                                <s:hidden name="action" value="click"/>
                                                <s:submit value="Delete"/>
                                            </s:form>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>

                    </s:if>

                </div>
            </div>
        </div>
    </body>
</html>
