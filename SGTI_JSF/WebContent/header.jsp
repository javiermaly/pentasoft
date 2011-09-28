
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<link rel="stylesheet" type="text/css" href="estilo.css" media="screen" />
</head>
<body>
	<div class="wrap">
		<f:subview id="header">
			<div class="header">
				<h:outputLink value="loginOK.jsf">
					<f:verbatim>
						<div class="logo">

							<img src="./images/logo.png" alt="" title="" border="0">
					</f:verbatim>
				</h:outputLink>
			</div>
			<div class="usuarioLog">
				Usuario:
				<h:outputLabel value="#{UsuarioBean.usuarioSession.nombre}"></h:outputLabel>
				<h:outputLabel value="#{UsuarioBean.usuarioSession.apellido}"></h:outputLabel>
				/
				<h:outputLabel rendered="#{UsuarioBean.perfil==1}">ADMINISTRADOR</h:outputLabel>
				<h:outputLabel rendered="#{UsuarioBean.perfil==2}">ADMINISTRATIVO</h:outputLabel>
				<h:outputLabel rendered="#{UsuarioBean.perfil==3}">TECNICO ENCARGADO</h:outputLabel>
				<h:outputLabel rendered="#{UsuarioBean.perfil==4}">TECNICO</h:outputLabel>
				<br />

				<h:form>

					<h:commandButton action="#{LoginBean.logOut}"
						image="./images/logout.png" style="margin-top: 5px;"></h:commandButton>


				</h:form>


			</div>
	</div>
	<div class="clear"></div>

	<h:form rendered="#{UsuarioBean.perfil==1}">
		<h1>ADMINISTRADOR</h1>

		<div id="menu">
			<ul id="nav">

				<li><span>Clientes</span>
					<ul>
						<li><a href="buscarCliente.jsf">Buscar Cliente</a></li>
						<li><a href="altaCliente.jsf">Alta Cliente</a></li>
						<li><a href="bajaCliente.jsf">Baja Cliente</a></li>
						<li><a href="modificarCliente.jsf">Modificación Cliente</a>
						</li>
						<li><a href="listadoClientes.jsf">Listado de Clientes</a>
						</li>
					</ul></li>

				<li><span>Usuarios</span>
					<ul>
						<li><a href="buscarUsuario.jsf">Buscar Usuario </a></li>
						<li><a href="altaUsuario.jsf">Alta Usuario</a></li>
						<li><a href="modificarUsuario.jsf">Modificación Usuario</a>
						</li>
						<li><a href="listadoUsuarios.jsf">Listado de Usuarios</a></li>
					</ul>
				</li>
				<li><span>Grupos</span>

					<ul>
						<li><a href="buscarGrupo.jsf">Buscar Grupo</a></li>
						<li><a href="altaGrupo.jsf">Alta Grupo</a></li>
						<li><a href="bajaGrupo.jsf">Baja Grupo</a></li>
						<li><a href="modificarGrupo.jsf">Modificación Grupo</a></li>
						<li><a href="listadoGrupos.jsf">Listado de Grupos</a></li>
					</ul>
				</li>
				<li><span>Listados</span>

					<ul>
                 		 <li><a href="reporteTareasPorUsuario.jsf">Tareas Finalizadas por un Tecnico</a></li>   
                  		 <li><a href="reporteTareasPorGrupo.jsf">Tareas por Grupo</a></li>         
                  		 <li><a href="reporteTareasEntraronEstado.jsf">Tareas que Ingresaron a un Estado</a></li>
                  		 <li><a href="reporteTareasSalieronEstado.jsf">Tareas que Salieron de un Estado</a></li>
                  		 <li><a href="reporteTaPasFechComp.jsf">Tareas No Comprometidas</a></li>
                  		 <li><a href="reporteTaFechaComp.jsf">Tareas Comprometidas</a></li>
              		 </ul>
						</li>
					</ul></li>
					<li><span><a href="cambiarContrasenia.jsf">Contraseña</a></span></li>

			</ul>

		</div>
	</h:form>
	<h:form rendered="#{UsuarioBean.perfil==2}">
		<h1>ADMINISTRATIVO</h1>
		<div id="menu">
			<ul id="nav">

				<li><span>Clientes</span>
					<ul>
						<li><a href="buscarCliente.jsf">Buscar Cliente</a></li>
						<li><a href="altaCliente.jsf">Alta Cliente</a></li>
						<li><a href="bajaCliente.jsf">Baja Cliente</a></li>
						<li><a href="modificarCliente.jsf">Modificación Cliente</a>
						</li>
						<li><a href="listadoClientes.jsf">Listado de Clientes</a></li>
					</ul>
				</li>

				<li><span>Usuarios</span>
					<ul>
						<li><a href="buscarUsuario.jsf">Buscar Usuario </a></li>
					</ul>
				</li>
				<li><span>Tareas</span>

					<ul>
						<li><a href="buscarTarea.jsf">Buscar Tarea</a></li>
						<li><a href="abrirTarea.jsf">Abrir Tarea</a></li>
						<li><a href="modificarTarea.jsf">Modificar Tarea</a></li>
						<li><a href="reAbrirTarea.jsf">Reabrir Tarea</a></li>
						<li><a href="cerrarTarea.jsf">Cerrar Tarea</a></li>
					</ul>
				</li>
				<li><span>Listados</span>

					<ul>
						<li><a href="reporteTareasPorUsuario.jsf">Tareas
								Finalizadas por un Tecnico</a>
						</li>
						<li><a href="reporteTareasPorGrupo.jsf">Tareas por Grupo</a>
						</li>
					</ul>
				</li>
				<li><span><a href="cambiarContrasenia.jsf">Contraseña</a></span></li>

			</ul>
			
		</div>
	</h:form>
	<h:form rendered="#{UsuarioBean.perfil==3}">
		<h1>ENCARGADO</h1>

		<div id="menu">
			<ul id="nav">

				<li><span>Tareas</span>
					<ul>
						<li><a href="buscarTarea.jsf">Buscar Tarea</a></li>
						<li><a href="asignarTarea.jsf">Asignar Tarea</a></li>
						<li><a href="tomarTarea.jsf">Tomar Tarea</a></li>
						<li><a href="derivarTarea.jsf">Derivar Tarea</a></li>
						<li><a href="finalizarTarea.jsf">Finalizar Tarea</a></li>
					</ul>
				</li>
				<li><span>Clientes</span>
					<ul>
						<li><a href="buscarCliente.jsf">Buscar Cliente</a></li>
					</ul>
				</li>
				<li><span>Usuarios</span>
					<ul>
						<li><a href="buscarUsuario.jsf">Buscar Usuario</a>
						</li>
					</ul></li>
				<li><span>Listados</span>
					<ul>
						<li><a href="reporteTareasPorUsuario.jsf">Tareas
								Finalizadas por un Tecnico</a>
						</li>
					</ul></li>
					<li><span><a href="cambiarContrasenia.jsf">Contraseña</a></span></li>
			</ul>
			
		</div>


	</h:form>
	<h:form rendered="#{UsuarioBean.perfil==4}">
		<h1>TECNICO</h1>
		<div id="menu">
			<ul id="nav">

				<li><span>Tareas</span>
					<ul>
						<li><a href="buscarTarea.jsf">Buscar Tarea</a></li>
						<li><a href="tomarTarea.jsf">Tomar Tarea</a></li>
						<li><a href="derivarTarea.jsf">Derivar Tarea</a></li>
						<li><a href="finalizarTarea.jsf">Finalizar Tarea</a></li>
						
					
						</ul>
				<li><span><a href="cambiarContrasenia.jsf">Contraseña</a></span></li>
				
			</ul>
		</div>
	</h:form>
	</f:subview>
</head>
<body>