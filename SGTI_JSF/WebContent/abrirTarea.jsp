
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
				<td><h:outputText> Cedula o RUT del Cliente </h:outputText></td>
				<td><h:inputText id="cedrut" value="#{ClienteBean.cedRut}" required="true" maxlength="15"  >
					<f:converter converterId="javax.faces.Integer"/></h:inputText>
				</td>
					<h:message for="cedrut" style="color:red"></h:message>
				<td><h:commandButton  value="Aceptar" action="#{ClienteBean.buscarCliente}"></h:commandButton></td>
			</tr>
		</table>
</h:form>
	<h:form rendered="#{TareaBean.evento==1}">
		<table border="1">
			<tr>
				<th bgcolor="green"> Tarea Abierta con exito!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{TareaBean.evento==2}">
		<table border="1">
			<tr>
				<th> Error al abrir la Tarea!!!</th>
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
<h:form>	
		<h1>Abrir Tarea</h1>			
				<table border="1">
					<tr>
						<th>Cliente: </th><td><h:outputText value="#{ClienteSession.clienteSession.nombre_RazonSocial}" ></h:outputText></td>
					</tr>
					<tr>
						<th>Prioridad: </th>
						<td><h:selectOneRadio value="#{TareaBean.prioridad}">
							<f:selectItem itemValue="1" itemLabel="Alta"/>
							<f:selectItem itemValue="2" itemLabel="Media"/>
							<f:selectItem itemValue="3" itemLabel="Baja"/>
							</h:selectOneRadio>
						</td>
					</tr>					
					<tr>
						<th>Lugar: </th>
						<td><h:selectOneRadio value="#{TareaBean.esExterna}">
							<f:selectItem itemValue="false" itemLabel="Interna"/>
							<f:selectItem itemValue="true" itemLabel="Externa"/>
							</h:selectOneRadio>
						</td>
					</tr>
					<tr>
						<th>Tipo: </th>
						<td>
							<h:selectOneMenu id="comboTipos" value="#{TareaBean.tipoId}"> 					 					
								<f:selectItems value="#{TareaBean.comboTipos}"/>						
							</h:selectOneMenu>					
						</td>
					</tr>
					<tr>
						<th>Grupo Asingado: </th>
						<td>
							<h:selectOneMenu id="comboGrupos" value="#{TareaBean.grupoId}"> 					 					
								<f:selectItems value="#{TareaBean.comboGrupos}"/>						
							</h:selectOneMenu>					
						</td>
					</tr>
					<tr>
						<th>Descripcion: </th>
						<td><h:inputTextarea rows="5" cols="25" value="#{TareaBean.descripcion}"/>						
						</td>
					</tr>
					<tr>
						<th>Observacion: </th>
						<td><h:inputTextarea rows="5" cols="25" value="#{TareaBean.observacion}"/>						
						</td>
					</tr>					
					<tr>
						<th>Fecha Comprometida(año/mes/dia)</th>
						<td><h:inputText id="fechaComprometida"  value="#{TareaBean.fechaComprometida}">
							<f:convertDateTime pattern="yyyy/MM/dd"/>
							</h:inputText> <h:message for="fechaComprometida" style="color:red"></h:message>
						</td>
						
					</tr>
					<tr>
						<td><h:commandButton value="Aceptar" action="#{TareaBean.abrirTarea}"></h:commandButton></td>
					</tr>					
				</table>		
</h:form>

</f:view>
</body>
</html>
