<%-- 
    Document   : tercera
    Created on : 27-abr-2008, 12:21:28
    Author     : Chema
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tercera p&aacute;gina</title>
    </head>
    <body>
        <h2>Tercera p&aacute;gina controlada por Spring</h2>
        <p>El nombre de la persona es <strong>${persona.nombre}</strong></p>
        <p>El apellido de la persona es <strong>${persona.apellido}</strong></p>
        <a href="cuarta.html">Ir al formulario</a>
    </body>
</html>
