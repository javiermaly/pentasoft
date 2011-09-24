package stateless;

import java.util.List;

import javax.ejb.Remote;

import beans.Encargado;
import beans.Tecnico;
import beans.Usuario;

@Remote
public interface UsuarioRemote  {

	public boolean agregarUsuario(Usuario u);	
	public boolean eliminarUsuario(long ced);	
	public List<Usuario> listarUsuarios();
	public List<Tecnico> listarTecnicos();	
	public List<Usuario> listarTecnicosGrupo(Encargado e);	
	public Usuario encontrarUsuario(long ced);
	public boolean actualizarUsuario(Usuario u);
	public Usuario login(long ced, String pwd);
	public List<Encargado> listarEncargadosHabilitados();
}
