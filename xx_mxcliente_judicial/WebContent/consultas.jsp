<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proyecto Justicia</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<script type="text/javascript">

function seleccionar(){
	
 	var juez=document.getElementById("juez").checked;
 	var juzgado=document.getElementById("juzgado").checked;
 	if(juez){
 		document.getElementById('consul2').style.display = 'none';
 		document.getElementById('consul1').style.display = 'inline';
 		cargarComboJueces();
 	} else if(juzgado){
 		document.getElementById('consul1').style.display = 'none';
 		document.getElementById('consul2').style.display = 'inline';
 		cargarComboJuzgados();
 	}
	
}

function cargarComboJuzgados(){
	 var url="http://localhost:8001/juzgados";
	 var urlSalida=url+"/lista"
	 //alert('En cargarComboJuzgados, urlSalida:'+urlSalida);
	 $.ajax({
         type: "GET",
         url: urlSalida,
         dataType: 'json', 
         success: function(data){
             //alert('data'+data);
             var json=data;
             var opciones='';
             for(var i=0;i<json.length;i++){
            	opciones=opciones+'<option value="'+ json[i].idJuzgado +'">'+  json[i].numeroJuzgado +'</option>';
             }
        	
             $("#idjuzgados").html(opciones);
         }
 });
}


function cargarComboJueces(){
	var url="http://localhost:8002/jueces";
	var urlSalida=url+"/lista";
	console.log=urlSalida;
	alert('En cargarComboJueces, urlSalida:'+urlSalida);
	 $.ajax({
        type: "GET",
        url: urlSalida,
        dataType: 'json', 
        success: function(data){
            alert('data:'+data);
            var json=data;
            var opciones='';
            for(var i=0;i<json.length;i++){
           		opciones=opciones+'<option value="'+ json[i].idJuez +'">'+  json[i].nombre +'</option>';
            }
       	
            $("#idjueces").html(opciones);
        }
});
	
}

function enviar(){
    
	if(document.getElementById("juez").checked){
	   document.getElementById("tipoConsulta").value='porjuez';
	   var idjueces= document.getElementById("idjueces");
	   var valorjuez = idjueces.options[idjueces.selectedIndex].value;
	   document.getElementById("idjuez").value=valorjuez;
	   //alert('valorjuez:'+valorjuez);
	   document.getElementById('formulario').submit();
	  
	}else if(document.getElementById("juzgado").checked){
		 document.getElementById("tipoConsulta").value='porjuzgado';
		 var idjuzgados=document.getElementById("idjuzgados");
		 var valorjuzgados = idjuzgados.options[idjuzgados.selectedIndex].value;
		 
		 document.getElementById("idjuzgado").value=valorjuzgados;
		 var estado = document.getElementById("idestado");
		 var pro = estado.options[estado.selectedIndex].value;
		 document.getElementById('formulario').submit();
  	    	
	}

}

</script>

</head>
<body>
<div class="container" >
<form id="formulario" action="consultar" method="post">
<input type="hidden" id="tipoConsulta" name="tipoConsulta" value="">
<input type="hidden" id="idjuez" name="idjuez" value="">
<input type="hidden" id="idjuzgado" name="idjuzgado" value="">


      <br>
      <h2>Consulta de Instrucciones</h2>
      <br>
      &nbsp;<input type="radio" id="juez" name="radiobu" onclick="seleccionar();" value="porjuez">
      <label >Consulta por Juez</label>
      <br>
      &nbsp;<input type="radio" id="juzgado" name="radiobu" onclick="seleccionar();" value="porjuzgado">
      <label >Consulta por Juzgado</label>

      <br><br>

  <div id="consul1" style="display: none;"    >    
     <br/>          
     <label>Seleccionar Juez: </label>  
       <select id="idjueces" name="idjueces">
  	   </select>      
  </div>
  
  <div id="consul2" style="display: none;" >  
       <br/>    
       <label>Seleccionar Juzgado: </label>  
         <select id="idjuzgados" name="idjuzgados">
  	     </select>  
     <br/><br/>	 
   <label>Estado de la instrucción: </label>  
    <select id="idestado" name="idestado">
  	  <option value="todo"></option>
  	  <option value="pendiente_asignacion">PENIENTE_ASIGNACION</option>
  	  <option value="en_proceso">EN_PROCESO</option>
   	  <option value="finalizado">FINALIZADO</option>
	</select>
	 	 
  </div>	
	<br/><br/><br/> 
    <input type="button" onclick="enviar();" value="Enviar" />
   
</form>
</div>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="toUsuario" >Volver</a>
<br/>



  

</body>
</html>