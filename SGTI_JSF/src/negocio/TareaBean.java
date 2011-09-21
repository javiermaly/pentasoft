package negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import beans.Cliente;
import beans.Encargado;
import beans.Estado;
import beans.Grupo;
import beans.Tarea;
import beans.Tecnico;
import beans.Tiene;
import beans.Tipo;
import beans.Usuario;

import stateless.FacadeRemote;
import conexion.ConexionEJB;

public class TareaBean {

	private long id;
	private long idMuestra;// el id que mostramos cuando abre la tarea
	private Cliente cliente;
	private int prioridad;
	private String prioridadStr;
	private boolean esExterna;
	private String descripcion;
	private String observacion;
	private Calendar fechaApertura;
	private Date fechaComprometida;
	private String tecnicoCed;
	private Tiene tiene;
	private Tipo tipoTarea;
	private Estado estado;
	// private String tipoId;
	private Date fechaCierre;
	@SuppressWarnings("rawtypes")
	private ArrayList comboGrupos = new ArrayList();
	private ArrayList comboTipos = new ArrayList();
	private ArrayList comboTecnicos = new ArrayList();
	private String varId;

	private List<Tarea> listadoTareasFinalizadasNoCerradas;
	private List<Tarea> listadoTareasAbiertas;

	private String grupoId;
	private int evento = 0;

	private ClienteSession cliSession;

	private UsuarioBean usuSession;

	ConexionEJB con = new ConexionEJB();
	FacadeRemote statelessFacade = con.conectar();

	public List<Tarea> getListadoTareasFinalizadasNoCerradas() {
		listadoTareasFinalizadasNoCerradas = statelessFacade
				.tareasFinalizadasNoCerradas();
		return listadoTareasFinalizadasNoCerradas;
	}

	public void setListadoTareasFinalizadasNoCerradas(
			List<Tarea> listadoTareasFinalizadasNoCerradas) {
		this.listadoTareasFinalizadasNoCerradas = listadoTareasFinalizadasNoCerradas;
	}

	public List<Tarea> getListadoTareasAbiertas() {
		Encargado e = (Encargado) usuSession.getUsuarioSession();
		System.out.println("Esta es la cedula del ENCARGADO  " + e.getCedula());
		listadoTareasAbiertas = statelessFacade.tareasAbiertasGrupo(e);
		return listadoTareasAbiertas;
	}

	public void setListadoTareasAbiertas(List<Tarea> listadoTareasAbiertas) {
		this.listadoTareasAbiertas = listadoTareasAbiertas;
	}

	public boolean isEsExterna() {
		return esExterna;
	}

	public void setEsExterna(boolean esExterna) {
		this.esExterna = esExterna;
	}

	public long getIdMuestra() {

		return idMuestra;
	}

