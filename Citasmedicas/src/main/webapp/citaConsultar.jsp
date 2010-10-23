<%@ include file="/Templates/header.jsp" %>

<!-- Inicio del contenido de la Página Web -->
<div id="content">
    <div class="post">
        <h2>Cita  M&eacute;dica OnLine</h2>
        <p class="meta">Mis Citas</p>
        <div class="entry">
            <p>Visualize sus citas m&eacute;dicas.</p>

            <form action="ConsultaCitaServlet" method="post">
                <input type="hidden" name="metodo" value=""/>
                <table width="530px" >
                    <tr>
                        <td width="200">&nbsp;</td>
                        <td width="330">&nbsp;</td>
                    </tr>
                    <tr>
                        <td height="30" colspan="2">
                            <p><span class="Estilo1"><strong>Mis Citas M&eacute;dica</strong></span></p>
                        </td>
                    </tr>
                    <tr style="height: 20px">
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <table>
                                <thead>
                                <th>Seleccionar</th>
                                <th>Medico</th>
                                <th>Paciente</th>
                                <th>Hora</th>
                                </thead>
                                <c:forEach var="cit" items="${citas}"  >

                                    <tr>
                                        <td><input type="radio" name="cita" value="${cit.idConsulta}"> </td>
                                        <td>${cit.medico.nombre} </td>
                                        <td>${cit.paciente.nombre} </td>
                                        <td>${cit.horaInicio} - ${cit.horaFin} </td>
                                    </tr>
                                </c:forEach>
                            </table>

                        </td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>



                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td>
                            <c:choose>
                                <c:when test="${persona.usuario.rol.nombre == 'Medico'}">
                                    <input type="submit" name="btnRegistrar" value="registrar diagnostico" onclick="document.getElementsByName('metodo')[0].value='diagnostico'">
                                </c:when>
                                <c:otherwise>
                                    <input type="submit" name="btnVer" value="ver diagnostico" onclick="document.getElementsByName('metodo')[0].value='ver'">
                                </c:otherwise>
                            </c:choose>

                        </td>
                    </tr>


                </table>
            </form>
        </div>
    </div>
    <div style="clear: both;">&nbsp;</div>
</div>
<!-- (end #content) Fin del contenido de la Página Web  -->

<%@ include file="/Templates/footer.jsp" %>