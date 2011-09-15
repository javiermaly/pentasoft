package stateless;

import java.util.List;

import javax.ejb.Stateless;

import singleton.Singleton;

import beans.*;

@Stateless
public class FacadeMain implements FacadeRemote {
	
	

    Singleton singleton = new Singleton();
    TareaRemote statelessMTar = singleton.conectarMT();
    UsuarioRemote statelessMUsu = singleton.conectarMU();
    ClienteRemote statelessMCli = singleton.conectarMC(); 
	
    
	public boolean abrirTarea(Tarea t, Tiene tiene, Grupo g) {// la que realiza el administrativo
		statelessMTar.agregarTarea(t, tiene, g);
		return true;
	}

	public boolean tomarTarea(Tarea t, Realiza r, Tipo ti) {// cuando un técnico trabaja sobre la tarea
		statelessMTar.altaTareaRealiza(t, r);
		return true;
	}

	public Tarea buscarTarea(long id) { // buscar una tarea
		Tarea t = statelessMTar.encontrarTarea(id);
		return t;
	}

	@Override
	public Tarea modificarTarea(Tarea tar) { // modificar tarea
		Tarea t = statelessMTar.actualizarTarea(tar);
		return t;
	}

	@Override
	public boolean bajaTarea(Tarea t) {
		if(buscarTarea(t.getId())!=null){//control si existe
			if(statelessMTar.eliminarTarea(t)){
				System.out.println("Tarea Eliminada");
				return true;
			}else{
				System.out.println("No se pudo eliminar la tarea, porque no tiene estado Abierta");
				return false;
			}
		}else{
			System.out.println("no existe la Tarea");
			return false;
		}	
		
	}
	
