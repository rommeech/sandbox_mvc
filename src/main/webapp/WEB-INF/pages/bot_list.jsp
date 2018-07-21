<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="title" value="Telegram Bots" scope="request"/>

<!doctype html>
<html>
<jsp:include page="include/metadata.jsp"/>
<body>

<jsp:include page="include/header.jsp"/>

<nav class="sub-nav">
    <a href="<spring:url value='/bots/new/'/>"><spring:message text="Add new bot"/></a>
</nav>

<main>

    <table class="table_list">
        <tr>
            <th class="numeric"><spring:message text="ID"/></th>
            <th><spring:message text="Name"/></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${bots}" var="bot">
            <tr>
                <td class="numeric">${bot.id}</td>
                <td>${bot.name}</td>
                <td class="td_buttons">
                    <a href="<spring:url value="/bots/edit/${bot.id}/"/>"><spring:message text="edit"/></a>
                    <a href="<spring:url value="/bots/delete/${bot.id}/"/>"><spring:message text="delete"/></a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <jsp:include page="include/paginator.jsp"/>

</main>

<jsp:include page="include/footer.jsp"/>

</body>
</html>
