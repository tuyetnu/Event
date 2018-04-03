<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">List Offer</h1>
                </div>

                <s:if test="%{result != null}">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Title</th>
                                <th>Start</th>
                                <th>End</th>
                                <th>Status</th>
                                <th>Reason</th>
                                <th>Preview</th>
                                <th>Delete</th>
                            <tr>
                        </thead>
                        <tbody>
                        <s:iterator value="result">
                            <s:if test="%{status != 'Deleted'}">
                                <tr>
                                    <td><s:property value="id"/></td>
                                <td><s:property value="title"/></td>
                                <td><s:property value="startDate"/></td>
                                <td><s:property value="endDate"/></td>
                                <td><s:property value="status"/></td>
                                <td><s:property value="reason"/></td>
                                <td>
                                <s:url id="previewLink" action="Detail">
                                    <s:param name="id" value="%{id}"/>
                                </s:url>
                                <s:a href="%{#previewLink}">Preview</s:a>
                                </td>
                                <td>
                                <s:form action="EditStatus" method="POST">
                                    <s:hidden name="id" value="%{id}"/>
                                    <s:hidden name="status" value="Deleted"/>
                                    <s:hidden name="searchValue" value="%{searchValue}"/>
                                    <s:submit value="Delete"/>
                                </s:form>
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
