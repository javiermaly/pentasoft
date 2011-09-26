<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<f:subview id="header">
	<%@include file="header.jsp"%>
</f:subview>
<h:form>
		<h1>Reporte de Tareas por Usuario</h1>
		<p>Todas las Tareas que un Técnico pasó al estado Finalizada</p>
		<table>
			<tr>
				<td><h:outputText>Cédula del Técnico </h:outputText>
				</td>
				<td><h:inputText id="cedula" value="#{UsuariosBean.cedula}"	required="true"><f:validateLength  maximum="8"></f:validateLength>
						<f:converter converterId="javax.faces.Long"/></h:inputText></td>
						<h:message for="cedula" style="color:red"></h:message>						
				<td><h:commandButton value="Aceptar" action="#{UsuariosBean.buscarUsuario}"></h:commandButton>
				</td>
			</tr>
		</table>
</h:form>
<h:form rendered="#{UsuariosBean.evento==3}">
		<table border="1">
			<tr>
				<th> No existe un Tecnico con esa cedula!</th>
			</tr>
		</table>
</h:form>
<h:form rendered="#{UsuariosBean.evento==4}">
	
	<center>
			<h2>Lista de Tareas</h2>

			<h:dataTable value="#{TareaBean.listadoTareasFinalizadasTecnico}"
				var="tarea" border="1">
				<h:column>
					<f:facet name="header">
						<h:outputText id="idTarea" value="Id"></h:outputText>
					</f:facet>
					<h:outputText value="#{tarea.id}"></h:outputText>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Prioridad"></h:outputText>
					</f:facet>
					<h:outputText value="#{tarea.prioridad}"></h:outputText>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Es Externa"></h:outputText>
					</f:facet>
					<h:selectBooleanCheckbox disabled="true" value="#{tarea.esExterna}"></h:selectBooleanCheckbox>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Descripcion"></h:outputText>
					</f:facet>
					<h:outputText value="#{tarea.descripcion}">
					</h:outputText>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Observacion"></h:outputText>
					</f:facet>
					<h:outputText value="#{tarea.observacion}">
					</h:outputText>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Fecha Apertura"></h:outputText>
					</f:facet>
					<h:outputText value="#{tarea.fechaApertura.time}">
						<f:convertDateTime type="both" dateStyle="short"
							pattern="yyyy/MM/dd" />

					</h:outputText>
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputText value="Fecha Comprometida"></h:outputText>
					</f:facet>
					<h:outputText value="#{tarea.fechaComprometida.time}">
						<f:convertDateTime type="both" dateStyle="short"
							pattern="yyyy/MM/dd" />
					</h:outputText>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Tipo"></h:outputText>
					</f:facet>
					<h:outputText value="#{tarea.tipo.descripcion}">
					</h:outputText>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="ACCIÓN"></h:outputText>
					</f:facet>
					<h:commandLink value="Cerrar" action="#{TareaBean.pasarPamCerrarTarea}"> 
						<f:param id="idTareaCerrar" name="idTareaCerrar" value="#{tarea.id}" /> 
					</h:commandLink>				
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="ACCIÓN"></h:outputText>
					</f:facet>
					<h:commandLink value="Re-Abrir" action="#{TareaBean.pasarPamReabrirTarea}"> 
						<f:param id="idTareaReAbrir" name="idTareaReAbrir" value="#{tarea.id}" /> 
					</h:commandLink>

				
				</h:column>

			</h:dataTable>
		</center>


</h:form>	
</f:view>

</div>
</body>
</html>