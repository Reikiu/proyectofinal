<%-- 
    Document   : api
    Created on : 03-oct-2019, 0:27:07
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Maps</title>
        <link href="recursos/css/mapa.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="recursos/bootstrap/css/bootstrap.min.css">
        <link href="css/style.css" rel="stylesheet" id="bootstrap-css">
         <title>Mapa de proyectos</title>
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
        <script src="script.js" type="text/javascript"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBGf8UQ-G_-E6LZR6wbmXUibcVpfh4caac&callback=iniciarMap"></script>
</body>
</html>
