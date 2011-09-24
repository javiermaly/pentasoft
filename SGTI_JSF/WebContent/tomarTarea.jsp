<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>



<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>
	<h:form rendered="#{TareaBean.id !=null}">
		<h1>Buscar Tarea</h1>
		<table>
			<tr>
				<td><h:outputText> Identificador de la tarea:  </h:outputText>
				</td>
				<td><h:inputText id="id" value="#{TareaBean.id}"
						required="true">
						<f:validateLength minimum="1" maximum="15"></f:validateLength>
						<f:converter converterId="javax.faces.Long" />
					</h:inputText></td>

				<h:message for="id" style="color:red"></h:message>
				<td><h:commandButton value="Aceptar"
						action="#{TareaBean.buscarTarea}"></h:commandButton>
				</td>
			</tr>
		</table>
	</h:form>

	<h:form rendered="#{TareaBean.evento==4}">
		<table border="1">
			<tr>
				<th>Id:</th>
				<th><h:inputText id="id" value="#{TareaBean.id}"
						readonly="true" /> <h:inputHidden value="#{TareaBean.id}"></h:inputHidden>
	</th>
			</tr>
			<tr>
				<th>Cliente:</th>
				<th><h:outputText
						value="#{TareaBean.cliente.nombre_RazonSocial}"></h:outputText></th>
			</tr>

			<tr>
				<th>Prioridad:</th>
				<th><h:outputText value="#{TareaBean.prioridad}"></h:outputText>
				</th>
			</tr>
			<tr>
				<th>Externa:</th>
				<th><h:selectBooleanCheckbox disabled="true"
						value="#{TareaBean.esExterna}"></h:selectBooleanCheckbox>
				</th>
			</tr>
			<tr>
				<th>Descripción:</th>
				<th><h:outputText value="#{TareaBean.descripcion}"></h:outputText>
				</th>
			</tr>
			<tr>
				<th>Observaciones:</th>
				<th><h:inputTextarea rows="5" cols="25" required="true"
						value="#{TareaBean.observacion}"></h:inputTextarea></th>
			</tr>
			<tr>
				<th>Fecha Apertura:</th>
				<th><h:outputText value="#{TareaBean.fechaApertura.time}">
						<f:convertDateTime type="both" dateStyle="short"
							pattern="yyyy/MM/dd" />
					</h:outputText></th>
			</tr>
			<tr>
				<th>Fecha Comprometida:</th>
				<th><h:outputText value="#{TareaBean.fechaComprometida.time}">
						<f:convertDateTime type="both" dateStyle="short"
							pattern="yyyy/MM/dd" />
					</h:outputText></th>
			</tr>
			<tr>
				<th>Tipo:</th>
				<th><h:outputText value="#{TareaBean.tipoTarea.descripcion}"></h:outputText>
				</th>
			</tr>
			<tr>
				<th>Estado:</th>
				<th><h:outputText value="#{TareaBean.tiene.estado.descripcion}"></h:outputText>
				</th>
			</tr>
			<tr>
				<th>Fecha Cierre:</th>
				<th><h:outputText value="#{TareaBean.fechaCierre.time}">
						<f:convertDateTime type="both" dateStyle="short"
							pattern="yyyy/MM/dd" />
					</h:outputText></th>
			</tr>
			<tr>
				<td colspan="2" align="left"><h:commandButton value="Aceptar"
						action="#{TareaBean.tomarTarea}"></h:commandButton>
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
				<th>Tarea EN PROCESO</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{TareaBean.evento==3}">
		<table border="1">
			<tr>
				<th>La tarea ingresada no existe en el sistema!!!</th>
			</tr>
		</table>
	</h:form>

</f:view>
</body>
</html>



