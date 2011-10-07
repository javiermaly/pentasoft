<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>



<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
		</f:subview>
	<h:form>
		<h1>Modificar Tarea</h1>
		<table>
			<tr>
				<td><h:outputText> Id de tarea: </h:outputText>
				</td>
				<td><h:inputText id="id" value="#{TareaBean.id}" required="true">
					<f:validateLength minimum="1"></f:validateLength>
					<f:converter converterId="javax.faces.Long"/></h:inputText>
				</td>		
				
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
				<th>Id Tarea</th>
				<td>
				<h:inputText id="id" value="#{TareaBean.id}"
						readonly="true" /> <h:inputHidden value="#{TareaBean.id}"></h:inputHidden>
				</td>
			</tr>
					<tr>
						<th>Prioridad: </th>
						<td><h:selectOneRadio id="prioridad" required="true" value="#{TareaBean.prioridad}">
							<f:selectItem itemValue="1" itemLabel="Alta"/>
							<f:selectItem itemValue="2" itemLabel="Media"/>
							<f:selectItem itemValue="3" itemLabel="Baja"/>
							</h:selectOneRadio>
							<h:message for="prioridad" style="color:red"></h:message>
						</td>
					</tr>					
					<tr>
						<th>Lugar: </th>
						<td><h:selectOneRadio value="#{TareaBean.esExterna}">
							<f:selectItem itemValue="false" itemLabel="Interna"/>
							<f:selectItem itemValue="true" itemLabel="Externa"/>
							</h:selectOneRadio>
						</td>
					</tr>
					<tr>
						<th>Tipo: </th>
						<td>
							<h:selectOneMenu id="comboTipos" value="#{TareaBean.varId}"> 					 					
								<f:selectItems value="#{TareaBean.comboTipos}"/>						
							</h:selectOneMenu>					
						</td>
					</tr>
					<tr>
						<th>Grupo Asingado: </th>
						<td>
							<h:selectOneMenu id="comboGrupos" value="#{TareaBean.grupoId}"> 					 					
								<f:selectItems value="#{TareaBean.comboGrupos}"/>						
							</h:selectOneMenu>					
						</td>
					</tr>
					<tr>
						<th>Descripcion: </th>
						<td><h:inputTextarea rows="5" cols="25" value="#{TareaBean.descripcion}"/>						
						</td>
					</tr>
					<tr>
					<th>Fecha Comprometida (año/mes/dia):</th>
	
					<td><h:inputText id="fchaComprometida" value="#{TareaBean.fechaComprometida}">
							<f:convertDateTime  pattern="yyyy/MM/dd" />
						</h:inputText>
						<h:message for="fchaComprometida" style="color:red"></h:message>
					</td>
						
					</tr>
					<tr>
						<td colspan="2" align="right"><h:commandButton value="Modificar" action="#{TareaBean.modificarTarea}"></h:commandButton></td>
					</tr>					
				</table>		
</h:form>
	<h:form rendered="#{TareaBean.evento==6}">
		<table border="1">
			<tr>
				<th> Tarea modificada con exito!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{TareaBean.evento==2}">
		<table border="1">
			<tr>
				<th> Error al modificar!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{TareaBean.evento==3}">
		<table border="1">
			<tr>
				<th>La Tarea no existe!!!</th>
			</tr>
		</table>
	</h:form>
<f:subview id="footer">
	<%@include file="footer.jsp"%>		
</f:subview>
</f:view>




