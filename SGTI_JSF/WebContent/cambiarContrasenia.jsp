<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>
			<h:form>

				<h2>Cambio de contraseña</h2>

				<table>
					<tr>
						<th><label for="password1">Ingrese nueva contraseña</label></th>

						<td><h:inputSecret id="pwd" value="#{LoginBean.pwd}"
								required="true"></h:inputSecret></td>
					</tr>
					<tr>
						<th><label id="oo" for="password2">Repita contraseña</label></th>
						<td><h:inputSecret id="pwd2" value="#{LoginBean.pwd2}"
								required="true"></h:inputSecret></td>
					</tr>
					
					<tr>
						<td><h:commandButton styleClass="boton" value="Aceptar"
								action="#{LoginBean.cambioContrasenia}"></h:commandButton></td>
					</tr>

					<h:form rendered="#{LoginBean.evento==8}">
						<h3 style="color: red">
							<f:verbatim>Las contraseñas no coinciden.</f:verbatim>
						</h3>
					</h:form>
					<h:form rendered="#{LoginBean.evento==7}">
						<h3 style="color: red">
							<f:verbatim>Error al cambiar la contraseña.</f:verbatim>
						</h3>
					</h:form>
					<h:form rendered="#{LoginBean.evento==6}">
						<h3 style="color: blue">
							<f:verbatim>Contraseña cambiada con exito.</f:verbatim>
						</h3>
					</h:form>



				</table>
			</h:form>
		</f:view>
	</div>
</body>
</html>