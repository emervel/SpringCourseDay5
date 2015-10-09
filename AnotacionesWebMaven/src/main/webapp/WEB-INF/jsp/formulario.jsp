<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cuarta p&aacute;gina</title>
    </head>
    <body>
        <h2>Cuarta p&aacute;gina controlada por Spring, incluyendo un formulario</h2>
        <h3>Introducir "ab" y "ab" para provocar un error</h3>
        <h3>Dejar los valores por defecto para un correcto funcionamiento</h3>
        <form:form commandName="persona">
            <table>
                <tr>
                    <td>Nombre de usuario:</td>
                    <td>
                        <form:input path="nombre"/>
                    </td>
                    <td>
                        <form:errors path="nombre"/>
                    </td>
                </tr>
                <tr>
                    <td>Apellido:</td>
                    <td>
                        <form:input path="apellido"/>
                    </td>
                    <td>
                        <form:errors path="apellido"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <input type="submit" value="Continuar"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
