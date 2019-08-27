<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Capturar Exceções</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
  
</head>
<body>

	<div style="background-color: #006400; color: #FFF; padding: 10px; margin-bottom: 10px;">
		<table class="table">
			<tr  scope="row" >
				<td>
					<a href="..\index.jsp"><img src="../resources/img/home.png" alt="Voltar"/></a>
				</td>
				<td><h3 style="margin-left: 25%">Capturar Exceções com jQuery</h3></td>
			</tr>		
		</table>
	</div>
	
	<div style="padding: 20px;">
		<input type="text"  id="valorInformado" placeholder="Informa um numero...">
		<input type="submit" value="Testar" onclick="testarExcecoes()">	
	</div>
	
</body>

<script>
	function testarExcecoes() {
		
		var valorInformado = $('#valorInformado').val();

		//Escrita basica Ajax
		<!--
			$.ajax({
				method: "",
				url: "",
				data: {"variavel" : "valor"}
			}).always(function(response) {
				alert(response);
			});
		-->
		$.ajax({
			method: "POST",
			url: "capturarExcecao", //servlet destino
			data: {valorExcecaoParam : valorInformado}
		
		}).done(function(response) { //capturar retorno da invocação
			alert(response);
		
		}).fail(function(jqXHR, textStatus, errorThrown) {
			alert("Erro: " + jqXHR.responseText); //Mostra o erro que foi escrito no server
		});
		
	}
</script>
</html>