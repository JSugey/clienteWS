<%-- 
    Document   : busca
    Created on : 15/08/2019, 11:37:18 AM
    Author     : Usuario
--%>
<link rel="stylesheet" href="https://bootswatch.com/4/cerulean/bootstrap.css" media="screen">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1><s:property value="titulo" /></h1>
            <s:form action="guardarLibro" width="800">
                <s:hidden name="libro.id" value="%{idLibro}"/>
                <s:textfield name="libro.nombre" value="%{libro.nombre}" label="Nombre" cssClass="form-control" cssStyle="width:100%" />
                <s:textfield name="libro.autor" value="%{libro.autor}" label="Autor" cssClass="form-control" />
                <s:textfield name="libro.genero" value="%{libro.genero}" label="Genero" cssClass="form-control" />
                <s:textarea name="libro.descripcion" value="%{libro.descripcion}" label="Descripcion" cssClass="form-control" />
                <s:textfield name="libro.imagen" value="%{libro.imagen}" label="Imagen" cssClass="form-control"/>
                <s:submit cssClass="btn btn-success" value="Guardar" />
            </s:form>
        </div>
        
    </body>
</html>
