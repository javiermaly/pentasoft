<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>


	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>

	<h:form id="listdado" rendered="#{UsuarioBean.perfil==2}">

		<center>
			<h1>Listado de tareas</h1>

			<h:dataTable value="#{TareaBean.listadoTareasFinalizadasNoCerradas}"
				var="tarea" border="1">
				<h:column>
					<f:facet name="header">
						<h:outputText id="idTarea" value="Id"></h:outputText>
					</f:facet>
					<h:outputText value="#{tarea.id}"></h:outputText>
				</h:column>
				<%--   					<h:column> --%>
				<%--   						<f:facet name="header"> --%>
				<%--   						<h:outputText value="Cliente"></h:outputText> --%>
				<%--   						</f:facet> --%>
				<%--   							<h:outputText value="#{tarea.cliente_cedRut}"></h:outputText> --%>
				<%--   					</h:column>              --%>
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
						<h:outputText value="ACCI�N"></h:outputText>
					</f:facet>
					<h:commandLink value="Cerrar" target="loginOK.jsf" action="#{TareaBean.cerrarTareaDesdeListado}"> 
						<f:param id="idTareaBoton" name="idTareaBoton" value="#{tarea.id}" /> 
					</h:commandLink>				
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="ACCI�N"></h:outputText>
					</f:facet>
					<h:commandLink value="Re-Abrir" target="loginOK.jsf" action="#{TareaBean.reabrirTareaDesdeListado}"> 
						<f:param id="idTareaReAbrir" name="idTareaReAbrir" value="#{tarea.id}" /> 
					</h:commandLink>

				
				</h:column>

			</h:dataTable>
		</center>
	</h:form>

	<h:form id="listadoEncargado" rendered="#{UsuarioBean.perfil==3}">

		<center>
			<h1>Listado de Tareas de su Grupo para Asignar a los T�cnicos</h1>

			<h:dataTable value="#{TareaBean.listadoTareasAbiertas}"	var="tarea" border="1">
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
					<f:facet name="header" >
						<h:outputText value="ACCI�N" ></h:outputText>
					</f:facet>
					<h:commandLink value="Asignar" action="#{TareaBean.pasarPamAsignarTarea}">
						<f:param  id="idTareaAsignar" name="idTareaAsignar" value="#{tarea.id}"></f:param>
					</h:commandLink>	
				</h:column>			
			</h:dataTable>
		</center>
		
		<center>
			<h1>Listado de Tareas a Trabajar</h1>

			<h:dataTable value="#{TareaBean.listadoTareasAsignadas}"	var="tarea" border="1">
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
						<h:outputText value="ACCI�N"></h:outputText>
					</f:facet>
					<h:commandLink value="Tomar" action="#{TareaBean.pasarPamTomarTarea}"> 
						<f:param  id="idTareaTomar" name="idTareaTomar" value="#{tarea.id}" /> 
					</h:commandLink>				
				</h:column>

			</h:dataTable>
		</center>
	

		
		
		<center>
			<h1>Listado de Tareas a Finalizar o Derivar </h1>

			<h:dataTable value="#{TareaBean.listTareasEnProcesoTecnico}"	var="tarea" border="1">
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
					<f:facet name="header" >
						<h:outputText value="ACCI�N" ></h:outputText>
					</f:facet>
					<h:commandLink value="Finalizar" action="#{TareaBean.pasarPamFinalizarTarea}">
						<f:param  id="idTareaFinalizar" name="idTareaFinalizar" value="#{tarea.id}"></f:param>
					</h:commandLink>	
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="ACCI�N"></h:outputText>
					</f:facet>
					<h:commandLink value="Derivar" action="#{TareaBean.pasarPamDerivarTarea}"> 
						<f:param  id="idTareaDerivar" name="idTareaDerivar" value="#{tarea.id}" /> 
					</h:commandLink>				
				</h:column>

			</h:dataTable>
		</center>
	</h:form>



</f:view>

</div>
</body>
</html>