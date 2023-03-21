<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page pageEncoding="UTF-8" contentType="text/html" />

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta</title>
        <link rel="stylesheet" type="text/css" href="${estilo}" />
    </head>
    <body>

        <div id="principal">
            <h2>Actualizaci&oacute;n de datos</h2>
        <form method="post" action="control?op=add">
            <table>
<%--                <tr>
                    <td>Código</td>
                    <td><input type="text" name="id"  /></td>
                </tr>--%>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre" /></td>
                </tr>
                <tr>
                    <td>Apellido 1:</td>
                    <td><input type="text" name="ape1"  /></td>
                </tr>
                <tr>
                    <td>Apellido 2:</td>
                    <td><input type="text" name="ape2" /></td>
                </tr>
                <tr>
                    <td>Estilo:</td>
                    <td><input type="text" name="estilo" /></td>
                </tr>
                <tr>
                    <td>Fecha de nacimiento:</td>
                    <td><input type="date" name="fecha" /></td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre0" /></td>
                </tr>
                <tr>
                    <td>Tecnica: </td>
                    <td><input type="text" name="tecnica0" /></td>
                </tr>
                  <tr>
                    <td>Dimensiones:</td>
                    <td><input type="text" name="dimensiones0" /></td>
                </tr>
               <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre1" /></td>
                </tr>
                <tr>
                    <td>Tecnica: </td>
                    <td><input type="text" name="tecnica1" /></td>
                </tr>
                  <tr>
                    <td>Dimensiones:</td>
                    <td><input type="text" name="dimensiones1" /></td>
                </tr>
                
                     <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre2" /></td>
                </tr>
                <tr>
                    <td>Tecnica: </td>
                    <td><input type="text" name="tecnica2" /></td>
                </tr>
                  <tr>
                    <td>Dimensiones:</td>
                    <td><input type="text" name="dimensiones2" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="enviar" value="Enviar" class="boton" /></td>
                </tr>
            </table>
        </form>
        </div>


    </body>
</html>