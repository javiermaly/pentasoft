package stateless;

import javax.ejb.Remote;

@Remote
public interface FacadeExternoRemote {

	public String buscarTareaExterno(long idTarea);
	public boolean loginExterno(long usuario, String pwd);
	public boolean tomarTareaExterno(long idTarea);
}
