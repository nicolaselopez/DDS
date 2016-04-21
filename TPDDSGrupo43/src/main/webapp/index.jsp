<%@ page import="vista.listObject" %>
<%@ page import="modelo.Poi" %>
<%@ page import="java.util.*" %>
<%@ page import="org.json.*" %>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>DDS - 2016 1er Cuatrimestre</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/stylish-portfolio.css" rel="stylesheet">

    <!-- Login CSS -->
    <link href="css/login.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/googleapi-font.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
    <nav id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
            <li>
                <a href="#top" onclick = $("#menu-close").click(); >Mapa</a>
            </li>
            <li>
                <a href="login.jsp" onclick = $("#menu-close").click(); >LogIn</a>
            </li>
            
            <li>
                <a href="contactos.jsp" onclick = $("#menu-close").click(); >Contactos</a>
            </li>
        </ul>
    </nav>

    <!-- Header -->
    <header id="top" class="header">
        <div class="text-vertical-center">
            <h1>Mapa de POIS</h1>
            <br>
            <div id="outerdiv">
            	<div id="map"></div>
        	</div>
            <br>
        	<a href="#" data-toggle="modal" data-target="#cercania-modal" class="btn btn-dark btn-lg">Calcular Cercania</a>
            <br>
        	<a href="#" data-toggle="modal" data-target="#disponibilidad-modal" class="btn btn-dark btn-lg">Calcular Disponibilidad</a>
        </div>
    </header>
    <!--Cercania Fade-->
    <div class="modal fade" id="cercania-modal" tabindex="1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
                <div class="loginmodal-container">
                    <h2>Calculo de Cercania</h2><br>
                    <form action="ServletCalculoCercania" method="get">
                    <input type="hidden" name="latitud1" id="latitud1" >
                    <input type="hidden" name="longitud1" id="longitud1">
                    <input type="hidden" name="comunaPos" id="comunaPos" >
                    <input type="hidden" name="idPoiMap" id="idPoiMap" value =0>
                    <h1>Selecciona un Poi del mapa</h1>
                    <input type="text" name="latitud2" id="latitud2" placeholder="Latitud Poi">
                    <input type="text" name="longitud2" id="longitud2" placeholder="Longitud Poi">
                    
                    <h1>O eleji de esta lista:</h1>
                    <div class="styled-select">
	                    <select id="poi" name="poi">
	                    <%
	                    Poi[] pois = new listObject().getlistPoi();
	                    List<String> poiArrayList = new ArrayList<String>();
	                    out.write("<option value=\"0\">--Seleccionar POI--</option>");
	                    for(int i=0;i<100;i++) {
	                    	if(pois[i].getIdPoi()== -1){
	                    		break;	
	                    	}
	                    	out.write("<option value=" + pois[i].getIdPoi()+ ">" + pois[i].getPoiDescripcion()+"</option>");
	                    	poiArrayList.add(pois[i].getPoiDescripcion()+"/"+pois[i].getPoiLatitudGeo()+"/"+pois[i].getPoiLongitudGeo()+"/"+pois[i].getIdPoi());
						}
	                    String json = (new JSONArray(poiArrayList)).toString();
						%>
	                    </select>
	                </div>
                    <input type="submit" name="register" class="login loginmodal-submit" value="Calcular">
                  </form>
                </div>
            </div>
    </div>
    
    <!--Disponibilidad Fade-->
    <div class="modal fade" id="disponibilidad-modal" tabindex="1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
                <div class="loginmodal-container">
                    <h2>Calculo de Disponibilidad</h2><br>
                    <form action="ServletCalculoDisponibilidad" method="get">
                    <h1>Eleji de esta lista:</h1>
                    <div class="styled-select">
	                    <select id="poi" name="poi">
	                    <%
	                    Poi[] poisD = new listObject().getlistPoi();

	                    out.write("<option value=\"0\">--Seleccionar POI--</option>");
	                    for(int i=0;i<100;i++) {
	                    	if(poisD[i].getIdPoi()== -1){
	                    		break;	
	                    	}
	                    	out.write("<option value=" + poisD[i].getIdPoi()+ ">" + poisD[i].getPoiDescripcion()+"</option>");
						}
						%>
	                    </select>
	                </div>
                    <input type="submit" name="register" class="login loginmodal-submit" value="Calcular">
                  </form>
                </div>
            </div>
    </div>
    
      
    <script>
    var map;
    var markers = [];
    var comuna;

    function initMap() {
    	geocoder = new google.maps.Geocoder();
    	var myLatlng1 = new google.maps.LatLng(-34.607430, -58.432560);
	     var mapOptions = {
	         zoom: 12,
	         center: myLatlng1,
	         mapTypeId: google.maps.MapTypeId.ROADMAP
	     };
        map = new google.maps.Map(document.getElementById('map'), mapOptions);

        // Try HTML5 geolocation.
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
              lat: position.coords.latitude,
              lng: position.coords.longitude
            };
            var markerPos = new google.maps.Marker({
            	icon: 'http://maps.google.com/mapfiles/ms/icons/blue-dot.png',
            	position: pos,
            	animation: google.maps.Animation.DROP,
            	title:"Usted se encuentra aquí.",
            	map: map
            });
            map.setCenter(pos);
            $('#latitud1').val(pos.lat);
            $('#longitud1').val(pos.lng);
            getReverseGeocodingData(pos.lat,pos.lng);
          }, function() {
            handleLocationError(true, infoWindow, map.getCenter());
          });
        } else {
          // Browser doesn't support Geolocation
          handleLocationError(false, infoWindow, map.getCenter());
        }
        
        map.addListener('click', function(e) {
          clearMarkers();
          markers = [];
          placeMarkerAndPanTo(e.latLng, map);
        });
        var arr=<%= json %>;
        $.each( arr, function(i, text){ 
            var datos = text.split('/',4);
            var pos = {
              lat: parseFloat(datos[1]),
              lng: parseFloat(datos[2])
            };
            var markerPos = new google.maps.Marker({
            	position: pos,
            	title:datos[0],
            	map: map
            });
            markerPos.addListener('click',function(){
            	$('#latitud2').val(parseFloat(datos[1]));
                $('#longitud2').val(parseFloat(datos[2]));
                $('#idPoiMap').val(parseInt(datos[3]));
            });  
        });
        
      }
      
      function setMapOnAll(map) {
    	  for (var i = 0; i < markers.length; i++) {
    	    markers[i].setMap(map);
    	  }
    	}
    
      function clearMarkers() {
    	  setMapOnAll(null);
      }
      
      function getAddress(results) {
  	    if(results && results.length) {
  	        for (var i=0; i<results.length; i++) {
  	                for(var j=0; j<results[i].address_components.length;j++){
  	                	if(results[i].address_components[j].long_name.indexOf('Comuna')!= -1){
  	                		return results[i].address_components[j].long_name; 
  	                	}
  	                };
  	            }
  	        return results[0].formatted_address;
  	    }
  	    return '';
  	  }
      
      function getReverseGeocodingData(lat, lng) {
    	    var latlng = new google.maps.LatLng(lat, lng);
    	    // This is making the Geocode request
    	    var geocoder = new google.maps.Geocoder();
    	    geocoder.geocode({ 'latLng': latlng }, function (results, status) {
    	        if (status !== google.maps.GeocoderStatus.OK) {
    	            alert(status);
    	        }
    	        // This is checking to see if the Geoeode Status is OK before proceeding
    	        if (status == google.maps.GeocoderStatus.OK) {
    	            comuna = getAddress(results);
    	            $('#comunaPos').val(comuna);
    	        }
    	    });
  	  }
      
      
    </script>
    
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDdZb-Yl0gK_AOjcmjU4bCcRecyi-IlTe0&callback=initMap"
    async defer></script>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script>
    // Closes the sidebar menu
    $("#menu-close").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });

    // Opens the sidebar menu
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });

    // Scrolls to the selected menu item on the page
    $(function() {
        $('a[href*=#]:not([href=#])').click(function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {

                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
    });
    </script>

</body>

</html>
