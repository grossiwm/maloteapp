<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
<h3>Usuários</h3>
<hr size="4" color="gray"/>
<table>
<c:forEach items="${usuarios}" var="usuario">
    <tr>
        <td>Email: <c:out value="${usuario.email}"/></td>
        <td>Empresa: <c:out value="${usuario.empresa.nome}"/></td>   
    </tr>
</c:forEach>
</table>
</body>
</html>