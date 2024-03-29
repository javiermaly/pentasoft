package stateless;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;


import beans.Encargado;
import beans.Estado;
import beans.Grupo;
import beans.Realiza;
import beans.Tarea;
import beans.Tecnico;
import beans.Tiene;
import beans.Tipo;
import beans.Usuario;

@Remote
public interface TareaRemote {
	public long agregarTarea(Tarea t, Tiene tiene, Grupo g);
	public List<Tarea> traerTodasTareas( );
	public Tarea encontrarTarea(long id);
	
	public List<Tarea> tareasPorUsuario(Usuario u);
	public Tarea actualizarTarea(Tarea t);
	public boolean eliminarTarea(Tarea t);
	//public boolean altaTareaRealiza(Tarea t, Realiza r);
	public boolean asignaTareaUsuario(Tarea t, Usuario u);
	public boolean altaGrupo(Grupo gr);
	public Grupo encontrarGrupo(int id);
	public Grupo actualizarGrupo(Grupo gr) ;
	public boolean eliminarGrupo(Grupo gr);
	public Estado encontrarEstado(int id);
	public Tiene tieneDeTarea(Tarea t);
	public boolean cambiarEstadoTarea(Tarea t, Estado est) ;
	public boolean agregarEstado(Estado est);
	public Estado actualizarEstado(int id);
	public Estado actualizarEstado(Estado est);
	public List<Estado> dameEstadosSgtes(Estado est);
	public boolean validarEstadoSiguiente(Estado estadoActual, Estado estadoSgte);
	public boolean avanzarTareaEstado(Tarea tar, Estado sigEst);
	public boolean tomarTarea(Tarea t);
	public boolean finalizarTarea(Tarea t);
	public boolean derivarTarea(Tarea t, Grupo gr);
	public boolean reabrirTarea(Tarea t);
	public boolean cerrarTarea(Tarea t);
	
	//listados
	public List<Tarea> tareasFinalizadasNoCerradas();
	public List<Tarea> listTareasAbiertasGrupos(Encargado e);//lista de tareas con estado abierta para un encargado en un determinado grupo
	public List<Grupo> listadoGrupos();
	public List<Tarea> listTareasAsignadaTecnico(Tecnico t);
	public List<Tarea> listTareasEnProcesoTecnico(Tecnico t);
	
    //buscar el tipo de tarea
    public Tipo encontrarTipo(int id);
    public List<Tipo> listadoTipos();
    
    public List<Estado> listadoEstados();
    
    //reportes
	public List<Tarea> reporteTareasFinalizadasTecnico(Usuario u);
	public List<Tarea> reporteTareasPorGrupo(Grupo g);
	public List<Tarea> reporteTareasEntraronEstado(Estado e, Date fechaU, Date fechaD);
	public List<Tarea> reporteTareasSalieronEstado(Estado e, Date fechaU, Date fechaD);
	public List<Tarea> reporteTareasNoComprometidas(Date fechaU, Date fechaD);
	public List<Tarea> reporteTareasComprometidas(Date fechaU, Date fechaD);

	
}
