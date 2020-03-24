<%@ page import="org.rp.sandboxmvc.helper.MessageProvider" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<% pageContext.setAttribute("newLineChar", "\n"); %>
<% pageContext.setAttribute("newLineHtml", "<br>"); %>

<c:set var="messageProvider" value="${sessionScope['scopedTarget.messageProvider']}"/>

<div id="messages">
<c:if test="${messageProvider.hasInfoMessages()}">
    <c:forEach var="msg" items="${messageProvider.getAllInfoMessages()}">
        <div class="info_msg">${fn:replace(msg, newLineChar, newLineHtml)}</div>
    </c:forEach>
</c:if>

<c:if test="${messageProvider.hasWarningMessages()}">
    <c:forEach var="msg" items="${messageProvider.getAllWarningMessages()}">
        <div class="warning_msg">${fn:replace(msg, newLineChar, newLineHtml)}</div>
    </c:forEach>
</c:if>

<c:if test="${messageProvider.hasErrorMessages()}">
    <c:forEach var="msg" items="${messageProvider.getAllErrorMessages()}">
        <div class="error_msg">${fn:replace(msg, newLineChar, newLineHtml)}</div>
    </c:forEach>
</c:if>
</div>