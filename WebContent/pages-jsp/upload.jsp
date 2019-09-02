<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpLoad Imagem</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />

<script
  src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
  integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
  crossorigin="anonymous"></script>
</head>
<body>

	<div style="background-color: #006400; color: #FFF; padding: 10px; margin-bottom: 10px;">
		<a href="ServletAutenticacao?deslogar=true"><button  style="float: right; background-color: gray; padding: 10px; color: #FFF; border: 0px;" >Deslogar</button></a>
		<table class="table">
			<tr  scope="row" >
				<td>
					<a href="..\index.jsp"><img src="../resources/img/home.png" alt="Voltar"/></a>
				</td>
				<td><h3 style="margin-left: 25%">Upload Imagem</h3></td>
			</tr>		
		</table>
	</div>
	
	<div class="container bg-secondary p-5">
		<div>
			<input type="file" id="file" name="file" onchange="uploadFile();">
		</div>
		<hr>
		<div>
			<img alt="Imagem" src="" id="target" width="200"/>
		</div>
		<hr>
		<h4 id="respostaUpload" style="color: #00b16a"></h4>
		
		<div class="bg-white p-5">
			Verificar se ja existe imagem do utilizador na base de dados<br>
			<a href="fileUpload?acao=getImage"><button>Carregar imagem</button></a>
			<hr>
			Verificar se ja existe imagens dos utilizadores na base de dados<br>
			<a href="fileUpload?acao=getImages"><button>Carregar imagens</button></a>
		</div>
		<div>
			<c:if test="${imagem != null }">
				<a href="fileUpload?acao=download"><img alt="Imagem"  src="${imagem }" width="200"/></a>
			</c:if> 		
			
			<c:forEach var="imagem" items="${imagens }">
				<img alt="Imagem"  src="${imagem }" width="200"/>
			</c:forEach>
		</div>
	
	</div>
	
	
</body>

<script>

	function uploadFile() {
		var target = document.getElementById("target");
		var file = document.querySelector("input[type=file]").files[0];
		var reader = new FileReader();
		
		reader.onloadend = function() {
		target.src = reader.result;
			
			////////----------Upload Ajax
			
/* 		Default Method		
 
 				$.ajax({
				  type: "POST",
				  url: url,
				  data: {},
				}).done(function(response) {
				    alert( "Sucesso: " + response );
				  })
				  .fail(function(xhr, status, errorThrown) {
				    alert( "Error: " +  xhr.responseText);
				  });
			 */
			
			$.ajax({
			
			  type: "POST",
			  url: "fileUpload",
			  data: {fileUpload : target.src}
		
			}).done(function(response) {
			    //alert( "Sucesso: " + response );
			    $('#respostaUpload').text(response);
			    
			  })
			  .fail(function(xhr, status, errorThrown) {
			    alert( "Error: " +  xhr.responseText);
			  });
		};
		
		if(file) {
			reader.readAsDataURL(file);
		} else {
			target.src = "";
		}
	}

	
</script>
</html>