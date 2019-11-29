<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show contacts here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>

	

<div class="container">
<c:choose>
	<c:when test="${not empty requestScope.juzgados}">
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Id Juzgado</th>
	        <th>Numero Juzgado</th>
	        <th>Provincia</th>
	        <th>Localidad</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
	    <c:forEach var="juz" items="${requestScope.juzgados}">	
	      <tr>
	        <td>${juz.idJuzgado}</td>
	        <td>${juz.numeroJuzgado}</td>
	        <td>${juz.idProvincia}</td>
	        <td>${juz.idLocalidad}</td>
<%-- 	        <td><a href="doEliminar?idContacto=${contacto.idContacto}">Eliminar</a></td> --%>
	      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
  </c:when>
  <c:otherwise>
  	<h1>Sin juzgados</h1>
  </c:otherwise>
</c:choose>	
    <div class="col-sm-10">
		
		<a type="button" href='toMenuAdmin' class="btn btn-default">Volver</a>
	</div>
</div>

</body>
</html>