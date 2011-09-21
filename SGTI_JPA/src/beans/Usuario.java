package beans;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;


@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries(value = { 
		@NamedQuery(name="todosUsuarios", query="select u from Usuario u"),
		@NamedQuery(name="usuarioPorCedula", query="select u from Usuario u where u.cedula = :cedula"),
	})
		

@Entity

public class Usuario implements Serializable {

	   
	@Id
	private long cedula;
	private String nombre;
	private String apellido;
	private String usuario;
	private String pwd;
	private String telefono;
	private String direccion;
	private String celular;
	private boolean habilitado;
	private static final long serialVersionUID = 1L;
	@Transient
	private String perfil;

	public Usuario() {
		super();
	}   
	public long getCedula() {
		return this.cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}   
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}   
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}   
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}   
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}   
	public String getCelular() {
		return this.celular;
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
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
   
}