	public void setIdMuestra(long idMuestra) {
		this.idMuestra = idMuestra;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Tiene getTiene() {
		return tiene;
	}

	public void setTiene(Tiene tiene) {
		this.tiene = tiene;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFechaComprometida() {
		return fechaComprometida;
	}

	public void setFechaComprometida(Date fechaComprometida) {
		this.fechaComprometida = fechaComprometida;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Calendar getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Calendar fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Tipo getTipoTarea() {
		return tipoTarea;
	}

	public void setTipoTarea(Tipo tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public String getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(String grupoId) {
		this.grupoId = grupoId;
	}

	// public String getTipoId() {
	// return tipoId;
	// }
	//
	// public void setTipo(String tipoId) {
	// this.tipoId = tipoId;
	// }

	public String getVarId() {
		return varId;
	}

	public void setVarId(String varId) {
		this.varId = varId;
	}

	public ClienteSession getCliSession() {
		return cliSession;
	}

	public void setCliSession(ClienteSession cliSession) {
		this.cliSession = cliSession;
	}

	public UsuarioBean getUsuSession() {
		return usuSession;
	}

	public void setUsuSession(UsuarioBean usuSession) {
		this.usuSession = usuSession;
	}

	public int getEvento() {
		return evento;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}

	public String getPrioridadStr() {
		return prioridadStr;
	}

	public void setPrioridadStr(String prioridadStr) {
		this.prioridadStr = prioridadStr;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList getComboGrupos() {

		List<Grupo> grupos = statelessFacade.listGrupos();
		comboGrupos.clear();
		for (int i = 0; i < grupos.size(); i++) {
			Grupo g = new Grupo();
			g = (Grupo) grupos.get(i);

			comboGrupos.add(new SelectItem(g.getId(), g.getDescripcion()));
		}

		return comboGrupos;
	}

	public void setComboGrupos(ArrayList comboGrupos) {
		this.comboGrupos = comboGrupos;
	}

	// combo para tipos
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList getComboTipos() {
		List<Tipo> tipos = statelessFacade.listTipos();

		for (int i = 0; i < tipos.size(); i++) {
			Tipo t = new Tipo();
			t = tipos.get(i);

			comboTipos.add(new SelectItem(t.getId(), t.getDescripcion()));
		}

		return comboTipos;
	}

	public void setComboTipos(ArrayList comboTipos) {
		this.comboTipos = comboTipos;
	}

	public ArrayList getComboTecnicos() {
		Usuario u = statelessFacade.encontrarUsuario(usuSession.usuarioSession.getCedula());
		List<Tecnico> tecnicos = statelessFacade.listarTecnicosGrupo(u);
		
		for (int i = 0; i < tecnicos.size(); i++) {
			Tecnico t = new Tecnico();
			t = tecnicos.get(i);

			comboTecnicos.add(new SelectItem(t.getCedula(), t.getApellido()));
		}

		
		return comboTecnicos;
	}

	public void setComboTecnicos(ArrayList comboTecnicos) {
		this.comboTecnicos = comboTecnicos;
	}

	// ABRIR/CREAR LA TAREA
	public String abrirTarea() {

		Tarea t = new Tarea();
		Tipo tip = new Tipo();
		Tiene tiene = new Tiene();
		Grupo g = new Grupo();
		Cliente c = new Cliente();

		c = cliSession.getClienteSession();// asignar a c el cliente que está en
											// la sesion

		tip = statelessFacade.buscarTipo(Integer.valueOf(varId));// encontrar el
																	// tipo
																	// pasado
																	// para
																	// asignarlo
																	// a la
																	// tarea

		tiene.setEstado(statelessFacade.buscarEstado(1));
		tiene.setFechaInicio(Calendar.getInstance());

		if (fechaComprometida != null) { // comprueba si no ingresó una fecha
			Calendar cal = Calendar.getInstance();
			cal.setTime(fechaComprometida);
			t.setFechaComprometida(cal);
		}

		g = statelessFacade.buscarGrupo(Integer.valueOf(grupoId));

		t.setCliente(c);
		t.setDescripcion(descripcion);
		t.setEsExterna(esExterna);
		t.setFechaApertura(Calendar.getInstance());
		t.setObservacion(observacion);
		t.setPrioridad(prioridad);
		t.setTipo(tip);
		t.agregarTiene(tiene);

		if (statelessFacade.abrirTarea(t, tiene, g) != 0) {
			System.out.println("TAREA DADA DE ALTA");
			idMuestra = statelessFacade.abrirTarea(t, tiene, g);
			evento = 1;// exito
			return "TareaAbierta";
		} else {
			System.out.println("ERROR AL DAR DE ALTA LA TAREA");
			evento = 2;
			return "ErrorTareaAbierta";
		}

	}

	// buscador para Tareas
	public String buscarTarea() {
		Tarea t = new Tarea();
		t = statelessFacade.buscarTarea(id);
		if (t != null) {
			cliente = t.getCliente();
			prioridad = t.getPrioridad();
			if (prioridad == 1) {
				prioridadStr = "Alta";
			} else if (prioridad == 2) {
				prioridadStr = "Media";
			} else if (prioridad == 3) {
				prioridadStr = "Baja";
			}
			esExterna = t.getEsExterna();
			descripcion = t.getDescripcion();
			observacion = t.getObservacion();
			fechaApertura = t.getFechaApertura();
			if (t.getFechaComprometida() != null) {
				fechaComprometida = t.getFechaComprometida().getTime();
			}
			if (t.getFechaCierre() != null) {
				fechaCierre = t.getFechaCierre().getTime();
			}

			tipoTarea = t.getTipo();
			tiene = statelessFacade.tieneDeTarea(t);
			System.out.println(tiene.getEstado().getDescripcion());
			// estado=;
			evento = 4;// encontrado
			return "TareaEncontrada";
		} else {

			evento = 3;// noexiste
			return "TareaNoEncontrada";
		}
	}

	public String cerrarTareaDesdeListado() {
		String retorno;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest myRequest = (HttpServletRequest) context
				.getExternalContext().getRequest();
		System.out.println("id de la tarea recibido: "
				+ myRequest.getParameter("idTareaBoton"));
		try {
			id = Long.parseLong(myRequest.getParameter("idTareaBoton"));

			Tarea tarea = statelessFacade.buscarTarea(id);
			System.out.println("tarea: " + tarea.getDescripcion());
			System.out.println(usuSession.getUsuarioSession().getApellido());
			System.out.println(usuSession.perfil);
			Usuario usu = statelessFacade
					.encontrarUsuario(usuSession.usuarioSession.getCedula());
			if (statelessFacade.cerrarTarea(tarea, usu)) {
				retorno = "tareaCerrada";

				// habria que poner la tarea colgada de la session en null
			} else {
				retorno = "tareaNoCerrada";
			}

			// System.out.println("usuario: "+usu.getApellido());
			System.out.println("entre a cerrar tarea");
			System.out.println("id de la tarea recibido: " + getId());
		} catch (Exception e) {
			System.out.println("error en parametro recibido");
			System.out.println(usuSession.getUsuarioSession().getApellido());
			retorno = "tareaNoCerrada";
		}

		return retorno;
	}

	public String reabrirTareaDesdeListado() {
		String retorno;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest myRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		System.out.println("id de la tarea recibido: "+ myRequest.getParameter("idTareaReAbrir"));
		try {
			id = Long.parseLong(myRequest.getParameter("idTareaReAbrir"));

			Tarea tarea = statelessFacade.buscarTarea(id);
			System.out.println("tarea: " + tarea.getDescripcion());
			System.out.println(usuSession.getUsuarioSession().getApellido());
			System.out.println(usuSession.perfil);
			Usuario usu = statelessFacade.encontrarUsuario(usuSession.usuarioSession.getCedula());
			if (statelessFacade.reabrirTarea(tarea, usu)) {
				retorno = "tareaReAbierta";
				// habria que poner la tarea colgada de la session en null
			} else {
				retorno = "tareaNoReAbierta";
			}

			// System.out.println("usuario: "+usu.getApellido());
			System.out.println("entre a cerrar tarea");
			System.out.println("id de la tarea recibido: " + getId());
		} catch (Exception e) {
			System.out.println("error en parametro recibido");
			System.out.println(usuSession.getUsuarioSession().getApellido());
			retorno = "tareaNoCerrada";
		}

		return retorno;

	}

	public String reabrirTarea() {
		try {
			System.out.println("reabrir tarea id: " + getId() + id);
			Tarea tarea = statelessFacade.buscarTarea(getId());
			tarea.setObservacion(getObservacion());
		
			Usuario usu = statelessFacade.encontrarUsuario(usuSession.usuarioSession.getCedula());

			if (statelessFacade.reabrirTarea(tarea, usu)) {
				evento = 5;
				System.out.println(evento);
				return "tareaReAbierta";

			} else {
				System.out.println(evento);
				evento = 6;
				return "tareaNoReAbierta";
				
			}

		} catch (Exception e) {
			evento=6;
			System.out.println(evento);
			System.out.println("error en parametro recibido");
			System.out.println(usuSession.getUsuarioSession().getApellido());
			return "tareaNoReAbierta";
		}

		
	}

	public String cerrarTarea() {
		String retorno;

		try {
			Tarea tarea = statelessFacade.buscarTarea(getId());
			tarea.setObservacion(getObservacion());
			System.out.println("tarea: " + tarea.getDescripcion());
			System.out.println(usuSession.getUsuarioSession().getApellido());
			System.out.println(usuSession.perfil);
			Usuario usu = statelessFacade.encontrarUsuario(usuSession.usuarioSession.getCedula());

			if (statelessFacade.cerrarTarea(tarea, usu)) {
				retorno = "tareaCerrada";
				// evento=4;//?
			} else {
				retorno = "tareaNoCerrada";
				// evento=3;//?
			}

		} catch (Exception e) {
			// evento=2;//?
			System.out.println("error en parametro recibido");
			System.out.println(usuSession.getUsuarioSession().getApellido());
			retorno = "tareaNoCerrada";
		}

		return retorno;

	}

	// prueba Asignar TArea
	public String pasarParametros() {
		// ActionEvent event
		String retorno;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest myRequest = (HttpServletRequest)context.getExternalContext().getRequest();
		System.out.println("id de la tarea recibido: "+ myRequest.getParameter("idTareaAsignar"));
		// String idTarea =(String)
		// event.getComponent().getAttributes().get("idTareaAsignar");
		// FacesUtil.getActionAttribute(event, "nombreAtributo1");

		if (myRequest.getParameter("idTareaAsignar") != null) {
			id = Long.parseLong(myRequest.getParameter("idTareaAsignar"));

			retorno = "asignarTarea";
		} else {
			retorno = "ErrorAsignarTarea";
		}
		return retorno;
	}

}
