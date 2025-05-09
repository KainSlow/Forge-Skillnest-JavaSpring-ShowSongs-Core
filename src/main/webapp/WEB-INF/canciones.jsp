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
        <thead>
            <tr>
                <th> Titulo </th>
                <th> Autor </th>
                <th> Detalle </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${canciones}" var="cancion">
            <tr>
                <td> ${cancion.titulo} </td>
                <td> ${cancion.artista} </td>
                <td> <a class="btn" href="/canciones/detalle/${cancion.id}">Detalles</a></td>
            </tr>
            </c:forEach>
        </tbody>
        <tfoot>
            <tr><td></td></tr>
        </tfoot>
    </table>
</body>
</html>