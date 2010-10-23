<%@ include file="/Templates/header.jsp" %>

<link href="Recursos/styles/jquery-ui.css" rel="stylesheet" type='text/css' media="screen" />
<link href="Recursos/styles/jquery.weekcalendar.css" rel="stylesheet" type='text/css' media="screen" />


<script type='text/javascript' src='Recursos/scripts/json2.js'></script>
<script type='text/javascript' src='Recursos/scripts/jquery.min.js'></script>
<script type='text/javascript' src='Recursos/scripts/jquery-ui.min.js'></script>
<script type='text/javascript' src='Recursos/scripts/jquery.weekcalendar.js'></script>

<script type='text/javascript'>

    var year = new Date().getFullYear();
	var month = new Date().getMonth();
	var day = new Date().getDate();

	var eventData = {
		events : []
	};

    $(document).ready(function() {        

            var $cboEspecialidad = $("#cboEspecialidad");
            var $array_Especialidad = '[{"codEspecialidad":"MG", "desEspecialidad":"Medicina General"},{"codEspecialidad":"PE","desEspecialidad":"Pediatria"},{"codEspecialidad":"GI","desEspecialidad":"Ginecolog&iacute;a"},{"codEspecialidad":"TR","desEspecialidad":"Traumatolog&iacute;a"}, {"codEspecialidad":"UR","desEspecialidad":"Urolog&iacute;a"}]';
            var $objEspecialidad = ConvertToJSON($array_Especialidad);
            CargarSelect($cboEspecialidad, $objEspecialidad,"codEspecialidad","desEspecialidad");

            filtrarMedico();

            $('#calendar').weekCalendar({
                timeslotsPerHour: 4,
                height: function($calendar){
                        return $(window).height() - $("h1").outerHeight();
                },
                eventRender : function(calEvent, $event) {
                        if(calEvent.end.getTime() < new Date().getTime()) {
                                $event.css("backgroundColor", "#aaa");
                                $event.find(".time").css({"backgroundColor": "#999", "border":"1px solid #888"});
                        }
                },
                eventNew : function(calEvent, $event) {
                        //displayMessage("<p><strong>Added event</strong><br/>Start: " + calEvent.start + "<br/>End: " + calEvent.end + "<p>");
                       //var fecha = ConvertToFecha(calEvent.start);}
                       var fecha = ConvertToFecha(calEvent.start);
                       var hini = ConvertToHora(calEvent.start);
                       var hfin = ConvertToHora(calEvent.end);
                       displayMessage("Se ingresado un horario para el " + fecha + " de " + hini + " a " + hfin);
                       
                },
                eventDrop : function(calEvent, $event) {
                        //displayMessage("<p><strong>Detalle Horario</strong><br/>Inicio Horario: " + calEvent.start + "<br/>Fin Horario: " + calEvent.end + "<p>");
                },
                eventResize : function(calEvent, $event) {
                        //displayMessage("<p><strong>Detalle Horario</strong><br/>Inicio Horario: " + calEvent.start + "<br/>Fin Horario: " + calEvent.end + "<p>");
                },
                eventClick : function(calEvent, $event) {
                        //displayMessage("<p><strong>Detalle Horario</strong><br/>Inicio Horario: " + calEvent.start + "<br/>Fin Horario: " + calEvent.end + "<p>");
                        //displayMessage("Se ha generado una cita en el horario de " + calEvent.start + " a " + calEvent.end);
                },
                eventMouseover : function(calEvent, $event) {
                        //displayMessage("<p><strong>Detalle Horario</strong><br/>Inicio Horario: " + calEvent.start + "<br/>Fin Horario: " + calEvent.end + "<p>");
                },
                eventMouseout : function(calEvent, $event) {
                        //displayMessage("<p><strong>Detalle Horario</strong><br/>Inicio Horario: " + calEvent.start + "<br/>Fin Horario: " + calEvent.end + "<p>");
                },
                noEvents : function() {
                        displayMessage("No existe horario registrado para esta semana");
                },
                data:eventData
            });

            function displayMessage(message) {
                    //$("#message").html(message).fadeIn();
                    alert(message);
            }

            $('#cboEspecialidad').change(function(){
                filtrarMedico();                
            });

	});
        
       function filtrarMedico(){
             var $cboMedico = $("#cboMedico");
                    var $array_Medico = '[{"codMedico":"1","nomMedico":"Pedro Jimnenez","codEspecialidad":"MG"},{"codMedico":"2","nomMedico":"Pablo Dominguez","codEspecialidad":"MG"},{"codMedico":"3","nomMedico":"Miguel Mendez","codEspecialidad":"PE"},{"codMedico":"4","nomMedico":"Rodrigo Palacios","codEspecialidad":"PE"},{"codMedico":"5","nomMedico":"Jorge Rojas","codEspecialidad":"GI"},{"codMedico":"6","nomMedico":"Andrez Perez","codEspecialidad":"GI"},{"codMedico":"7","nomMedico":"Jose Quispe","codEspecialidad":"TR"},{"codMedico":"8","nomMedico":"Pablo Arteaga","codEspecialidad":"TR"},{"codMedico":"9","nomMedico":"Ana Juarez","codEspecialidad":"UR"},{"codMedico":"10","nomMedico":"Luis Mejia","codEspecialidad":"UR"}]';
                    var $objMedico = ConvertToJSON($array_Medico);

                    var $objFiltro = [];
                    $value =  $("#cboEspecialidad").val();
                    $objFiltro = filterByProperty_Equal($objMedico, "codEspecialidad", $value);
                    CargarSelect($cboMedico, $objFiltro,"codMedico","nomMedico");
        }

    //Convertir Fecha
    function ConvertToFecha($date){
        var year = $date.getFullYear();
	var month = $date.getMonth();
	var day = $date.getDate();
        var fechaFormat = day + '/' + month + '/' + year;
        return fechaFormat;
    }

    function ConvertToHora($date){
        var  hora = $date.getHours();
        var  minutos = $date.getMinutes();
        var  segundos = $date.getSeconds();

        if ((hora >= 0)&&(hora <= 9)){
            hora="0"+hora;
        }
        if ((minutos >= 0)&&(minutos <= 9)){
            minutos="0"+minutos;
        }
        if ((segundos >= 0)&&(segundos <= 9)){
            segundos="0"+segundos;
        }
        var horaExacta = hora + ':' + minutos;
        return horaExacta;
    }

    //String ConvertToJSON OK
    function ConvertToJSON($str){
        var $myData = JSON.parse($str, function (key, value) {
            var type;
            if (value && typeof value === 'object') {
                    type = value.type;
                    if (typeof type === 'string' && typeof window[type] === 'function') {
                        return new (window[type])(value);
                    }
                }
                return value;
            });
        return $myData;
    }

    //Filtrar ArrayObjectJSON: prop(Nombre Columna, value(valor buscado)
    //Uso: arr = filterByProperty(arr, prop, value);
    function filterByProperty_Equal(arr, prop, value) {
        return $.grep(arr, function (item) {
                 return item[prop] == value
            }
        );
    }

    //Borrar ArrayObjectJSON: prop(Nombre Columna, value(valor buscado)
    //Uso: arr = deleteByProperty(arr, prop, value);
    function filterByProperty_Dif(arr, prop, value) {
        return $.grep(arr, function (item) {
                 return item[prop] != value;
            }
        );
    }

    //CargarSelect
    function CargarSelect($select, $myData, SelectValue, SelectText){
        var options = $select.attr('options');
        $('option', $select).remove();

        $.each($myData, function(index, array) {
            $select.append('<option value="' + this[SelectValue] + '">' + this[SelectText] + '</option>');
        });
    }
