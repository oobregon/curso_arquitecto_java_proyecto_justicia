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
<script type="text/javascript">

var urlLocProv="http://localhost:9000/justicia/geo/localidades/porProvincia";


function provincias() {
    var prov = document.getElementById("idProvincia");
	var provSel = prov.options[prov.selectedIndex].value;
	var urlFinal = urlLocProv+'/'+provSel;
	$.get(urlFinal,function(data,status){
	procesarRespuesta(data);
	});
}

function procesarRespuesta(data){
    if (data.length!=0){
		 var opciones='';
		 opciones=opciones+'<label>Localidades:</label>';
		 opciones=opciones+'<select name="idLocalidad" id="idLocalidad"    class="form-control" style="width:30%"      >';
	     for(var i=0;i<data.length;i++){
	            	opciones=opciones+'<option value="'+ data[i].cmun +'">'+  data[i].municipio +'</option>';
	            	console.log("opciones: "+opciones);
	     }
	    
    } else {
    	 var opciones='';
		 opciones=opciones+'<label>Localidades:</label>';
		 opciones=opciones+'<select name="idLocalidad" id="idLocalidad"   class="form-control" style="width:30%"    >';
	 	 opciones=opciones+'<option value="999999" > No hay Localidades </option>';
	     console.log("opciones: "+opciones);    	
    }
    $("#local").html(opciones);
}
function validarProvincia(){
		var idProvSel = $("#idProvincia option:selected" ).val();
		console.log("Seleccion combo idProvSel: "+idProvSel);
		if(idProvSel==""||idProvSel=="0"){
			alert("Seleccione una Provincia ");
			return false;
		}else{
			return true;
		}
}
function validarLocalidad(){
		var idLocSel=$("#idLocalidad option:selected" ).val();
		if(idLocSel==""||idLocSel=="0"){
			alert("Seleccione una Localidad");
			return false;
		}else{
			return true;
		}
}
function validarJuzgado(){
		var numJuz=$("#numeroJuzgado").val();
		if(isNaN(numJuz)){
			alert("El número de Juzgado debe ser numérico");
			return false;    			
		}else{
			if(numJuz==0){
				alert("El número de Juzgado debe ser distinta de cero");
				return false;
			}else{
				return true;
			}
		}
}
	function validar(){
		return validarJuzgado()&&validarProvincia()&&validarLocalidad();
	}



</script>
</head>
<body>
<div class="container">
	<h1>Formulario de Alta de Juzgado</h1>
	<f:form action="doAltaJuzgado"  onsubmit="return validar();"  method="post" modelAttribute="juzgado">
		
		<div class="form-group">
			<label>Numero Juzgado:</label>
			<f:input path="numeroJuzgado" type="text" class="form-control" style="width:30%" />
		</div>
		<div class="form-group">
		  	<label>Provincias:</label>
			<f:select path="idProvincia" class="form-control" style="width:30%"   onchange="provincias();"  >
				<f:option value="0" label="TODOS"/>
				<f:options items="${provincias}" itemValue="idProvincia" itemLabel="nombreProvincia"/>			
			</f:select>		 
		   </div>
		   
	      <div class="form-group" id="local">
	      </div>		   
		    
		 
		<br>
		<button type="submit" class="btn btn-default">Alta Juzgado</button>
		
	</f:form>
</div>
<br/>
&nbsp;&nbsp;<a href="toAdministrativa" >Volver</a>
<br/>
</body>
</html>