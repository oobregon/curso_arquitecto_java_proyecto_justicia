<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1>Formulario de Alta de Juzgado</h1>
	<f:form action="doAltaJuzgado" method="post" modelAttribute="juzgado">
		
		<div class="form-group">
			<label>Numero Juzgado:</label>
			<f:input path="numeroJuzgado" type="text" class="form-control" style="width:30%" />
		</div>
		<div class="form-group">
		  	<label>Provincias:</label>
			<f:select path="idProvincia" class="form-control" style="width:30%"  >
				<f:option value="0" label="TODOS"/>
				<f:options items="${provincias}" itemValue="idProvincia" itemLabel="nombreProvincia"/>			
			</f:select>		 
		   </div> 
		<div class="form-group">
		  	<label>Localidades:</label>
			<f:select path="idLocalidad" class="form-control" style="width:30%"  >
			<f:option value="0" label="TODOS"/>
				<f:options items="${localidades}" itemValue="idLocalidad" itemLabel="nombreLocalidad" />			
			</f:select>		 		 
		</div> 
		
		<button type="submit" class="btn btn-default">Alta Juzgado</button>
		
	</f:form>
</div>
<br/>
&nbsp;&nbsp;<a href="toAdministrativa" >Volver</a>
<br/>
</body>
</html>