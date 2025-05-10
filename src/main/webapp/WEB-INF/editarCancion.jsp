<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body class="bg panel col gap pad acenter">
    <form:form class="panel col gap pad" action="/canciones/procesa/editar/${cancion.id}" method="POST" modelAttribute="cancion">

        <input type="hidden" name="_method" value="PUT"/>

        <div class="inputBox">
            <form:label path = "titulo">Titulo:</form:label>
            <form:input path = "titulo"></form:input>
            <form:errors path = "titulo"></form:errors>
        </div>
        
        <div class="inputBox">
            <form:label path = "artista">Artista</form:label>
            <form:input path = "artista"></form:input>
            <form:errors path = "artista"></form:errors>

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
        <button type="submit" class="btn"> Actualizar </button>
    </form:form>
    <a class="btn" href="/canciones">Volver</a>
</body>
</html>