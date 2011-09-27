package beans;

import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQueries(value = { 
		@NamedQuery(name="todosEncargadosHabilitados", query="select e from Encargado e where e.habilitado=true"),
		@NamedQuery(name="encSinGrupo", query="select e from Encargado e where e.cedula NOT IN (select g.enc.cedula from Grupo g)"),
		
		
	})
	
	

@Entity
public class Encargado extends Tecnico {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Encargado(){
		super();
	}


}
