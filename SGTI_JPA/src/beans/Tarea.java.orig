package beans;

import java.io.Serializable;
import java.lang.String;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

import javax.persistence.*;

@NamedQueries(value = { 
		@NamedQuery(name="todosTareas", query="select t from Tarea t"),
		@NamedQuery(name="tareasPorUsuario", query="select t from Tarea t where (select r from Realiza r where r.usu.cedula = :cedula) IN t.listRealiza")
		})
	
@Entity

public class Tarea implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private boolean esExterna;
	private String descripcion;
	private String observacion;
	private @Temporal(TemporalType.DATE) Calendar fechaApertura;
	private @Temporal(TemporalType.DATE) Calendar fechaComprometida;
	private @Temporal(TemporalType.DATE) Calendar fechaCierre;
	@ManyToOne
	private Tipo tipo;	
	@OneToMany(mappedBy="tarea")
	private List<Realiza> listRealiza=new ArrayList<Realiza>();	
	@ManyToOne
	private Cliente cliente;	
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Tiene> colTiene=new ArrayList<Tiene>();	
	
	
	private static final long serialVersionUID = 1L;

	
	public Tarea() {
		super();
	}   
	
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public boolean getEsExterna() {
		return this.esExterna;
	}

	public void setEsExterna(boolean esExterna) {
		this.esExterna = esExterna;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
	public Calendar getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(Calendar fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public Calendar getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(Calendar fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public Calendar getFechaComprometida() {
		return fechaComprometida;
	}
	public void setFechaComprometida(Calendar fechaComprometida) {
		this.fechaComprometida = fechaComprometida;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public void setListRealiza(List<Realiza> listRealiza) {
		this.listRealiza = listRealiza;
	}
	public List<Realiza> getListRealiza() {
		return listRealiza;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public List<Tiene> getColTiene() {
		return colTiene;
	}


	public void setColTiene(List<Tiene> colTiene) {
		this.colTiene = colTiene;
	}
   
	public boolean agregarRealiza(Realiza r){
		boolean retorno;
		if(listRealiza.add(r)){
			retorno=true;
		}
		else{
			retorno=false;
		}
		
		return retorno;
	}
	
	public boolean agregarTiene(Tiene tiene){
		boolean retorno;
		if(colTiene.add(tiene)){
			retorno=true;
		}
		else{
			retorno=false;
		}
		
		return retorno;
	}
	
}
