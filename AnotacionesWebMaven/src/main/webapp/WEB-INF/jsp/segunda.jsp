<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Segunda p&aacute;gina</title>
    </head>
    <body>
        <h2>Segunda p&aacute;gina controlada por Spring</h2>
        <h3>El valor del par&aacute;metro enviado por la primera p&aacute;gina es:</h3>
        <strong>${parametro}</strong>
        <h3>La hora actual es: ${hora}</h3>
        <a href="tercera.html">Ir a la tercera p&aacute;gina</a>
    </body>
</html>
