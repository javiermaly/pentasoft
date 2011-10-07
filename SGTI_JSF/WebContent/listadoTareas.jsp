<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<f:view>
<f:subview id="header">
		<%@include file="header.jsp"%>
</f:subview>

	
	<h:form id="listdado">
	
	<center>
            <h1>Listado de tareas</h1>
                                       
                <h:dataTable value="#{TareaBean.listadoTareasFinalizadasNoCerradas}" var="tarea" border="1" >
  					<h:column>
  						<f:facet name="header" >
  							<h:outputText value="Id"></h:outputText>
  						</f:facet>
  							<h:outputText value="#{tarea.id}"></h:outputText>
  					</h:column>
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Prioridad"></h:outputText>
  						</f:facet>
  							<h:outputText value="#{tarea.prioridad}"></h:outputText>
  					</h:column>  
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Es Externa"></h:outputText>
  						</f:facet>
  							<h:selectBooleanCheckbox disabled="true"
						value="#{tarea.esExterna}"></h:selectBooleanCheckbox>
  					</h:column>  
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Descripcion"></h:outputText>
  						</f:facet>  							  							
  							<h:outputText value="#{tarea.descripcion}">
   						 </h:outputText>
  					</h:column>       
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Observacion"></h:outputText>
  						</f:facet>  							  							
  							<h:outputText value="#{tarea.observacion}">
   						 </h:outputText>
  					</h:column>     
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Fecha Apertura"></h:outputText>
  						</f:facet>  							  							
  							<h:outputText value="#{tarea.fechaApertura.time}">
   						 	<f:convertDateTime type="both" dateStyle="short" pattern="yyyy/MM/dd" />
						
   						 </h:outputText>
  					</h:column>       
  					
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Fecha Comprometida"></h:outputText>
  						</f:facet>  							  							
  							<h:outputText value="#{tarea.fechaComprometida.time}">
   						 	<f:convertDateTime type="both" dateStyle="short" pattern="yyyy/MM/dd" />
					 </h:outputText>
  					</h:column>   
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="Tipo"></h:outputText>
  						</f:facet>  							  							
  							<h:outputText value="#{tarea.tipo.descripcion}">
   						 </h:outputText>
  					</h:column>    
  					<h:column>
  						<f:facet name="header">
  						<h:outputText value="ACCIÓN"></h:outputText>
  						</f:facet>  							  							
  							<h:commandButton value="CERRAR"
						action="#{TareaBean.cerrarTarea}"></h:commandButton>
   						 
  					</h:column>    
  					
                </h:dataTable>
         </center>
         </h:form>
<f:subview id="footer">
	<%@include file="footer.jsp"%>		
</f:subview>

</f:view>




