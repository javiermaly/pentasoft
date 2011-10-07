<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<f:view>
<f:subview id="header">
		<%@include file="header.jsp"%>
</f:subview>

	
	<h:form id="listdado">
	
	<center>
            <h1>Listado de usuarios</h1>
                                       
                <h:dataTable value="#{UsuariosBean.listUsuarios}" var="usuario" border="1" >
  					<h:column>
  						<f:facet name="header" >
  							<h:outputText value="Cedula"></h:outputText>
  						</f:facet>
  							<h:outputText value="#{usuario.cedula}"></h:outputText>
  					</h:column>
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Nombre"></h:outputText>
  						</f:facet>
  							<h:outputText value="#{usuario.nombre}"></h:outputText>
  					</h:column>             
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Apellido"></h:outputText>
  						</f:facet>
  							<h:outputText value="#{usuario.apellido}"></h:outputText>
  					</h:column>  
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Usuario"></h:outputText>
  						</f:facet>
  							<h:outputText value="#{usuario.usuario}"></h:outputText>
  					</h:column>  
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Teléfono"></h:outputText>
  						</f:facet>  							  							
  							<h:outputText value="#{usuario.telefono}">
   						 </h:outputText>
  					</h:column>       
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Dirección"></h:outputText>
  						</f:facet>  							  							
  							<h:outputText value="#{usuario.direccion}">
   						 </h:outputText>
  					</h:column>       
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Celular"></h:outputText>
  						</f:facet>  							  							
  							<h:outputText value="#{usuario.celular}">
   						 </h:outputText>
  					</h:column>     
  					     
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Habilitado"></h:outputText>
  						</f:facet>  					
  						<h:selectBooleanCheckbox disabled="true" value="#{usuario.habilitado}" ></h:selectBooleanCheckbox>		  							
  							
   						 
  					</h:column>  
  					
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Perfil"></h:outputText>
  						</f:facet>  							  							
  							<h:outputText value="#{usuario.perfil}">
   						 </h:outputText>
  					</h:column>       
  					
                </h:dataTable>
         </center>
         </h:form>
<f:subview id="footer">
	<%@include file="footer.jsp"%>		
</f:subview>

</f:view>




