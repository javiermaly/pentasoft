<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<f:subview id="header">
	<%@include file="header.jsp"%>
</f:subview>
<h:form >
<h1>Derivar Tarea</h1>
		<table border="1">		
			<tr>
				<th>Derivar la Tarea al Grupo: </th>				
				<td>
					<h:selectOneMenu id="comboGrupos" value="#{TareaBean.grupoId}"> 					 					
						<f:selectItems value="#{TareaBean.comboGrupos}"/>								
					</h:selectOneMenu>					
				</td>
			</tr>
			<tr>
				<th>Id:</th>
				<td><h:inputText id="id" value="#{TareaBean.id}" readonly="true" /> 
					<h:inputHidden value="#{TareaBean.id}"></h:inputHidden>
				</td>
			</tr>
			<tr>
				<th>Cliente:</th>
				<td><h:outputText
						value="#{TareaBean.cliente.nombre_RazonSocial}"></h:outputText></td>
			</tr>

			<tr>
				<th>Prioridad:</th>
				<td><h:outputText value="#{TareaBean.prioridadStr}"></h:outputText>
				</td>
			</tr>
			<tr>
				<th>Externa:</th>
				<td><h:selectBooleanCheckbox disabled="true"
						value="#{TareaBean.esExterna}"></h:selectBooleanCheckbox>
				</td>
			</tr>
			<tr>
				<th>Descripci�n:</th>
				<td><h:outputText value="#{TareaBean.descripcion}"></h:outputText>
				</td>
			</tr>
			<tr>
				<th>Observaciones:</th>
				<td><h:inputTextarea rows="5" cols="25" disabled="true"
						value="#{TareaBean.observacion}"></h:inputTextarea></td>
			</tr>
			<tr>
				<th>Fecha Apertura:</th>
				<td><h:outputText value="#{TareaBean.fechaApertura.time}">
						<f:convertDateTime type="both" dateStyle="short"
							pattern="yyyy/MM/dd" />
					</h:outputText></td>
			</tr>
			<tr>
				<th>Fecha Comprometida:</th>
				<td><h:outputText value="#{TareaBean.fechaComprometida.time}">
						<f:convertDateTime type="both" dateStyle="short"
							pattern="yyyy/MM/dd" />
					</h:outputText></td>
			</tr>
			<tr>
				<th>Tipo:</th>
				<td><h:outputText value="#{TareaBean.tipoTarea.descripcion}"></h:outputText>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><h:commandButton value="Aceptar"
						action="#{TareaBean.asignarTarea}"></h:commandButton>
				</td>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{TareaBean.evento==1}">
		<table border="1">
			<tr>
				<th>La tarea se asign� correctamente!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{TareaBean.evento==2}">
		<table border="1">
			<tr>
				<th>Error: No se pudo asingar la tarea!</th>
			</tr>
		</table>
	</h:form>

</f:view>


</body>
</html>