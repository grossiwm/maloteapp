<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="partials/head.jsp"/>
    <body>
    <jsp:include page="partials/menu.jsp"/>
        <h1>Perfil</h1>
        <h2> Usuário logado: <c:out value="${usuario.email}"/></h2>

    </body>
</html>