
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%-- <%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>   --%>
<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>


	<h:form>
		<h1>Alta de Grupo</h1>
	</h:form>
	<h:form >
		<table border="1">
			
			<tr>
				<th>Descripci�n</th>
				<td>
				<h:inputText id="descripcion" value="#{GrupoBean.descripcion}" ></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Encargado</th>
				<td>
					<h:selectOneMenu id="comboEncargadosHabilitados" value="#{GrupoBean.encargadoCed}"> 					 					
						<f:selectItems value="#{GrupoBean.encargadosSinGrupo}"/>						
					</h:selectOneMenu>					
				</td>
			</tr>
			<tr>
				<td><h:commandButton value="Aceptar" action="#{GrupoBean.altaGrupo}"></h:commandButton></td>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{GrupoBean.evento==1 }">
		<table border="1">
			<tr>
				<th> Grupo ingresado con exito!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{GrupoBean.evento==2}">
		<table border="1">
			<tr>
				<th> Error al ingresarlo!!!</th>
			</tr>
		</table>
	</h:form>
	

</f:view>
</body>
</html>
