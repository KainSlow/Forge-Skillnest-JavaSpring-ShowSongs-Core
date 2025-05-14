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
<body class= "panel bg col acenter pad gap">
    <table>
        <caption>
            Buenas canciones
        </caption>
        <colgroup>
            <col span="1">
            <col span="1">
            <col span="1">
            <col span="1">
            <col span="1">
        </colgroup>
        <thead>
            <tr> <a class="btn" href="/canciones/formulario/agregar">Agregar cancion</a>  </tr>
            <tr>
                <th> </th>
                <th> Titulo </th>
                <th> Autor </th>
                <th> Album </th>
                <th> Detalle </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${canciones}" var="cancion">
            <tr>
                <td> <a class="btn small img panel col acenter" href="/canciones/formulario/editar/${cancion.id}"> <img src="/img/editar.png"> <img> </a></td>
                <td> ${cancion.titulo} </td>
                <td> <a href="/artistas/detalle/${cancion.artista.id}"> ${cancion.artista.nombre} ${cancion.artista.apellido} </a> </td>
                <td> ${cancion.album} </td>
                <td> <a class="btn" href="/canciones/detalle/${cancion.id}">Detalles</a></td>
            </tr>
            </c:forEach>
        </tbody>
        <tfoot>
            <tr><td></td></tr>
        </tfoot>
    </table>
    <a class="btn" href="/artistas"> Ir a artistas</a>

</body>
</html>