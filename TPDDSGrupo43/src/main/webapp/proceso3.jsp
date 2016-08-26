<%@page import="vista.listObject"%>
<%@page import="modelo.Poi" %>
<%@page import="modelo.Usuario" %>
<%@page import="modelo.Accion" %>
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
        	<a href="#" data-toggle="modal" data-target="#login-modal" class="btn btn-dark btn-lg">Asignar Acciones a Usuarios</a>
        	<br>
        	<a href="#" data-toggle="modal" data-target="#rollback-modal" class="btn btn-dark btn-lg">Rollback Usuario</a>
        </div>
    </header>

    <!--Servicio Fade-->
    <div class="modal fade" id="login-modal" tabindex="1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
                <div class="loginmodal-container">
                    <h1>Seleccione Usuarios</h1>
                  <form action="ServletProceso3" method="get">
                   
                     <div class="styled-select">
                     <select id="proceso" name="proceso">
	                    <%
						Usuario[] procesos = new listObject().getlistUsuarios();
                     for(int i=0;i<procesos.length;i++) {
	                    	if(procesos[i]==null)
	                    		break;
	                    	out.write("<option value=" + procesos[i].getUsuario()+ ">" + procesos[i].getNombre()+"</option>");
						}
						%>
	                    </select>
						<%
						Accion[] acciones = new listObject().getlistAcciones();
                       	out.write("<input type=\"checkbox\" id=\"acc1\" name=\"acc1\" value=1>"+ acciones[0].getAccionDescripcion()+"<br>");
                   		out.write("<input type=\"checkbox\" id=\"acc2\" name=\"acc2\" value=1>"+ acciones[1].getAccionDescripcion()+"<br>");
                   		out.write("<input type=\"checkbox\" id=\"acc3\" name=\"acc3\" value=1>"+ acciones[2].getAccionDescripcion()+"<br>");
                   		out.write("<input type=\"checkbox\" id=\"acc4\" name=\"acc4\" value=1>"+ acciones[3].getAccionDescripcion()+"<br>");
                   		out.write("<input type=\"checkbox\" id=\"acc5\" name=\"acc5\" value=1>"+ acciones[4].getAccionDescripcion()+"<br>");
                   		out.write("<input type=\"checkbox\" id=\"acc6\" name=\"acc6\" value=1>"+ acciones[5].getAccionDescripcion()+"<br>");
                   		out.write("<input type=\"checkbox\" id=\"acc7\" name=\"acc7\" value=1>"+ acciones[6].getAccionDescripcion()+"<br>");
                   		out.write("<input type=\"checkbox\" id=\"acc8\" name=\"acc8\" value=1>"+ acciones[7].getAccionDescripcion()+"<br>");
                   		out.write("<input type=\"checkbox\" id=\"acc9\" name=\"acc9\" value=1>"+ acciones[8].getAccionDescripcion()+"<br>");
                   		out.write("<input type=\"checkbox\" id=\"acc10\" name=\"acc10\" value=1>"+ acciones[9].getAccionDescripcion()+"<br>");
                   		out.write("<input type=\"checkbox\" id=\"acc11\" name=\"acc11\" value=1>"+ acciones[10].getAccionDescripcion()+"<br>");
                   		out.write("<input type=\"checkbox\" id=\"acc12\" name=\"acc12\" value=1>"+ acciones[11].getAccionDescripcion()+"<br>");
                   		
						%>
					</div>
	                <input type="hidden" name="us" value = <%= usu %>>
	                <input type="submit" name="register" class="login loginmodal-submit" value="Registrar Servicio">
                  </form>
                </div>
            </div>
    </div>
    
    <!--Servicio Fade-->
    <!--Disponibilidad Fade-->
    <div class="modal fade" id="rollback-modal" tabindex="1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
                <div class="loginmodal-container">
                    <h2>Rollback Usuario</h2><br>
                    <form action="ServletProceso3Rollback" method="get">
                    <h1>Elegi de esta lista:</h1>
                    <div class="styled-select">
	                    <select id="usuarien" name="usuarien">
	                    <%
						Usuario[] usuarioo = new listObject().getlistUsuarios();
                     for(int i=0;i<usuarioo.length;i++) {
	                    	if(usuarioo[i]==null)
	                    		break;
	                    	out.write("<option value=" + usuarioo[i].getUsuario()+ ">" + usuarioo[i].getNombre()+"</option>");
						}
						%>
	                    </select>
	                </div>
                    <input type="submit" name="register" class="login loginmodal-submit" value="Rollback">
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
