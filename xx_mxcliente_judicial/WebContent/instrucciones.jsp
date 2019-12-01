<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,dto.*"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto Justicia</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<div align="center">
  
<c:set var="lista" value="${requestScope.instrucciones}" />
   <c:choose>
   <c:when test="${!empty lista}">
         <br/>
         <h2>Listado de Instrucciones</h2>
         <br><br>
		 <table border="1">
		    <tr> <th>&nbsp;Juzgado&nbsp;</th> <th style='text-align: center;' >&nbsp;Juez&nbsp;</th> <th style='text-align: center;' >&nbsp;Fecha Inicio&nbsp;</th> <th style='text-align: center;' >Estado</th> </tr>
		
		 <c:forEach var="m" items="${lista}">   		    	
		    		<tr>
		    			<td>&nbsp;${m.idJuzgado}&nbsp;</td>
						<td>&nbsp;${m.idJuez}&nbsp;</td>
						<td  style='text-align: center;' >&nbsp;${m.fechaInicio}&nbsp;</td>
						<td style='text-align: center;' >&nbsp;${m.estado}&nbsp;</td>
					</tr>		    	
		    	
		   </c:forEach>  	
		</table>
		</c:when>
   <c:otherwise>
    <h2>No tiene instruciones</h2>
	</c:otherwise>
	</c:choose>

</div>
<br/>
&nbsp;&nbsp;&nbsp;<a href="toConsultas" >Volver</a>
<br/>

		


</body>
</html>