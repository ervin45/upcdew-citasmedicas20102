<%@ include file="/Templates/header.jsp" %>

<script type='text/javascript'>

    function registrar(){
        var mensajeError = '';
        var horario = '';
        if(document.getElementsByName("horario").length > 0){
            for(var i = 0 ; i< document.getElementsByName("horario").length ; i++){
                if(document.getElementsByName("horario")[i].checked){
                    horario = document.getElementsByName("horario")[i].value;
                    break;
                }
            }
        }
        
        if(horario.length==0){
            mensajeError = "Seleccione algun horario";
        }

    <c:if test="${persona.usuario.rol.nombre != 'Paciente'}">
                paciente = trim(document.getElementsByName("paciente")[0].value);
                if(paciente.length==0){
                    mensajeError = (mensajeError.length==0?'':mensajeError) +'\n' + "Seleccione algun paciente";
                }
    </c:if>

                if(mensajeError.length>0){
                    alert(mensajeError);
                }else{
                    document.getElementsByName('metodo')[0].value='registrar';
                    document.getElementsByName('metodo')[0].form.submit();
                }
            }


            function trim(stringToTrim) {
                return stringToTrim.replace(/\ /g,'');;
            }



</script>

<!-- Inicio del contenido de la Página Web -->
<div id="content">
    <div class="post">
        <h2>Cita  M&eacute;dica OnLine</h2>
        <p class="meta">Reservas</p>
        <div class="entry">
            <p>Realice sus reservas de citas m&eacute;dicas.</p>

            <form action="RegistroCitaServlet" method="post">
                <input type="hidden" name="metodo" value=""/>
                <table width="530px" >
                    <tr>
                        <td width="200">&nbsp;</td>
                        <td width="330">&nbsp;</td>
                    </tr>
                    <tr>
                        <td height="30" colspan="2">
                            <p><span class="Estilo1"><strong>Solicitar Cita M&eacute;dica</strong></span></p>
                        </td>
                    </tr>
                    <tr>
                        <td>Especialidad :
                        </td>
                        <td>
                            <select name="especialidad" id="especialidad" >
                                <c:forEach var="esp" items="${especialidades}"   >
                                    <option value="${esp.idEspecialidad}" >
                                        ${esp.nombre}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr style="height: 20px">
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td><input type="submit" name="btnConsultar" value="Consultar" onclick="document.getElementsByName('metodo')[0].value='buscar'">
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
                                <th>Hora Inicio</th>
                                <th>Hora Fin</th>
                                <th>Medico</th>
                                </thead>
                                <c:forEach var="hor" items="${horarios}"  >

                                    <tr>
                                        <td><input type="radio" name="horario" value="${hor.idHorario}"> </td>
                                        <td>${hor.horaInicio} </td>
                                        <td>${hor.horaFin} </td>
                                        <td>${hor.medico.nombre} </td>
                                    </tr>
                                </c:forEach>
                            </table>

                        </td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>

                    <c:choose>
                        <c:when test="${persona.usuario.rol.nombre == 'Paciente'}">
                            <input type="hidden" name="paciente" value="${persona.usuario.login}" />
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td>Paciente : </td>
                                <td>

                                    <select name="paciente" id="paciente">
                                        <option value="">Seleccione</option>
                                        <c:forEach var="pa" items="${pacientes}"  >
                                            <option value="${pa.usuario.login}" >
                                                ${pa.nombre} ${pa.apePaterno}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                        </c:otherwise>
                    </c:choose>



                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                        <td><input type="button" name="btnGuardar" value="registrar" onclick="javascript:registrar();">
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