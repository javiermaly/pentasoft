<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>



<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>
	<h:form>
		<h1>Modificar Cliente</h1>
		<table>
			<tr>
				<td><h:outputText> Cedula o RUT del Cliente </h:outputText>
				</td>
				<td><h:inputText id="cedrut" value="#{ClienteBean.cedRut}"
						required="true"></h:inputText>
				</td>
				<td><h:commandButton value="Aceptar"
						action="#{ClienteBean.buscarCliente}"></h:commandButton>
				</td>
			</tr>
		</table>
	</h:form>

	<h:form rendered="#{ClienteBean.evento==4}">
		<table border="1">
			<tr>
				<th>Cédula / RUT: </th>
				<th><h:inputText value="#{ClienteBean.cedRut}"></h:inputText></th>
			</tr>
			<tr>
				<th>Nombre Completo / Razón Social:</th>
				<td><h:inputText value="#{ClienteSession.clienteSession.nombre_RazonSocial}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Teléfono</th>
				<td><h:inputText value="#{ClienteSession.clienteSession.telefono}"></h:inputText></td>
			</tr>
				
			<tr>
				<th>Fecha fin de Garantia</th>
				<td><h:inputText rendered="#{ClienteSession.fechaGarant!=null}" value="#{ClienteSession.fechaGarant}">
  					<f:convertDateTime pattern="yyyy/MM/dd"/>
  					</h:inputText>
  				</td> 
			</tr> 
			<tr>
				<td><h:commandButton value="Aceptar"action="#{ClienteBean.modificarCliente}"></h:commandButton></td>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{ClienteBean.evento==1}">
		<table border="1">
			<tr>
				<th> Cliente modificado con exito!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{ClienteBean.evento==2}">
		<table border="1">
			<tr>
				<th> Error al modificar!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{ClienteBean.evento==3}">
		<table border="1">
			<tr>
				<th> Cliente no existe!!!</th>
			</tr>
		</table>
	</h:form>
</f:view>
</body>
</html>



