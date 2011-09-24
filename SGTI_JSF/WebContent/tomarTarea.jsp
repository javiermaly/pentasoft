<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>


<f:subview id="header">
	<%@include file="header.jsp"%>
</f:subview>
<h:form >
<h1>Tomar la Tarea</h1>
		<table border="1">		
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
				<td align="right"><h:commandButton value="Aceptar"
						action="#{TareaBean.tomarTarea}"></h:commandButton>
				<h:commandButton value="Cancelar" ><h:outputLink value="./SGTI_JSF//loginOK.jsp"></h:outputLink> </h:commandButton>
				</td>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{TareaBean.evento==1}">
		<table border="1">
			<tr>
				<th>Tomada la tarea correctamente, ya puede trabajar sobre ella!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{TareaBean.evento==2}">
		<table border="1">
			<tr>
				<th>Error: No se pudo Tomar la tarea!</th>
			</tr>
		</table>
	</h:form>

</f:view>

</div>
</body>
</html>