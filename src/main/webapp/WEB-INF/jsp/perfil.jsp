<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title> MaloteApp </title>
    </head>
    <body>
        <h1>Perfil</h1>
        <h2> Usuário logado: <c:out value="${usuario.email}"/></h2>

    </body>
</html>