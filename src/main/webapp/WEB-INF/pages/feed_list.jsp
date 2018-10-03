<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message var="title" code="feed.title" scope="request"/>

<!doctype html>
<html>
<jsp:include page="include/metadata.jsp"/>
<body>

<jsp:include page="include/header.jsp"/>

<nav class="sub-nav">
    <a href="<spring:url value='/feeds/new/'/>"><spring:message text="Add new feed"/></a>
</nav>

<jsp:include page="include/messages.jsp"/>

<main>

    <table class="table_list">
        <tr>
            <th class="numeric"><spring:message text="ID"/></th>
            <th><spring:message text="Status"/></th>
            <th><spring:message text="Title"/></th>
            <th><spring:message text="Url"/></th>
            <th class="numeric"><spring:message text="Job Interval, ms"/></th>
            <th class="numeric"><spring:message text="Next Job"/></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${feeds}" var="feed">
            <tr>
                <td class="numeric">${feed.id}</td>
                <td>${feed.status}</td>
                <td>${feed.title}</td>
                <td>${feed.feedUrl}</td>
                <td class="numeric">${feed.jobInterval}</td>
                <td class="numeric">${feed.nextJob}</td>
                <td class="td_buttons">
                    <a href="<spring:url value="/feeds/delete/${feed.id}/"/>"><spring:message code="action.delete"/></a>
                    <a href="<spring:url value="/feeds/edit/${feed.id}/"/>"><spring:message code="action.edit"/></a>
                    <a href="<spring:url value="/posts/?feed=${feed.id}"/>"><spring:message code="action.posts"/></a>
                    <a href="<spring:url value="/feeds/read/${feed.id}/"/>"><spring:message code="action.read"/></a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <jsp:include page="include/paginator.jsp"/>

</main>

<jsp:include page="include/footer.jsp"/>

</body>
</html>
