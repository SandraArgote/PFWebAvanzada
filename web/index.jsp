<%-- 
    Author     : Sandra Paulina Argote Romo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de sesión</title>
    </head>
    <body>
        <div >
            <h1 class="Naranja1 font-700">Iniciar Sesión</h1>
            <form class="formulario" action="login_controlador" method="post">

                Usuario : <input type="text" name="usuario"><br>
                Contraseña : <input type="password" name="pass"><br>

                <input type="submit" class="boton" name="ingresar" value="Iniciar sesión">
            </form>
        </div>
    </body>
     <link rel="stylesheet" type="text/css" href="css/estilos.css" /> 
</html>
