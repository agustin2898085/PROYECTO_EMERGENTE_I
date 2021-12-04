<%@include file="header.jsp" %>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Cliente"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");
%>
        <h1>Registro de Clientes</h1>
        <p>

            <a class="btn btn-success btn-sm" href="MainController?op=nuevo">Nuevo</a>


        </p>
        <table  id="tabla" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Correo</th>
                <th>Telefono</th>
                <th>Saldo</th>
            </tr>
            <c:forEach var="item" items="${lista}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.apellido}</td>
                    <td>${item.correo}</td>
                    <td>${item.telefono}</td>
                    <td>${item.saldo}</td>
                    
                    <td><a class="btn btn-primary  btn-sm" href="MainController?op=editar&id=${item.id}">Editar
                        </a></td>
                    <td><a class="btn btn-danger btn-sm" href="MainController?op=eliminar&id=${item.id}" onclick="
                        return(confirm('Esta seguro de eliminar'))">Eliminar</a></td>
                                       
                   
                </tr>
            </c:forEach>

        </table>

<%@include file="footer.jsp" %>