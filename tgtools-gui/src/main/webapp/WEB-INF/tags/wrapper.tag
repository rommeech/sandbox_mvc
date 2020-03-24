<%@ tag description="Tg Wrapper Tag" pageEncoding="UTF-8" %>
<%@ attribute name="subnav" fragment="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<jsp:include page="/WEB-INF/pages/include/metadata.jsp"/>
<body>
    <jsp:include page="/WEB-INF/pages/include/header.jsp"/>

    <nav class="sub-nav"><jsp:invoke fragment="subnav"/></nav>

    <jsp:include page="/WEB-INF/pages/include/messages.jsp"/>

    <main>
        <c:if test="${title != null}"><h1>${title}</h1></c:if>
        <jsp:doBody/>
    </main>

    <jsp:include page="/WEB-INF/pages/include/footer.jsp"/>
</body>
</html>








