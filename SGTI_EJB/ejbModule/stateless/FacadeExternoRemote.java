package stateless;

import javax.ejb.Remote;

@Remote
public interface FacadeExternoRemote {

	public String buscarClienteExterno(long doc);
	public String buscarTareaExterno(long idTarea);
	public boolean loginExterno(long usuario, String pwd);
	public boolean tomarTareaExterno(long idTarea);
	public boolean finalizarTareaExterno(long idTarea);
}
