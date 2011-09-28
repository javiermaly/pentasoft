<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>



<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>
	<h:form>
		<h1>Buscar Grupo</h1>
		<table>
			<tr>
				<th><h:outputText> Identificador de grupo </h:outputText>
				</th>
				<td>
					<h:inputText id="id" value="#{GrupoBean.id}" required="true">
					<f:validateLength minimum="1" maximum="4"></f:validateLength>
					<f:converter converterId="javax.faces.Long"/></h:inputText>
				</td>
					<h:message for="id" style="color:red"></h:message>
				<td>
					<h:commandButton value="Buscar" action="#{GrupoBean.buscarGrupo}"></h:commandButton>
				</td>
			</tr>
		</table>
	</h:form>

	<h:form rendered="#{GrupoBean.evento==4}">
		<table border="1">
			
			<tr>
				<th>Id: </th>
				<td><h:outputText value="#{GrupoBean.id}"></h:outputText></td>
			</tr>
			<tr>
				<th>Descripción:</th>
				<td><h:outputText value="#{GrupoBean.descripcion}"></h:outputText>
				</td>
			</tr>
			<tr>
				<th>Encargado</th>
				<td><h:outputText value="#{GrupoBean.encargadoCed}"></h:outputText></td>
			</tr>
			
		</table>
	</h:form>
	<h:form rendered="#{GrupoBean.evento==3}">
		<table border="1">
			<tr>
				<th> Grupo no existe!!!</th>
			</tr>
		</table>
	</h:form>

</f:view>
</body>
</html>



