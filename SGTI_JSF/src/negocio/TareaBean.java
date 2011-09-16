package negocio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import beans.Cliente;
import beans.Estado;
import beans.Grupo;
import beans.Tarea;
import beans.Tiene;
import beans.Tipo;
import beans.Usuario;

import stateless.FacadeRemote;
import conexion.ConexionEJB;

public class TareaBean {

	private long id;
	private Cliente cliente;
	private int prioridad;
	private boolean esExterna;
	private String descripcion;
	private String observacion;
	private Calendar fechaApertura;
	private Calendar fechaComprometida;
	// private Calendar fechaComprometida;
	private Tiene tiene;
	private Tipo tipoTarea;
	private Estado estado;
	private int tipo;
	private Calendar fechaCierre;
	
	private List<Tarea> listadoTareasFinalizadasNoCerradas;

	private int grupoId;
	private int evento = 0;

	private ClienteSession cliSession;
	
	private UsuarioBean usuSession;

	ConexionEJB con = new ConexionEJB();
	FacadeRemote statelessFacade = con.conectar();

	
	
	public List<Tarea> getListadoTareasFinalizadasNoCerradas() {
		listadoTareasFinalizadasNoCerradas=statelessFacade.tareasFinalizadasNoCerradas();
		return listadoTareasFinalizadasNoCerradas;
	}

	public void setListadoTareasFinalizadasNoCerradas(
			List<Tarea> listadoTareasFinalizadasNoCerradas) {
		this.listadoTareasFinalizadasNoCerradas = listadoTareasFinalizadasNoCerradas;
	}

	public boolean isEsExterna() {
		return esExterna;
	}

	public void setEsExterna(boolean esExterna) {
		this.esExterna = esExterna;
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Calendar getFechaComprometida() {
		return fechaComprometida;
	}

	public void setFechaComprometida(Calendar fechaComprometida) {
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

	public Calendar getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Calendar fechaCierre) {
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

	public int getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
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

	// ABRIR/CREAR LA TAREA
	public String abrirTarea() {

		Tarea t = new Tarea();
		Tipo tip = new Tipo();
		Tiene tiene = new Tiene();
		Grupo g = new Grupo();
		Cliente c = new Cliente();
		
		c = cliSession.getClienteSession();// asignar a c el cliente que está en
											// la sesion

		tip = statelessFacade.buscarTipo(tipo);// encontrar el tipo pasado para
												// asignarlo a la tarea

		tiene.setEstado(statelessFacade.buscarEstado(1));
		tiene.setFechaInicio(Calendar.getInstance());

		if (fechaComprometida != null) { // comprueba si no ingresó una fecha
			Calendar cal = Calendar.getInstance();
			cal.setTime(fechaComprometida.getTime());
			t.setFechaComprometida(cal);
		}

		g = statelessFacade.buscarGrupo(grupoId);

		t.setCliente(c);
		t.setDescripcion(descripcion);
		t.setEsExterna(esExterna);
		t.setFechaApertura(Calendar.getInstance());
		t.setObservacion(observacion);
		t.setPrioridad(prioridad);
		t.setTipo(tip);
		t.agregarTiene(tiene);

		if (statelessFacade.abrirTarea(t, tiene, g)) {
			System.out.println("TAREA DADA DE ALTA");
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
		t=statelessFacade.buscarTarea(id);
		if (t != null) {
			cliente=t.getCliente();
			prioridad=t.getPrioridad();
			esExterna=t.getEsExterna();
			descripcion=t.getDescripcion();
			observacion=t.getObservacion();
			fechaApertura=t.getFechaApertura();
			fechaComprometida=t.getFechaComprometida();
			tipoTarea=t.getTipo();
			tiene=statelessFacade.tieneDeTarea(t);
			System.out.println(tiene.getEstado().getDescripcion());
			//estado=;
			fechaCierre=t.getFechaCierre();
			evento = 4;// encontrado
			return "TareaEncontrada";
		} else {

			
			evento = 3;// noexiste
			return "TareaNoEncontrada";
		}
	}
	
	public String cerrarTarea(){
		String retorno;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest myRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		System.out.println("id de la tarea recibido: "+myRequest.getParameter("idTareaBoton"));
		try{
		id = Long.parseLong(myRequest.getParameter("idTareaBoton"));
		
		Tarea tarea=statelessFacade.buscarTarea(id);
		System.out.println("tarea: "+tarea.getDescripcion());
		System.out.println(usuSession.getUsuarioSession().getApellido());
		System.out.println(usuSession.perfil);
		Usuario usu=statelessFacade.encontrarUsuario(usuSession.usuarioSession.getCedula());
		if(statelessFacade.cerrarTarea(tarea, usu)){
			retorno="tareaCerrada";
			
			//habria que poner la tarea colgada de la session en null
		}
		else{
			retorno="tareaNoCerrada";
		}
		
		//System.out.println("usuario: "+usu.getApellido());
		System.out.println("entre a cerrar tarea");
		System.out.println("id de la tarea recibido: "+getId());
		}
		catch(Exception e){
			System.out.println("error en parametro recibido");
			System.out.println(usuSession.getUsuarioSession().getApellido());
			retorno="tareaNoCerrada";
		}
		
		return retorno;
	}
	
	public String reabrirTarea(){
		String retorno;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest myRequest = (HttpServletRequest) context.getExternalContext().getRequest();
		System.out.println("id de la tarea recibido: "+myRequest.getParameter("idTareaReAbrir"));
		try{
		id = Long.parseLong(myRequest.getParameter("idTareaReAbrir"));
		
		Tarea tarea=statelessFacade.buscarTarea(id);
		System.out.println("tarea: "+tarea.getDescripcion());
		System.out.println(usuSession.getUsuarioSession().getApellido());
		System.out.println(usuSession.perfil);
		Usuario usu=statelessFacade.encontrarUsuario(usuSession.usuarioSession.getCedula());
		if(statelessFacade.reabrirTarea(tarea, usu)){
			retorno="tareaReAbierta";
			//habria que poner la tarea colgada de la session en null
		}
		else{
			retorno="tareaNoReAbierta";
		}
		
		//System.out.println("usuario: "+usu.getApellido());
		System.out.println("entre a cerrar tarea");
		System.out.println("id de la tarea recibido: "+getId());
		}
		catch(Exception e){
			System.out.println("error en parametro recibido");
			System.out.println(usuSession.getUsuarioSession().getApellido());
			retorno="tareaNoCerrada";
		}
		
		return retorno;
	
	}
}
