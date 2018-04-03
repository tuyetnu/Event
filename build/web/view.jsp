<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Page</title>
    </head>
    <body>
        <jsp:include page="HTML/header.jsp"/>
        <br/><br/>
        <table align="center">
            <s:iterator value="result" status="counter">
                <s:if test="%{#counter.count % 4 == 1}">
                    <tr>
                    </s:if>
                    <td>
                        <s:url id="viewLink" action="Detail">
                            <s:param name="id" value="%{id}"/>
                        </s:url>
                        <table align="center">
                            <tr>
                                <td>
                                    <s:a href="%{#viewLink}">
                                        <img src="<s:property value="%{image}"/>" height="300" width="300"/><br/>
                                    </s:a>
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: center;">
                                    <s:property value="%{title}"/>
                                </td>
                            </tr>
                        </table>

                    </td>
                    <s:if test="%{#counter.count % 4 == 0}">
                    </tr>
                </s:if>
            </s:iterator>
        </table>
        <br/><br/>
        <jsp:include page="HTML/footer.html"/>
    </body>
</html>
