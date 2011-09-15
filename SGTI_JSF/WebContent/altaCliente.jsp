
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>


	<h:form>
		<h1>Alta de Cliente</h1>
		<table>
			<tr>
				<td><h:outputText> Cedula o RUT del Cliente </h:outputText></td>
				<td><h:inputText id="cedRut" value="#{ClienteBean.cedRut}" required="true">
					<f:converter converterId="javax.faces.Integer"/></h:inputText></td>
					<h:message for="cedRut" style="color:red"></h:message>
				<td><h:commandButton value="Aceptar" action="#{ClienteBean.buscarCliente}"></h:commandButton></td>
				
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{ClienteBean.nombreRazSocial == null }">
		<table border="1">
			<tr>
				<th>Es empresa: </th>
				<td><h:selectOneRadio value="#{ClienteBean.empresa}">
					<f:selectItem itemValue="true" itemLabel="Si"/>
					<f:selectItem itemValue="false" itemLabel="No"/>					
					</h:selectOneRadio>
				</td>
			</tr>
			<tr>
				<th>Cedula / RUT</th>
				<td><h:inputText value="#{ClienteBean.cliSession.clienteSession.cedRut}" required="true" readonly="true"></h:inputText>
				</td>
					<h:message for="cedRut" style="color:red"></h:message>
			</tr>

			<tr>
				<th>Nombre Completo / Razon Social:</th>
				<td><h:inputText value="#{ClienteBean.nombreRazSocial}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Direccion:</th>
				<td><h:inputText value="#{ClienteBean.direccion}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Telefono:</th>
				<td><h:inputText id="telefono" value="#{ClienteBean.telefono}">
					<f:converter converterId="javax.faces.Integer"/>
					</h:inputText>
					<h:message for="telefono" style="color:red"></h:message>					
				</td>			
			</tr>
			<tr>
				<th>Fecha de Fin de Garantia (año/mes/dia):</th>

				<td><h:inputText id="fchaGarantia" value="#{ClienteBean.fechaFinGarantia}">
						<f:convertDateTime  pattern="yyyy/MM/dd" />
					</h:inputText>
				</td>
					<h:message for="fchaGarantia" style="color:red"></h:message>
			</tr>
			<tr>
				<td><h:commandButton value="Aceptar" 
						action="#{ClienteBean.altaCliente}"></h:commandButton></td>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{ClienteBean.evento==1 }">
		<table border="1">
			<tr>
				<th> Cliente ingresado con exito!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{ClienteBean.evento==2}">
		<table border="1">
			<tr>
				<th> Error al ingresarlo!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{ClienteBean.evento==4}">
		<table border="1">
			<tr>
				<th> Cliente ya existe!!!</th>
			</tr>
		</table>
	</h:form>

</f:view>
</body>
</html>