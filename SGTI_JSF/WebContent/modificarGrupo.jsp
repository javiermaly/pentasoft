
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%-- <%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>   --%>
<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>


	
		<h:form id="formBuscarGrupo">
		<h1>Modificar Grupo</h1>
		<table>
			<tr>
				<td><h:outputText>Id del grupo a modificar</h:outputText>
				</td>
				<td><h:inputText id="id" value="#{GrupoBean.id}" required="true">
					<f:validateLength minimum="1" maximum="4"></f:validateLength>
					<f:converter converterId="javax.faces.Long"/></h:inputText>
				</td>		
				
					<h:message for="id" style="color:red"></h:message>
			
				<td><h:commandButton value="Aceptar"
						action="#{GrupoBean.buscarGrupo}"></h:commandButton>
				</td>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{GrupoBean.evento==4}">
		<table border="1" >
		<tr>
				<th>Id Grupo</th>
				<td>
				<h:inputText id="id" value="#{GrupoBean.id}" ></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Descripción</th>
				<td>
				<h:inputText id="descripcion" value="#{GrupoBean.descripcion}" ></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Encargado</th>
				<td>
					<h:selectOneMenu id="comboEncargadosHabilitados" value="#{GrupoBean.encargadoSeleccionado}"> 					 					
						<f:selectItems value="#{GrupoBean.encargadosHabilitados}"/>
								
					</h:selectOneMenu>					
				</td>
			</tr>
			<tr>
				<td><h:commandButton value="Aceptar" action="#{GrupoBean.modificarGrupo}"></h:commandButton></td>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{GrupoBean.evento==1 }">
		<table border="1">
			<tr>
				<th> Grupo modificado con exito!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{GrupoBean.evento==3}">
		<table border="1">
			<tr>
				<th> Grupo no encontrado!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{GrupoBean.evento==6}">
		<table border="1">
			<tr>
				<th> Error al modificar el grupo!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{GrupoBean.evento==5}">
		<table border="1">
			<tr>
				<th> Error al modificar el grupo!!!</th>
			</tr>
		</table>
	</h:form>
	

</f:view>
</body>
</html>
