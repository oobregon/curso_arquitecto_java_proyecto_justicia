<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto Justicia</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>
<div class="container">
	<h1>Formulario de Alta de Juez</h1>
	<f:form action="doAltaJuez" method="post" modelAttribute="juez">
		<div class="form-group">
			<label>Dni Juez:</label>
			<f:input path="idJuez" type="text" class="form-control" style="width:30%" />
		</div>
		<div class="form-group">
			<label>Nombre:</label>
			<f:input path="nombre" type="text" class="form-control" style="width:30%" />
		</div>
		<div class="form-group">
			<label>Apellidos:</label>
			<f:input path="apellidos" type="text" class="form-control" style="width:30%" />
		</div>
		<div class="form-group">
			<label>Estado:</label>
			<f:select path="estado" class="form-control" style="width:30%"  >
				<f:option value="activo" label="ACTIVO"/>
				<f:option value="inactivo" label="INACTIVO"/>		
			</f:select>		 
		</div>
		<br/>		
		<button type="submit" class="btn btn-default">Alta Juez</button>
		
	</f:form>
</div>
<br/>
&nbsp;&nbsp;<a href="toAdministrativa" >Volver</a>
<br/>
</body>
</html>