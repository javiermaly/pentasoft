<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<f:view>
<f:subview id="header">
		<%@include file="header.jsp"%>
</f:subview>

	<h:form id="listCliente">
	
	
	<center>
            <h1>Listado de clientes</h1>                
                
                <h:dataTable id="clientes" value="#{ClienteBean.listClientes}" var="cliente" border="1" >
  					<h:column>
  						<f:facet name="header" >
  							<h:outputText value="Cedula / RUT"></h:outputText>
  						</f:facet>
  							<h:outputText value="#{cliente.cedRut}"></h:outputText>
  					</h:column>
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Es Empresa"></h:outputText>
  						</f:facet>  					
  						<h:selectBooleanCheckbox disabled="true" value="#{cliente.empresa}" ></h:selectBooleanCheckbox>		  							
  							
   						 
  					</h:column>  
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Nombre / Razon Social"></h:outputText>
  						</f:facet>
  							<h:outputText value="#{cliente.nombre_RazonSocial}"></h:outputText>
  					</h:column>             
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Telefono"></h:outputText>
  						</f:facet>
  							<h:outputText value="#{cliente.telefono}"></h:outputText>
  					</h:column>  
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Direccion"></h:outputText>
  						</f:facet>
  							<h:outputText value="#{cliente.direccion}"></h:outputText>
  					</h:column>  
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Fecha Fin Garantia"></h:outputText>
  						</f:facet>
  							  							
  							<h:outputText value="#{cliente.fechaFinGarantia.time}">
   						 	<f:convertDateTime type="both" dateStyle="short" pattern="yyyy/MM/dd" />
							</h:outputText>
  					</h:column>       
  					
                </h:dataTable>
         </center>
         </h:form>
    </body>
</html>
<f:subview id="footer">
	<%@include file="footer.jsp"%>		
</f:subview>
</f:view>




