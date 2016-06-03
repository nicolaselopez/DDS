<%@page import="vista.listObject"%>
<%@page import="modelo.Barrio" %>
<%@page import="modelo.Rubro" %>
<%@page import="modelo.TipoPoi" %>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>DDS - 2016 1er Cuatrimestre - Prueba Login</title>

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

    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">

</head>

<body>
    <!-- Navigation -->
    <a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
    <nav id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
            <li>
                <a href="#top" onclick = $("#menu-close").click(); >Home</a>
            </li>
            <li>
                <a href="agregarServicio.jsp" onclick = $("#menu-close").click(); >Registrar Servicio a Poi</a>
            </li>
            <li>
                <a href="editarPoiSeleccion.jsp" onclick = $("#menu-close").click(); >Editar Poi</a>
            </li>
            <li>
                <a href="borrarPoi.jsp" onclick = $("#menu-close").click(); >Borrar Poi</a>
            </li>
        	<li>
                <a href="recuperarPoi.jsp" onclick = $("#menu-close").click(); >Recuperar Poi</a>
            </li>
        	        	
            <li>
                <a href="editarServicioSeleccion.jsp" onclick = $("#menu-close").click(); >Editar Servicio</a>
            </li>
        	<li>
                <a href="borrarServicio.jsp" onclick = $("#menu-close").click(); >Borrar Servicio a Poi</a>
            </li>      
            <li>
                <a href="recuperarServicio.jsp" onclick = $("#menu-close").click(); >Recuperar Servicio a Poi</a>
            </li>   
            <li>
                <a href="index.jsp" onclick = $("#menu-close").click(); >Logout</a>
            </li>
        </ul>
    </nav>

    <!-- Header -->
    <header id="top" class="header">
        <div class="text-center">
            <br>
            <h2>Seleccione el punto a registrar:</h2>
            <br>
            <div id="outerdiv">
            	<div id="map"></div>
        	</div>
        	<br>
        	<a href="#" data-toggle="modal" data-target="#login-modal" class="btn btn-dark btn-lg">Registrar POI</a>
        </div>
    </header>

    <!--POI Fade-->
    <div class="modal fade" id="login-modal" tabindex="1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
                <div class="loginmodal-container">
                    <h1>Registra tu POI</h1><br>
                  <form action="ServletRegistrarPoi" method="get">
                    <input type="text" name="nombrePoi" placeholder="Nombre del Poi">
                    <input type="text" name="latitud" id="latitud">
                    <input type="text" name="longitud" id="longitud">
                    <input type="text" name="calle" placeholder="Calle">
                    <input type="text" name="numero" placeholder="Numero">
                    <input type="text" name="piso" placeholder="Piso">
                    <input type="text" name="dpto" placeholder="Depto">
                    <input type="text" name="codpos" placeholder="Codigo Postal">
                    <div class="styled-select">
	                    <select id="tipoPoi" name="tipoPoi">
	                    <%
						TipoPoi[] tipoPoi = new listObject().getlistTipoPoi();
	                    out.write("<option value=\"0\">--Tipo de POI--</option>");
						for(int i=0;i<4;i++) {
						    out.write("<option value=" + tipoPoi[i].getIdTipoPoi()+ ">" + tipoPoi[i].getTipoPoiDescripcion()+"</option>");
						}
						%>
	                    </select>
	                </div>
                    <div class="styled-select">
	                    <select id="barrio" name="barrio">
	                    <%
						Barrio[] barrios = new listObject().getlistBarrio();
	                    out.write("<option value=\"0\">--Localidad--</option>");
						for(int i=0;i<48;i++) {
						    out.write("<option value=" + barrios[i].getIdBarrio()+ ">" + barrios[i].getBarrioDescripcion()+"</option>");
						}
						%>
	                    </select>
	                </div>
	                <div class="styled-select">
	                    <select id="rubro" name="rubro">
	                    <%
						Rubro[] rubros = new listObject().getlistRubro();
	                    out.write("<option value=\"0\">Rubro (Si corresponde)</option>");
	                    for(int i=0;i<100;i++) {
	                    	if(rubros[i].getIdRubro()== -1){
	                    		break;	
	                    	}
	                    	out.write("<option value=" + rubros[i].getIdRubro()+ ">" + rubros[i].getRubroDescripcion()+"</option>");
						}
						%>
	                    </select>
	                </div>
	                
                    <input type="submit" name="register" class="login loginmodal-submit" value="Registrar Poi">
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

        map.addListener('click', function(e) {
          clearMarkers();
          markers = [];
          placeMarkerAndPanTo(e.latLng, map);
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
        $('#latitud').val(latLng.lat());
        $('#longitud').val(latLng.lng());
        map.panTo(latLng);
      }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDdZb-Yl0gK_AOjcmjU4bCcRecyi-IlTe0&callback=initMap"
    async defer></script>

    <!--Login Fade
    <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
                <div class="loginmodal-container">
                    <h1>Ingresa a tu cuenta</h1><br>
                  <form action="ServletConsulta" method="get">
                    <input type="text" name="usuario" placeholder="Usuario">
                    <input type="password" name="pass" placeholder="Contraseña">
                    <input type="submit" name="login" class="login loginmodal-submit" value="Consultar">
                  </form>
                    
                  <div class="login-help">
                    <a href="registrar.jsp">Registrate</a>
                  </div>
                </div>
            </div>
    </div>-->

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
