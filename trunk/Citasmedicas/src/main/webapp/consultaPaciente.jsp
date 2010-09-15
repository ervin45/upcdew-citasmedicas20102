<%@ include file="/Templates/header.jsp" %>

<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script type='text/javascript' src='Recursos/scripts/jquery-1.4.2.js'></script>
<script type='text/javascript' src='Recursos/scripts/jquery.ui.core.js'></script>
<script type='text/javascript' src='Recursos/scripts/jquery.ui.datepicker-es.js'></script>
<script type='text/javascript' src='Recursos/scripts/jquery.ui.datepicker.js'></script>


<script>
    $(document).ready(function() {
        $("#datePickerInicio").datepicker({
                showOn: 'button',
                buttonImage: 'Recursos/images/calendario.bmp',
                buttonImageOnly: true
        });
        $("#datePickerFin").datepicker({
                showOn: 'button',
                buttonImage: 'Recursos/images/calendario.bmp',
                buttonImageOnly: true
        });
    });
</script>

<!-- Inicio del contenido de la Página Web -->
<div id="content">
    <form action="ConsultaPacienteServlet" method="post">
    <table>
        <tr>
            <td>
                Seleccione la fecha de inicio:
            </td>
            <td>
                <input name="datePickerInicio" id="datePickerInicio" type="text" size="10px">
            </td>
        </tr>
         <tr>
            <td>
                Seleccione la fecha de fin:
            </td>
            <td>
                <input name="datePickerFin" id="datePickerFin" type="text" size="10px">
            </td>
        </tr>
        <tr>
            <td>
            </td>
            <td>
                <input width="20" type="submit"  name="btnConsultar" value="Consultar">
            </td>
        </tr>
        <tr>
            <td colspan="2" height="20px"></td>
        </tr>
        <tr>
            <td colspan="2">
                <%
                    String Data =(String)request.getAttribute("consultaMedica");
                %>
                <input name="txt" value="<%=Data %>"/>

                <script>
                    alert(<%=Data %>);
                </script>
                <input type="hidden" name="txtData" id="txtData"
                       value="<%=Data %>"
               size="0" readonly="readonly" disabled="disabled" />
            </td>
        </tr>
    </table>
    </form>


</div>
<!-- (end #content) Fin del contenido de la Página Web  -->


<%@ include file="/Templates/footer.jsp" %>