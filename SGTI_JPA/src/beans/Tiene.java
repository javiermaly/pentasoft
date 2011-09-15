package beans;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

@NamedQueries(value = { 
		//@NamedQuery(name="tieneSinFechaFin", query="select t from Tiene t where t.fechafin = 0"),
		
		
	})
	
/**
 * Entity implementation class for Entity: Tiene
 *
 */
@Entity

public class Tiene implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private @Temporal(TemporalType.DATE) Calendar fechaInicio;
	private @Temporal(TemporalType.DATE) Calendar fechaFin;	
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Estado estado;
	
	private static final long serialVersionUID = 1L;

	public Tiene() {
		super();
	}   
  
	
	public Calendar getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Calendar getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}



	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
   
}


