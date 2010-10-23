<%@ include file="/Templates/header.jsp" %>

<!-- Inicio del contenido de la Página Web -->
<div id="content">
    <div class="post">
        <h2>Cita  M&eacute;dica OnLine</h2>
        <p class="meta">Registrar Diagnostico</p>
        <div class="entry">
            <p>Realice diagnostico.</p>

            <form action="ConsultaCitaServlet" method="post">
                <input type="hidden" name="metodo" value=""/>
                <input type="hidden" name="cita" value="${cita.idConsulta}"/>
                <table width="530px" >
                    <tr>
                        <td width="200">&nbsp;</td>
                        <td width="330">&nbsp;</td>
                    </tr>
                    <tr>
                        <td height="30" colspan="2">
                            <p><span class="Estilo1"><strong>Cita M&eacute;dica</strong></span></p>
                        </td>
                    </tr>
                    <tr>
                        <td>Especialidad : </td>
                        <td>
                            ${cita.especialidad.nombre}
                        </td>
                    </tr>
                    <tr>
                        <td>Medico : </td>
                        <td>
                            ${cita.medico.nombre}
                        </td>
                    </tr>
                    <tr>
                        <td>Paciente : </td>
                        <td>
                            ${cita.paciente.nombre}
                        </td>
                    </tr>
                    <tr>
                        <td>Hora : </td>
                        <td>
                            ${cita.horaInicio} - ${cita.horaFin}
                        </td>
                    </tr>
                    <tr>
                        <td>Diagnostico : </td>
                        <td>
                            <c:choose>
                                <c:when test="${persona.usuario.rol.nombre == 'Medico'}">
                                    <textarea cols="30" rows="5" id="diagnostico" name="diagnostico" ></textarea>
                                </c:when>
                                <c:otherwise>
                                    ${cita.diagnostico}
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <tr style="height: 20px">
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>
                            <c:choose>
                                <c:when test="${persona.usuario.rol.nombre == 'Medico'}">
                                    <input type="submit" name="btnGuardar" value="registrar" onclick="document.getElementsByName('metodo')[0].value='registrar'">
                                    &nbsp;&nbsp;
                                    <input type="button" name="btnRegresar" value="regresar" onclick="history.go(-1);">
                                </c:when>
                                <c:otherwise>
                                    <input type="button" name="btnRegresar" value="regresar" onclick="history.go(-1);">
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <tr style="height: 20px">
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>

                    


                </table>
            </form>
        </div>
    </div>
    <div style="clear: both;">&nbsp;</div>
</div>
<!-- (end #content) Fin del contenido de la Página Web  -->

<%@ include file="/Templates/footer.jsp" %>