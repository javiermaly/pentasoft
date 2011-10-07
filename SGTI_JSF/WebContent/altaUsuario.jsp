
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<f:subview id="header">
		<%@include file="header.jsp"%>
	</f:subview>


	<h:form>
		<h1>Alta de Usuario</h1>
		<table>
			<tr>
				<td>Seleccione el tipo de Usuario que desea Ingresar: </td>						
			</tr>
			<tr>
				<td><h:selectOneRadio value="#{UsuarioBean.tipo}" onchange="submit()">
					<f:selectItem itemValue="Administrador" itemLabel="Administrador" />
					<f:selectItem itemValue="Administrativo" itemLabel="Administrativo"/>	
					<f:selectItem itemValue="Encargado" itemLabel="Encargado"/>	
					<f:selectItem itemValue="Tecnico" itemLabel="Tecnico"/>				
				</h:selectOneRadio>
				</td>

			</tr>
		</table>
	</h:form>
	<h:form rendered="#{UsuarioBean.tipo =='Administrador' || UsuarioBean.tipo =='Administrativo'}">
		<table border="1">
			<tr>
				<th>*Cedula: </th>
				<td><h:inputText id="cedula" value="#{UsuariosBean.cedula}" required="true">
						<f:validateLength  maximum="8"></f:validateLength>
						<f:converter converterId="javax.faces.Long"/></h:inputText></td>
						<h:message for="cedula" style="color:red"></h:message>				
			</tr>
			<tr>
				<th>*Contraseña:</th>
				<td><h:inputSecret id="pass" value="#{UsuariosBean.pwd}"></h:inputSecret>
				</td>
				<h:message for="pass" style="color:red"></h:message>			
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
				<td colspan="2" align="right"><h:commandButton value="Aceptar" action="#{UsuariosBean.altaUsuario}"></h:commandButton></td>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{UsuarioBean.tipo =='Encargado'}">
		<table border="1">
			<tr>
				<th>*Cedula:</th>
				<td><h:inputText id="cedula" value="#{UsuariosBean.cedula}"
						required="true">
						<f:validateLength maximum="8"></f:validateLength>
						<f:converter converterId="javax.faces.Long" />
					</h:inputText>
				</td>
				<h:message for="cedula" style="color:red"></h:message>
			</tr>
			<tr>
				<th>*Contraseña:</th>
				<td><h:inputSecret id = "passe"value="#{UsuariosBean.pwd}"></h:inputSecret>
				</td>
				<h:message for="passe" style="color:red"></h:message>
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
				<td colspan="2" align="right"><h:commandButton value="Aceptar" action="#{UsuariosBean.altaUsuario}"></h:commandButton></td>
			</tr>
		</table>
	</h:form>
	<h:form rendered="#{UsuarioBean.tipo =='Tecnico'}">
		<table border="1">
			<tr>
				<th>*Cedula:</th>
				<td><h:inputText id="cedula" value="#{UsuariosBean.cedula}"
						required="true">
						<f:validateLength maximum="8"></f:validateLength>
						<f:converter converterId="javax.faces.Long" />
					</h:inputText>
				</td>
				<h:message for="cedula" style="color:red"></h:message>
			</tr>
			<tr>
				<th>*Contraseña:</th>
				<td><h:inputSecret id="passt" value="#{UsuariosBean.pwd}"></h:inputSecret>
				</td>
				<h:message for="passt" style="color:red"></h:message>
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
				<td colspan="2" align="right"><h:commandButton value="Aceptar" action="#{UsuariosBean.altaUsuario}"></h:commandButton></td>
			</tr>	
			
		</table>
	</h:form>
	<h:form rendered="#{UsuariosBean.evento==1}">
		<table border="1">
			<tr>
				<th> Usuario ingresado con exito!!!</th>
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
				<th> Usuario Ya Existe en la Base de Datos!!!</th>
			</tr>
		</table>
	</h:form>
	
<f:subview id="footer">
	<%@include file="footer.jsp"%>		
</f:subview>
</f:view>

