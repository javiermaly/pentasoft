package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

@NamedQueries(value = { 
		@NamedQuery(name="todosClientes", query="select c from Cliente c"),
		
	})
	
@Entity
public class Cliente implements Serializable {

	@Id
	private long cedRut;
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int id;
	private boolean empresa;
	private String nombre_RazonSocial;
	private String telefono;
	private String direccion;
	private @Temporal(TemporalType.TIMESTAMP)Calendar fechaFinGarantia;
		
	@OneToMany(mappedBy="cliente")
	private List<Tarea> tareas= new ArrayList<Tarea>();
	
	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
	}
	
	
	public Cliente(int id, boolean empresa, String nombre_RazonSocial,
			long cedRut, String telefono, String direccion,
			Calendar fechaFinGarantia) {
		super();
		
		this.empresa = empresa;
		this.nombre_RazonSocial = nombre_RazonSocial;
		this.cedRut = cedRut;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fechaFinGarantia = fechaFinGarantia;
	}
	
	public Cliente(int id, boolean empresa, String nombre_RazonSocial,
			long cedRut, String telefono, String direccion) {
		super();
		
		this.empresa = empresa;
		this.nombre_RazonSocial = nombre_RazonSocial;
		this.cedRut = cedRut;
		this.telefono = telefono;
		this.direccion = direccion;
		
	}



	
	public boolean getEmpresa() {
		return empresa;
	}

	public void setEmpresa(boolean empresa2) {
		this.empresa = empresa2;
	}

	public String getNombre_RazonSocial() {
		return nombre_RazonSocial;
	}

	public void setNombre_RazonSocial(String nombre_RazonSocial) {
		this.nombre_RazonSocial = nombre_RazonSocial;
	}

	public long getCedRut() {
		return cedRut;
	}

	public void setCedRut(long cedRut) {
		this.cedRut = cedRut;
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
//
//	public Calendar getFechaFinGarantía() {
//		return fechaFinGarantia;
//	}
//
//	public void setFechaFinGarantía(Calendar fechaFinGarantía) {
//		this.fechaFinGarantia = fechaFinGarantia;
//	}


	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}


	public List<Tarea> getTareas() {
		return tareas;
	}


	public void setFechaFinGarantia(Calendar fechaFinGarantia) {
		this.fechaFinGarantia = fechaFinGarantia;
	}


	public Calendar getFechaFinGarantia() {
		return fechaFinGarantia;
	}
	
	
   
}
