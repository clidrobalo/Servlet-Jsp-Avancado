<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data Table jQuery</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
  
  <link rel="stylesheet" href="http://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
  <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
  <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

</head>
<body>
	<div style="background-color: #006400; color: #FFF; padding: 10px; margin-bottom: 10px;">
		<a href="ServletAutenticacao?deslogar=true"><button  style="float: right; background-color: gray; padding: 10px; color: #FFF; border: 0px;" >Deslogar</button></a>
		<table class="table">
			<tr  scope="row" >
				<td>
					<a href="..\index.jsp"><img src="../resources/img/home.png" alt="Voltar"/></a>
				</td>
				<td><h3 style="margin-left: 25%">Data Table com jQuery</h3></td>
			</tr>		
		</table>
	</div>
	
	<div class="container bg-white mt-4">
		<table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th>Nome</th>
                <th>Cidade</th>
                <th>Telefone</th>
            </tr>
        </thead>
        <tbody>
       		
        </tbody>
    </table>
	</div>
</body>

<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": "carregarDadosDataTable" //Url para Retorno dos dados do servidor
    } );
} );
</script>
</html>