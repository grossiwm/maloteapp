<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<jsp:include page="partials/head.jsp"/>
<body>
<jsp:include page="partials/menu.jsp"/>
<h3>Malotes</h3>
<hr size="4" color="gray"/>
<table>
<c:forEach items="${malotes}" var="m">
    <tr>
        <td>Id: <c:out value="${m.id}"/></td>
        <td>Empresa: <c:out value="${m.empresa.nome}"/></td>
        <td>Valor: <c:out value="${m.usuario.nome}"/></td>
        <td><a href="/usuario/alterar-malote/<c:out value="${m.id}"/>">Editar</a></td>
        <td><a href="/usuario/remove-malote/<c:out value="${m.id}"/>">Remover</a></td>

    </tr>
</c:forEach>
</table>
</body>
</html>