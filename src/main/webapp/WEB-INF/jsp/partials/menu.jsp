<%@ page import="com.gabrielrossilopes.appmalote.session.UsuarioLogadoSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:set var = "usuarioLogado" scope="session" value = "${sessionScope['scopedTarget.usuarioLogadoSession']}"/>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">MaloteApp</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <c:if test = "${!usuarioLogado.isNull()}">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/usuario/perfil">Perfil</a>
                    </li>
                    <c:if test = "${usuarioLogado.isAdmin()}">
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/cadastrar-usuario">Novo Usuário</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/listar-usuarios">Usuarios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/listar-solicitacoes">Solicitações</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/listar-empresas">Empresas</a>
                        </li>
                    </c:if>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                </c:if>
                <c:if test = "${usuarioLogado.isNull()}">
                    <a class="nav-link" href="/login">Login</a>
                    <a class="nav-link" href="/usuario/solicitar-acesso">Cadastrar</a>
                </c:if>
            </ul>
        </div>
    </div>
</nav>