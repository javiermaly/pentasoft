<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<f:subview id="header">
	<%@include file="header.jsp"%>
</f:subview>
<h:form>
		<h1>Reporte de Tareas Por Grupo</h1>
		<p>Todas las Tareas que tiene para trabajar o está trabajando un determinado grupo</p>
		<table>
			<tr>
				<td>Seleccione Grupo: </td>
				<td>
					<h:selectOneMenu id="comboGrupo" value="#{ReportesBean.grupoId}" onchange="submit()" > 					 					
						<f:selectItems value="#{ReportesBean.comboGrupos}"/>						
					</h:selectOneMenu>					
				</td>
			</tr>
		</table>
</h:form>
<h:form rendered="#{ReportesBean.grupoId!=null}">
	
	<center>
			<h2>Lista de Tareas</h2>

			<h:dataTable value="#{ReportesBean.reporteTareasPorGrupo}"
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