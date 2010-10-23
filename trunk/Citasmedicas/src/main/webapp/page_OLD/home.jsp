<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Web Consultorio M&eacute;dico</title>
<link href="Recursos/style.css" rel="stylesheet" type="text/css" media="screen" />
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
                        <input type="text" name="s" id="search-text" size="15" value="Ingrese una palabra..." />
                        <input type="submit" id="search-submit" value="GO" />
                        <c:if test="${persona.nombre!=null}">
                            Bienvenido ${persona.nombre}  ${persona.apePaterno}
                        </c:if>

                    </form>
		</div>
	</div>
	<!-- end #header -->
	<!-- #menu -->
        <c:choose>
            <c:when test="${sessionUsuario.rol.nombre == 'Medico'}">
                <%@ include file="/Templates/menuMedico.jsp" %>
            </c:when>
            <c:when test="${sessionUsuario.rol.nombre == 'Paciente'}">
                <%@ include file="/Templates/menuPaciente.jsp" %>
            </c:when>
            <c:when test="${sessionUsuario.rol.nombre == 'Empleado'}">
                <%@ include file="/Templates/menuEmpleado.jsp" %>
            </c:when>
            <c:otherwise>
                <%@ include file="/Templates/menuDefault.jsp" %>
            </c:otherwise>
        </c:choose>
        <!-- end #menu -->
	<div id="splash">&nbsp;</div>
	<!-- end #menu -->
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">

<!-- Inicio del contenido de la Página Web -->
<div id="content">
	<h2>Links de Inter&eacute;s</h2>
	<br/>
	<p>Aqu&iacute; podr&aacute; encontrar informaci&oacute;n acerca de organizaciones que ofrecen noticias de la salud al nivel mundial. Consulte los link a continuaci&oacute;n e informece sobre las novedades en el sector de la salud. </p>
	<br/>
	<br/>
	<a href="http://servicios.eldiariomontanes.es/consultorio/medico/">Diario el Monta&ntilde;&eacute;s</a><br/>
	<a href="http://bvs.isciii.es/E/index.php">Biblioteca virtual de salud</a><br/>
	<a href="http://www.dmedicina.com/">DMedicina</a><br/>
	<a href="http://www.infermeravirtual.com/es-es/home.html">Enfermera Virtual</a><br/>
	<a href="http://www.medicosypacientes.com/">M&eacute;dicos y Pacientes</a><br/>
	<a href="http://www.who.int/ageing/en/">Organizaci&oacute;n Mundial de la Salud</a><br/>
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
						<li><a href="receta.jsp">Diagn&oacute;stico</a></li>
						<li><a href="consulta.jsp">Consultas</a></li>
						<li><a href="horarios.jsp">Horarios</a></li>
						<li><a href="contact.jsp">Cont&aacute;ctenos</a></li>
						<li><a href="login.jsp">Login</a></li>
					</ul>
				</li>
				<li>
					<h2>Links de Inter&eacute;s</h2>
					<ul>
						<li><a href="http://servicios.eldiariomontanes.es/consultorio/medico/">Diario el Monta&ntilde;&eacute;s</a></li>
						<li><a href="http://bvs.isciii.es/E/index.php">Biblioteca virtual de salud</a></li>
						<li><a href="http://www.dmedicina.com/">DMedicina</a></li>
						<li><a href="http://www.infermeravirtual.com/es-es/home.html">Enfermera Virtual</a></li>
						<li><a href="http://www.medicosypacientes.com/">M&eacute;dicos y Pacientes</a></li>
						<li><a href="http://www.who.int/ageing/en/">Organizaci&oacute;n Mundial de la Salud</a></li>
					</ul>
				</li>
				<li>
					<h2>Compa&ntilde;&iacute;as de Seguro de Salud</h2>
					<ul>
						<li><a href="http://www.essalud.gob.pe">Seguro Social del Per&uacute;</a></li>
						<li><a href="http://www.pacificoseguros.com/paginas/psalud4.shtml">Pac&iacute;fico Salud</a></li>
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