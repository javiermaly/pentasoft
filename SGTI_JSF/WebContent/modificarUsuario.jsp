<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>

	
	<h:form>
		<table>
			<h1>Modificar Usuario</h1>
		   	<tr>
				<td><h:outputText>Cédula del Usuario </h:outputText>
				</td>
				<td><h:inputText id="cedula" value="#{UsuariosBean.cedula}"	required="true"><f:validateLength  maximum="8"></f:validateLength>
						<f:converter converterId="javax.faces.Long"/></h:inputText></td>
						<h:message for="cedula" style="color:red"></h:message>						
				<td><h:commandButton value="Aceptar" action="#{UsuariosBean.buscarUsuario}"></h:commandButton>
				</td>
			</tr>	
			
		</table>
	</h:form>
	<h:form rendered="#{UsuariosBean.perfil =='Administrador' || UsuariosBean.perfil =='Administrativo'}">
		<table border="1">
			<tr>
				<th>Habilitar/Deshabilitar:</th>
				<td><h:selectOneRadio value="#{UsuariosBean.habilitado}">
						<f:selectItem itemValue="false" itemLabel="Deshabilitado" />
						<f:selectItem itemValue="true" itemLabel="Habilitado" />
					</h:selectOneRadio>
				</td>
			</tr>
			<tr>
				<th>Cedula: </th>
				<td><h:inputText id="cedula" value="#{UsuariosBean.cedula}" readonly="true" />
				<h:inputHidden value="#{UsuariosBean.cedula}"></h:inputHidden>				
				</td>										
			</tr>			
				
			<tr>
				<th>Nombre:</th>
				<td><h:inputText value="#{UsuariosBean.nombre}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Apellido:</th>
				<td><h:inputText value="#{UsuariosBean.apellido}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Direccion:</th>
				<td><h:inputText value="#{UsuariosBean.direccion}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Telefono:</th>
				<td><h:inputText id="telefono" value="#{UsuariosBean.telefono}">
					<f:converter converterId="javax.faces.Integer"/>
					</h:inputText>
					<h:message for="telefono" style="color:red"></h:message>					
				</td>			
			</tr>
			<tr>
				<th>Celular:</th>
				<td><h:inputText id="celular" value="#{UsuariosBean.celular}">
					<f:converter converterId="javax.faces.Integer"/>
					</h:inputText>
					<h:message for="celular" style="color:red"></h:message>					
				</td>			
			</tr>
			<tr>
				<td colspan="2" align="right"><h:commandButton value="Aceptar" action="#{UsuariosBean.modificarUsuario}"></h:commandButton></td>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{UsuariosBean.perfil =='Encargado'}">
		<table border="1">
			<tr>
				<th>Habilitar/Deshabilitar:</th>
				<td><h:selectOneRadio value="#{UsuariosBean.habilitado}">
						<f:selectItem itemValue="false" itemLabel="Deshabilitado" />
						<f:selectItem itemValue="true" itemLabel="Habilitado" />
					</h:selectOneRadio>
				</td>
			</tr>
			<tr>
				<th>Cedula: </th>
				<td><h:inputText id="cedula" value="#{UsuariosBean.cedula}" readonly="true" >
				<h:inputHidden value="#{UsuariosBean.cedula}"></h:inputHidden> </h:inputText>
				
				</td>										
			</tr>			
			<tr>
				<th>Contraseña:</th>
				<td><h:inputSecret  value="#{UsuariosBean.pwd}" ></h:inputSecret>
				</td>
				
			</tr>
			<tr>
				<th>Nombre:</th>
				<td><h:inputText value="#{UsuariosBean.nombre}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Apellido:</th>
				<td><h:inputText value="#{UsuariosBean.apellido}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Direccion:</th>
				<td><h:inputText value="#{UsuariosBean.direccion}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Telefono:</th>
				<td><h:inputText id="telefono" value="#{UsuariosBean.telefono}">
					<f:converter converterId="javax.faces.Integer"/>
					</h:inputText>
					<h:message for="telefono" style="color:red"></h:message>					
				</td>			
			</tr>
			<tr>
				<th>Celular:</th>
				<td><h:inputText id="celular" value="#{UsuariosBean.celular}">
					<f:converter converterId="javax.faces.Integer"/>
					</h:inputText>
					<h:message for="celular" style="color:red"></h:message>					
				</td>			
			</tr>
			<tr>
				<th>Es:</th>
				<td><h:selectOneRadio value="#{UsuariosBean.esExterno}">
						<f:selectItem itemValue="false" itemLabel="Interno" />
						<f:selectItem itemValue="true" itemLabel="Externo" />
					</h:selectOneRadio>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><h:commandButton value="Aceptar" action="#{UsuariosBean.modificarUsuario}"></h:commandButton></td>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{UsuariosBean.perfil =='Tecnico'}">
		<table border="1">
			<tr>
				<th>Habilitar/Deshabilitar:</th>
				<td><h:selectOneRadio value="#{UsuariosBean.habilitado}">
						<f:selectItem itemValue="false" itemLabel="Deshabilitado" />
						<f:selectItem itemValue="true" itemLabel="Habilitado" />
					</h:selectOneRadio>
				</td>
			</tr>
			<tr>
				<th>Cedula: </th>
				<td><h:inputText id="cedula" value="#{UsuariosBean.cedula}" readonly="true" >
				<h:inputHidden value="#{UsuariosBean.cedula}"></h:inputHidden> </h:inputText>				
				</td>										
			</tr>
			<tr>
				<th>Contraseña:</th>
				<td><h:inputSecret  value="#{UsuariosBean.pwd}" ></h:inputSecret>
				</td>
				
			</tr>
			<tr>
				<th>Nombre:</th>
				<td><h:inputText value="#{UsuariosBean.nombre}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Apellido:</th>
				<td><h:inputText value="#{UsuariosBean.apellido}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Direccion:</th>
				<td><h:inputText value="#{UsuariosBean.direccion}"></h:inputText>
				</td>
			</tr>
			<tr>
				<th>Telefono:</th>
				<td><h:inputText id="telefono" value="#{UsuariosBean.telefono}">
					<f:converter converterId="javax.faces.Integer"/>
					</h:inputText>
					<h:message for="telefono" style="color:red"></h:message>					
				</td>			
			</tr>
			<tr>
				<th>Celular:</th>
				<td><h:inputText id="celular" value="#{UsuariosBean.celular}">
					<f:converter converterId="javax.faces.Integer"/>
					</h:inputText>
					<h:message for="celular" style="color:red"></h:message>					
				</td>			
			</tr>
			<tr>
				<th>Es:</th>
				<td><h:selectOneRadio value="#{UsuariosBean.esExterno}">
						<f:selectItem itemValue="false" itemLabel="Interno" />
						<f:selectItem itemValue="true" itemLabel="Externo" />
					</h:selectOneRadio>
				</td>
			</tr>
			<tr>
				<th>Grupo: </th>
				<td>
					<h:selectOneMenu id="comboGrupo" value="#{UsuariosBean.grupoId}"> 					 					
						<f:selectItems value="#{UsuariosBean.comboGrupos}"/>						
					</h:selectOneMenu>					
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="right"><h:commandButton value="Aceptar" action="#{UsuariosBean.modificarUsuario}"></h:commandButton></td>
			</tr>	
			
		</table>
	</h:form>
	<h:form rendered="#{UsuariosBean.evento==1}">
		<table border="1">
			<tr>
				<th> Usuario Modificado con exito!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{UsuariosBean.evento==2}">
		<table border="1">
			<tr>
				<th> Error al ingresar Usuario!!!</th>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{UsuariosBean.evento==3}">
		<table border="1">
			<tr>
				<th> No Existe usuario con esa cedula!!!</th>
			</tr>
		</table>
	</h:form>
	

</f:view>
</body>
</html>