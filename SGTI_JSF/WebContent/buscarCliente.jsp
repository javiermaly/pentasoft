<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>



<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>
	<h:form>
		<h1>Buscar Cliente</h1>
		<table>
			<tr>
				<td><h:outputText> Cedula o RUT del Cliente </h:outputText>
				</td>
				<td>
					<h:inputText id="cedrut" value="#{ClienteBean.cedRut}" required="true">
					<f:validateLength minimum="8" maximum="15"></f:validateLength>
					<f:converter converterId="javax.faces.Long"/></h:inputText></td>
				</td>
					<h:message for="cedrut" style="color:red"></h:message>
				<td>
					<h:commandButton value="Aceptar" action="#{ClienteBean.buscarCliente}"></h:commandButton>
				</td>
			</tr>
		</table>
	</h:form>

	<h:form rendered="#{ClienteBean.evento==4}">
		<table border="1">
			<tr>
				<th>Es empresa: </th>
				<td><h:selectOneRadio value="#{ClienteSession.clienteSession.empresa}"  readonly="true" disabled="true">
					<f:selectItem itemValue="true" itemLabel="Si"/>
					<f:selectItem itemValue="false" itemLabel="No"/>					
					</h:selectOneRadio>
				</td>
			</tr>
			<tr>
				<th>Nombre o Razón Social: </th>
				<th><h:outputText value="#{ClienteSession.clienteSession.nombre_RazonSocial}"></h:outputText></th>
			</tr>
			<tr>
				<th>Dirección:</th>
				<td><h:outputText value="#{ClienteSession.clienteSession.direccion}"></h:outputText>
				</td>
			</tr>
			<tr>
				<th>Telefono</th>
				<th><h:outputText value="#{ClienteSession.clienteSession.telefono}"></h:outputText></th>
			</tr>
			<tr>
				<th>Fecha fin de Garantia</th>
 				<th><h:outputText value="#{ClienteSession.clienteSession.fechaFinGarantia.time}">
 						<f:convertDateTime pattern="dd/MM/yyyy"/>
 					</h:outputText>
 				</th> 
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



