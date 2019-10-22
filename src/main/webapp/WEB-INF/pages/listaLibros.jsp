<%-- 
    Document   : listaLibros
    Created on : 13/08/2019, 10:30:26 AM
    Author     : Usuario
--%>
<link rel="stylesheet" href="https://bootswatch.com/4/cerulean/bootstrap.css" media="screen">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<sj:head jqueryui="true" jquerytheme="blitzer" locale="es"></sj:head>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>lista libros</title>
    </head>
    <body>
        <div class="container">
            <table class="table table-hover">
                <thead >
                    <tr>
                        <td scope="col">Id</td>
                        <td scope="col">Nombre</td>
                        <td scope="col">Autor</td>
                        <td scope="col">Genero</td>
                        <td scope="col">Descripcion</td>
                        <td scope="col">Acciones</td>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="listaLibro">
                            <tr>
                                <td scope="row"><s:property value="id" /></td>
                                <td><s:property value="nombre" /></td>
                                <td><s:property value="autor" /></td>
                                <td><s:property value="genero" /></td>
                                <td><s:property value="descripcion" /></td>
                                <td>
                                    <sj:submit formIds="%{id}_eliminar" value="Eliminar" cssClass="btn btn-danger" />
                                    <sj:submit formIds="%{id}_editar" value="Editar" cssClass="btn btn-success" />                                    
                                    <sj:submit formIds="%{id}_ver" value="Ver" cssClass="btn btn-info" />
                                </td>
                            <tr>    
                            <tr style="display:none;">
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td>
                                    <s:form id="%{id}_editar" action="editarLibro.action">
                                        <s:hidden name="idLibro" value="%{id}"/>
                                        <s:hidden name="libro.nombre" value="%{nombre}"/>
                                        <s:hidden name="libro.autor" value="%{genero}"/>
                                        <s:hidden name="libro.genero" value="%{autor}"/>
                                        <s:hidden name="libro.descripcion" value="%{descripcion}"/>
                                        <s:hidden name="libro.imagen" value="%{imagen}"/>
                                    </s:form>
                                    <s:form id="%{id}_eliminar" action="eliminarLibro.action">
                                        <s:hidden name="idLibro" value="%{id}"/>
                                    </s:form>
                                    <s:form id="%{id}_ver" action="obtenerLibro.action">
                                        <s:hidden name="idLibro" value="%{id}"/>
                                    </s:form>
                                </td>
                            </tr>
                    </s:iterator>
                </tbody>
            </table>
        </div>       

    </body>
</html>

