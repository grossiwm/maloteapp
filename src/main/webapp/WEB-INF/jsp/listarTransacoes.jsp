<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<jsp:include page="partials/head.jsp"/>
<body>
<jsp:include page="partials/menu.jsp"/>
<h3>Transações</h3>
<hr size="4" color="gray"/>
<table>
<c:forEach items="${transacoes}" var="t">
    <tr>
        <td>Id: <c:out value="${t.id}"/></td>
        <td>Tipo Transação: <c:out value="${t.tipoTransacao}"/></td>
        <td>Valor: <c:out value="${t.valor}"/></td>
        <c:if test = "${t.malote != null}">
            <td>Malote: <c:out value="${t.malote.id}"/></td>
        </c:if>
        <td><a href="/usuario/alterar-malote/<c:out value='${t.malote.id}' />">Ver malote /></a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>