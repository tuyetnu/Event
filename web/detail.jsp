
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details Page</title>
    </head>
    <body>
        <jsp:include page="HTML/header.jsp"/>
    <center>
        <table>
            <tr>
                <td style="width: 45%">
                    <div style="border: solid 1px; border-color: #000000; width: 500px; height: 500px; margin-left: 100px; margin-top: 50px; margin-right: 20px">
                        <img src="<s:property value="%{#session.DTO.image}"/>" style="width: 500px; height: 500px;" id="img"/>  
                    </div>
                </td>
                <td style="width: 55%; ">

                    <div style="margin-bottom:  90px;">
                        <b><center><s:property value="%{#session.DTO.title}"/></center></b><br/>  
                        Min people:<s:property value="%{#session.DTO.min}"/><br/> 
                        Max people:<s:property value="%{#session.DTO.max}"/><br/>
                        Start Date:<s:property value="%{#session.DTO.startDate}"/><br/>
                        End Date:<s:property value="%{#session.DTO.endDate}"/><br/>
                        Category:<s:property value="%{#session.DTO.category}"/><br/>
                        Status: <s:property value="%{#session.DTO.status}"/><br/>
                        Offer by <s:property value="%{#session.DTO.userPost}"/><br/>

                    </div>
                    <div style="width: 100%; margin-bottom: 150px; ">
                        <s:property value="%{#session.DTO.description}"/>
                        <br/>

                    </div>
                </td>
            </tr>
        </table>
    </center>
</body>
<jsp:include page="HTML/footer.html"/>
</html>
