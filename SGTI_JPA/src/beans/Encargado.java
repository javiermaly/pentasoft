package beans;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQueries(value = { 
		@NamedQuery(name="todosEncargadosHabilitados", query="select e from Encargado e where e.habilitado=true"),
		
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
