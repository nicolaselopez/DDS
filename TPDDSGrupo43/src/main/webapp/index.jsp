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
        </div>
    </header>
    <!--Cercania Fade-->
    <div class="modal fade" id="cercania-modal" tabindex="1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
                <div class="loginmodal-container">
                    <h1>Calculo de Cercania</h1><br>
                    <form action="ServletCalcularCercania" method="get">
                    <input type="hidden" name="latitud1" id="latitud1" >
                    <input type="hidden" name="longitud1" id="longitud1">
                    <input type="hidden" name="latitud2" id="latitud2">
                    <input type="hidden" name="longitud2" id="longitud2">
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
	                    	poiArrayList.add(pois[i].getPoiDescripcion()+"/"+pois[i].getPoiLatitudGeo()+"/"+pois[i].getPoiLongitudGeo());
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
    <script>
    var map;
    var markers = [];
    function initMap() {
    	
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
            var datos = text.split('/',3);
            var pos = {
              lat: parseFloat(datos[1]),
              lng: parseFloat(datos[2])
            };
            var markerPos = new google.maps.Marker({
            	position: pos,
            	title:datos[0],
            	map: map
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
    
      function placeMarkerAndPanTo(latLng, map) {
        var marker = new google.maps.Marker({
          position: latLng,
          map: map
        });
        markers.push(marker);
        $('#latitud2').val(latLng.lat());
        $('#longitud2').val(latLng.lng());
        map.panTo(latLng);
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
