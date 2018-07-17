<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:choose>
    <c:when test="${channel.id != null}">
        <c:set var="title" value="${channel.id}. ${channel.name} / Telegram Channels" scope="request"/>
    </c:when>
    <c:otherwise>
        <c:set var="title" value="New channel / Telegram Channels" scope="request"/>
    </c:otherwise>
</c:choose>

<!doctype html>
<html>
<jsp:include page="../include/metadata.jsp"/>
<body>

<jsp:include page="../include/header.jsp"/>

<nav class="sub-nav">
    <a href="<spring:url value='/channels/'/>">Channel list</a>
</nav>

<main>

    <jsp:include page="../include/messages.jsp"/>

    <spring:url var="formAction" value="/channels/save/"/>
    <form:form modelAttribute="channel" acceptCharset="UTF-8" method="POST" action="${formAction}">
        <form:hidden path="id"/>

        <div class="div_edit">
            
            <div class="div_row">
                <div class="div_legend"><spring:message text="Name"/></div>
                <div class="div_input">
                    <form:input path="name"/>
                    <form:errors path="name" cssClass="field_error"/>
                </div>
            </div>

            <div class="div_row">
                <div class="div_legend"><spring:message text="Feed"/></div>
                <div class="div_input">
                    <form:input path="feed"/>
                    <form:errors path="feed" cssClass="field_error"/>
                </div>
            </div>

            <div class="div_row">
                <div class="div_legend"><spring:message text="Token"/></div>
                <div class="div_input">
                    <form:input path="token"/>
                    <form:errors path="token" cssClass="field_error"/>
                </div>
            </div>

            <div class="div_row">
                <div class="div_legend"><spring:message text="Status"/></div>
                <div class="div_input">
                    <form:input path="status"/>
                    <form:errors path="status" cssClass="field_error"/>
                </div>
            </div>

        </div>
    </form:form>
</main>

<jsp:include page="../include/footer.jsp"/>

</body>
</html>
