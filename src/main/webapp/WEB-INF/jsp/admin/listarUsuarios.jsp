<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="../partials/head.jsp"/>
<body>
<jsp:include page="../partials/menu.jsp"/>
<h3>Usuários</h3>
<hr size="4" color="gray"/>
<table>
<c:forEach items="${usuarios}" var="usuario">
    <tr>
        <td>Id: <c:out value="${usuario.id}"/></td>
        <td>Email: <c:out value="${usuario.email}"/></td>
        <td>Empresa: <c:out value="${usuario.empresa.nome}"/></td>
        <td><a href="/admin/editar-usuario/<c:out value="${usuario.id}"/>">Editar</a></td>
        <td><a href="/admin/remove-usuario/<c:out value="${usuario.id}"/>">Remover</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>