<%@include file="header.jsp" %>
<%@page import="com.emergentes.modelo.Cliente"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Cliente lib = (Cliente) request.getAttribute("lib");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><c:if test="${lib.id==0}">
                Nuevo Registro
            </c:if>
            <c:if test="${lib.id!=0}">
                Editar registro
            </c:if>
        </h1>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="well well-sm">
                        <form class="form-horizontal" action="MainController" method="post">
                            <input  type="hidden" name="id" value="${lib.id}">
                            <fieldset>
                                <div class="form-group mb-3">
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                                    <div class="col-md-8">
                                        <input id="fname" name="nombre" type="text" placeholder="Nombre" value="${lib.nombre}"class="form-control">
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                                    <div class="col-md-8">
                                        <input id="lname" name="apellido" type="text" placeholder="Apellido" value="${lib.apellido}" class="form-control">
                                    </div>
                                </div>

                                <div class="form-group mb-3">
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
                                    <div class="col-md-8">
                                        <input id="email" name="correo" type="text" placeholder="Correo" value="${lib.correo}" class="form-control">
                                    </div>
                                </div>

                                <div class="form-group mb-3">
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-phone-square bigicon"></i></span>
                                    <div class="col-md-8">
                                        <input id="phone" name="telefono" type="text" placeholder="Telefono" value="${lib.telefono}" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-phone-square bigicon"></i></span>
                                    <div class="col-md-8">
                                        <input id="phone" name="saldo" type="text" placeholder="Saldo" value="${lib.saldo}" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-1 text-center">
                                        <button type="submit" class="btn btn-primary btn-lg">Enviar</button>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
