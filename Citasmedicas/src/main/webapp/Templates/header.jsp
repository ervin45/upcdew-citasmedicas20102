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
        <div id="menu">
        <c:choose>
            <c:when test="${persona.usuario.idRol == 'ME'}">
                <%@ include file="/Templates/menuMedico.jsp" %>
            </c:when>
            <c:when test="${persona.usuario.idRol == 'PA'}">
                <%@ include file="/Templates/menuPaciente.jsp" %>
            </c:when>
            <c:when test="${persona.usuario.idRol == 'EM'}">
                <%@ include file="/Templates/menuEmpleado.jsp" %>
            </c:when>
            <c:otherwise>                
                <%@ include file="/Templates/menuDefault.jsp" %>
            </c:otherwise>
        </c:choose>
        </div>
        <!-- end #menu -->
	<div id="splash">&nbsp;</div>
	<!-- end #menu -->
	<div id="page">
	<div id="page-bgtop">
	<div id="page-bgbtm">