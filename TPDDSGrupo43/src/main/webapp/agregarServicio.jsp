<%@page import="vista.listObject"%>
<%@page import="modelo.Poi" %>
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

    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">

</head>

<body>

    <!-- Header -->
    <header id="top" class="header">
        <div class="text-center">
            <br>
            <h2>Alta de Servicios por POI:</h2>
        	<br>
        	<a href="#" data-toggle="modal" data-target="#login-modal" class="btn btn-dark btn-lg">Registrar Servicio</a>
        </div>
    </header>

    <!--Servicio Fade-->
    <div class="modal fade" id="login-modal" tabindex="1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
                <div class="loginmodal-container">
                    <h1>Registra tu Servicio</h1><br>
                  <form action="ServletRegistrarServicio" method="get">
                    <div class="styled-select">
	                    <select id="poi" name="poi">
	                    <%
						Poi[] pois = new listObject().getlistPoi();
	                    out.write("<option value=\"0\">--Seleccionar POI--</option>");
	                    for(int i=0;i<100;i++) {
	                    	if(pois[i].getIdPoi()== -1){
	                    		break;	
	                    	}
	                    	out.write("<option value=" + pois[i].getIdPoi()+ ">" + pois[i].getPoiDescripcion()+"</option>");
						}
						%>
	                    </select>
	                </div>
	                <input type="text" name="nombreServicio" placeholder="Nombre del Servicio">
                    <h3>Dias Disponible</h3>
                    <input type="checkbox" id="dLun" name="dLun" value="Lun">Lunes
                    <input type="checkbox" id="dMar" name="dMar" value="Mar">Martes
                    <input type="checkbox" id="dMie" name="dMie" value="Mie">Miercoles
                    <input type="checkbox" id="dJue" name="dJue" value="Jue">Jueves<br>
                    <input type="checkbox" id="dVie" name="dVie" value="Vie">Viernes
                    <input type="checkbox" id="dSab" name="dSab" value="Sab">Sabado
                    <input type="checkbox" id="dDom" name="dDom" value="Dom">Domingo<br>
                    <input type="text" name="horaDesde1" placeholder="Horario Desde Op1">
                    <input type="text" name="horaHasta1" placeholder="Horario Hasta Op1">
                    <input type="text" name="horaDesde2" placeholder="Horario Desde Op2">
                    <input type="text" name="horaHasta2" placeholder="Horario Hasta Op2">
                    <input type="text" name="tags" placeholder="Tags separados por ';'">
                    <input type="submit" name="register" class="login loginmodal-submit" value="Registrar Poi">
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
