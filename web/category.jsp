<%-- 
    Document   : category
    Created on : 2/01/2015, 12:18:16 PM
    Author     : Toni
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.*" %>
<%@page import="java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/categorias.css">
        <link rel="stylesheet" type="text/css" href="css/admin.css">
        <link rel="stylesheet" type="text/css" href="css/articulos.css">
        <title>Index</title>
    </head>
    <body>
        <div class="contenedor">
            <hr id="row">
            
                <!-- HEADER -->
            <div class="header">
                <hr id="internal-row">
                <div class="clear"></div>
                <div class="logo"></div>
                <div id="vertical"></div>
                <div class="menu-header-admin">
                    <div class="user">
                        <div class="bienvenida">
                            <a href="#">Bienvenido Administrador</a>
                        </div>
                    </div>
                    <div class="options">
                        <ul id="menu">
                            <li><a href="users.jsp">Usuarios</a></li>
                            <li><a href="category.jsp">Categorias</a></li>
                            <li><a href="articulos.jsp">Articulos</a></li>
                            <li><a href="sales.jsp">Ventas</a></li>
                        </ul>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            
            <div class="div-header"></div>
            
                <!-- CONTENIDO -->
           
            <div class="contenido">
                <div id="superior">
                    <div id="marco">
                        <div id="encabezado">
                            <p id="titulo">
                                <span>Categorias</span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="main-admin">
                    <a href="#" id="agregar">Agregar Categoría</a>
                    <br />
                    <table>
                        <th>Código Categoria <hr id="row"></th>
                        <th>Nombre Categoría <hr id="row"></th>
                        <th>Opciones <hr id="row"></th>
                        <%
                            ArrayList<CategoriaArticulo> lista = CategoriaDB.obtenerCategoria();
                            for (CategoriaArticulo categoria : lista) {
                        %>
                        <tr>
                            <td><%= categoria.getId()%></td>
                            <td><%= categoria.getNombre()%></td>
                            <td><a href="actualizarCategoria.jsp?id=<%= categoria.getId()%>"><img src="img/edit.png"></a>
                                <a href="eliminarCategoria.jsp?id=<%= categoria.getId()%>"><img src="img/delete.png"></a>
                                <img src="img/detalle.png"></td>
                        </tr>
                       <%
                            }
                %>
                    </table>
                </div>
                <div id="division"></div>
                 
                <!-- Contenido -->
            </div>
            
                <!-- FOOTER -->
            <div class="div-footer"></div>
            
            <div class="footer">
                <div class="sign"></div>
                <div id="vertical"></div>
            </div>
            <hr id="row">
            
            <hr id="internal-row">
            
            <div id="division"></div>
        </div>
    </body>
</html>
