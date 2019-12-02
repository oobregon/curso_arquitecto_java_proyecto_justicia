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
<script type="text/javascript">


</script>

</head>
<body>

<div align="center">
	
<c:set var="lista" value="${requestScope.misinstruc}" />
   <c:choose>
   <c:when test="${!empty lista}">
        
        <br>
    	<h2>Listado de Instrucciones</h2>
    	<br><br>
        <table border="1">
		    <tr> <th style='text-align: center;' >Juez</th><th style='text-align: center;' >&nbsp;Juzgado&nbsp;</th> <th style='text-align: center;'>Instruccion</th> <th>&nbsp;Num Piezas&nbsp;</th>
		    <th style='text-align: center;' >Fecha Inicio</th> <th style='text-align: center;'>Estado</th> <th>&nbsp;Finalizar Instruccion&nbsp;</th> </tr>
		
		 <c:forEach var="m" items="${lista}">   		    	
		    		<tr>
		    			<td>&nbsp;${m.idJuez}&nbsp;</td>
						<td>${m.idJuzgado}</td>
						<td>&nbsp;${m.nombreProceso}&nbsp;</td>
						<td>${m.numeroPiezas}</td>
						<td>&nbsp;${m.fechaInicio}&nbsp;</td>
						<td style="text-align: center;">&nbsp;${m.estado}&nbsp;</td>
					    <c:choose>
   						 <c:when test="${'EN_PROCESO'== m.estado}">
        					<td style="text-align: center;" ><a href="doActualizar?id=${m.idInstruccion}&juez=${m.idJuez}">Finalizar</a></td>
   						 </c:when>
   						 <c:otherwise>
						     <td></td>
	                     </c:otherwise>
	                   </c:choose> 
					</tr>		    	
		    	
		   </c:forEach>  	
		</table>
		</c:when>
   <c:otherwise>
    <h2>No tiene instrucciones</h2>
	</c:otherwise>
	</c:choose>
<br/><br/>

</div>
	
<br/><br/>
&nbsp;&nbsp;&nbsp;<a href="toUsuario" >Volver</a>
<br/>
		





</body>
</html>