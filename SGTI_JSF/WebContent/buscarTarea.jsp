<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>



<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>
	<h:form>
		<h1>Buscar Tarea</h1>
		<table>
			<tr>
				<td><h:outputText> Identificador de la tarea:  </h:outputText>
				</td>
				<td><h:inputText id="id" value="#{TareaBean.id}"
						required="true">
						<f:validateLength minimum="1" maximum="15"></f:validateLength>
						<f:converter converterId="javax.faces.Long" />
					</h:inputText>
				</td>
				
				<h:message for="id" style="color:red"></h:message>
				<td><h:commandButton value="Aceptar"
						action="#{TareaBean.buscarTarea}"></h:commandButton></td>
			</tr>
		</table>
	</h:form>

	<h:form rendered="#{TareaBean.evento==4}">
		<table border="1">
			<tr>
				<th>Cliente:</th>
				<td><h:outputText
						value="#{TareaBean.cliente.nombre_RazonSocial}"></h:outputText>
				</td>
			</tr>

			<tr>
				<th>Prioridad:</th>
				<td><h:outputText value="#{TareaBean.prioridadStr}"></h:outputText>
				</td>
			</tr>
			<tr>
				<th>Externa:</th>
				<td><h:selectBooleanCheckbox disabled="true"
						value="#{TareaBean.esExterna}"></h:selectBooleanCheckbox></td>
			</tr>
			<tr>
				<th>Descripcion:</th>
				<td><h:outputText value="#{TareaBean.descripcion}"></h:outputText>
				</td>
			</tr>
			<tr>
				<th>Observaciones: </th>
				<td><h:outputText value="#{TareaBean.observacion}"></h:outputText>
				</td>
			</tr>
			<tr>
				<th>Fecha Apertura: </th>
				<td><h:outputText value="#{TareaBean.fechaApertura.time}">
   						 	<f:convertDateTime type="both" dateStyle="short" pattern="yyyy/MM/dd" />
							</h:outputText>
				</td>
			</tr>
			<tr>
				<th>Fecha Comprometida: </th>
				<td><h:outputText value="#{TareaBean.fechaComprometida.time}">
   						 	<f:convertDateTime type="both" dateStyle="short" pattern="yyyy/MM/dd" />
							</h:outputText>
				</td>
			</tr>
			<tr>
				<th>Tipo: </th>
				<td><h:outputText value="#{TareaBean.tipoTarea.descripcion}"></h:outputText>
				</td>
			</tr>
			<tr>
				<th>Estado: </th>
				<td><h:outputText value="#{TareaBean.tiene.estado.descripcion}"></h:outputText>
				</td>
			</tr>
			<tr>
				<th>Fecha Cierre: </th>
				<td><h:outputText value="#{TareaBean.fechaCierre.time}">
   						 	<f:convertDateTime type="both" dateStyle="short" pattern="yyyy/MM/dd" />
							</h:outputText>
				</td>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{TareaBean.evento==3}">
		<table border="1">
			<tr>
				<th>La tarea ingresada no existe!!!</th>
			</tr>
		</table>
	</h:form>
<f:subview id="footer">
	<%@include file="footer.jsp"%>		
</f:subview>
</f:view>




