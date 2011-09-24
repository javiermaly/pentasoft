package beans;

import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQueries(value = { 
		@NamedQuery(name="todosEncargadosHabilitados", query="select e from Encargado e where e.habilitado=true"),
		@NamedQuery(name="encargadosJoaquin", query="SELECT e FROM Encargado AS e WHERE e.cedula NOT IN (SELECT g.enc.cedula FROM Grupo g) OR e.cedula = :cedEncargado"),
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
