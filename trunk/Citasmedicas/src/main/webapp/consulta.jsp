<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<style type='text/css'>

	body {
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		margin: 0;
	}

	h1 {
		margin: 0;
		padding: 0.5em;
	}

	p.description {
		font-size: 0.8em;
		padding: 1em;
		position: absolute;
		top: 3.2em;
		margin-right: 400px;
	}

	#message {
		font-size: 0.7em;
		position: absolute;
		top: 100em;
		left: 10em;
		width: 350px;
		display: none;
		padding: 1em;
		background: #ffc;
		border: 1px solid #dda;
	}

</style>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Web Consultorio Médico</title>
<link href="Recursos/style.css" rel="stylesheet" type="text/css" media="screen" />
<link href="Recursos/styles/jquery-ui.css" rel="stylesheet" type='text/css' media="screen" />
<link href="Recursos/styles/jquery.weekcalendar.css" rel="stylesheet" type='text/css' media="screen" />

<script type='text/javascript' src='Recursos/scripts/jquery.min.js'></script>
<script type='text/javascript' src='Recursos/scripts/jquery-ui.min.js'></script>
<script type='text/javascript' src='Recursos/scripts/jquery.weekcalendar.js'></script>
<script type='text/javascript'>


	var year = new Date().getFullYear();
	var month = new Date().getMonth();
	var day = new Date().getDate();

	var eventData = {
		events : [
		   {"id":1, "start": new Date(year, month, day, 12), "end": new Date(year, month, day, 13, 35),"title":""},
		   {"id":2, "start": new Date(year, month, day, 14), "end": new Date(year, month, day, 14, 45),"title":""},
		   {"id":3, "start": new Date(year, month, day + 1, 18), "end": new Date(year, month, day + 1, 18, 45),"title":""},
		   {"id":4, "start": new Date(year, month, day - 1, 8), "end": new Date(year, month, day - 1, 9, 30),"title":""},
		   {"id":5, "start": new Date(year, month, day + 1, 14), "end": new Date(year, month, day + 1, 15),"title":""}
		]
	};



	$(document).ready(function() {

		$('#calendar').weekCalendar({
			timeslotsPerHour: 4,
			height: function($calendar){
				return $(window).height() - $("h1").outerHeight();
			},
			eventRender : function(calEvent, $event) {
				if(calEvent.end.getTime() < new Date().getTime()) {
					$event.css("backgroundColor", "#aaa");
					$event.find(".time").css({"backgroundColor": "#999", "border":"1px solid #888"});
				}
			},
			eventNew : function(calEvent, $event) {
				displayMessage("<p><strong>Added event</strong><br/>Start: " + calEvent.start + "<br/>End: " + calEvent.end + "<p>");
			},
			eventDrop : function(calEvent, $event) {
				displayMessage("<p><strong>Detalle Horario</strong><br/>Inicio Horario: " + calEvent.start + "<br/>Fin Horario: " + calEvent.end + "<p>");
			},
			eventResize : function(calEvent, $event) {
				displayMessage("<p><strong>Detalle Horario</strong><br/>Inicio Horario: " + calEvent.start + "<br/>Fin Horario: " + calEvent.end + "<p>");
			},
			eventClick : function(calEvent, $event) {
				displayMessage("<p><strong>Detalle Horario</strong><br/>Inicio Horario: " + calEvent.start + "<br/>Fin Horario: " + calEvent.end + "<p>");
			},
			eventMouseover : function(calEvent, $event) {
				displayMessage("<p><strong>Detalle Horario</strong><br/>Inicio Horario: " + calEvent.start + "<br/>Fin Horario: " + calEvent.end + "<p>");
			},
			eventMouseout : function(calEvent, $event) {
				displayMessage("<p><strong>Detalle Horario</strong><br/>Inicio Horario: " + calEvent.start + "<br/>Fin Horario: " + calEvent.end + "<p>");
			},
			noEvents : function() {
				displayMessage("<p>No existe horario registrado para esta semana<p>");
			},
			data:eventData
		});

		function displayMessage(message) {
			//$("#message").html(message).fadeIn();
		}

		$("<div id=\"message\" class=\"ui-corner-all\"></div>").prependTo($("body"));

	});

</script>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1>softmedic</h1>
			<p> Gestion de citas y consultas</p>
		</div>
		<div id="search">
			<form method="get" action="">
				<fieldset>
				<input type="text" name="s" id="search-text" size="15" value="Ingrese una palabra..." />
				<input type="submit" id="search-submit" value="GO" />
				</fieldset>
			</form>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu">
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a href="cita.jsp">Citas</a></li>
			<li><a href="receta.jsp">Diagnóstico</a></li>
			<li><a href="consulta.jsp">Consultas</a></li>
			<li><a href="horarios.jsp">Horarios</a></li>
			<li><a href="contact.jsp">Contáctenos</a></li>
			<li><a href="login.jsp">Login</a></li>
		</ul>
	</div>
	<div id="splash">&nbsp;</div>
	<!-- end #menu -->
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">
                <!-- Inicio del contenido de la Página Web -->
		<div id="content">

		</div>
		<!-- (end #content) Fin del contenido de la Página Web  -->
                
		<div id="sidebar">
			<ul>
				<li>
					<h2>SoftMedic</h2>
					<p>Visita nuestros link y comienza el cambio.</p>
				</li>
				<li>
					<h2>Categorias</h2>
					<ul>
						<li class="Pagina Actual"><a href="index.jsp">Home</a></li>
						<li><a href="cita.jsp">Citas</a></li>
						<li><a href="receta.jsp">Diagnóstico</a></li>
						<li><a href="consulta.jsp">Consultas</a></li>
						<li><a href="horarios.jsp">Horarios</a></li>
						<li><a href="contact.jsp">Contáctenos</a></li>
						<li><a href="login.jsp">Login</a></li>
					</ul>
				</li>
				<li>
					<h2>Links de Interés</h2>
					<ul>
						<li><a href="http://servicios.eldiariomontanes.es/consultorio/medico/">Diario el Montañés</a></li>
						<li><a href="http://bvs.isciii.es/E/index.php">Biblioteca virtual de salud</a></li>
						<li><a href="http://www.dmedicina.com/">DMedicina</a></li>
						<li><a href="http://www.infermeravirtual.com/es-es/home.html">Enfermera Virtual</a></li>
						<li><a href="http://www.medicosypacientes.com/">Médicos y Pacientes</a></li>
						<li><a href="http://www.who.int/ageing/en/">Organización Mundial de la Salud</a></li>
					</ul>
				</li>
				<li>
					<h2>Compañías de Seguro de Salud</h2>
					<ul>
						<li><a href="http://www.essalud.gob.pe">Seguro Social del Perú</a></li>
						<li><a href="http://www.pacificoseguros.com/paginas/psalud4.shtml">Pacífico Salud</a></li>
						<li><a href="http://www.rimac.com.pe/ilwwcm/connect/PR_PortalRimac/P%C3%A1gina+Principal/Rimac+Seguros/Seguros+Personales/Salud/">Rimac Seguros</a></li>
						<li><a href="http://www.mapfreperu.com/portal/productos/salud/index.asp">Mapfre Peru</a></li>
						<li><a href="http://www.lapositiva.com.pe/0/modulos/JER/JER_Interna.aspx?ARE=0&PFL=1&JER=28">La Positiva</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
	</div>
	</div>
	</div>
	<!-- end #page -->
</div>
	<div id="footer">
		<p>Copyright (c) 2010. All rights reserved. DEW 2010_1</p>
	</div>
	<!-- end #footer -->
</body>
</html>
