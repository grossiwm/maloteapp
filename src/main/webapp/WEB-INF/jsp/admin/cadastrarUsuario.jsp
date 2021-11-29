<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head></head>
<body>
   <h1>Cadastrar usuário</h1>
   <form action="/admin/cadastrar-usuario" method='POST'>
      <table>
         <tr>
            <td>Usuário:</td>
            <td><input type='text' name='email' value=''></td>
         </tr>
         <tr>
            <td>Senha:</td>
            <td><input type='password' name='senha' /></td>
         </tr>
         <tr>
            <td>Empresa:</td>
            <td>
				<select name="empresa">
				  <c:forEach items="${empresas}" var="empresa">
				    <option value="${empresa.id}">
				        ${empresa.nome}
				    </option>
				  </c:forEach>
				</select>
            </td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
      </table>
  </form>
</body>
</html>