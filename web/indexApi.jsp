<%-- 
    Document   : indexApi
    Created on : 05-oct-2019, 2:20:59
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index API</title>
        <style>
      #map {
        height: 90%;
      }
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
  </style>
    </head>
    
    <body>
         <div id="map"></div>

    <script>

      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          center: new google.maps.LatLng(13.8033424, -88.8517187),
          zoom: 9.2
        });
        
      var prev_infowindow =false;       
 
          //Cambia esto dependiendo de el nombre de tu archivo PHP o XML 
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

    </body>
</html>
