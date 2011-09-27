<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<f:subview id="header">
	<%@include file="header.jsp"%>
</f:subview>
<h:form>
		<h1>Reporte de Tareas Finalizadas</h1>
		<p>Todas las Tareas que un T�cnico pas� al estado Finalizada</p>
		<table>
			<tr>
				<td><h:outputText>C�dula del T�cnico </h:outputText>
				</td>
				<td><h:inputText id="cedula" value="#{ReportesBean.cedula}"	required="true">
						<f:validateLength  maximum="8"></f:validateLength>
						<f:converter converterId="javax.faces.Long"/></h:inputText></td>
						<h:message for="cedula" style="color:red"></h:message>						
				<td><h:commandButton value="Aceptar" action="#{ReportesBean.buscarUsuario}"></h:commandButton>
				</td>
			</tr>
		</table>
</h:form>
<h:form rendered="#{ReportesBean.evento==3}">
		<table border="1">
			<tr>
				<th> No existe un Tecnico con esa cedula!</th>
			</tr>
		</table>
</h:form>
<h:form rendered="#{ReportesBean.evento==4}">
	
	<center>
			<h2>Lista de Tareas</h2>

			<h:dataTable value="#{ReportesBean.reporteTareasFinalizadasTecnico}"
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
		
			</h:dataTable>
		</center>


</h:form>	
</f:view>

</div>
</body>
</html>