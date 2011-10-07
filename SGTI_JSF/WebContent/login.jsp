<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	
	<title>Ingreso al Sistema</title>
	
	<link rel="shortcut icon" href="/favicon.ico">
	<link rel="stylesheet" type="text/css" href="estilo.css" />
</head>

<body>
<body>
<div class="wrap">	

<f:view>

<div class="header">
    		<div class="logo"><img src="./images/logo.png" alt="" title="" border="0"></div>
						
</div>
<div class="clear"></div>
	<h:form>
		<fieldset>
			
			<h1>SISTEMA DE GESTION DE TAREAS INFORMATICAS</h1>
			<div class="clear"></div>			
			<h2>INGRESAR</h2>
			<div class="clear"></div>
			
			<label for="login">C&eacute;dula   -solo n&uacute;meros-</label>
			<h:inputText styleClass="login" id="cedula" value="#{LoginBean.cedula}" required="true">
				<f:converter converterId="javax.faces.Long"/></h:inputText>
				<h:message for="cedula" style="color:red"></h:message>				
			<div class="clear"></div>
			
			<label for="password">Contrase&ntilde;a</label>
			<h:inputSecret styleClass="login"  id="pwd" value="#{LoginBean.pwd}" required="true"></h:inputSecret>
				<h:message for="pwd" style="color:red"></h:message>
			<div class="clear"></div>		
			<h:form rendered="#{LoginBean.evento==3 }"><h3 style="color:red"><f:verbatim>Error: verfique cedula y/o contraseña.</f:verbatim></h3></h:form>
			
			<h:form rendered="#{LoginBean.evento==2 }"><h3 style="color:red"><f:verbatim>El usuario no esta habilitado, contacte al administrador</f:verbatim></h3></h:form>
			<br/>
			<h:commandButton styleClass="boton" value="Aceptar" action="#{LoginBean.login}"></h:commandButton>
			
			
		</fieldset>
	</h:form>
	</f:view>
</div>	
</body>
</html>