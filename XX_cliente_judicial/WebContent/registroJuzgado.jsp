<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Contact here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<script type="text/javascript">
 var url="http://localhost:8080/07_crud_contactos_rest/contacto";
 function cambiarProvincias() {  
  var pr = document.getElementById("provincias");
  var pro = estado.options[estado.selectedIndex].value;
  alert('Cambiar Provincias Pro: '+ pro);
  $.get(url,function(data,status){
		procesarRespuesta(data);
	});  	
}
 function procesarRespuesta(data){
		console.log("respuestaContactos");
		console.log(data);		
			$("#localidades").html(tabla);
		}
	}

</script>
</head>
<body>
<div class="container">
	<h1>Formulario de Alta de Juzgado</h1>
	<f:form action="doAltaJuzgado" method="post" modelAttribute="juzgado">
		<div class="form-group">
			<label>Numero de Juzgado:</label>
			<f:input path="numeroJuzgado" class="form-control" style="width:30%" />
		</div>
		<div class="form-group">
		  	<label>Provincias:</label>
			<f:select path="idProvincia" id="provincias" onchange="cambiarProvincias();" >
				<f:option value="0" label="TODOS"/>
				<f:options items="${provincias}" itemValue="idProvincia" itemLabel="nombreProvincia"/>			
			</f:select>		 
		   </div> 
		<div class="form-group">
		  	<label>Localidades:</label>
			<f:select path="idLocalidad" id="localidades"  >
			<f:option value="0" label="TODOS"/>
				<f:options items="${localidades}" itemValue="idLocalidad" itemLabel="nombreLocalidad" />			
			</f:select>		 		 
		</div> 
		
		<button type="submit" class="btn btn-default">Alta</button>
		
	</f:form>
</div>
</body>
</html>