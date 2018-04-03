<%-- 
    Document   : post
    Created on : Oct 22, 2017, 6:08:39 PM
    Author     : NUNTTSE62525
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post Page</title>
        <script>
            function checkPost() {
                var min = document.getElementById("min").value;
                if (isNaN(min)) {
                    alert("Min people must be a positive numbers");
                    return false;
                }
                if (min < 0) {
                    alert("Min people must bigger than 0");
                    return false;
                }

                var max = document.getElementById("max").value;
                if (isNaN(max)) {
                    alert("Max people must be a positive numbers");
                    return false;
                }
                max = Number(max);
                mix = Number(min);
                if (max < min) {
                    alert("Max people must bigger than min people");
                    return false;
                }
                var today = new Date();
                var startDate = document.getElementById("startDate").value;
                var d = today.getDate();
                var m = today.getMonth();
                var y = today.getFullYear();
                var std = startDate.split("-");
                if (y > std[0] || m > std[1] || d > std[2]) {
                    alert("Start date must after current date");
                    return false;
                }
                var endDate = document.getElementById("endDate").value;
                var ed = endDate.split("-");
                if (std[0] > ed[0] || std[1] > ed[1] || std[2] > ed[2]) {
                    alert("End date must after start date");
                    return false;
                }
                var image = document.getElementById("image").value;
                if (image == "") {
                    alert("Pls choose image");
                    return false;
                }
            }
        </script>
        <s:head/>
    </head>
    <body>
        <s:if test="%{#session.ROLELOGIN != 'admin' && #session.ROLELOGIN != 'user'}" >
            <jsp:forward page="login.jsp"/>
        </s:if>
        <jsp:include page="HTML/header.jsp"/>
        <br/>
        <div style="width: 700px; margin-left: 400px;">
            <s:form action="Post" method="POST" enctype="multipart/form-data" theme="simple">
                <b>Title:</b>  
                <s:textfield name="title" cssStyle="width: 80%" id="title"/><br/>
                <s:fielderror fieldName="title"/>
                <b>Min people:</b>  
                <s:textfield name="min" cssStyle="width: 20%" id="min"/><br/>
                <s:fielderror fieldName="min"/>
                <b>Max people:</b>  
                <s:textfield name="max" cssStyle="width: 20%" id="max"/><br/>
                <s:fielderror fieldName="max"/>
                <b>Start Date:</b>  
                <input type="date" name="startDate" id="startDate"/><br/>
                <b>End Date:</b>  
                <input type="date" name="endDate" id="endDate"/><br/>
                <b>Category:</b>  
                <s:textfield name="category" cssStyle="width: 20%"/><br/>
                <s:fielderror fieldName="category"/>
                <s:file accept="image/*" name="image" id="image"/> <br/>
                <s:hidden value="%{#session.USERLOGIN}" name="userPost"/>
                <b>Description:</b>
                <s:textarea name="description" cssStyle="width: 100%; height: 430px;" id="description"/><br/>
                <s:fielderror fieldName="description"/>
                <s:submit value="Upload" cssStyle="margin-left: 350px;" onclick="return checkPost()"/>
            </s:form>
        </div>
        <br/><br/><br/><br/>
        <jsp:include page="HTML/footer.html"/>
    </body>
</html>
