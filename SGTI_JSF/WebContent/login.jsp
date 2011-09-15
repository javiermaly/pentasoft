<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	
	<title>Login Page</title>
	
	<link rel="shortcut icon" href="/favicon.ico">
	<link rel="stylesheet" type="text/css" href="style.css" />
</head>

<body>
<f:view>
	<h:form>
		<fieldset>
		
			<legend>Log in</legend>
			
			<label for="login">Cedula</label>
			<h:inputText id="cedula" value="#{LoginBean.cedula}" required="true"></h:inputText>
			<div class="clear"></div>
			
			<label for="password">Password</label>
			<h:inputText  id="pwd" value="#{LoginBean.pwd}" required="true"></h:inputText>
			<div class="clear"></div>
			
			<label for="remember_me" style="padding: 0;">Remember me?</label>
			<input type="checkbox" id="remember_me" style="position: relative; top: 3px; margin: 0; " name="remember_me"/>
			<div class="clear"></div>
			
			<br/>
			<h:commandButton style="margin: -20px 0 0 287px;" value="Aceptar" action="#{LoginBean.login}"></h:commandButton>
			
		</fieldset>
	</h:form>
	</f:view>
</body>

</html>