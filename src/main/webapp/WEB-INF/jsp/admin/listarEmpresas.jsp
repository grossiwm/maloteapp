<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
<h3>Empresas</h3>
<hr size="4" color="gray"/>
<table>
<c:forEach items="${empresas}" var="empresa">
    <tr>
        <td>Nome: <c:out value="${empresa.nome}"/></td>
    </tr>
</c:forEach>
</table>
</body>
</html>