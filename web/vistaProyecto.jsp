<%-- 
    Document   : vistaProyecto
    Created on : 05-oct-2019, 1:49:03
    Author     : hp
--%>

<%@page contentType="text/html" import="constructora.entidades.*" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="recursos/css/mapa.css" rel="stylesheet" type="text/css"/>
         <link href="recursos/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="recursos/bootstrap/jquery.js" type="text/javascript"></script>
        <script src="recursos/bootstrap/js/bootstrap.js" type="text/javascript"></script>
        <script src="recursos/bootstrap/sweetalert2.all.min.js" type="text/javascript"></script>
        <title>Nuevo Proyecto</title>
         <script>
            $(document).ready(function(){
                $('#del').click(function(){
                Swal.fire({
                    type:"warning",
                    tittle:"Eliminar registro",
                    text:"No se podrá recuperar despues de eliminar",
                    showCancelButton:true,
                    cancelButtonColor:"red"
                    
                }).then(result=>{
                    if(result.value){
                        $('#d1').append("<input type='hidden' name='eliminar'>");
                        $('#formProyecto').submit();
                    }
                });
                });
            });
        </script>
     
    </head>
    <style type="text/css">

  label{
    font-weight: bold;
  }

  #contenedorForm{
    color: black;
  }


  body{
    background-color:  #F1F0F0;
     height: 100%;
        margin: 0;
        padding: 0;
  }

  #reContratos:hover{
    cursor: pointer;
  }
  #map {
        height: 90%;

