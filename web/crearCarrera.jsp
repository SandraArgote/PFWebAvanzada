<%-- 
    Author     : Sandra Paulina Argote Romo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Maestro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css"/> 
        <title>Alta Carrera</title>
    </head>
    <body>

        <%
            if (session != null) {
                if (session.getAttribute("usuario") != null && session.getAttribute("tipo") != null) {
                    String usuario = (String) session.getAttribute("usuario");
                    String tipo = (String) session.getAttribute("tipo");
                } else {
                    response.sendRedirect("index.jsp");
                }
            }
        %>

        <% ArrayList<Maestro> listaMaestro = (ArrayList<Maestro>) request.getAttribute("lista"); %>

        <nav class="navegacion-usuario">
            <a href="inicioAdmin.jsp">Inicio</a>
            <a href="crearCarrera.jsp">Agregar Carrera</a>
            <a href="verMaestros_controlador">Profesores</a>
            <a class="cerrar-sesion" href='login_controlador?cerrar=true'>Cerrar Sesion</a>
        </nav> 

        <h1>Registrar carrera</h1>
        <form action="crearCarrera_controlador" method="post">

            <label> Clave de Carrera </label>
            <input type="text" name="idCarrera" required=""> 
            <label>Nombre de la Carrera</label>
            <input type="text" name="nombreCarrera" required="">
            <select name="jefe" id="jefe">

                <option value="0"> Seleccione jefe </option>
                <% try {
                        for (Maestro li : listaMaestro) {%>
                <option value="<%= li.getIdMaestro()%>"><%= li.getNombreMaestro()%> </option>

                <% }
                    } catch (Exception e) {
                        System.out.println(e);
                    }%>

            </select>
            <input type="submit">
        </form>
    </body>
</html>