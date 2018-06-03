<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title><spring:message text="Feed"/> / ${feed.id}</title>
    <style>
        input { width: 95%; }
        td { padding: 2px 5px 2px 5px; }
    </style>
</head>
<body>

<h1><spring:message text="Feed"/> / ${feed.id}</h1>

<springform:form modelAttribute="feed" method="POST" action="${pageContext.request.contextPath}/feeds/save/">
    <springform:hidden path="id"/>

    <table border="1" width="100%">
        <tr>
            <td width="20%"><spring:message text="ID"/></td>
            <td width="80%">${feed.id}</td>
        </tr>
        <tr>
            <td><spring:message text="Created"/></td>
            <td>${feed.dateCreated}</td>
        </tr>
        <tr>
            <td><spring:message text="Updated"/></td>
            <td>${feed.lastUpdated}</td>
        </tr>
        <tr>
            <td><spring:message text="Status"/></td>
            <td>${feed.status}</td>
        </tr>
        <tr>
            <td><spring:message text="Icon URL"/></td>
            <td><springform:input path="iconUrl"/></td>
        </tr>
        <tr>
            <td><spring:message text="Logo URL"/></td>
            <td><springform:input path="logoUrl"/></td>
        </tr>
        <tr>
            <td><spring:message text="Feed URL"/></td>
            <td><springform:input path="feedUrl"/></td>
        </tr>
        <tr>
            <td><spring:message text="Title"/></td>
            <td><springform:input path="title"/></td>
        </tr>
        <tr>
            <td><spring:message text="Author"/></td>
            <td><springform:input path="author"/></td>
        </tr>
        <tr>
            <td><spring:message text="Description"/></td>
            <td><springform:input path="description"/></td>
        </tr>
        <tr>
            <td><spring:message text="Job interval"/></td>
            <td><springform:input path="jobInterval"/></td>
        </tr>
        <tr>
            <td><spring:message text="Next job"/></td>
            <td><springform:input path="nextJob"/></td>
        </tr>
        <tr>
            <td></td>
            <td><springform:button>Save</springform:button></td>
        </tr>
    </table>
</springform:form>

</body>
</html>
