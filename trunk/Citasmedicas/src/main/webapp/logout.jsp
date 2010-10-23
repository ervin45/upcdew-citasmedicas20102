<%@ include file="/Templates/header.jsp" %>

<!-- Inicio del contenido de la Página Web -->
<div id="content">
    <c:if test="${persona.usuario.rol.nombre != null}">
    <form action="LogOutServlet" method="post">
        <h2>Salir del Sistema</h2><br>
        <input width="20" type="submit"  name="btnLogout" value="Cerrar Sesi&oacute;n">
    </form>
    </c:if>


    <c:if test="${persona.usuario.rol.nombre == null}">
        <p> La Sesi&oacute;n ha sido terminada...</p>

        <p> Gracias por utilizar nuestro sistema</p>
    </c:if>
    
</div>
<!-- (end #content) Fin del contenido de la Página Web  -->

<%@ include file="/Templates/footer.jsp" %>