<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<f:view>
<f:subview id="header">
		<%@include file="header.jsp"%>
</f:subview>

	<h:form id="listCliente">
	
	<center>
            <h1>Listado de grupos</h1>
           
                <h:dataTable id="clientes" value="#{GrupoBean.listGrupos}" var="grupo" border="1" >
  					<h:column>
  						<f:facet name="header" >
  							<h:outputText value="ID"></h:outputText>
  						</f:facet>
  							<h:outputText value="#{grupo.id}"></h:outputText>
  					</h:column>
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Descripción"></h:outputText>
  						</f:facet>
  							<h:outputText value="#{grupo.descripcion}"></h:outputText>
  					</h:column>             
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Encargado"></h:outputText>
  						</f:facet>
  							<h:outputText value="#{grupo.enc.apellido}"></h:outputText>
  					</h:column>             
  					
  					  
  					
                </h:dataTable>
         </center>
         </h:form>
    </body>
</html>

</f:view>
</body>
</html>



