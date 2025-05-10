<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h3>${cancion.artista}</h3>
    <h4>${cancion.album}</h4>
    <h4>${cancion.genero}</h4>
    <h4>${cancion.idioma}</h4>
    <a class="btn" href="/canciones/formulario/editar/${cancion.id}"> Editar </a>
    <a class="btn" href="/canciones">Volver</a>
</body>
</html>