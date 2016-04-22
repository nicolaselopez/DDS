<%@page import="modelo.Poi"%>
<%@page import="modelo.Servicio"%>
<%@ page import="vista.listObject" %>

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
<%Poi poi=(Poi)request.getAttribute("poi");%>
<% if(poi == null){
	poi = new Poi();
	poi.setPoiDescripcion("Error");};%>
<%Boolean OK = (Boolean)request.getAttribute("OK"); %>

    <!-- Navigation -->
    <a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
    <nav id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
            <li>
                <a href="index.jsp" onclick = $("#menu-close").click(); >Mapa</a>
            </li>
            <li>
                <a href="login.jsp" onclick = $("#menu-close").click(); >LogIn</a>
            </li>
        </ul>
    </nav>
    <!-- Header -->
    <header id="top" class="header">
        <div class="text-vertical-center">

        	<a href="#" data-toggle="modal" data-target="#disponibilidad-modal" class="btn btn-dark btn-lg">Calcular Disponibilidad</a>
        </div>
    </header>
     <!--Disponibilidad Fade-->
    <div class="modal fade" id="disponibilidad-modal" tabindex="1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
                <div class="loginmodal-container">
                    <h2>Seleccionar Servicio</h2><br>
                    <form action="ServletCalculoDisponibilidad2" method="get">
                    <h1>Eleji de esta lista:</h1>
                    <div class="styled-select">
	                    <select id="serv" name="serv">
	                    <%
	                    Servicio[] servicioPoi = poi.getPoiServicio();
	                    out.write("<option value=\"0\">--Servicios--</option>");
	                    for(int i=0;i<servicioPoi.length;i++) {
	                    	if(servicioPoi[i].getIdServicio()== -1){
	                    		break;	
	                    	}
	                    	out.write("<option value=" + servicioPoi[i].getIdServicio()+ ">" + servicioPoi[i].getServicioDescripcion()+"</option>");
						}
						%>
	                    </select>
	                </div>
                    <input type="submit" name="register" class="login loginmodal-submit" value="Calcular">
                  </form>
                </div>
            </div>
    </div>

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
