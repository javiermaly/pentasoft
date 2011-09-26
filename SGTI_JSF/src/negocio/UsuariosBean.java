package negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.model.SelectItem;

import stateless.FacadeRemote;
import conexion.ConexionEJB;

import beans.Administrador;
import beans.Administrativo;

import beans.Cliente;
import beans.Encargado;
import beans.Grupo;
import beans.Tecnico;
import beans.Usuario;

public class UsuariosBean {
	public Usuario usuarioRequest;
	public UsuarioBean usuSession;
	private long cedula;	
	private String nombre;
	private String apellido;
	private String pwd;
	private String telefono;
	private String direccion;
	private String celular;
	private String perfil;
	private boolean habilitado;
	private List<Usuario> listUsuarios;
	int evento = 0;
	private boolean esExterno;
//	private List<Grupo> listGrupos;
	public ArrayList comboGrupos = new ArrayList();//ListItems para el selectoOneMany 
	public String grupoId;
	
	ConexionEJB con = new ConexionEJB();
	FacadeRemote statelessFacade = con.conectar();

	
	
	public Usuario getUsuarioRequest() {
		return usuarioRequest;
	}

	public void setUsuarioRequest(Usuario usuarioRequest) {
		this.usuarioRequest = usuarioRequest;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public List<Usuario> getListUsuarios() {
		System.out.println("papap");
		listUsuarios=this.listadoUsuarios();
		System.out.println("Cargue:" + listUsuarios.size());
		return listUsuarios;
	}

	public void setListUsuarios(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}

	public int getEvento() {
		return evento;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public boolean isEsExterno() {
		return esExterno;
	}

	public void setEsExterno(boolean esExterno) {
		this.esExterno = esExterno;
	}
	
//	public List<Grupo> getListGrupos() {
//		listGrupos=statelessFacade.listGrupos();
//		return listGrupos;
//	}

//	public void setListGrupos(List<Grupo> listGrupos) {
//		this.listGrupos = listGrupos;
//	}	
	
	public String getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(String grupoId) {
		this.grupoId = grupoId;
	}
	
	public UsuarioBean getUsuSession() {
		return usuSession;
	}
	public void setUsuSession(UsuarioBean usuSession) {
		this.usuSession = usuSession;
	}
	
	

	//para combo de Grupos en alta Usuario Tecnico
	@SuppressWarnings("rawtypes")
	public ArrayList getComboGrupos() {		
		
		List<Grupo> listGrupos = statelessFacade.listGrupos();
        comboGrupos.clear();
        for(int i=0; i<listGrupos.size(); i++)
        {
            Grupo g = new Grupo();
            g = (Grupo)listGrupos.get(i);
            
           comboGrupos.add(new SelectItem(g.getId(), g.getDescripcion()));
        }
		
		return comboGrupos;
	}

	public void setComboGrupos(ArrayList comboGrupos) {
		this.comboGrupos = comboGrupos;
	}

	
	public String altaUsuario(){
		String estado="";
		
		System.out.println("perfil: " +perfil);
		Usuario ussu = new Usuario();
		ussu=statelessFacade.encontrarUsuario(cedula);
		
		if((ussu==null)){
			System.out.println("entro con  " + usuSession.tipo );
			if((usuSession.tipo.equalsIgnoreCase("Administrador"))) {
				System.out.println("entro a administrador");
				Administrador admin= new Administrador();
				admin.setCedula(cedula);
				admin.setNombre(nombre);
				admin.setApellido(apellido);
				admin.setTelefono(telefono);
				admin.setCelular(celular);
				admin.setDireccion(direccion);
				admin.setHabilitado(true);
				admin.setPwd(pwd);
							
				if(statelessFacade.altaAdministrador(admin)){
					evento=1;
					return estado="UsuarioIngresado";
					
				}else{
					evento=2;
					return estado= "ErrorIngreso";
				}				
			}else if((usuSession.tipo.equalsIgnoreCase("Administrativo"))){
				System.out.println("entro a administrativo");
				Administrativo admin= new Administrativo();
				admin.setCedula(cedula);
				admin.setNombre(nombre);
				admin.setApellido(apellido);
				admin.setTelefono(telefono);
				admin.setCelular(celular);
				admin.setDireccion(direccion);
				admin.setHabilitado(true);
				admin.setPwd(pwd);
							
				if(statelessFacade.altaAdministrativo(admin)){
					evento=1;
					return estado="UsuarioIngresado";
				}else{
					evento=2;
					return estado= "ErrorIngreso";
				}				
			}else if((usuSession.tipo.equalsIgnoreCase("Encargado"))){
				Encargado e= new Encargado();
				e.setCedula(cedula);
				e.setNombre(nombre);
				e.setApellido(apellido);
				e.setCelular(celular);
				e.setTelefono(telefono);
				e.setDireccion(direccion);
				e.setHabilitado(true);
				e.setPwd(pwd);
				e.setEsExterno(esExterno);
				
				if(statelessFacade.altaEncargado(e)){
					//agregar el tecnico al coltecnicos en grupo
					Grupo g = (Grupo)statelessFacade.buscarGrupo(Integer.valueOf(grupoId));
					g.getColTecnicos().add(e);
					statelessFacade.modificarGrupo(g);
					evento=1;
					return estado="UsuarioIngresado";
				}else{
					evento=2;
					return estado= "ErrorIngreso";
				}				
			}else if((usuSession.tipo.equalsIgnoreCase("Tecnico"))){
				Tecnico t= new Tecnico();
				t.setCedula(cedula);
				t.setNombre(nombre);
				t.setApellido(apellido);
				t.setCelular(celular);
				t.setTelefono(telefono);
				t.setDireccion(direccion);
				t.setHabilitado(true);
				t.setPwd(pwd);
				t.setEsExterno(esExterno);
								
					if(statelessFacade.altaTecnico(t)){
						//agregar el tecnico al coltecnicos en grupo
						Grupo g = (Grupo)statelessFacade.buscarGrupo(Integer.valueOf(grupoId));
						g.getColTecnicos().add(t);
						statelessFacade.modificarGrupo(g);
						
						evento=1;
						return estado="UsuarioIngresado";
					}else{
						evento=2;
						return estado= "ErrorIngreso";
					}
			}else{
				evento=2;
				return estado= "ErrorIngreso";
			}
		
		}else{//del primer if comprueba si es nulo el usu
			evento=3;
			estado="UsuarioYaExiste";
			return estado;
		}
			
				
		
	}
	
	
	
	public List<Usuario> listadoUsuarios() {
		List<Usuario> listUsuarios = statelessFacade.listarUsuarios();
		System.out.println("usuariosBean listado usuarios");

		for (Usuario usuario : listUsuarios) {
			if (usuario instanceof Administrativo) {
				usuario.setPerfil("Administrativo");
			} else if (usuario instanceof Administrador) {
				usuario.setPerfil("Administrador");
			} else if (usuario instanceof Encargado) {
				usuario.setPerfil("Encargado");
			} else if (usuario instanceof Tecnico) {
				usuario.setPerfil("Técnico");
			}

		}
		return listUsuarios;


	}

	// buscador para usuarios
	public String buscarUsuario() {
		Usuario u = new Usuario();
				
		u = statelessFacade.encontrarUsuario(cedula);
		
		
		if (u != null) {

			this.nombre = u.getNombre();
			this.celular = u.getCelular();
			this.apellido=u.getApellido();
			this.direccion=u.getDireccion();
			this.habilitado=u.isHabilitado();
			this.pwd=u.getPwd();
			this.telefono=u.getTelefono();
			this.cedula=u.getCedula();
			
			if (u instanceof Administrativo) {
				System.out.println("es administrativo");
				this.perfil = "Administrativo";
				
			} else if (u instanceof Administrador) {
				System.out.println("es administrador");
				this.perfil = "Administrador";
			} else if (u instanceof Encargado) {
				this.perfil = "Encargado";
			} else if (u instanceof Tecnico) {
				this.esExterno=((Tecnico) u).isEsExterno();
				this.perfil = "Tecnico";
			} else
				this.perfil = "basura";

			System.out.println(perfil);

			System.out.println("usuario encontrado y puesto en el request");
			evento = 4;// encontrado
			return "usuarioEncontrado";
		} else {
			System.out.println("usuario nulo!!");
			evento = 3;// noexiste
			return "usuarioNoEncontrado";
		}
	}
	
	public String modificarUsuario(){
		
		System.out.println("modificar Usuario");
		Usuario ussu = new Usuario();
		ussu=statelessFacade.encontrarUsuario(cedula);
		
		if ((ussu != null)) {
			ussu.setApellido(apellido);
			ussu.setCedula(cedula);
			ussu.setCelular(celular);
			ussu.setDireccion(direccion);
			ussu.setNombre(nombre);
			ussu.setPwd(pwd);
			ussu.setTelefono(telefono);
			ussu.setHabilitado(habilitado);
			
			
			if (ussu instanceof Encargado ) {
				Encargado e = (Encargado) ussu;
							
				e.setEsExterno(esExterno);
				if(statelessFacade.modifUsuario(e)){
					evento=1;
					return "UsuarioModificado";
				}else{
					evento=2;//error
					return "errorModificarUsuario";
				}
				
			} else if (ussu instanceof Tecnico) {
				
				Tecnico t=(Tecnico) ussu;
				t.setEsExterno(esExterno);				
				if(statelessFacade.modifUsuario(t)){
					evento=1;
					return "UsuarioModificado";
				}else{
					evento=2;//error
					return "errorModificarUsuario";
				}
				
			}else{
				if(statelessFacade.modifUsuario(ussu)){
					evento=1;
					return "UsuarioModificado";
				}else{
					evento=2;//error
					return "errorModificarUsuario";
				}
			}//else
			

		}else 
			evento=3;//noexiste
			return "UsuarioNoExiste";
		
		
	}

	

}
