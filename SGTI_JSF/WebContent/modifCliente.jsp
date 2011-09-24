<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>

	<h:panelGrid columns="2">

		<h:panelGroup>
			<h:outputText> Cedula o RUT del Cliente </h:outputText>
			<h:inputText id="cedrut" value="#{ClienteBean.cedRut}"
				required="true">
				<f:validateLength minimum="8" maximum="15"></f:validateLength>
				<f:converter converterId="javax.faces.Long" />
			</h:inputText>
			<h:message for="cedrut" style="color:red"></h:message>
		</h:panelGroup>
		<h:panelGroup>
			<h:commandButton value="Aceptar" action="#{ClienteBean.buscarCliente}"></h:commandButton>
		</h:panelGroup>
	</h:panelGrid>


	<h:form rendered="#{ClienteBean.evento==4}">
		<table border="1">
			<tr>
				<th>Es empresa: </th>
				<td><h:selectOneRadio value="#{ClienteSession.clienteSession.empresa}">
					<f:selectItem itemValue="true" itemLabel="Si"/>
					<f:selectItem itemValue="false" itemLabel="No"/>					
					</h:selectOneRadio>
				</td>
			</tr>
			<tr>
				<th>C�dula / RUT: </th>
				<td><h:inputText id="cedrut" value="#{ClienteBean.cedRut}" required="true">
					<f:validateLength minimum="8" maximum="15"></f:validateLength>
					<f:converter converterId="javax.faces.Long"/></h:inputText>
				</td><h:message for="cedrut" style="color:red"></h:message>
			</tr>
			<tr>
				<th>Nombre Completo / Raz�n Social:</th>
				<td><h:inputText value="#{ClienteSession.clienteSession.nombre_RazonSocial}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Direcci�n:</th>
				<td><h:inputText value="#{ClienteSession.clienteSession.direccion}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Tel�fono</th>
					<td><h:inputText id="telefono" value="#{ClienteSession.clienteSession.telefono}">
							<f:converter converterId="javax.faces.Integer"/>							
						</h:inputText>
						<h:message for="telefono" style="color:red"></h:message>												
					</td>		
			</tr>							
			<tr>
				<th>Fecha fin de Garantia</th>
				<td><h:inputText id="fchaGarantia" rendered="#{ClienteSession.fechaGarant!=null}" value="#{ClienteSession.fechaGarant}">
  						<f:convertDateTime pattern="yyyy/MM/dd"/>
  					</h:inputText>
  					<h:message for="fchaGarantia" style="color:red"></h:message>
  				</td> 
			</tr> 
			<tr>
				<td><h:commandButton value="Aceptar"action="#{ClienteBean.modificarCliente}"></h:commandButton></td>
			</tr>			
		</table>
	</h:form>

</f:view>
</body>
</html>
