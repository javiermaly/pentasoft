package beans;

import java.io.Serializable;

import java.util.Calendar;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Realiza
 *
 */
@Entity
public class Realiza implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private @Temporal(TemporalType.DATE) Calendar fechaInicio;
	private @Temporal(TemporalType.DATE) Calendar fechaFin;
	@ManyToOne
	private Usuario usu;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Tarea tarea;
	
	
	private static final long serialVersionUID = 1L;

	
	public Realiza() {
		super();
	}   
	
	
	public Realiza(int id, Calendar fechaInicio, Calendar fechaFin,
			Usuario usu, Tarea tarea) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.usu = usu;
		this.tarea = tarea;
	}


	public Calendar getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}   
	public Calendar getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}   
	public Usuario getUsu() {
		return this.usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	public Tarea getTarea() {
		return tarea;
	}   
	
	
   
}
