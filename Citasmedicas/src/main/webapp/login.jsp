<%@ include file="/Templates/header.jsp" %>

<script type='text/javascript'>

    function validar(){
        var mensajeError = '';
        login = trim(document.getElementsByName("login")[0].value);
        password = trim(document.getElementsByName("password")[0].value);

        if(login.length==0){
            mensajeError = "Ingrese Login";
        }
        if(password.length==0){
            mensajeError = (mensajeError.length==0?'':mensajeError)+ '\n' + "Ingrese Password";
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
        <h2>Ingreso al sistema</h2>
        <p class="meta"></p>
        <div class="entry">

            <form action="LoginServlet" method="post" onsubmit="return validar();">
                <table width="450px" >
                    <tr bgcolor="#3F3F27">
                        <td height="30" colspan="2">
                            <div align="center"><h2>DATOS DEL USUARIO</h2></div>
                        </td>
                    </tr>
                    <tr>
                        <td height="20" colspan="2"></td>
                    </tr>
                    <tr>
                        <td height="30">Usuario : </td>
                        <td><input name="login" type="text" size="20"></td>
                    </tr>
                    <tr>
                        <td height="30">Password : </td>
                        <td><input name="password" type="password" size="20"></td>
                    </tr>
                    <tr>
                        <td height="20"></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><input width="20" type="submit"  name="btnLogin" value="Login"></td>
                        <td><a href="registroUsuario.jsp" class="link" >Registrarse</a></td>
                    </tr>
                </table>
            </form>

        </div>
    </div>
    <div style="clear: both;">&nbsp;</div>
</div>
<!-- (end #content) Fin del contenido de la P�gina Web  -->

<%@ include file="/Templates/footer.jsp" %>