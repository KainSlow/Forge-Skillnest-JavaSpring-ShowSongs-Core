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
    <div class="panel col gap h-pad6 acenter">
        <h1>${artista.nombre} ${artista.apellido}</h1>
        <p>
            ${artista.biografia}
        </p>

        <h3>Canciones:</h3>
        <c:forEach items="${artista.canciones}" var="cancion">
            <a href="/canciones/detalle/${cancion.id}">${cancion.titulo}</a>
        </c:forEach>

        <a class="btn" href="/artistas/formulario/editar/${artista.id}"> Editar </a>
        <form:form action="/artistas/eliminar/${artista.id}" method="POST">
            <input type="hidden" name="_method" value="DELETE"/>
            <button class="btn" type ="submit" > Eliminar </button>
        </form:form>
        <a class="btn" href="/artistas">Volver</a>
    </div>
</body>
</html>