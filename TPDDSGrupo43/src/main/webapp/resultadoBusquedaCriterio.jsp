<%@page import="modelo.Poi"%>
<%@page import="modelo.Servicio"%>
<%@page import="modelo.HistorialBusqueda"%>
<%@page import="modelo.ResultadosHistorial"%>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.google.gson.Gson" %>
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

    <style type="text/css">
    table{
    background-color:white;
    border: hidden;
    border-radius: 25px;
    }
    #registroOK {
	display: none;
	}
    </style>

</head>

<body>
<%Poi[] pois=(Poi[])request.getAttribute("pois");%>
<% if(pois == null){
	pois = new Poi[1];
	pois[0] = new Poi();
	pois[0].setIdPoi(-1);};%>

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
              <div class="container"> 
  				<h1>Búsquedas encontradas</h1> <br>
  				 <div class="table-responsive">
        <form action="ServletVerDescripcion" method="get">
  					<table class="table table-hover">
    					<thead>
      						<tr>
        						<th>Nombre</th>
        						<th>Direccion</th>
      						</tr>
    					</thead>
    					<tbody>
     						<%  Gson gson = new Gson();

     							for(int i=0;i<pois.length;i++) {
                   				if(pois[i].getIdPoi()== -1){
                   				break;	
                   				}
                   					Poi poi = pois[i];
                   					out.write("<tr>");
									out.write("<td>" + poi.getPoiDescripcion() +"</td>");
									out.write("<td>" + poi.getPoiDireccion().getPoiCalle() + " " + poi.getPoiDireccion().getPoiNumero() +"</td>");
									out.write("</tr>");
           out.write("<td><input type=\"submit\" name=\"register\" class=\"login loginmodal-submit\" value=\"Ver POI\">");
			  					}
							%>
    				</tbody>
    				
    				
  				</table>
            </form>
  				</div>
			</div>
            <br>

	<table id="registroOK" class="table table-hover">
	    <tr>
	    	<th>POI</th>
	    </tr>
	</table>
    </header>

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

    function mostrarPois(data) {
        data = data.replace(/@/g, '"');
        var resultado = JSON.parse(data);

	    $("#registroOK").text("");
        var len = resultado.length;
        var txt = "<tr><th>POI</th><th>Detalle</th></tr>";
        if(len > 0){
            for(var i=0;i<len;i++){
            	if(resultado[i].IdPoi!=0)
                {
            		txt +="<tr><td>"+resultado[i].IdPoi+"</td><td>"+resultado[i].PoiDescripcion+"</td></tr>";
                }
            }
        }
        
	    $("#registroOK").show();
	    $("#registroOK").append(txt);
		$("#registro").hide();

	};
    </script>

</body>

</html>