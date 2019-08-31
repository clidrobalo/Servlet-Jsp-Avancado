<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Barra de progesso</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
  
  <link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
  
  <script>
 	function iniciarProgressBar() {
 		
 		var elem = document.getElementById("mybar");
 		var width = 1;
 		var id = setInterval(() => {
			if(width >= 100) {
				clearInterval();
			} else {
				width++;
				elem.style.width = width + "%";
			}
		}, 10);
 	}
  
  </script>
  
</head>
<body>
	
	<div style="background-color: tomato; color: #FFF; padding: 10px; margin-bottom: 10px;">
		<a href="ServletAutenticacao?deslogar=true"><button  style="float: right; background-color: gray; padding: 10px; color: #FFF; border: 0px;" >Deslogar</button></a>
		<table class="table">
			<tr  scope="row" >
				<td>
					<a href="..\index.jsp"><img src="../resources/img/home.png" alt="Voltar"/></a>
				</td>
				<td><h3 style="margin-left: 25%">Barra de progesso com JS e jQuery</h3></td>
			</tr>		
		</table>
	</div>
	
	<h3>Exemplo progress bar com JavaScript</h3>
	<div class="myProgress">
		<div class="myBar" id="mybar">
		
		</div>
	</div>
	<input type="button" onclick="iniciarProgressBar()" value="Inciar Barra de progresso"> 
</body>
</html>