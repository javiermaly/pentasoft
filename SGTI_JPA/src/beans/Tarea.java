package beans;

import java.io.Serializable;
import java.lang.String;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

import javax.persistence.*;

@NamedQueries(value = { 
		@NamedQuery(name="todosTareas", query="select t from Tarea t"),
		
})
@NamedNativeQueries(
		{
		@NamedNativeQuery(name="tareasPorUsuario",
    query = "SELECT * FROM Tarea T join Realiza R on T.id=R.tarea_id where ((R.usu_cedula = 1?))",
    resultClass=Tarea.class),
    
    @NamedNativeQuery(name="tareasFinalizadasNoCerradas",
    query = "SELECT * from Tarea where id= ANY( SELECT Ta.Tarea_id FROM Tiene T join Tarea_Tiene Ta on T.id=Ta.Tarea_id  where T.estado_id=6);",
    resultClass=Tarea.class)
		}
)


@Entity

public class Tarea implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private boolean esExterna;
	private String descripcion;
	private String observacion;
	private @Temporal(TemporalType.DATE) Calendar fechaApertura;
	private @Temporal(TemporalType.DATE) Calendar fechaComprometida;
	private @Temporal(TemporalType.DATE) Calendar fechaCierre;
	@ManyToOne(fetch=FetchType.EAGER)
	private Tipo tipo;	
	@OneToMany(mappedBy="tarea")
	private List<Realiza> listRealiza=new ArrayList<Realiza>();	
	
	@ManyToOne
	private Cliente cliente;	
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Tiene> colTiene=new ArrayList<Tiene>();	
	
	int prioridad;
	
	private static final long serialVersionUID = 1L;

	
	public Tarea() {
		super();
	}   
	
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
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

	

	public int getPrioridad() {
		return prioridad;
	}


	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
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
