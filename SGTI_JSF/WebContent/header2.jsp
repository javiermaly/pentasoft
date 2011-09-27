
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<style type="text/css" ></style>
<link rel="stylesheet" type="text/css" href="estilo.css" media="screen" />

<f:subview id="header">

	<h:form rendered="#{LoginBean.perfil==1}">	
		<h1>ADMINISTRADOR</h1>
			<div id="menu">
            <ul id="nav">
 
            <li><span>Clientes</span>
                <ul>
                    <li><a href="#">Buscar Cliente</a></li>
                    <li><a href="#">Alta Cliente</a></li>
                    <li><a href="#">Baja Cliente</a></li>
                    <li><a href="#">Modificación Cliente</a></li>
                    <li><a href="#">Listado de Clientes</a></li>
               </ul>
            </li>
 
            <li><span>Usuarios</span>
                <ul>
                    <li><a href="#">Buscar Usuario </a></li>
                    <li><a href="#">Alta Usuario</a></li>
                    <li><a href="#">Baja Usuario</a></li>
                    <li><a href="#">Modificación Usuario</a></li>
                    <li><a href="#">Habilitación Usuario</a></li>
                    <li><a href="#">Listado de Usuarios</a></li>
               </ul>
            </li>            
            <li><span>Grupos</span>
 
                <ul>
                  <li><a href="#">Buscar Grupo</a></li>
                  <li><a href="#">Alta Grupo</a></li>
                  <li><a href="#">Baja Grupo</a></li>
                  <li><a href="#">Modificación Grupo</a></li>
                  <li><a href="#">Listado de Grupos</a></li>
               </ul>
            </li>
        </ul>
 
    </div>
	</h:form>



</f:subview>
</head>
<body>