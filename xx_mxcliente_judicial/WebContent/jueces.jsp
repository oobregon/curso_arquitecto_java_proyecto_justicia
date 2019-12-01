<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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


function cambiarEstado (id){
	//alert('En cambiarEstado');
	var url ="http://localhost:8002/jueces";
	var urlSalida=url+"/baja/"+id;
	//alert('urlSalida es:'+urlSalida);
	$.ajax({
		   url: urlSalida,
		   type: 'PUT',
		   success: function(response) {
			   cambiarInstruccion(id);
		   }
	});
	    
}

function cambiarInstruccion (id){
	//alert('En cambiarInstruccion:'+id);
	var url ="http://localhost:9002/instruccion";
	var urlSalida=url+"/eliminiarJuez/"+id;
	//alert('urlSalida es:'+urlSalida);
	$.ajax({
		   url: urlSalida,
		   type: 'PUT',
		   success: function(response) {
			   cargarJueces();
		   }
	});

}

function cargarJueces() {
   // alert('En cargarJueces');
	var url ="http://localhost:8002/jueces";
	var urlSalida=url+"/lista";
    //alert('urlSalida es:'+urlSalida);
	$.get(urlSalida,function(data,status){
		procesarRespuesta(data);
	});
	
}

function procesarRespuesta(data){
	var json=data;
	//alert('json:'+json);
	var cabecera="<h1>LISTADO DE JUECES</h1> <br/>";
	var tabla=cabecera+"<table border='1'><tr><th style='text-align: center;'>&nbsp;Nombre&nbsp;</th><th style='text-align: center;'>&nbsp;Apellidos&nbsp;</th><th style='text-align: center;'>&nbsp;Estado&nbsp;</th><th>&nbsp;Inactivar Juez&nbsp;</th> </tr>";
	for(var i=0;i<json.length;i++){
		tabla+="<tr><td>&nbsp;"+json[i].nombre+"&nbsp;</td><td>&nbsp;"+json[i].apellidos+"&nbsp;</td><td style='text-align: center;' >&nbsp;"+json[i].estado+"&nbsp;</td>";
		//alert('estado:'+json[i].estado);
		if(json[i].estado=='ACTIVO'){
			tabla+="<td style='text-align: center;' ><a href='#' onclick='cambiarEstado("+json[i].idJuez+")'> Inactivar </a></td> </tr>";
		}else{
			tabla+="<td> </td> </tr>";
		}
		
		
	}
	tabla+="</table>";
	$("#tabla").html(tabla);
	
	
}


</script>

</head>

<body  onload="cargarJueces();">

<div align="center" class="container" >


		<div id="tabla"></div>
<br/><br/>
		
</div>
	
&nbsp;&nbsp;&nbsp;<a href="toAdministrativa">Volver</a>
		
</body>
</html>