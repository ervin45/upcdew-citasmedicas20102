<div id="sidebar">
			<ul>
				<li>
					<h2>SoftMedic</h2>
					<p>Visita nuestros link y comienza el cambio.</p>
				</li>
				<li>
					<h2>Categorias</h2>					
                                            <c:choose>
                                            <c:when test="${persona.usuario.rol.nombre == 'Medico'}">
                                                <%@ include file="/Templates/menuMedico.jsp" %>
                                            </c:when>
                                            <c:when test="${persona.usuario.rol.nombre == 'Paciente'}">
                                                <%@ include file="/Templates/menuPaciente.jsp" %>
                                            </c:when>
                                            <c:when test="${persona.usuario.rol.nombre == 'Empleado'}">
                                                <%@ include file="/Templates/menuEmpleado.jsp" %>
                                            </c:when>
                                            <c:otherwise>
                                                <%@ include file="/Templates/menuDefault.jsp" %>
                                            </c:otherwise>
                                            </c:choose>
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