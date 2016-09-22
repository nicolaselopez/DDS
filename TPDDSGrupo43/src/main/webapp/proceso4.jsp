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
	<%String usu = "0";
	if(request.getParameter("us")!= null){
		usu = request.getParameter("us");
	}else if( request.getAttribute("us") != null){
		usu = (String)request.getAttribute("us");
	};
	 %>
    <!-- Navigation -->
    <a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
    <nav id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <a id="menu-close" href="#" class="btn btn-light btn-lg pull-right toggle"><i class="fa fa-times"></i></a>
           <li>
                <a href="home.jsp?us=<%= usu %>" onclick = $("#menu-close").click(); >Home</a>
            </li>
            <li>
                <a href="registrarPoi.jsp?us=<%= usu %>" onclick = $("#menu-close").click(); >Registrar Poi</a>
            </li>
            <li>
                <a href="agregarServicio.jsp?us=<%= usu %>"onclick = $("#menu-close").click(); >Registrar Servicio a Poi</a>
            </li>
            <li>
                <a href="editarPoiSeleccion.jsp?us=<%= usu %>" onclick = $("#menu-close").click(); >Editar Poi</a>
            </li>
            <li>
                <a href="borrarPoi.jsp?us=<%= usu %>" onclick = $("#menu-close").click(); >Borrar Poi</a>
            </li>
        	<li>
                <a href="recuperarPoi.jsp?us=<%= usu %>" onclick = $("#menu-close").click(); >Recuperar Poi</a>
            </li>       	
            <li>
                <a href="editarServicioSeleccion.jsp?us=<%= usu %>" onclick = $("#menu-close").click(); >Editar Servicio</a>
            </li>
        	<li>
                <a href="borrarServicio.jsp?us=<%= usu %>" onclick = $("#menu-close").click(); >Borrar Servicio a Poi</a>
            </li>      
            <li>
                <a href="recuperarServicio.jsp?us=<%= usu %>" onclick = $("#menu-close").click(); >Recuperar Servicio a Poi</a>
            </li>    
            <li>
                <a href="actualizarInfoExterna.jsp?us=<%= usu %>" onclick = $("#menu-close").click(); >Actualizar Info Externa</a>
            </li>  
            <li>
                <a href="reporteSeleccion.jsp?us=<%= usu %>" onclick = $("#menu-close").click(); >Generar Reportes</a>
            </li> 
            <li>
                <a href="proceso.jsp?us=<%= usu %>" onclick = $("#menu-close").click(); >Procesos</a>
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
            <h2>Proceso</h2>
        	<br>
        	<a href="#" data-toggle="modal" data-target="#login-modal" class="btn btn-dark btn-lg">Seleccioná un proceso</a>
        </div>
    </header>

    <!--Servicio Fade-->
    <div class="modal fade" id="login-modal" tabindex="1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
                <div class="loginmodal-container">
                    <h1>Seleccione un proceso</h1>
                  <form action="ServletProceso4" method="get">
                   
                     <div class="styled-select">
	                    <input type="checkbox" id="dLun" name="dLun" value="Lun">Proceso1<br>
	                    <input type="checkbox" id="dMar" name="dMar" value="Mar">Proceso2<br>
	                    <input type="checkbox" id="dMie" name="dMie" value="Mie">Proceso3<br>
	                </div>
	                <input type="hidden" name="us" value = <%= usu %>>
	                <input type="submit" name="register" class="login loginmodal-submit" value="Ejecutar">
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
