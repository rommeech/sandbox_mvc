<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:choose>
    <c:when test="${feed.id != null}">
        <c:set var="title" value="FeedId=${feed.id} / Feeds" scope="request"/>
    </c:when>
    <c:otherwise>
        <c:set var="title" value="New Feed / Feeds" scope="request"/>
    </c:otherwise>
</c:choose>

<!doctype html>
<html>
<jsp:include page="include/metadata.jsp"/>
<body>

<jsp:include page="include/header.jsp"/>

<nav class="sub-nav">
    <a href="<spring:url value='/feeds/'/>">Feed list</a>
    <c:if test="${!empty feed.id}"><a href="<spring:url value='/posts/?feed=${feed.id}'/>">Posts</a></c:if>
</nav>

<main>

    <jsp:include page="include/messages.jsp"/>

    <spring:url var="formAction" value="/feeds/save/"/>
    <form:form modelAttribute="feed" acceptCharset="UTF-8" method="POST" action="${formAction}">
        <form:hidden path="id"/>

        <table class="table_edit">

            <tr>
                <td class="td_legend"><spring:message text="Status"/></td>
                <td><form:select path="status">
                    <form:options items="${statusList}" path="status" />
                </form:select></td>
            </tr>
            <tr>
                <td class="td_legend"><spring:message text="Icon URL"/></td>
                <td><form:input path="iconUrl"/></td>
            </tr>
            <tr>
                <td class="td_legend"><spring:message text="Logo URL"/></td>
                <td><form:input path="logoUrl"/></td>
            </tr>
            <tr>
                <td class="td_legend"><spring:message text="Feed URL"/></td>
                <td><form:input path="feedUrl"/></td>
            </tr>
            <tr>
                <td class="td_legend"><spring:message text="Title"/></td>
                <td><form:input path="title"/></td>
            </tr>
            <tr>
                <td class="td_legend"><spring:message text="Author"/></td>
                <td><form:input path="author"/></td>
            </tr>
            <tr>
                <td class="td_legend"><spring:message text="Description"/></td>
                <td><form:input path="description"/></td>
            </tr>
            <tr>
                <td class="td_legend"><spring:message text="Job interval, ms"/></td>
                <td><form:input path="jobInterval"/></td>
            </tr>
            <tr>
                <td class="td_legend"><spring:message text="Next job"/></td>
                <td><form:input path="nextJob"/></td>
            </tr>

            <tr>
                <td></td>
                <td>
                    <form:button>Save</form:button>
                    <a href="<spring:url value="/feeds/"/>">Cancel</a>
                </td>
            </tr>
        </table>
    </form:form>
</main>

<jsp:include page="include/footer.jsp"/>

</body>
</html>
