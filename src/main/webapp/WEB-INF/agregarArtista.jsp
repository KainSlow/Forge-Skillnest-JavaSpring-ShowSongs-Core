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

    <form:form class="panel col gap pad" action="/artistas/procesa/agregar" method="POST" modelAttribute="artista">

        <div class="inputBox">
            <form:label path = "nombre">Nombre</form:label>
            <form:input path = "nombre"></form:input>
            <form:errors path = "nombre"></form:errors>
        </div>
        <div class="inputBox">
            <form:label path = "apellido" for = "apellido">Apellido</form:label>
            <form:input path = "apellido"></form:input>
            <form:errors path = "apellido"></form:errors>
            
        </div>
        <div class="inputBox">
            <form:label path = "biografia">Biografía</form:label>
            <form:input type="hidden" path = "biografia" id="hidden_bio"></form:input>
            <textarea path="biografia" rows="10" onchange="onBioChange(this)"></textarea>
            <form:errors path = "biografia"></form:errors>
        </div>
        <button type="submit" class="btn"> Agregar </button>
    </form:form>

    <a class="btn" href="/artistas">Volver</a>

    <script src="/js/agregarArtista.js"></script>
</body>
</html>