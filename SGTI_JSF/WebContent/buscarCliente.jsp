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
					<h:inputText id="cedrut" value="#{ClienteBean.cedRut}" required="true" size="15">
					<f:validateLength maximum="15"></f:validateLength>
					<f:converter converterId="javax.faces.Long"/></h:inputText>
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
				<th>Nombre o Razon Social: </th>
				<td><h:outputText value="#{ClienteSession.clienteSession.nombre_RazonSocial}"></h:outputText></td>
			</tr>
			<tr>
				<th>Direccion:</th>
				<td><h:outputText value="#{ClienteSession.clienteSession.direccion}"></h:outputText>
				</td>
			</tr>
			<tr>
				<th>Telefono</th>
				<td><h:outputText value="#{ClienteSession.clienteSession.telefono}"></h:outputText></td>
			</tr>
			<tr>
				<th>Fecha fin de Garantia</th>
 				<td><h:outputText value="#{ClienteSession.clienteSession.fechaFinGarantia.time}">
 						<f:convertDateTime pattern="dd/MM/yyyy"/>
 					</h:outputText>
 				</td> 
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
<f:subview id="footer">
	<%@include file="footer.jsp"%>		
</f:subview>
</f:view>




