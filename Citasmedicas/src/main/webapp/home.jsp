<%@ include file="/Templates/header.jsp" %>

<!-- Inicio del contenido de la Página Web -->
<style type="text/css">
    <!--
    .Estilo1 {color: #ECE9D8}
    -->
</style>

<div id="content">
    <h2>Index</h2>
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
</div>
<!-- (end #content) Fin del contenido de la Página Web  -->
<span class="Estilo1"></span>
<%@ include file="/Templates/footer.jsp" %>