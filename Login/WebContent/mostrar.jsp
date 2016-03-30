<%@page import="controlador.BeanUsuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta Usuario</title>
</head>
<body>
<%BeanUsuario busuario=(BeanUsuario)request.getAttribute("busuario"); %>
<div align="center">
<table>
<tr>
<td>Nombre:</td>
<td><input type="text" size="20" name="nombre" value="<%= busuario.getNombre() %>"></td>
</tr>
<tr>
<td>Apellido:</td>
<td><input type="text" size="20" name="apellido" value="<%= busuario.getApellido() %>"></td>
</tr>
<tr>
<td>Edad:</td>
<td><input type="text" size="20" name="edad" value="<%= busuario.getEdad() %>"></td>
</tr>
<tr>
<td>Correo:</td>
<td><input type="text" size="20" name="correo" value="<%= busuario.getCorreo() %>"></td>
</tr>
<tr>
<td>Usuario:</td>
<td><input type="text" size="20" name="usuario" value="<%= busuario.getUsuario() %>"></td>
</tr>
<tr>
<td>Contraseña:</td>
<td><input type="text" size="20" name="clave" value="<%= busuario.getClave() %>"></td>
</tr>
</table>
</div>
</body>
</html>