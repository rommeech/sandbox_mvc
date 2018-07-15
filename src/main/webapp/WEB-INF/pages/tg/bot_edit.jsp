<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:choose>
    <c:when test="${bot.id != null}">
        <c:set var="title" value="BotId=${bot.id} / Telegram Bots" scope="request"/>
    </c:when>
    <c:otherwise>
        <c:set var="title" value="New Bot / Telegram Bots" scope="request"/>
    </c:otherwise>
</c:choose>

<!doctype html>
<html>
<jsp:include page="../include/metadata.jsp"/>
<body>

<jsp:include page="../include/header.jsp"/>

<nav class="subnav">
    <a href="<spring:url value='/bots/'/>">Bot List</a>
</nav>

<main>

    <jsp:include page="../include/messages.jsp"/>

    <spring:url var="formAction" value="/bots/save/"/>
    <form:form modelAttribute="bot" acceptCharset="UTF-8" method="POST" action="${formAction}">
        <form:hidden path="id"/>

        <div class="div_edit">
            <div class="div_edit_row">
                <div class="div_edit_legend">
                    <spring:message text="Name"/>
                    <div class="div_edit_error"><form:errors path="name"/></div>
                </div>
                <div class="div_edit_input"><form:input path="name"/></div>
            </div>
            <div class="div_edit_row">
                <div class="div_edit_legend">
                    <spring:message text="Username"/>
                    <div class="div_edit_error"><form:errors path="username"/></div>
                </div>
                <div class="div_edit_input"><form:input path="username"/></div>
            </div>
            <div class="div_edit_row">
                <div class="div_edit_legend">
                    <spring:message text="Token"/>
                    <div class="div_edit_error"><form:errors path="token"/></div>
                </div>
                <div class="div_edit_input"><form:input path="token"/></div>
            </div>
            <div class="div_edit_row">
                <div class="div_edit_legend">
                    <spring:message text="Bot Picrute URL"/>
                    <div class="div_edit_error"><form:errors path="botpic"/></div>
                </div>
                <div class="div_edit_input"><form:input path="botpic"/></div>
            </div>
            <div class="div_edit_row">
                <div class="div_edit_legend">
                    <spring:message text="About"/>
                    <div class="div_edit_error"><form:errors path="about"/></div>
                </div>
                <div class="div_edit_input"><form:textarea rows="6" path="about"/></div>
            </div>
            <div class="div_edit_row">
                <div class="div_edit_legend">
                    <spring:message text="Description"/>
                    <div class="div_edit_error"><form:errors path="description"/></div>
                </div>
                <div class="div_edit_input"><form:textarea rows="6" path="description"/></div>
            </div>
            <div class="div_edit_row">
                <div class="div_edit_legend"></div>
                <div class="div_edit_input">
                    <form:button>Save</form:button>
                    <a href="<spring:url value="/bots/"/>">Cancel</a>
                </div>
            </div>
        </div>
    </form:form>
</main>

<jsp:include page="../include/footer.jsp"/>

</body>
</html>
