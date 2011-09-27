package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import stateless.FacadeRemote;
import conexion.ConexionEJB;

import beans.Administrador;
import beans.Administrativo;
import beans.Encargado;
import beans.Grupo;
import beans.Tarea;
import beans.Tecnico;
import beans.Usuario;

public class ReportesBean {

	private List<Tarea> reporteTareasFinalizadasTecnico;
	private List<Tarea> reporteTareasPorGrupo;
	ConexionEJB con = new ConexionEJB();
	FacadeRemote statelessFacade = con.conectar();
	private String nombre;
	private String celular;
	private String apellido;
	private String direccion;
	private boolean habilitado;
	private String pwd;
	private String telefono;
	private long cedula;
	private String perfil;
	private boolean esExterno;
	private int evento;
	private Usuario u;

	public ArrayList comboGrupos = new ArrayList();
	public String grupoId;
	
	
		
	public String getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(String grupoId) {
		this.grupoId = grupoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
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

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public boolean isEsExterno() {
		return esExterno;
	}

	public void setEsExterno(boolean esExterno) {
		this.esExterno = esExterno;
	}

	public int getEvento() {
		return evento;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}

	public List<Tarea> getReporteTareasFinalizadasTecnico() {
		System.out.println("Esta es la cedula del Tecnico  " + u.getCedula());
		reporteTareasFinalizadasTecnico = statelessFacade.reporteTareasFinalizadasTecnico(u);
		return reporteTareasFinalizadasTecnico;
	}

	public void setReporteTareasFinalizadasTecnico(List<Tarea> reporteTareasFinalizadasTecnico) {
		this.reporteTareasFinalizadasTecnico = reporteTareasFinalizadasTecnico;
	}
		
	public List<Tarea> getReporteTareasPorGrupo() {
		Grupo g = (Grupo)statelessFacade.buscarGrupo(Integer.valueOf(grupoId));
		reporteTareasPorGrupo = statelessFacade.reporteTareasPorGrupo(g);
		return reporteTareasPorGrupo;
	}

	public void setReporteTareasPorGrupo(List<Tarea> reporteTareasPorGrupo) {
		this.reporteTareasPorGrupo = reporteTareasPorGrupo;
	}
	
	//Combo de Grupos
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

	
	
	

	public String buscarUsuario() {
		
				
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
	
	
	
	
}
