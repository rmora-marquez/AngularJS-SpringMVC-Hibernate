/****/
$(document).ready(function() {
    console.log("jquery listo");
});
$(function() {
    console.log("jquery listo 2");
    var $h1Tag = $("h1");
    var $h2Tag = $("#subtitulo");
    console.log($h1Tag.html());
    console.log($h2Tag.html());

    $h1Tag.html("Programación con <strong>Jquery<strong>");
    $h2Tag.html("Ejemplos de front end con <span class='badge badge-danger'>javascript<span>");
    $h1Tag.css({
        'font-size': '70px',
        'color': 'red'
    });
    $h2Tag.addClass('alert alert-danger');

    $("#favoritos li").each(function(idx, li) {
        console.log("indice " + idx + " contiene " + $(li).html());
        if(idx === 0){
        	$(li).clone().appendTo("#odiados");
        }
        if( $(li).html() === 'Jazz' ){
        	$("#odiados").append( $(li).clone() );
        }
    });

    var $nuevoLi = $("<li class='list-group-item'>Metal</li>");
    $nuevoLi.click(function(){
    	console.log("Viva el metal");
    });
    $nuevoLi.appendTo("#favoritos");

    $("<li/>",{
    	'html':'Bachata',
    	'class' : 'list-group-item text-danger',
    	'id' : 'bachata'
     	}).bind({
     		'click' : function(){ console.log("Bachata"); },
     		'mouseover' : function(){ console.log("Baile la bachata");}
     	}).appendTo("#favoritos");        
    
    
    $.ajax({    	
    	url : '/musicstore/api/mensaje',
    	type: 'GET',
    	dataType: 'json',
    	success: function(mensaje){
    		$("<div/>",{ 'html': '<h1>Resultado ajax:</h1><p>'    			
    							+ JSON.stringify(mensaje)+"</p>" 
    			       }).insertAfter("#odiados");
    		}    	
    });
    
    //Interfaz de Usuario De artistas
    var artistas = [];
    var artSeleccionado = {id:null,nombre: "",fotoUrl: "",sitioUrl:""};
    var URL = "/musicstore/api/artista/";
    
    function cargarTodo(){
    	$.ajax({
    		url : URL,
    		type: 'GET',
    		dataType : 'json',
    		success : function(respuesta){
    			artistas = respuesta;
    			mostrarTabla();
    		}
    	});
    }
    function mostrarTabla(){
    	$("#tabla tbody").empty();
    	$(artistas).each(function(idx,artista){
    		var $tr = $("<tr/>");
    		var $tdNombre = $("<td/>",{ 'html': artista.nombre });
    		var $tdFoto = $("<td/>");
    		var $img = $("<img/>",{ 'src' : artista.fotoUrl, 'style':'width:90px;heigh:60px' });
    		var $tdSitio = $("<td/>");
    		var $link = $("<a/>",{'html' : 'Sitio de Fans', 'href': artista.sitioUrl, 'class':'btn btn-primary' });
    		//Botones
    		var $btnEditar = $("<a/>",{'html':'Editar','href':'#', 'class':'btn btn-success' });
    		var $btnBorrar = $("<a/>",{'html':'Borrar','href':'#', 'class':'btn btn-danger' });
    		var $tdAcciones = $("<td/>");
    		//Agregamos eventos
    		$btnBorrar.click(function(e){
    			e.preventDefault();
    			borrar(artista.id);
    		});
    		$btnEditar.click(function(e){
    			e.preventDefault();
    			editar(artista.id);
    		});    		
    		$tdFoto.append($img);
    		$tdSitio.append($link)
    		$tdAcciones.append($btnEditar).append($btnBorrar);
    		$tr.append($tdNombre).append($tdFoto).append($tdSitio).append($tdAcciones);
    		$tr.appendTo("#tabla tbody");
    	});
    };    
    //Editar
    function editar(id){
    	$.getJSON(URL+id,function(art){
    		artSeleccionado = art;
    		$("#input-nombre").val(art.nombre);
    		$("#input-foto").val(art.fotoUrl);
    		$("#input-sitio").val(art.sitioUrl);
    	})
    }
    //Borrar 
    function borrar(id){
    	$.ajax({
    		url : URL+id, type:'DELETE', 
    		success : function(){
    			alert("Artista borrado");
    			cargarTodo();
    		}, error (xhr,status,error){
    			alert("Error en borrar");
    		} 
    	});
    }
    
    //Eventos
    $("#formulario").submit(function(e){
    	artSeleccionado.nombre = $("#input-nombre").val();
    	artSeleccionado.sitioUrl = $("#input-sitio").val();
    	artSeleccionado.fotoUrl = $("#input-foto").val();
    	if(artSeleccionado.id != null){
    		//Actualizar
    		$.ajax({
    			url: URL+artSeleccionado.id, data : JSON.stringify(artSeleccionado),
    			type : 'PUT', contentType:'application/json',
    			success: function(){
    				alert("Guardado correctamente");
	    			cargarTodo();
	    			artSeleccionado = {id:null,nombre:"",fotoUrl:null,sitioUrl:null};
	    			$("#formulario").trigger("reset");
    			}
    			,error: function(){
    				alert("Surgio un error de guardado");
    			}	
    		});
    	}else{
	    	//Guardar
	    	$.ajax({
	    		url : URL, data : JSON.stringify(artSeleccionado),
	    		type: 'POST', contentType: 'application/json',
	    		success : function(){
	    			alert("Guardado correctamente");
	    			cargarTodo();
	    			artSeleccionado = {id:null,nombre:"",fotoUrl:null,sitioUrl:null};
	    			$("#formulario").trigger("reset");
	    		},error : function(xhr,status, error){
	    			alert("Surgio un error "+ JSON.stringify(status) );
	    		}
	    	});
    	}
    	e.preventDefault();
    	return false;
    });
    
    
    cargarTodo();
    
});