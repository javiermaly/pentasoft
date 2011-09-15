<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
  xmlns:f="http://java.sun.com/jsf/core"
  xmlns:h="http://java.sun.com/jsf/html"
  xmlns:ui="http://java.sun.com/jsf/facelets" 
  xmlns:rich="http://richfaces.org/rich">
<f:view>
    <!-- aquí incluiremos nuestros componentes JSF -->
    <rich:panel>
    <f:facet name="header">
      <h:outputText value="RichFaces calendar" />

    </f:facet>

    <h:form>

        <h:panelGrid columns="2">

            <h:panelGroup>

                <h:outputLabel value="Fecha" />

            </h:panelGroup>

            <rich:calendar datePattern="d/M/yyyy HH:mm" />

        </h:panelGrid>

    </h:form>
 <h:commandButton action="foo" value="Asignar" />

    <rich:spacer height="20px"/>     

    <rich:separator height="5px"/>

    <rich:spacer height="20px"/>

             
    <h:outputLabel value="Fecha seleccionada: " /><h:outputText value="#{bean.birthDay}"/>

  </rich:panel>
    
</f:view>

</html>