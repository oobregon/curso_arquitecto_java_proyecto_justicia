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
	<c:when test="${not empty requestScope.jueces}">
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Iden Juez</th>
	        <th>Nombre</th>
	        <th>Apellidos</th>
	        <th>Estado</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
	    <c:forEach var="jue" items="${requestScope.jueces}">	
	      <tr>
	        <td>${jue.idJuez}</td>
	        <td>${jue.nombre}</td>
	        <td>${jue.apellidos}</td>
	        <td>${jue.estado}</td>
	        <td><a href="doInactivarJuez?idJuez=${jue.idJuez}">Inactivar</a></td>
	      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
  </c:when>
  <c:otherwise>
  	<h1>Sin jueces</h1>
  </c:otherwise>
</c:choose>	
    <div class="col-sm-10">
		
		<a type="button" href='toMenuAdmin' class="btn btn-default">Volver</a>
	</div>
</div>

</body>
</html>