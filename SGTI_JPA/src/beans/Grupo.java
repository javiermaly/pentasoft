package beans;

import beans.Encargado;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Grupo
 *
 */

@NamedQueries(value = { 
		@NamedQuery(name="todosGrupos", query="select g from Grupo g"),
		
	})
	
@Entity

public class Grupo implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String descripcion;
	@OneToOne(fetch=FetchType.EAGER)
	private Encargado enc;	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Tecnico> colTecnicos= new ArrayList<Tecnico>();
	
	@ManyToMany
	private List<Tarea> colTareas;
	
	private static final long serialVersionUID = 1L;
	
	
	
	public Grupo(int id, String descripcion, Encargado enc
		) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.enc = enc;
		
	}
	
	public Grupo() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}   
	public Encargado getEnc() {
		return this.enc;
	}

	public void setEnc(Encargado enc) {
		this.enc = enc;
	}
	public void setColTecnicos(List<Tecnico> colTecnicos) {
		this.colTecnicos = colTecnicos;
	}
	public List<Tecnico> getColTecnicos() {
		return colTecnicos;
	}

	public List<Tarea> getColTareas() {
		return colTareas;
	}

	public void setColTareas(List<Tarea> colTareas) {
		this.colTareas = colTareas;
	}
   
	public boolean asignaTarea(Tarea t){
		boolean retorno = false;
		if(colTareas.isEmpty()){
			colTareas= new ArrayList<Tarea>();
			colTareas.add(t);
			retorno=true;
		}
		else if (colTareas.add(t)){
			retorno=true;
		}
	return retorno;
	}
}
