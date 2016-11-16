<%@page import="vista.listObject"%>
<%@page import="modelo.Poi" %>
<%@page import="modelo.Autenticador" %>
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
	  <%boolean valid = Autenticador.controlarPermisos(Integer.parseInt(usu), 13);
	  if(!valid){
	  request.setAttribute("us", usu);
	  request.getRequestDispatcher("accesoDenegado.jsp").forward(request, response);
	  }%>
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
                <a href="historialBusqueda.jsp?us=<%= usu %>" onclick = $("#menu-close").click(); >Historial Busqueda</a>
            </li>
            <li>
                <a href="busquedaCriterio.jsp?us=<%= usu %>" onclick = $("#menu-close").click(); >Busqueda por Criterio</a>
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
            <h2>Historial de búsquedas</h2>
        	<br>
        	<a href="#" data-toggle="modal" data-target="#login-modal" class="btn btn-dark btn-lg">Click Aquí</a>
        </div>
    </header>

    <!--Servicio Fade-->
    <div class="modal fade" id="login-modal" tabindex="1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
                <div class="loginmodal-container">
                    <h1>Ingrese la fecha Desde/Hasta</h1>
                  <form action="ServletHistorialBusquedasMongo" method="get">
                     <div class="styled-select">
	                    Desde<br>
	                    <input id="desde" type="date" name="desde"><br>
  						Hasta<br>
	                    <input id="hasta" type="date" name="hasta">
	                </div>
	                <input type="hidden" name="us" value = <%= usu %>>
	                <input type="submit" name="register" class="login loginmodal-submit" onsubmit="return validateForm()" value="Buscar">
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
    
    function validateForm() {
        var x = $('#desde').val();
        var y = $('#hasta').val();
        if (x == null || y == null || y < x) {
            if(x == null){
            	alert("Debe seleccionar una fecha desde");
            }else if(y == null){
            	alert("Debe seleccionar una fecha hasta");
            }else if(y < x){
            	alert("fecha Hasta no puede ser menor que fecha Desde");
            }
            return false;
        }
    }
    </script>

</body>

</html>
