<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Efetuar autenticação</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</head>
<body>

	<div style="background-color: #006400; color: #FFF; padding: 10px; margin-bottom: 10px;">
		<table class="table">
			<tr  scope="row" >
				<td>
					<a href="../index.jsp"><img src="../resources/img/home.png" alt="Voltar"/></a>
				</td>
				<td><h3 style="margin-left: 25%">Efetuar Autenticação</h3></td>
			</tr>		
		</table>
	</div>
	
	
	
	<center>Login: Clid Robalo & Senha: 1234</center>
	<div style="margin: 20px auto; background-color: #2F4F4F; width: 400px; color: #FFF; padding: 20px;">
		
		<c:if test="${cridenciasInvalidos }">
			<h3 style="color: tomato;">Login ou Senha Invalido</h3>
		</c:if>
		
		
		<form action="ServletAutenticacao" method="post">
			<input type="text" name="urlParam" id="urlParam" value="${urlParam }" style="width: 100%;">
			<table class="table">
				<tbody>
					<tr>
						<th scope="row">Login</th>
						<td>
							<input type="text" value="${usuario.user }" name="login" style="width: 100%;" placeholder="   Login..." required>
						</td>
					</tr>
					<tr>
						<th scope="row">Senha</th>
						<td >
							<input type="password" value="${usuario.senha }" name="senha" style="width: 100%;" placeholder="   Senha..." required>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="Autenticar" style="width: 100%; background-color: #FFF; color: #2F4F4F; border: 0px; height: 40px;">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		
	
	</div>
</body>
</html>