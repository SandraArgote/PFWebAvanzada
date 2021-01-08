<%-- 
    Author     : Sandra Paulina Argote Romo
--%>

<%@page import="modelo.Maestro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Signika:wght@300;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/estilos.css"/> 
    </head>
    <body>
        <nav>
            <a href="inicioMaestro.jsp">Inicio</a>
            <a href="#">Perfil</a>
            <a class="cerrar-sesion" href='login_controlador?cerrar=true'>Cerrar Sesión</a>
        </nav>

        <h1 class="Naranja1">Datos personales</h1>

        <% Maestro ma = (Maestro) request.getAttribute("maestro");%>

        Id maestro : <input  readonly="readonly"  type="text" name="id" value="<%= ma.getIdMaestro()%>"><br>
        Nombre maestro : <input  readonly="readonly" type="text"  value="<%= ma.getNombreMaestro()%>"><br>
        Correo: <input type="text"  readonly="readonly"  value="<%= ma.getCorreo()%>"><br>
        Teléfono: <input type="text"  readonly="readonly" value="<%= ma.getTelefono()%>"><br>
        Departamento: <input type="text"  readonly="readonly" value="<%= ma.getDepartamento()%>"><br>

    </body>
</html>