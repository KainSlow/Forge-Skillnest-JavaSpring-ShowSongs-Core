<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*, java.text.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body class="panel bg col gap pad acenter">
    <h1>${cancion.titulo}</h1>
    <a href="/artistas/detalle/${cancion.artista.id}"><h3> ${cancion.artista.nombre} ${cancion.artista.apellido} </h3></a>
    <h4>${cancion.album}</h4>
    <h4>${cancion.genero}</h4>
    <h4>${cancion.idioma}</h4>
    <a class="btn" href="/canciones/formulario/editar/${cancion.id}"> Editar </a>
    <form:form action="/canciones/eliminar/${cancion.id}" method="POST">
        <input type="hidden" name="_method" value="DELETE"/>
        <button class="btn" type ="submit" > Eliminar </button>
    </form:form>
    <a class="btn" href="/canciones">Volver</a>
</body>
</html>