</script>
<!-- Inicio del contenido de la Página Web -->
<div id="content">                     

        <div class="post">
        <h2>Horarios</h2></br>
        <p class="meta">Programaci&oacute;n de Horarios </p>
        <div class="entry">
        <p>Ingrese los horarios de los doctores para que puedan estar disponibles para realizar las atenciones m&eacute;dicas.</p>

        <form action="HorariosServlet" method="post">
        <table width="530px" >
          <tr>
            <td width="200">&nbsp;</td>
            <td width="330">&nbsp;</td>
          </tr>
          <tr>
              <td height="30" colspan="2"><div align="center"><h2 class="title"><a href="#">Registro de Horarios</a></h2></div></td>
          </tr>
          <tr>
              <td colspan="2" style="height: 20px"></td>
          </tr>
          <tr>
            <td>Especialidad : </td>
            <td><select name="cboEspecialidad" id="cboEspecialidad" size="1">
            </select></td>
          </tr>
          <tr>
            <td>Doctor : </td>
            <td><select name="cboMedico" id="cboMedico">
            </select></td>
          </tr>
          <tr>
              <td colspan="2">
                <div id='calendar'></div>                
              </td>
          </tr>
          <tr style="height: 20px">
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><input type="submit" name="Submit" value="Registrar"></td>
          </tr>          
        </table>
        </form>
        </div>
    </div>
<div style="clear: both;">&nbsp;</div>
</div>
<!-- (end #content) Fin del contenido de la Página Web  -->



<%@ include file="/Templates/footer.jsp" %>