<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page pageEncoding="UTF-8" contentType="text/html" />

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar</title>
        <link rel="stylesheet" type="text/css" href="${estilo}" />
    </head>
    <body>

        <div id="principal">
            <h2>Actualizaci&oacute;n de datos</h2>
            <form method="post" action="conclusion?op=update">
                <table>
                    <tr>
                        <td>Código</td>
                        <td><input type="text" name="idAlum" value="${autor.idAutor}" readonly="readonly" /></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="nombre" value="${autor.nombre}" /></td>
                    </tr>
                    <tr>
                        <td>Apellido 1</td>
                        <td><input type="text" name="ape1" value="${autor.ape1}" /></td>
                    </tr>
                    <tr>
                        <td>Apellido 2</td>
                        <td><input type="text" name="ape2" value="${autor.ape2}" /></td>
                    </tr>
                    <tr>
                        <td>Estilo</td>
                        <td><input type="text" name="estilo" value="${autor.estilo}" /></td>
                    </tr>
                    <tr>
                        <td>Fecha</td>
                        <td><input type="date" name="fecha" value="${autor.fecha}" /></td>
                    </tr>
                    <c:forEach var="obra" items="${autor.obraList}" varStatus="status">
                        <tr>
                            <td>Obras</td>
                            <td><input type="text" name="nombre${status.count}" value="${obra.nombre}" /></td>
                        <input type="hidden" name="idObra${status.count}" value="${obra.idObra}" />
                        </tr>
                        <tr>
                            <td>Tecnica</td>
                            <td><input type="text" name="tecnica${status.count}" value="${obra.tecnica}" /></td>
                        <input type="hidden" name="idExamen${status.count}" value="${obra.idObra}" />
                        </tr>
                        <tr>
                            <td>Dimensiones</td>
                            <td><input type="text" name="dimensiones${status.count}" value="${obra.dimensiones}" /></td>
                        <input type="hidden" name="idObra${status.count}" value="${obra.idObra}" />
                        </tr>
                    </c:forEach>
                    <tr>

                        <td colspan="2"><input type="submit" name="enviar" value="Enviar" class="boton" /></td>
                    </tr>
                </table>

            </form>
        </div>


    </body>
</html>