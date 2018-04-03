<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Delete User</h1>
                </div>
                <br/>
                <h3>Accounts may contain offers event. Are you sure you want to delete?</h3>
                <s:form action="DeleteUser" method="POST" theme="simple">
                    <s:hidden name="userDelete" value="%{userDelete}"/>
                    <s:hidden name="searchValue" value="%{searchValue}"/>
                    <s:hidden name="action" value="delete"/>
                    <s:submit value="Yes"/>
                </s:form>
                <s:form action="DeleteUser" method="POST" theme="simple">
                    <s:hidden name="searchValue" value="%{searchValue}"/>
                    <s:hidden name="action" value="cancle"/>  
                    <s:submit value="No"/>
                </s:form>
            </div>
        </div>
    </body>
</html>
