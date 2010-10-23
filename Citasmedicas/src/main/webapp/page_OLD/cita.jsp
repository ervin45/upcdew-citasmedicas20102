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
		events : [
		   {"id":1, "start": new Date(year, month, day, 12), "end": new Date(year, month, day, 13, 35),"title":""},
		   {"id":2, "start": new Date(year, month, day, 14), "end": new Date(year, month, day, 14, 45),"title":""},
		   {"id":3, "start": new Date(year, month, day + 1, 15), "end": new Date(year, month, day + 1, 15, 45),"title":""},
		   {"id":4, "start": new Date(year, month, day - 1, 8), "end": new Date(year, month, day - 1, 9, 30),"title":""},
		   {"id":5, "start": new Date(year, month, day + 7, 12), "end": new Date(year, month, day + 7, 12,45),"title":""},
                   {"id":6, "start": new Date(year, month, day + 8, 15), "end": new Date(year, month, day + 8, 15, 30),"title":""},
                   {"id":7, "start": new Date(year, month, day + 8, 11), "end": new Date(year, month, day + 8, 12,15),"title":""},
                   {"id":8, "start": new Date(year, month, day + 9, 10), "end": new Date(year, month, day + 9, 14, 30),"title":""}
		]
	};



	$(document).ready(function() {

            var $calendar = $('#calendar');
            
            var $cboEspecialidad = $("#cboEspecialidad");
            var $array_Especialidad = '[{"codEspecialidad":"MG", "desEspecialidad":"Medicina General"},{"codEspecialidad":"PE","desEspecialidad":"Pediatria"},{"codEspecialidad":"GI","desEspecialidad":"Ginecolog&iacute;a"},{"codEspecialidad":"TR","desEspecialidad":"Traumatolog&iacute;a"}, {"codEspecialidad":"UR","desEspecialidad":"Urolog&iacute;a"}]';
            var $objEspecialidad = ConvertToJSON($array_Especialidad);
            CargarSelect($cboEspecialidad, $objEspecialidad,"codEspecialidad","desEspecialidad");

            filtrarMedico();
            $calendar.weekCalendar({
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
                       document.getElementById('txtFechaIni').value = fecha;
                       
                       displayMessage("Ha seleccionado una cita para el " + fecha + " en el horario de " + hini + " a " + hfin);
                       //window.location.replace("index.jsp");
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
	var month = ($date.getMonth()< 10 ? '0' : '') + $date.getMonth();
        var day = ($date.getDate()< 10 ? '0' : '') + $date.getDate();
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


<!-- Inicio del contenido de la Pagina Web -->
<div id="content">
    <div class="post">
        <h2>Cita  M&eacute;dica OnLine</h2>
        <p class="meta">Reservas</p>
        <div class="entry">
        <p>Realice sus reservas de citas m&eacute;dicas.</p>

        <form action="CitaServlet" method="post">
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
            <td>Especialidad : </td>
            <td>
              <select name="cboEspecialidad" id="cboEspecialidad" size="1">
              </select>
             </td>
          </tr>
          <tr>
            <td>Doctor : </td>
            <td>
                <select name="cboMedico" id="cboMedico" size="1">
                </select>
                
            </td>
          </tr>
          <tr style="height: 20px">
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><input type="submit" name="btnConsultar" value="Consultar">
            <input type="submit" name="btnGrabar" value="Grabar"></td>
          </tr>
          <tr>
              <td colspan="2"><div id='calendar'></div></td>
          </tr>
          <tr style="height: 20px">
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>

                              <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table>
            <input name="txtFechaIni" id="txtFechaIni" value="" type="hidden"/>
        </form>
        </div>
    </div>
<div style="clear: both;">&nbsp;</div>
</div>
<!-- (end #content) Fin del contenido de la Pagina Web  -->

<%@ include file="/Templates/footer.jsp" %>