	@Override
	public boolean asignarTareaGrupo(Tarea tar, Grupo gr) {//no iría se le asigna el grupo al momento de crear/abrir la tarea
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean asignarTareaTecnico(Tarea tar, Tecnico tec, Usuario usu) {
	
		boolean retorno =false;
		if ((usu instanceof Administrador)||(usu instanceof Encargado)) {
			if(statelessMTar.asignaTareaUsuario(tar, tec)){
				retorno = true;
			}			
		}		
		return retorno;
	}
	
	public boolean tomarTarea(Tarea tar, Usuario usu){	
		
		boolean retorno =false;
		
		if ((usu instanceof Encargado)||(usu instanceof Tecnico)) {
			if(statelessMTar.tomarTarea(tar, usu)){
				retorno = true;
			}			
		}	
		
		return retorno;
	}
	public boolean finalizarTarea(Tarea tar, Usuario usu){	
		
		boolean retorno =false;
		
		if ((usu instanceof Encargado)||(usu instanceof Tecnico)) {
			if(statelessMTar.finalizarTarea(tar, usu)){
				retorno = true;
			}			
		}	
		
		return retorno;
	}

	@Override
	public boolean derivarTarea(Tarea tar, Grupo gr, Usuario usu) {
		boolean retorno =false;
		
		if ((usu instanceof Encargado)||(usu instanceof Tecnico)) {
			if(statelessMTar.derivarTarea(tar, gr)){
				retorno = true;
			}			
		}	
		
		return retorno;
	}
	
	@Override
	public boolean reabrirTarea(Tarea tar, Usuario usu) {
		boolean retorno =false;
		
		if ((usu instanceof Administrativo)||(usu instanceof Administrador)) {
			if(statelessMTar.reabrirTarea(tar)){
				retorno = true;
			}			
		}	
		
		return retorno;
	}
	
	@Override
	public boolean cerrarTarea(Tarea tar, Usuario usu) {
		boolean retorno =false;
		
		if ((usu instanceof Administrativo)||(usu instanceof Administrador)) {
			if(statelessMTar.cerrarTarea(tar)){
				retorno = true;
			}			
		}	
		
		return retorno;
	}
	
	
//CLIENTES
	
	public Cliente buscarCliente(long cedRut){
		System.out.println("EJB facade buscarClienre: "+cedRut);
		return statelessMCli.encontrarCliente(cedRut);
	}
	
	
	@Override
	public boolean altaCliente(Cliente c) {
		return statelessMCli.agregarCliente(c);
		
	}

	@Override
	public Cliente modificarCliente(Cliente c) {
		return statelessMCli.actualizarCliente(c);
	}

	@Override
	public boolean bajaCliente(Cliente c) {
		return statelessMCli.eliminarCliente(c.getCedRut());
	}
	 public List<Cliente> listadoClientes(){
		 return statelessMCli.listarClientes();
	 }
	
	
//GRUPOS
	@Override
	public boolean altaGrupo(Grupo g) {
		return statelessMTar.altaGrupo(g);
		
	}

	@Override
	public Grupo modificarGrupo(Grupo g) {
		return statelessMTar.actualizarGrupo(g);
		
	}

	@Override
	public boolean bajaGrupo(Grupo g) {
		if(statelessMTar.eliminarGrupo(g)){
			return true;
		}
		else
			return false;
		
	}
	public Grupo buscarGrupo(int id){
		return statelessMTar.encontrarGrupo(id);
	}
	

	@Override
	public boolean altaAdministrador(Administrador admin) {
		if(statelessMUsu.encontrarUsuario(admin.getCedula()) != null){
			return false;
		}
		else
		{
			return statelessMUsu.agregarUsuario(admin);
		}
		
		
	}

	@Override
	public boolean altaAdministrativo(Administrativo ad) {
		if(statelessMUsu.encontrarUsuario(ad.getCedula()) != null){
			return false;
				
		}
		else
		{
			return statelessMUsu.agregarUsuario(ad);
		}
	}

	@Override
	public boolean altaEncargado(Encargado enc) {
		if(statelessMUsu.encontrarUsuario(enc.getCedula()) != null){
			return false;
				
		}
		else
		{
			return statelessMUsu.agregarUsuario(enc);
		}
	}

	@Override
	public boolean altaTecnico(Tecnico tec) {
		if(statelessMUsu.encontrarUsuario(tec.getCedula()) != null){
			return false;
				
		}
		else
		{
			return statelessMUsu.agregarUsuario(tec);
		}
	}

	@Override
	public boolean modifUsuario(Usuario usu) {
		if(statelessMUsu.encontrarUsuario(usu.getCedula()) != null){
			return statelessMUsu.actualizarUsuario(usu);
				
		}
		else
		{
			return false;
		
		}
	}

	@Override
	public boolean bajaUsu(Usuario usu) {
		if(statelessMUsu.encontrarUsuario(usu.getCedula()) != null){
			return statelessMUsu.eliminarUsuario(usu.getCedula());
				
		}
		else
		{
			return false;
		
		}
	}

	@Override
	public boolean inhabilitarUsuario(Usuario usu) {
		if(statelessMUsu.encontrarUsuario(usu.getCedula()) != null){
			usu.setHabilitado(false);
			return statelessMUsu.actualizarUsuario(usu);
		}
		else
		{
			return false;
		
		}
		
	}
	public List<Encargado> listarEncargadosHabilitados(){
		System.out.println("facade listad encargados");
		return statelessMUsu.listarEncargadosHabilitados();
	}
	

	@Override
	public Usuario login(long cedula, String pwd) {
		Usuario u = statelessMUsu.login(cedula, pwd);
		if(!(u==null)){
			System.out.println("tengo usuario");
			return u;
			
		}
		else{
			System.out.println("no tengo usuario");
			return null;
		}
		
	}
	public Usuario encontrarUsuario(long ced){
		return statelessMUsu.encontrarUsuario(ced);
	}
	
	//tipo
	public Tipo buscarTipo(int id){
		return statelessMTar.encontrarTipo(id);
	}
	
	//estado
	public Estado buscarEstado(int id){
		return statelessMTar.encontrarEstado(id);
	}

	

	@Override
	public List<Tarea> listadoTareasPorUsuario(Usuario u) {
		return statelessMTar.tareasPorUsuario(u);
	}

//	@Override
//	public boolean avanzarTareaEstado(Tarea tar, Estado sigEst) {
//		boolean retorno = false;
//		Tiene tiene = null;
//		tiene = mt.tieneDeTarea(tar);
//		Estado estActual = tiene.getEstado();
//		System.out.println("Estado Actual: " + estActual.getDescripcion());
//		if (!(estActual == sigEst)) {
//			System.out.println("los estados son diferentes");
//			if (mt.validarEstadoSiguiente(estActual, sigEst)) {
//				System.out.println("valide que el sgte estado es posible");
//				if (mt.cambiarEstadoTarea(tar, sigEst)) {
//					retorno = true;
//				}
//			}
//
//		}
//		return retorno;
//	}

	@Override
	public List<Tarea> listadoTareasPendientesPorGrupo(Encargado enc, Grupo gr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return statelessMUsu.listarUsuarios();
		
	}

	@Override
	public List<Grupo> listGrupos() {
		System.out.println("facade : list grupos");
		return statelessMTar.listadoGrupos();
		 
	}

	@Override
	public Tiene tieneDeTarea(Tarea t) {
		Tiene tiene=statelessMTar.tieneDeTarea(t);
		return tiene;
	}

	@Override
	public List<Tarea> tareasFinalizadasNoCerradas() {
		System.out.println("tareasFinalizadasNoCerradas Facade");
		
		List<Tarea> tareasFinalizadasNoCerradas=null;
		tareasFinalizadasNoCerradas=statelessMTar.tareasFinalizadasNoCerradas();
		return tareasFinalizadasNoCerradas;
	}

	
	
	
}
