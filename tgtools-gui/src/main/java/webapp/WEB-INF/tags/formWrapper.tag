<%@ tag pageEncoding="UTF-8" description="Form wrapper" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ attribute name="hiddenFields" fragment="true" %>
<%@ attribute name="model" required="true" %>
<%@ attribute name="formAction" required="true" type="java.lang.String" %>
<%@ attribute name="cancelLink" required="true" type="java.lang.String" %>

<form:form modelAttribute="${model}" acceptCharset="UTF-8" method="POST" action="${formAction}">
    <jsp:invoke fragment="hiddenFields"/>
    <div class="edit_form">
        <jsp:doBody/>
        <div class="form_buttons">
            <form:button>Save</form:button>
            <a href="${cancelLink}">Cancel</a>
        </div>
    </div>
</form:form>