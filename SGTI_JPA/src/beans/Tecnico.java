package beans;

import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries(value = { 
		@NamedQuery(name="todosTecnicos", query="select t from Tecnico t")		
	})
	
@NamedNativeQueries(
		{
		@NamedNativeQuery(name="tecnicosDelGrupoDelEncargado",
    query = "select * from Usuario where cedula=any(SELECT T.cedula FROM Tecnico T join Grupo_Tecnico GT join Grupo G where GT.Grupo_id = G.id and GT.colTecnicos_cedula=T.cedula and G.enc_cedula=?1)",
    resultClass=Tecnico.class)
		})
@Entity
public class Tecnico extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean esExterno;
	

	
	public Tecnico(){
		
	}
	public Tecnico(long cedula, String ape,String nom,String celular, String direccion ){
		this.setCedula(cedula);
		this.setApellido(ape);
		this.setCelular(celular);
		this.setDireccion(direccion);
		this.setNombre(nom);
		
		
	}

	public boolean isEsExterno() {
		return esExterno;
	}

	public void setEsExterno(boolean esExterno) {
		this.esExterno = esExterno;
	}
	
	
}