</style>

    <body>
         <%
            if(request.getAttribute("proyecto")!=null)
                    response.sendRedirect("ControlProyecto?mostrar=1");               
        %>
        <div id="map"></div>
        
	<div id="floating-panel">
		<div class="input-group" id="flotador">
 			<input class="form-control" id="address" type="textbox" placeholder="Ingrese una direccion">
     		<input class="btn btn-primary" id="submit" type="button" value="Buscar">
		</div>
      
      <div id="flotante2" hidden="on">
             <div id="flotador2">
          <form name="formProyecto" id="formProyecto" action="ControlProyecto" method="POST">
               
               <div class="form-row">
                  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <br>
                      <label for="txtDireccion">Direccion: </label>
                      <input class="form-control" type="text" id="direccion" name="direccion">
                      <div id="mensajeDireccion" class=""></div>
                  </div>
              </div>

              <div class="form-row">
                  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <br>
                      <label for="txtLongitud">Longitud: </label>
                      <input class="form-control" type="text" id="longitud" name="longitud">
                      <div id="mensajeLongitud" class=""></div>
                  </div>
              </div>

              <div class="form-row">
                  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <br>
                      <label for="txtLatitud">Latitud: </label>
                      <input class="form-control" type="text" id="latitud" name="latitud">
                      <div id="mensajeLatitud" class=""></div>
                  </div>
              </div>

              <div class="form-row">
                  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <br>
                      <label for="txtFoto">Foto: </label>
                      <input type="file" name="foto" id="foto">
                       <br> <br> <br>
                       <!--inicia seccion de los botones de agregar, modificar, eliminar y limpiar campos-->  
                        
                       <input type="submit" class="btn btn-info" name="insertar"  id="insertar" value="Agregar">
                       <input type="submit" class="btn btn-info" id="modificar" value="Modificar">
                      <button id="eliminar" name="eliminar" class="btn btn-danger">Borrar</button>
                  </div>
              </div>
                
            </form><br>
             </div>
      </div>
                
            </div>
      
                      <table id="example" class="mdl-data-table"  width="20%" border="1" cellpadding="0" cellspacing="0">
                <thead class="black white-text"><tr>
                        <th> ID PROYECTO </th>
                        <th> DIRECCION  </th>
                        <th> LATITUD </th>
                        <th> LONGITUD  </th>
                        <th> FOTO </th>
                        <th> ACCION </th>
                    </tr></thead>
                    <%
                        if(request.getAttribute("proyecto")!=null){
                            
                            ArrayList<Proyecto> pro = new ArrayList<Proyecto>();
                            pro.addAll((Collection)request.getAttribute("proyecto"));
                            
                            for(Proyecto p:pro){
                                out.println("<tr><td>"+p.getIdProyecto()+""
                                        + "</td><td>"+p.getDireccion()+""
                                        + "</td><td>"+p.getLatitud()+""
                                        + "</td><td>"+p.getLongitud()+""
                                        + "</td><td>"+p.getFoto()+""
                                        + "</td>"
                                        + "<td colspan='2'><input type='button' "
                                        + "value='editar' class='btn btn-danger' onclick=$('#idProyecto')."
                                        + "val('"+p.getIdProyecto()+"');$('#direccion')."
                                        + "val('"+p.getDireccion().replace(" ", "&nbsp;")+"');$('#latitud')."
                                        + "val('"+p.getLatitud().replace(" ", "&nbsp;")+"');$('#longitud')."
                                        + "val('"+p.getLongitud().replace(" ", "&nbsp;")+"');$('#foto')."
                                        + "val('"+p.getFoto()+"');"
                                        + "</td></tr>");
                            }
                        }
                    %>
                </table><br><br> 
                  </div>
              </div><br>
          </div> <br> 
          
                    </div><!--termina contenedor del formulario-->
                  </div><!--termina fila que divide la barra lateral con el formulario-->
                   
                  <div id="map"></div>

    <script>

      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          center: new google.maps.LatLng(13.8033424, -88.8517187),
          zoom: 9.2
        });
        
      var prev_infowindow =false;       
 
          //Cambia esto dependiendo de el nombre de tu archivo java o XML 
        downloadUrl('enlaceApi.php', function(data) {
          var xml = data.responseXML;
          var markers = xml.documentElement.getElementsByTagName('marker');
          Array.prototype.forEach.call(markers, function(markerElem) {
            var id = markerElem.getAttribute('idProyecto');
            var direccion = markerElem.getAttribute('direccion');
            var foto = markerElem.getAttribute('foto');
            var point = new google.maps.LatLng(
              parseFloat(markerElem.getAttribute('longitud')),
              parseFloat(markerElem.getAttribute('latitud')));

              var contentString = '<div style="height: 150px; with: 150px;">'+
                '<b>'+direccion+'</b><br>'+
                '<img width="100%"src="fotosubicaciones/'+foto+'">'+
                '<p>'+point+'</p>'+
                '</div>';

              var infowindow = new google.maps.InfoWindow({
                content: contentString,
                maxWidth: 250
              });

              var marker = new google.maps.Marker({
                map: map,
                position: point,
                animation: google.maps.Animation.DROP,
              });

              marker.addListener('click', function() {       
                if( prev_infowindow ) {
                  prev_infowindow.close();
                }

                prev_infowindow = infowindow;
                infowindow.open(map, marker);   
              });
          });
        });
      }

      function downloadUrl(url, callback) {
        var request = window.ActiveXObject ?
        new ActiveXObject('Microsoft.XMLHTTP') :
        new XMLHttpRequest;

        request.onreadystatechange = function() {
          if (request.readyState == 4) {
            request.onreadystatechange = doNothing;
            callback(request, request.status);
          }
        };

        request.open('GET', url, true);
        request.send(null);
      }

      function doNothing() {}
      </script>

      <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBGf8UQ-G_-E6LZR6wbmXUibcVpfh4caac&callback=initMap">
    </script>

                </div><!--termina contenedor del contenido interno-->
              </div><!--termina la row mas externa-->
            </div><!--termina el container-fluid mas externo--> 
        </form>
      </div>      
    </div>

     <script>
      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 9,
          center: {lat: 13.8033424, lng: -88.8517187}
        });
        var geocoder = new google.maps.Geocoder();

        document.getElementById('submit').addEventListener('click', function() {
          geocodeAddress(geocoder, map);
        });
      }

      function geocodeAddress(geocoder, resultsMap) {
        var address = document.getElementById('address').value;
        geocoder.geocode({'address': address}, function(results, status) {
          if (status === 'OK') {
            resultsMap.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
              map: resultsMap,
              position: results[0].geometry.location

            });

            document.getElementById("flotante2").hidden = false;

            document.getElementById("direccion").value = address;
            document.getElementById("longitud").value = results[0].geometry.location.lat();
            document.getElementById("latitud").value = results[0].geometry.location.lng();

            document.getElementById("address").disabled = true;
            document.getElementById("submit").disabled = true;

            /*document.getElementById("direccion").disabled = true;
            document.getElementById("longitud").disabled = true;
            document.getElementById("latitud").disabled = true;
            */
          } else {
            alert('La direccion que ingreso es incorrecta! ' + status);
            document.getElementById("address").value = "";  
          }
        });
      }

    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBGf8UQ-G_-E6LZR6wbmXUibcVpfh4caac&callback=initMap">
    </script>
   
                 <%
                    if(request.getAttribute("error")!=null)
                         out.println("<script>Swal.fire('error','"+request.getAttribute("error")+"','info')</script>");
                    if(request.getAttribute("r")!=null)
                     out.println("<script>Swal.fire('respuesta','"+request.getAttribute("r")+"','info')</script>");
                %>
       
    </body>
</html>
