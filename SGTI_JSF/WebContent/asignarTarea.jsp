<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>


<f:subview id="header">
	<%@include file="header.jsp"%>
</f:subview>
<h:form >
		<table border="1">
		<th>Asingar Tarea</th>
			<tr>
				<th>Id:</th>				
				<td>
					<h:selectOneMenu id="comboTecnicos" value="#{TareaBean.comboTecnicos}"> 					 					
						<f:selectItems value="#{TareaBean.comboTecnicos}"/>								
					</h:selectOneMenu>					
				</td>
			</tr>
			<tr>
				<th>Id:</th>
				<td><h:inputText id="id" value="#{TareaBean.id}"
						readonly="true" /> <h:inputHidden value="#{TareaBean.id}"></h:inputHidden>
				</td>
			</tr>
			<tr>
				<th>Cliente:</th>
				<td><h:outputText
						value="#{TareaBean.cliente.nombre_RazonSocial}"></h:outputText></td>
			</tr>

			<tr>
				<th>Prioridad:</th>
				<td><h:outputText value="#{TareaBean.prioridad}"></h:outputText>
				</td>
			</tr>
			<tr>
				<th>Externa:</th>
				<td><h:selectBooleanCheckbox disabled="true"
						value="#{TareaBean.esExterna}"></h:selectBooleanCheckbox>
				</td>
			</tr>
			<tr>
				<th>Descripción:</th>
				<td><h:outputText value="#{TareaBean.descripcion}"></h:outputText>
				</td>
			</tr>
			<tr>
				<th>Observaciones:</th>
				<td><h:inputTextarea rows="5" cols="25" required="true"
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
				<th><h:outputText value="#{TareaBean.tipoTarea.descripcion}"></h:outputText>
				</th>
			</tr>
			<tr>
				<td colspan="2" align="left"><h:commandButton value="Aceptar"
						action="#{TareaBean.asignarTarea}"></h:commandButton>
				</td>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{TareaBean.evento==6}">
		<table border="1">
			<tr>
				<th>No se pudo cambiar el estado a la tarea!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{TareaBean.evento==5}">
		<table border="1">
			<tr>
				<th>La tarea se asignó correctamente!!!</th>
			</tr>
		</table>
	</h:form>

</f:view>


</body>
</html>