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
	@SuppressWarnings("rawtypes")
	private ArrayList comboTipos = new ArrayList();
	@SuppressWarnings("rawtypes")
	private ArrayList comboTecnicos = new ArrayList();
	private String varId;

	private List<Tarea> listadoTareasFinalizadasNoCerradas;
	private List<Tarea> listadoTareasAbiertas;//para el home del Encargado
	private List<Tarea> listadoTareasAsignadas;//
	private List<Tarea> listTareasEnProcesoTecnico;
	
//	private List<Tarea> reporteTareasFinalizadasTecnico;

	private String grupoId;
	private int evento = 0;

	private ClienteSession cliSession;

	private UsuarioBean usuSession;

	ConexionEJB con = new ConexionEJB();
	FacadeRemote statelessFacade = con.conectar();

	
	
	
	public String getTecnicoCed() {
		return tecnicoCed;
	}

	public void setTecnicoCed(String tecnicoCed) {
		this.tecnicoCed = tecnicoCed;
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

	//COMBOS
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
		comboTipos.clear();
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

	// combo para Tecnicos
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList getComboTecnicos() {
		Encargado e = (Encargado) statelessFacade.encontrarUsuario(usuSession.usuarioSession.getCedula());
		System.out.println("cedula del encargado que le paso "+e.getCedula());
		List<Usuario> tecnicos = statelessFacade.listarTecnicosGrupo(e);
		System.out.println("tecnicos "+tecnicos.toString());
		for (int i = 0; i < tecnicos.size(); i++) {
			Usuario u = new Usuario();
			u = tecnicos.get(i);

			comboTecnicos.add(new SelectItem(u.getCedula(), u.getApellido()));
		}

		
		return comboTecnicos;
	}

	public void setComboTecnicos(ArrayList comboTecnicos) {
		this.comboTecnicos = comboTecnicos;
	}
	
	
	
	
	
	//LISTADOS
	public List<Tarea> getListTareasEnProcesoTecnico() {
		Tecnico t = (Tecnico) usuSession.getUsuarioSession();
		System.out.println("Esta es la cedula del ENCARGADO  " + t.getCedula());
		listTareasEnProcesoTecnico = statelessFacade.listTareasEnProcesoTecnico(t);
		return listTareasEnProcesoTecnico;
	}

	public void setListTareasEnProcesoTecnico(List<Tarea> listTareasEnProcesoTecnico) {
		this.listTareasEnProcesoTecnico = listTareasEnProcesoTecnico;
	}

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
	
	public List<Tarea> getListadoTareasAsignadas() {
		Tecnico t = (Tecnico) usuSession.getUsuarioSession();
		System.out.println("Esta es la cedula del Tecnico o encargado  " + t.getCedula());
		listadoTareasAsignadas = statelessFacade.listTareasAsignadaTecnico(t);
		return listadoTareasAsignadas;
	}

	public void setListadoTareasAsignadas(List<Tarea> listadoTareasAsignadas) {
		this.listadoTareasAsignadas = listadoTareasAsignadas;
	}
	
	
	


	// BUSCAR Tareas
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
	
	
	// ABRIR/CREAR LA TAREA
	public String abrirTarea() {

		Tarea t = new Tarea();
		Tipo tip = new Tipo();
		Tiene tiene = new Tiene();
		Grupo g = new Grupo();
		Cliente c = new Cliente();

		c = cliSession.getClienteSession();// asignar a c el cliente que está en la sesion

		tip = statelessFacade.buscarTipo(Integer.valueOf(varId));// encontrar el tipo
																	
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

		idMuestra = statelessFacade.abrirTarea(t, tiene, g);
		if (idMuestra != 0) {
			System.out.println("TAREA DADA DE ALTA");
			evento = 1;// exito
			return "TareaAbierta";
		} else {
			System.out.println("ERROR AL DAR DE ALTA LA TAREA");
			evento = 2;
			return "ErrorTareaAbierta";
		}

	}
	
	//ASIGNAR TArea
	public String pasarPamAsignarTarea() {
		
		String retorno;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest myRequest = (HttpServletRequest)context.getExternalContext().getRequest();
		System.out.println("id de la tarea recibido: "+ myRequest.getParameter("idTareaAsignar"));
	
		if (myRequest.getParameter("idTareaAsignar") != "") {
			id = Long.parseLong(myRequest.getParameter("idTareaAsignar"));
			Tarea t = statelessFacade.buscarTarea(id);
			prioridad=t.getPrioridad();
			if (prioridad == 1) {
				prioridadStr = "Alta";
			} else if (prioridad == 2) {
				prioridadStr = "Media";
			} else if (prioridad == 3) {
				prioridadStr = "Baja";
			}
			cliente=t.getCliente();
			esExterna=t.getEsExterna();
			descripcion=t.getDescripcion();
			observacion=t.getObservacion();
			fechaApertura=t.getFechaApertura();
			if(t.getFechaComprometida()!=null){
				fechaComprometida=t.getFechaComprometida().getTime();
			}
			tipoTarea=t.getTipo();	
			tiene = statelessFacade.tieneDeTarea(t);
			
			
			retorno = "irAsignarTarea";
		} else {
			retorno = "errorIrAsignarTarea";
		}
		return retorno;
	}

	public String asignarTarea(){
		Tarea tarea= statelessFacade.buscarTarea(id);
		System.out.println("tarea id "+tarea.getId());
		Tecnico tec= (Tecnico) statelessFacade.encontrarUsuario(Long.valueOf(tecnicoCed));
		System.out.println("tecnico ced "+tec.getCedula());
		Usuario usu= statelessFacade.encontrarUsuario(usuSession.usuarioSession.getCedula());
		System.out.println("usu ced"+usu.getCedula());
		
		tarea.setObservacion(observacion);
				
		if(statelessFacade.asignarTareaTecnico(tarea, tec, usu)){
			evento=1;
			return "tareaAsignada";
		}else{
			evento=2;
			return "errorTareaAsignada";
		}		
		
	}
	
	//DERIVAR TArea
	public String pasarPamDerivarTarea() {
		
		String retorno;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest myRequest = (HttpServletRequest)context.getExternalContext().getRequest();
		System.out.println("id de la tarea recibido: "+ myRequest.getParameter("idTareaDerivar"));
	
		if (myRequest.getParameter("idTareaDerivar") != "") {
			id = Long.parseLong(myRequest.getParameter("idTareaDerivar"));
			Tarea t = statelessFacade.buscarTarea(id);
			prioridad=t.getPrioridad();
			if (prioridad == 1) {
				prioridadStr = "Alta";
			} else if (prioridad == 2) {
				prioridadStr = "Media";
			} else if (prioridad == 3) {
				prioridadStr = "Baja";
			}
			cliente=t.getCliente();
			esExterna=t.getEsExterna();
			descripcion=t.getDescripcion();
			observacion=t.getObservacion();
			fechaApertura=t.getFechaApertura();
			if(t.getFechaComprometida()!=null){
				fechaComprometida=t.getFechaComprometida().getTime();
			}
			tipoTarea=t.getTipo();	
			tiene = statelessFacade.tieneDeTarea(t);
			
			retorno = "irDerivarTarea";
		} else {
			retorno = "errorIrDerivarTarea";
		}
		return retorno;
	}

	public String derivarTarea(){
		Tarea tarea= statelessFacade.buscarTarea(id);
		System.out.println("tarea id "+tarea.getId());
		Grupo gr = statelessFacade.buscarGrupo(Integer.valueOf(grupoId));
		System.out.println("grupo id "+gr.getId());
		Usuario usu= statelessFacade.encontrarUsuario(usuSession.usuarioSession.getCedula());
		System.out.println("usu ced"+usu.getCedula());		

		tarea.setObservacion(observacion);
		
		if(statelessFacade.derivarTarea(tarea, gr, usu)){
			evento=1;
			return "tareaDerivada";
		}else{
			evento=2;
			return "errorTareaDerivada";
		}		
		
	}
		
	//TOMAR Tarea
	public String pasarPamTomarTarea() {
		
		String retorno;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest myRequest = (HttpServletRequest)context.getExternalContext().getRequest();
		System.out.println("id de la tarea recibido: "+ myRequest.getParameter("idTareaTomar"));
	
		if (myRequest.getParameter("idTareaTomar") != "") {
			id = Long.parseLong(myRequest.getParameter("idTareaTomar"));
			Tarea t = statelessFacade.buscarTarea(id);
			prioridad=t.getPrioridad();
			if (prioridad == 1) {
				prioridadStr = "Alta";
			} else if (prioridad == 2) {
				prioridadStr = "Media";
			} else if (prioridad == 3) {
				prioridadStr = "Baja";
			}
			cliente=t.getCliente();
			esExterna=t.getEsExterna();
			descripcion=t.getDescripcion();
			observacion=t.getObservacion();
			fechaApertura=t.getFechaApertura();
			if(t.getFechaComprometida()!=null){
				fechaComprometida=t.getFechaComprometida().getTime();
			}
			tipoTarea=t.getTipo();		
			tiene = statelessFacade.tieneDeTarea(t);
			
			retorno = "irTomarTarea";
		} else {
			retorno = "errorIrTomarTarea";
		}
		return retorno;
	}

	public String tomarTarea(){
		Tarea tarea= statelessFacade.buscarTarea(id);
		tarea.setObservacion(observacion);
		System.out.println("tarea id "+tarea.getId());
		
		Usuario usu= statelessFacade.encontrarUsuario(usuSession.usuarioSession.getCedula());
		System.out.println("usu ced"+usu.getCedula());
			
				
		if(statelessFacade.tomarTarea(tarea, usu)){
			evento=1;
			return "tareaTomada";
		}else{
			evento=2;
			return "errorTareaTomada";
		}		
		
	}
	
	//FINALIZAR Tarea
	public String pasarPamFinalizarTarea() {
		
		String retorno;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest myRequest = (HttpServletRequest)context.getExternalContext().getRequest();
		System.out.println("id de la tarea recibido: "+ myRequest.getParameter("idTareaFinalizar"));
	
		if (myRequest.getParameter("idTareaFinalizar") != "") {
			id = Long.parseLong(myRequest.getParameter("idTareaFinalizar"));
			Tarea t = statelessFacade.buscarTarea(id);
			prioridad=t.getPrioridad();
			if (prioridad == 1) {
				prioridadStr = "Alta";
			} else if (prioridad == 2) {
				prioridadStr = "Media";
			} else if (prioridad == 3) {
				prioridadStr = "Baja";
			}
			cliente=t.getCliente();
			esExterna=t.getEsExterna();
			descripcion=t.getDescripcion();
			observacion=t.getObservacion();
			fechaApertura=t.getFechaApertura();
			if(t.getFechaComprometida()!=null){
				fechaComprometida=t.getFechaComprometida().getTime();
			}
			tipoTarea=t.getTipo();		
			tiene = statelessFacade.tieneDeTarea(t);
			
			retorno = "irFinalizarTarea";
		} else {
			retorno = "errorIrFinalizarTarea";
		}
		return retorno;
	}

	public String finalizarTarea(){
		Tarea tarea= statelessFacade.buscarTarea(id);
		System.out.println("tarea id "+tarea.getId());
		
		Usuario usu= statelessFacade.encontrarUsuario(usuSession.usuarioSession.getCedula());
		System.out.println("usu ced"+usu.getCedula());
			
		tarea.setObservacion(observacion);
		
		if(statelessFacade.finalizarTarea(tarea, usu)){
			evento=1;
			return "tareaFinalizada";
		}else{
			evento=2;
			return "errorTareaFinalizada";
		}		
		
	}
	
	//Cerrar Tarea
	public String pasarPamCerrarTarea() {
		
		String retorno;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest myRequest = (HttpServletRequest)context.getExternalContext().getRequest();
		System.out.println("id de la tarea recibido: "+ myRequest.getParameter("idTareaCerrar"));
	
		if (myRequest.getParameter("idTareaCerrar") != "") {
			id = Long.parseLong(myRequest.getParameter("idTareaCerrar"));
			Tarea t = statelessFacade.buscarTarea(id);
			prioridad=t.getPrioridad();
			if (prioridad == 1) {
				prioridadStr = "Alta";
			} else if (prioridad == 2) {
				prioridadStr = "Media";
			} else if (prioridad == 3) {
				prioridadStr = "Baja";
			}
			cliente=t.getCliente();
			esExterna=t.getEsExterna();
			descripcion=t.getDescripcion();
			observacion=t.getObservacion();
			fechaApertura=t.getFechaApertura();
			if (t.getFechaComprometida() != null) {
				fechaComprometida = t.getFechaComprometida().getTime();
			}
			tipoTarea=t.getTipo();
			tiene = statelessFacade.tieneDeTarea(t);
			
			
			retorno = "irCerrarTarea";
		} else {
			retorno = "errorIrCerrarTarea";
		}
		return retorno;
	}	
		
	public String cerrarTarea() {
			String retorno;
			Tarea tarea = statelessFacade.buscarTarea(getId());
			tarea.setObservacion(getObservacion());
			Usuario usu = statelessFacade.encontrarUsuario(usuSession.usuarioSession.getCedula());

			if (statelessFacade.cerrarTarea(tarea, usu)) {
				retorno = "tareaCerrada";
				evento=1;
			} else {
				retorno = "tareaNoCerrada";
				 evento=2;
			}

		return retorno;

	}
	
	
	
	//ReAbrir Tarea
	public String pasarPamReabrirTarea() {
		
		String retorno;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest myRequest = (HttpServletRequest)context.getExternalContext().getRequest();
		System.out.println("id de la tarea recibido: "+ myRequest.getParameter("idTareaReAbrir"));
	
		if (myRequest.getParameter("idTareaReAbrir") != "") {
			id = Long.parseLong(myRequest.getParameter("idTareaReAbrir"));
			Tarea t = statelessFacade.buscarTarea(id);
			prioridad=t.getPrioridad();
			if (prioridad == 1) {
				prioridadStr = "Alta";
			} else if (prioridad == 2) {
				prioridadStr = "Media";
			} else if (prioridad == 3) {
				prioridadStr = "Baja";
			}
			cliente=t.getCliente();
			esExterna=t.getEsExterna();
			descripcion=t.getDescripcion();
			observacion=t.getObservacion();
			fechaApertura=t.getFechaApertura();
			if(t.getFechaComprometida()!=null){
				fechaComprometida=t.getFechaComprometida().getTime();
			}
			tipoTarea=t.getTipo();		
			
			
			retorno = "irReAbrirTarea";
		} else {
			retorno = "errorIrReAbrirTarea";
		}
		return retorno;
	}	
	//RE-ABRIR Tarea
	public String reabrirTarea() {
		
			System.out.println("reabrir tarea id: " + getId() + id);
			Tarea tarea = statelessFacade.buscarTarea(getId());
			tarea.setObservacion(getObservacion());
		
			Usuario usu = statelessFacade.encontrarUsuario(usuSession.usuarioSession.getCedula());

			if (statelessFacade.reabrirTarea(tarea, usu)) {
				evento = 1;				
				return "tareaReAbierta";

			} else {				
				evento = 2;
				return "tareaNoReAbierta";
				
			}
			
	}

	public String modificarTarea(){
		Tarea t=statelessFacade.buscarTarea(id);
		t.setPrioridad(prioridad);
		t.setEsExterna(esExterna);
		Tipo tipo=statelessFacade.buscarTipo(Integer.parseInt(varId));
		t.setTipo(tipo);
		if (fechaComprometida != null) { // comprueba si no ingresó una fecha
			Calendar cal = Calendar.getInstance();
			cal.setTime(fechaComprometida);
			t.setFechaComprometida(cal);
		}
		t.setDescripcion(descripcion);
		
		if(statelessFacade.modificarTarea(t) != null){
			evento=6;
			return "tareaModificada";
		}
		else{
			evento=7;
			return "tareaNoModificada";
		}
		
	}

	
}
