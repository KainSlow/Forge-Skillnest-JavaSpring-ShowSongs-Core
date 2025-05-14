<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body class="bg panel col acenter pad gap">

    <form:form class="panel col gap pad" action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">

        <div class="inputBox">
            <form:label path = "titulo">Titulo:</form:label>
            <form:input path = "titulo"></form:input>
            <form:errors path = "titulo"></form:errors>
        </div>
        
        <div class="inputBox">
            <form:label path = "artista" for = "id_artista">Artista</form:label>
            <select name="id_artista" id="id_artista">
                <c:forEach items="${artistas}" var="artista">
                    <option value = "${artista.id}">
                        ${artista.nombre} ${artista.apellido}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="inputBox">
            <form:label path = "album">Album</form:label>
            <form:input path = "album"></form:input>
            <form:errors path = "album"></form:errors>

        </div>
        <div class="inputBox">
            <form:label path = "genero">Género</form:label>
            <form:input path = "genero"></form:input>
            <form:errors path = "genero"></form:errors>

        </div>
        <div class="inputBox">
            <form:label path = "idioma">Idioma</form:label>
            <form:input path = "idioma"></form:input>
            <form:errors path = "idioma"></form:errors>

        </div>
        <button type="submit" class="btn"> Agregar </button>
    </form:form>

    <a class="btn" href="/canciones">Volver</a>

</body>
</html>