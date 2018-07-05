<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<% pageContext.setAttribute("newLineChar", "\n"); %>
<% pageContext.setAttribute("newLineHtml", "<br>"); %>

<c:if test="${errorMsg != null}">
    <div class="error_msg">${fn:replace(errorMsg, newLineChar, newLineHtml)}</div>
</c:if>

<c:if test="${warningMsg != null}">
    <div class="warning_msg">${fn:replace(warningMsg, newLineChar, newLineHtml)}</div>
</c:if>

<c:if test="${infoMsg != null}">
    <div class="info_msg">${fn:replace(infoMsg, newLineChar, newLineHtml)}</div>
</c:if>
