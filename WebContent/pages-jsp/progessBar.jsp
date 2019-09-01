<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Barra de progesso</title>
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


<script>
  
//---Jquery
	 $(function() {
    var progressbar = $( "#progressbar" ), progressLabel = $( ".progress-label" );
 
    progressbar.progressbar({
      value: false,
      change: function() {
        progressLabel.text( progressbar.progressbar( "value" ) + "%" );
      },
      complete: function() {
        progressLabel.text( "Complete!" );
      }
    });
 
    function progress() {
      var val = progressbar.progressbar( "value" ) || 0;
 
      progressbar.progressbar( "value", val + 2 );
 
      if ( val < 99 ) {
        setTimeout( progress, 80 );
      }
    }
 
    setTimeout( progress, 2000 );
  });
	
 	function iniciarProgressBar() {
		
 		//-- JavaScript
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

	<div
		style="background-color: tomato; color: #FFF; padding: 10px; margin-bottom: 10px;">
		<a href="ServletAutenticacao?deslogar=true"><button
				style="float: right; background-color: gray; padding: 10px; color: #FFF; border: 0px;">Deslogar</button></a>
		<table class="table">
			<tr scope="row">
				<td><a href="..\index.jsp"><img
						src="../resources/img/home.png" alt="Voltar" /></a></td>
				<td><h3 style="margin-left: 25%">Barra de progesso com JS
						e jQuery</h3></td>
			</tr>
		</table>
	</div>

	<h3>Exemplo progress bar com JavaScript</h3>
	<div class="myProgress">
		<div class="myBar" id="mybar"></div>
	</div>

	<input type="button" onclick="iniciarProgressBar()"
		value="Inciar Barra de progresso">

	<br>

	<hr>

	<h3>Exemplo progress bar com jQuery</h3>
	<div id="progressbar">
		<div class="progress-label">Loading...</div>
	</div>
</body>
</html>