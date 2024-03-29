<%@ include file="/Templates/header.jsp" %>

<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script type='text/javascript' src='Recursos/scripts/jquery-1.4.2.js'></script>
<script type='text/javascript' src='Recursos/scripts/jquery.ui.core.js'></script>
<script type='text/javascript' src='Recursos/scripts/jquery.ui.datepicker-es.js'></script>
<script type='text/javascript' src='Recursos/scripts/jquery.ui.datepicker.js'></script>

<script>
    $(document).ready(function() {
        $("#fechaNacimiento").datepicker({
            showOn: 'button',
            buttonImage: 'Recursos/images/calendario.bmp',
            buttonImageOnly: true
        });
    });
</script>
<script type='text/javascript'>

    function validar(){
        var mensajeError = '';
        dni = trim(document.getElementsByName("documentoIdentidad")[0].value);
        nombre = trim(document.getElementsByName("nombre")[0].value);
        apePaterno = trim(document.getElementsByName("apePaterno")[0].value);
        apeMaterno = trim(document.getElementsByName("apeMaterno")[0].value);
        sexo = trim(document.getElementsByName("sexo")[0].checked?document.getElementsByName("sexo")[0].value:document.getElementsByName("sexo")[1].checked?document.getElementsByName("sexo")[1].value:'');
        fechaNacimiento = trim(document.getElementsByName("fechaNacimiento")[0].value);
        telefono = trim(document.getElementsByName("telefono")[0].value);
        celular = trim(document.getElementsByName("celular")[0].value);
        login = trim(document.getElementsByName("login")[0].value);
        password = trim(document.getElementsByName("password")[0].value);

        if(dni.length==0){
            mensajeError = "Documento de Identidad es requerido";
        }

        if(nombre.length==0){
            mensajeError = (mensajeError.length==0?'':mensajeError )+'\n' + "Nombre es requerido";
        }

        if(apePaterno.length==0){
            mensajeError = (mensajeError.length==0?'':mensajeError)+'\n' + "Apellido Paterno es requerido";
        }
        if(apeMaterno.length==0){
            mensajeError = (mensajeError.length==0?'':mensajeError)+'\n' + "Apellido Materno es requerido";
        }
        if(sexo.length==0){
            mensajeError = (mensajeError.length==0?'':mensajeError)+'\n' + "Sexo es requerido";
        }
        if(fechaNacimiento.length==0){
            mensajeError = (mensajeError.length==0?'':mensajeError)+'\n' + "Fecha de Nacimiento es requerido";
        }
        if(telefono.length==0){
            mensajeError = (mensajeError.length==0?'':mensajeError)+'\n' + "Telefono es requerido";
        }
        if(celular.length==0){
            mensajeError = (mensajeError.length==0?'':mensajeError)+'\n' + "Celular es requerido";
        }
        if(login.length==0){
            mensajeError = (mensajeError.length==0?'':mensajeError)+'\n' + "Login es requerido";
        }
        if(password.length==0){
            mensajeError = (mensajeError.length==0?'':mensajeError)+'\n' + "Password es requerido";
        }

        if(mensajeError.length>0){
            alert(mensajeError);
            return false;
        }else{
            return true;
        }
    }

   

    function trim(stringToTrim) {
        return stringToTrim.replace(/\ /g,'');;
    }



</script>


<!-- Inicio del contenido de la P�gina Web -->
<div id="content">
    <div class="post">
        <h2>Registro de Usuario</h2><br/>
        <p class="meta">Creaci&oacute;n de usuario en el sistema</p>
        <div class="entry">
            <p>Ingrese sus datos en el siguiente formulario, para realizar la creaci&Oacute;n de su usuario en el sistema.</p>

            <form action="RegistroPacienteServlet" method="post" onsubmit="return validar()">
                <table width="450px" >
                    <tr>
                        <td width="200">&nbsp;</td>
                        <td width="250">&nbsp;</td>
                    </tr>
                    <tr bgcolor="#3F3F27">
                        <td height="30" colspan="2" background=""><div align="center"><h2>Datos de Usuario</h2><br/></div></td>
                    </tr>

                    <tr>
                        <td><p>Documento de Identidad</p></td>
                        <td><label>
                                <input type="text" name="documentoIdentidad" id="documentoIdentidad">
                            </label></td>
                    </tr>
                    <tr>
                        <td><p>Nombres :</p></td>
                        <td><input name="nombre" type="text" size="40" maxlength="40"></td>
                    </tr>
                    <tr>
                        <td><p>Apellido Paterno :</p></td>
                        <td><input name="apePaterno" type="text" size="40" maxlength="40"></td>
                    </tr>
                    <tr>
                        <td><p>Apellido Materno :</p></td>
                        <td><input name="apeMaterno" type="text" size="40" maxlength="40"></td>
                    </tr>
                    <tr>
                        <td><p>Sexo :</p></td>
                        <td><input name="sexo" type="radio" value="M" >
                            Masculino
                            <input name="sexo" type="radio" value="F">
                            Femenino</td>
                    </tr>
                    <tr>
                        <td><p>Fecha de Nacimiento :</p></td>
                        <td><input name="fechaNacimiento" id="fechaNacimiento" type="text" size="15"></td>
                    </tr>
                    <tr>
                        <td>Tel�fono :</td>
                        <td><input name="telefono" type="text" size="30" maxlength="30"></td>
                    </tr>
                    <tr>
                        <td>Celular :</td>
                        <td><input name="celular" type="text" size="30" maxlength="30"></td>
                    </tr>
                    <tr>
                        <td>Correo Electronico:</td>
                        <td><input name="login" type="text" size="30" maxlength="30"></td>
                    </tr>
                    <tr>
                        <td height="30">Password :</td>
                        <td><input name="password" type="password" size="30" maxlength="30"></td>
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
<!-- (end #content) Fin del contenido de la P�gina Web  -->


<%@ include file="/Templates/footer.jsp" %>