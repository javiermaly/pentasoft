<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>



<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>
	<h:form>
		<h1>Eliminar Grupo</h1>
		<table>
			<tr>
				<td><h:outputText> Id del grupo a eliminar </h:outputText>
				</td>
				<td><h:inputText id="id" value="#{GrupoBean.id}"
						required="true">
						<f:validateLength minimum="1" maximum="4"></f:validateLength>
						<f:converter converterId="javax.faces.Long" />
					</h:inputText>
				</td>

				<h:message for="id" style="color:red"></h:message>

				<td><h:commandButton value="Buscar"
						action="#{GrupoBean.buscarGrupo}"></h:commandButton>
				</td>
			</tr>
		</table>
	</h:form>

	<h:form rendered="#{GrupoBean.evento==4}">
		<table border="1">
			<tr>
				<th>Id:</th>
				<td><h:inputText id="id" value="#{GrupoBean.id}"
						readonly="true" /> <h:inputHidden value="#{GrupoBean.id}"></h:inputHidden>
				</td>
			</tr>
			<tr>
				<th>Descripci�n:</th>
				<td><h:outputText value="#{GrupoBean.descripcion}"></h:outputText>
				</td>
			</tr>
			<tr>
				<th>Encargado</th>
				<th><h:outputText value="#{GrupoBean.encargadoCed}"></h:outputText>
				</th>
			</tr>
			<tr>
				<td><h:commandButton value="Eliminar"
						action="#{GrupoBean.eliminarGrupo}"></h:commandButton>
				</td>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{GrupoBean.evento==1}">
		<table border="1">
			<tr>
				<th>Grupo Eliminado con exito!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{GrupoBean.evento==2}">
		<table border="1">
			<tr>
				<th>Error al eliminar el grupo!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{GrupoBean.evento==3}">
		<table border="1">
			<tr>
				<th>El grupo que intenta dar de baja no existe!!!</th>
			</tr>
		</table>
	</h:form>


</f:view>
</body>
</html>



