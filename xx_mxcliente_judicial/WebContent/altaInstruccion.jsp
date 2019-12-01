<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto Justicia</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 



</head>
<body >

<div class="container"  >
<h1>Formulario de Alta de Instrucción</h1>
<f:form action="alta" method="post"  modelAttribute="instruccion"  >
   <div class="form-group">
           <label>Número Juzgado: </label> 
   		     <f:select path = "idJuzgado" class="form-control" style="width:30%" >
               <f:options items = "${juzgados}"  itemValue="idJuzgado" itemLabel="numeroJuzgado" />
             </f:select>  
   </div>          
   <div class="form-group">         
            <label>Nombre Instrucción: </label>
   			 <f:input type="text" path="nombreProceso" class="form-control" style="width:30%" />
    </div> 
   <div class="form-group">
             <label>Número de Piezas: </label>
             <f:input type="text" path="numeroPiezas" class="form-control" style="width:30%" />
    </div> 
    <div class="form-group">
             <label>Fecha Inicio: </label>          
             <f:input type="date" path="fechaInicio" class="form-control" style="width:30%"  />
    </div> 
            
             <br/>
			<button type="submit" class="btn btn-default" >Alta Instrucción</button>
	
</f:form>
</div>
<br/> <br/>
&nbsp;&nbsp;&nbsp;<a href="toAdministrativa">Volver</a>



</body>
</html>