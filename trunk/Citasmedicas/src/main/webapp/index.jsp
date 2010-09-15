<%@ include file="/Templates/header.jsp" %>

<!-- Inicio del contenido de la Página Web -->
    <div id="content">
        <div class="post">
            <h2>Bienvenido a SoftMedic</h2></br>
            <p class="meta">Gesti&oacute;n de citas y consultas</p>
            <div class="entry">
                
                <c:choose>
                    <c:when test="${persona == null}">
                        <p>Bienvenido al sistema en el que podr&aacute; encontrar muchas herramientas que le permitir&aacute;n acceder a informaci&oacute;n de su citas m&eacute;dicas en tiempo real. Le ofrecemos este y muchos servicios m&aacute;s.</p>
                        <p>Ingrese a nuestro sistema mediante el link de Login en la parte superior. Si a&uacute;n no se ha registrado, deber&aacute; hacerlo en ese link y podr&aacute; tener acceso al sistema para utilizar nuestros servicios. </p>
                    </c:when>
                    <c:when test="${persona.usuario.idRol == 'PA'}">
                        <p>Bienvenido al sistema que le permitir&aacute; generar sus citas m&eacute;dicas on line y hacer consultar los resultados de las misma. As&iacute; usted podr&aacute; tener acceso a la receta m&eacute;dica y a los resultados de cada cita m&eacute;dica generada con nosotros.. </p>
                        <p>Lo invitamos a que inicie su gesti&oacute;n de atenci&oacute;n m&eacute;dica e ingrese a la nueva era de salud on line que nuestra empresa le ofrece. </p>
                    </c:when>
                    <c:otherwise>
                        <p>Este sistema le permitir&aacute; administrar de forma f&aacute;cil y sencilla sus citas m&eacute;dicas. Tambien podr&aacute; programar los horarios de disponibilidad para sus m&eacute;dicos y acceder en l&iacute;nea a la historia m&eacute;dica del paciente, actualizando el diagn&oacute;stico realizado, as&iacute; como la receta m&eacute;dica del paciente, para que este pueda accederla desde cualquier dispositivo inteligente. </p>
                        <p>Lo invitamos a que inicie su gesti&oacute;n en l&iacute;nea y compruebe los beneficios que ofrece nuestro sistema. Muchas gracias por su confianza y &eacute;xitos en esta nueva era de gesti&oacute;n.</p>
                    </c:otherwise>
                </c:choose>
                <p>&nbsp;</p>
                <div id="medicos">&nbsp;</div>
                <p>&nbsp;</p>
              
                <c:if test="${persona.usuario.rol.nombre == null || persona.usuario.idRol == 'PA'}">
                    <p><a href="contact.jsp" class="links">Cont&aacute;ctenos</a></p>
                </c:if>
            </div>
        </div>
    </div>

<!-- (end #content) Fin del contenido de la Página Web  -->

<%@ include file="/Templates/footer.jsp" %>