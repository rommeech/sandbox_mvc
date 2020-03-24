<%@ tag pageEncoding="UTF-8" description="Edit field template: input, legend, validation error" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags" %>

<%@ attribute name="id" required="false" type="java.lang.String" %>
<%@ attribute name="field" required="true" type="java.lang.String" %>
<%@ attribute name="legendCode" required="true" type="java.lang.String" %>

<tg:formRow field="${field}" legendCode="${legendCode}" cssClass="field_checkbox">
    <jsp:body>
        <form:checkbox path="${field}" id="${id}" />
    </jsp:body>
</tg:formRow>
