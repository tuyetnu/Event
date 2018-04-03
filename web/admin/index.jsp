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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/Event/css/bootstrap.css">
        <script src="/Event/js/jquery.min.js"></script>
        <script src="/Event/js/bootstrap.min.js"></script>
        <title>Admin Theme</title>
    </head>

    <body>
        <jsp:include page="menu.jsp"/>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">List Events</h1>
                </div>
                <div class="input-group" style="width: 40%">
                    <s:form action="SearchEvent" method="POST" theme="simple">
                        <s:textfield cssClass="form-control" placeholder="Search by username..." name="searchValue"/>
                        <s:submit value="Search" cssClass="btn btn-default"></s:submit>
                    </s:form>      
                </div>
                <br/>
                <s:if test="%{result != null}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>UserPost</th>
                                <th>Title</th>
                                <th>Start</th>
                                <th>End</th>
                                <th>Status</th>
                                <th>Preview</th>
                                <th>Approve</th>
                                <th>Reject</th>
                                <th>Delete</th>
                            <tr>
                        </thead>
                        <tbody>
                            <s:iterator value="result">
                                <s:if test="%{status != 'Deleted'}">
                                    <tr>
                                        <td><s:property value="id"/></td>
                                        <td><s:property value="userPost"/></td>
                                        <td><s:property value="title"/></td>
                                        <td><s:property value="startDate"/></td>
                                        <td><s:property value="endDate"/></td>
                                        <td><s:property value="status"/></td>
                                        <td>
                                            <s:url id="previewLink" action="Detail">
                                                <s:param name="id" value="%{id}"/>
                                            </s:url>
                                            <s:a href="%{#previewLink}">Preview</s:a>
                                            </td>
                                            <td>
                                            <s:if test="%{status != 'Coming' && status != 'Opened' && status != 'Exprired' && status != 'Closed'}">
                                                <s:form action="EditStatus" method="POST">
                                                    <s:hidden name="id" value="%{id}"/>
                                                    <s:hidden name="status" value="Approved"/>
                                                    <s:hidden name="searchValue" value="%{searchValue}"/>
                                                    <s:submit value="Approve"/>
                                                </s:form>
                                            </s:if>
                                        </td>
                                        <td>

                                            <s:if test="%{status != 'Rejected' && status != 'Opened' && status != 'Exprired' && status != 'Closed'}">
                                                <s:form action="EditStatus" method="POST">
                                                    <s:textfield name="reason" />
                                                    <s:hidden name="id" value="%{id}"/>
                                                    <s:hidden name="status" value="Rejected"/>
                                                    <s:hidden name="searchValue" value="%{searchValue}"/>
                                                    <s:submit value="Reject"/>
                                                </s:form>
                                            </s:if>
                                        </td>
                                        <td>
                                            <s:if test="%{status != 'Closed'}">
                                                <s:form action="EditStatus" method="POST">
                                                    <s:hidden name="id" value="%{id}"/>
                                                    <s:hidden name="status" value="Deleted"/>
                                                    <s:hidden name="searchValue" value="%{searchValue}"/>
                                                    <s:submit value="Delete"/>
                                                </s:form>
                                            </s:if>
                                        </td>
                                    </tr>
                                </s:if>
                            </s:iterator>
                        </tbody>
                    </table>
                </s:if>
            </div>
        </div>


    </body>

</html>