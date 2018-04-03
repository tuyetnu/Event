<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
        <s:head/>
    </head>
    <body>
        <div>
            <jsp:include page="menu.jsp"/>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Update User</h1>
                    </div>
                    <div class="input-group" style="width: 40%">
                        <center>
                            <s:form action="Update" method="Update">
                                <s:textfield cssClass="form-control" name="username" value="%{#session.DTO.username}" label="Username" readonly="true"/>
                                <s:textfield cssClass="form-control" name="fullname" value="%{#session.DTO.fullname}" label="Fullname"/>
                                <s:checkbox name="password" label="Reset Password"/>
                                <s:radio name="role" label="Role" list="{'user', 'admin'}" value="%{#session.DTO.role}"/>
                                <s:hidden name="searchValue" value="%{searchValue}"/>
                                <s:submit value="Update" cssClass="searchbutton"/>
                            </s:form>
                        </center>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
