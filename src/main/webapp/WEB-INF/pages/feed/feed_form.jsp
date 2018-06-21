<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>

<c:choose>
    <c:when test="${!empty feed.id}">
        <c:set var="title" value="Feeds / ${feed.id}"/>
    </c:when>
    <c:otherwise>
        <c:set var="title" value="Feeds / new"/>
    </c:otherwise>
</c:choose>

<!doctype html>
<html>
<jsp:include page="../include/metadata.jsp">
    <jsp:param name="title" value="${title}"/>
</jsp:include>
<body>

<jsp:include page="../include/header.jsp"/>

<main>
    <h1>${title}</h1>

    <nav>
        <a href="<spring:url value='/feeds/'/>">Feeds list</a>
        <c:if test="${!empty feed.id}"> | <a href="<spring:url value='/posts/?feed=${feed.id}'/>">Posts</a></c:if>
    </nav>

    <spring:url var="formAction" value="/feeds/save/"/>
    <springform:form modelAttribute="feed" acceptCharset="UTF-8" method="POST" action="${formAction}">
        <springform:hidden path="id"/>

        <c:if test="${!empty feed.id}">
            <div>
                <span><spring:message text="ID"/>: ${feed.id}</span><br>
                <span><spring:message text="Created"/>: ${feed.dateCreated}</span><br>
                <span><spring:message text="Updated"/>: ${feed.lastUpdated}</span>
            </div>
        </c:if>

        <table width="90%">
            <col width="20%">
            <col width="80%">
            <tr>
                <td><spring:message text="Status"/></td>
                <td><springform:select path="status">
                    <springform:options items="${statusList}" path="status" />
                </springform:select></td>
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
                <td><spring:message text="Job interval, ms"/></td>
                <td><springform:input path="jobInterval"/></td>
            </tr>
            <tr>
                <td><spring:message text="Next job"/></td>
                <td><springform:input path="nextJob"/></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <springform:button>Save</springform:button>
                    <a href="<spring:url value="/feeds/"/>">Cancel</a>
                </td>
            </tr>
        </table>
    </springform:form>
</main>

<jsp:include page="../include/footer.jsp"/>

</body>
</html>
