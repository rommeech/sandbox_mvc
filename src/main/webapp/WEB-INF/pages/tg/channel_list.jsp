<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="title" value="Telegram Channels" scope="request"/>

<!doctype html>
<html>
<jsp:include page="../include/metadata.jsp"/>
<body>

<jsp:include page="../include/header.jsp"/>

<nav class="sub-nav">
    <a href="<spring:url value='/channels/new/'/>"><spring:message text="Add new channel"/></a>
</nav>

<main>

    <table class="table_list">
        <tr>
            <th class="numeric"><spring:message text="ID"/></th>
            <th><spring:message text="Name"/></th>
            <th><spring:message text="Status"/></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${channels}" var="channel">
            <tr>
                <td class="numeric">${channel.id}</td>
                <td>${channel.name}</td>
                <td>${channel.status}</td>
                <td class="td_buttons">
                    <a href="<spring:url value="/channels/edit/${channel.id}/"/>"><spring:message text="edit"/></a>
                    <a href="<spring:url value="/channels/delete/${channel.id}/"/>"><spring:message text="delete"/></a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <jsp:include page="../include/paginator.jsp"/>

</main>

<jsp:include page="../include/footer.jsp"/>

</body>
</html>
