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
            Artistas
        </caption>
        <colgroup>
            <col span="1">
            <col span="1">
        </colgroup>
        <thead>
            <tr> <a class="btn" href="/artistas/formulario/agregar">Agregar artista</a>  </tr>
            <tr>
                <th> </th>
                <th> Nombre </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${artistas}" var="artista">
            <tr>
                <td> <a class="btn small img panel col acenter" href="/artistas/formulario/editar/${artista.id}"> <img src="/img/editar.png"> <img> </a></td>
                <td> <a href="/artistas/detalle/${artista.id}">${artista.nombre} ${artista.apellido}</a> </td>
            </tr>
            </c:forEach>
        </tbody>
        <tfoot>
            <tr><td></td></tr>
        </tfoot>
    </table>
    <a class="btn" href="/canciones"> Ir a canciones</a>
</body>
</html>