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
				<td><h:inputText id="cedrut" value="#{ClienteBean.cedRut}" required="true">
					<f:validateLength maximum="15"></f:validateLength>
					<f:converter converterId="javax.faces.Long"/></h:inputText>
				</td>		
				
					<h:message for="cedrut" style="color:red"></h:message>
			
				<td><h:commandButton value="Aceptar"
						action="#{ClienteBean.buscarCliente}"></h:commandButton>
				</td>
			</tr>
		</table>
	</h:form>

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
				<th>Cédula / RUT: </th>
				<td><h:inputText id="cedrut" value="#{ClienteBean.cliSession.clienteSession.cedRut}" readonly="true" required="true">
					<f:validateLength maximum="15"></f:validateLength>
					<f:converter converterId="javax.faces.Long"/></h:inputText>
				</td><h:message for="cedrut" style="color:red"></h:message>
			</tr>
			<tr>
				<th>Nombre Completo / Razón Social:</th>
				<td><h:inputText value="#{ClienteSession.clienteSession.nombre_RazonSocial}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Dirección:</th>
				<td><h:inputText value="#{ClienteSession.clienteSession.direccion}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Teléfono</th>
					<td><h:inputText id="telefono" value="#{ClienteSession.clienteSession.telefono}">
							<f:converter converterId="javax.faces.Integer"/>							
						</h:inputText>
						<h:message for="telefono" style="color:red"></h:message>												
					</td>		
			</tr>							
			<tr>
				<th>Fecha fin de Garantia (año/mes/dia)</th>
					<td><h:inputText id="fchaGarantia" value="#{ClienteSession.fechaGarant}">
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



