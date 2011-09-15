package stateless;

import java.util.List;

import javax.ejb.Remote;

import beans.Cliente;

@Remote
public interface ClienteRemote {
	
	public boolean agregarCliente(Cliente c);	
	public boolean eliminarCliente(long cedRut);	
	public List<Cliente> listarClientes();	
	public Cliente encontrarCliente(long cedRut);	
	public Cliente actualizarCliente(Cliente u);
		
}
