<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<f:subview id="header">
	<%@include file="header.jsp"%>
</f:subview>

<h:form>
	<h1>Reporte de Tareas que pasaron la fecha comprometida</h1>
	<p>Todas las Tareas que no cumplieron con la fecha comprometida de finalizaci�n, en un determinado periodo de tiempo</p>
	<table>
			<tr>
				<th>Fecha Inicial (a�o/mes/dia):</th>
				<td><h:inputText id="fchaInicial" value="#{ReportesBean.fechaUno}">
						<f:convertDateTime  pattern="yyyy/MM/dd" />
					</h:inputText>
				</td>
					<h:message for="fchaInicial" style="color:red"></h:message>
			</tr>
			<tr>
				<th>Fecha Final (a�o/mes/dia):</th>
				<td><h:inputText id="fchaFinal" value="#{ReportesBean.fechaDos}">
						<f:convertDateTime  pattern="yyyy/MM/dd" />
					</h:inputText>
				</td>
					<h:message for="fchaFinal" style="color:red"></h:message>
			</tr>
			<tr>
				<td></td>
				<td>
					<h:commandButton value="Buscar" action="#{ReportesBean.tareasNoComprometidas}"></h:commandButton>
				</td>
			</tr>
		</table>
</h:form>	
	
<h:form rendered="#{ReportesBean.fechaUno!=null}">	
	<center>
			<h2>Lista de Tareas</h2>
			<h:dataTable value="#{ReportesBean.reporteTareasNoComprometidas}"
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
						<h:outputText value="Fecha Cierre"></h:outputText>
					</f:facet>
					<h:outputText value="#{tarea.fechaCierre.time}">
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
<f:subview id="footer">
	<%@include file="footer.jsp"%>		
</f:subview>
</f:view>

