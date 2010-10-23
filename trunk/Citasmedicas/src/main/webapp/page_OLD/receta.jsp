<%@ include file="/Templates/header.jsp" %>


                <!-- Inicio del contenido de la Página Web -->
		<div id="content">
			<div class="post">
				<h2>Atenci&oacute;n de Citas</h2>
				</br>
				<p class="meta">&nbsp;</p>
				<div class="entry">
                    <table width="450px" >
                        <form name="form1" method="post" action="RecetaServlet">
                      <tr>
                        <td width="200">&nbsp;</td>
                        <td width="250">&nbsp;</td>
                      </tr>
                      <tr bgcolor="#CCCCCC">
                      </tr>
                      <tr>
                        <td><p>Nro de Cita :</p></td>
                        <td><input name="textfield" type="text" size="10">
                          </td>
                      </tr>
					  <tr>
                        <td><p>Nombres :</p></td>
                        <td><input name="textfield2" type="text" size="40" maxlength="40" value=${usuario.Paciente.nombre} ></td>
                      </tr>
					  <tr>
                        <td><p>Apellidos :</p></td>
                        <td>
                            <input name="textfield2" type="text" size="40" maxlength="40" value=${usuario.Paciente.apePaterno} >
                        </td>
                      </tr>
					  <tr>
                        <td><p>Edad:</p></td>
                        <td><input name="textfield4" type="text" size="5">                        </td>
                      </tr>
					  <tr>
                        <td height="116"><p>Diagnóstico :</p></td>
                       <td><textarea name="diagnostico" cols="40" rows="5"></textarea></td>

                      </tr>
					  <tr>
                        <td>Receta :</td>
                        <td><textarea name="receta" cols="40" rows="5"></textarea></td>
                      </tr>
					  <tr>
                        <td>Indicaciones Adicionales</td>
                        <td><textarea name="indicaciones" cols="40" rows="5"></textarea></td>
                      </tr>
					  <tr>
                        <td><input type="submit" name="btnGrabar" id="btnGrabar" value="Grabar"></td>
                        <td><input type="submit" name="btnGrabar2" id="btnCancel" value="Cancelar"></td>
                      </tr>
                      </form>
                  </table>
			    <p>&nbsp;</p>

					<p>&nbsp;</p>
			  </div>
			</div>

		<div style="clear: both;">&nbsp;</div>
		</div>
		<!-- (end #content) Fin del contenido de la Página Web  -->


<%@ include file="/Templates/footer.jsp" %>