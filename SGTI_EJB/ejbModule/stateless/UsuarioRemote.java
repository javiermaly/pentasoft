package stateless;

import java.util.List;

import javax.ejb.Remote;

import beans.Encargado;
import beans.Usuario;

@Remote
public interface UsuarioRemote  {

	public boolean agregarUsuario(Usuario u);	
	public boolean eliminarUsuario(long ced);	
	public List<Usuario> listarUsuarios();	
	public Usuario encontrarUsuario(long ced);
	public boolean actualizarUsuario(Usuario u);
	public Usuario login(long ced, String pwd);
	public List<Encargado> listarEncargadosHabilitados();
}
