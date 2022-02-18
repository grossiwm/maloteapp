<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:set var = "usuarioLogado" scope="session" value = "${sessionScope['scopedTarget.usuarioLogadoSession']}"/>
<!DOCTYPE html>
<html>
<jsp:include page="./partials/head.jsp"/>
<body>
    <jsp:include page="./partials/menu.jsp"/>
    <h3>Malote número <c:out value="${malote.id}"/> da empresa <c:out value="${malote.empresa.nome}"/> </h3>
    <hr size="4" color="gray"/>
    <form action="/usuario/alterar-malote/<c:out value="${malote.id}"/>" method='POST'>
        <input type="hidden" value="usuarioLogado.id">
        <div>
            <label> Data de criação: <c:out value="${dataCriacao}"/>
        </div>
    </form>
    <c:if test = "${malote.id != null}">
           <legend>depósitos:</legend>
           <c:forEach items="${malote.depositos}" var="deposito">
               <div>
                   <label> <c:out value="${deposito.id}"/> - <c:out value="${deposito}"/>
                   <a href="/usuario/remove-deposito/${deposito.id}">remover</a> </ label>
                  <a href="/usuario/alterar-deposito/${deposito.id}">alterar</a> </ label>
               </div>
           </c:forEach>
          <legend>transferências:</legend>
          <c:forEach items="${malote.transferencias}" var="transferencia">
              <div>
                  <label> <c:out value="${transferencia.id}"/> - <c:out value="${transferencia}"/>
                  <a href="/usuario/remove-transferencia/${transferencia.id}">remover</a> </ label>
                  <a href="/usuario/alterar-transferencia/${transferencia.id}">alterar</a> </ label>
              </div>
          </c:forEach>
          <legend>Pagamentos:</legend>
          <a href='/usuario/novo-pagamento/<c:out value="${malote.id}"/>'>incluir pagamento</a>
        <c:forEach items="${malote.pagamentos}" var="pagamento">
                <div>
                    <label> <c:out value="${pagamento.id}"/> - <c:out value="${pagamento}"/>
                    <a href="/usuario/remove-pagamento/${pagamento.id}">remover</a> </ label>
                  <a href="/usuario/alterar-pagamento/${pagamento.id}">alterar</a> </ label>

                </div>
            </c:forEach>
    </c:if>

</body>
</html>