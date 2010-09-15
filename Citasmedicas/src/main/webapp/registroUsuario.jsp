<%@ include file="/Templates/header.jsp" %>

<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script type='text/javascript' src='Recursos/scripts/jquery-1.4.2.js'></script>
<script type='text/javascript' src='Recursos/scripts/jquery.ui.core.js'></script>
<script type='text/javascript' src='Recursos/scripts/jquery.ui.datepicker-es.js'></script>
<script type='text/javascript' src='Recursos/scripts/jquery.ui.datepicker.js'></script>

<script>
    $(document).ready(function() {
        $("#txtNacimiento").datepicker({
                showOn: 'button',
                buttonImage: 'Recursos/images/calendario.bmp',
                buttonImageOnly: true
        });
    });
</script>

                <!-- Inicio del contenido de la Página Web -->
		<div id="content">
			<div class="post">
				<h2>Registro de Usuario</h2></br>
				<p class="meta">Creaci&oacute;n de usuario en el sistema</p>
				<div class="entry">
					<p>Ingrese sus datos en el siguiente formulario, para realizar la creación de su usuario en el sistema.</p>
					
					<form action="RegistroPacienteServlet" method="post">
					<table width="450px" >
                      <tr>
                        <td width="200">&nbsp;</td>
                        <td width="250">&nbsp;</td>
                      </tr>
                      <tr bgcolor="#3F3F27">
                          <td height="30" colspan="2" background=""><div align="center"><h2>Datos de Usuario</h2></br></div></td>
                      </tr>
                     
                      <tr>
                        <td><p>Documento de Identidad</p></td>
                        <td><label>
                          <input type="text" name="txtdocumento" id="txtDocumento">
                        </label></td>
                      </tr>
					  <tr>
                        <td><p>Nombres :</p></td>
                        <td><input name="txtNombres" type="text" size="40" maxlength="40"></td>
                      </tr>
					   <tr>
                        <td><p>Apellido Paterno :</p></td>
                        <td><input name="txtApellidoPaterno" type="text" size="40" maxlength="40"></td>
                      </tr>
					  <tr>
						  <td><p>Apellido Materno :</p></td>
						  <td><input name="txtApellidoMaterno" type="text" size="40" maxlength="40"></td>
					  </tr>					  
					  <tr>
                        <td><p>Sexo :</p></td>
                        <td><input name="btnSexo" type="radio" value="M" >
                          Masculino
                            <input name="btnSexo" type="radio" value="F">
                        Femenino</td>
                      </tr>
					  <tr>
                        <td><p>Fecha de Nacimiento :</p></td>
                        <td><input name="txtNacimiento" id="txtNacimiento" type="text" size="15"></td>
                      </tr>
					  <tr>
                        <td>Teléfono :</td>
                        <td><input name="txtTelefono" type="text" size="30" maxlength="30"></td>
                      </tr>
					  <tr>
                        <td>Celular :</td>
                        <td><input name="txtCelular" type="text" size="30" maxlength="30"></td>
                      </tr>
					  <tr>
                        <td>Correo Electronico:</td>
                        <td><input name="txtUsuario" type="text" size="30" maxlength="30"></td>
                      </tr>
					  <tr>
                        <td height="30">Password :</td>
                        <td><input name="txtPassword" type="password" size="30" maxlength="30"></td>
                      </tr>
					   <tr>
                        <td>&nbsp;</td>
                        <td><input width="100" type="submit" name="btnRegistrar" value="Registrar"></td>
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
                        <td>&nbsp;</td>
                      </tr>
					  <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                      </tr>
                    </table>
</form>
					<p>&nbsp;</p>										
					
					<p>&nbsp;</p>                                        
				</div>
			</div>
			
		<div style="clear: both;">&nbsp;</div>
		</div>
		<!-- (end #content) Fin del contenido de la Página Web  -->


<%@ include file="/Templates/footer.jsp" %>