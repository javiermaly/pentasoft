package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import stateless.FacadeRemote;
import beans.Encargado;
import beans.Grupo;
import conexion.ConexionEJB;

public class GrupoBean {
	private int id = 0;
	private String descripcion;
	private String encargadoCed;
	private Encargado encargadoActual;
	private SelectItem selItem;
	private List<Grupo> listGrupos;
	// private String encargadoSeleccionado;
	private int evento = 0;

	ConexionEJB con = new ConexionEJB();
	FacadeRemote statelessFacade = con.conectar();

	@SuppressWarnings("rawtypes")
	private ArrayList encargadosHabilitados = new ArrayList();

	@SuppressWarnings("rawtypes")
	private ArrayList encargadosSinGrupo = new ArrayList();

	@SuppressWarnings("rawtypes")
	private ArrayList encargadosSinGrupoMasEncargadoActual = new ArrayList();

	// public String getEncargadoSeleccionado() {
	// Grupo gr = statelessFacade.buscarGrupo(id);
	// if (gr != null) {
	// System.out.println(gr.getDescripcion());
	// encargadoSeleccionado = gr.getEnc().getCedula()+""; // This will be
	// // the
	// // default
	// // selected
	// // item.
	// }
	// return encargadoSeleccionado;
	// }

	// public void setEncargadoSeleccionado(String encargado) {
	// System.out.println("encargado ced: "+encargado);
	// this.encargadoSeleccionado = encargado;
	// }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEncargadoCed() {
//		Grupo gr = statelessFacade.buscarGrupo(id);
//		if (gr != null) {
//			System.out.println(gr.getDescripcion());
//			encargadoCed = gr.getEnc().getCedula() + ""; // This will be
//															// the
//															// default
//															// selected
//															// item.
//		}

		return encargadoCed;
	}

	public void setEncargadoCed(String encargado) {
		this.encargadoCed = encargado;
	}

	public int getEvento() {
		return evento;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}

	public List<Grupo> getListGrupos() {
		listGrupos = statelessFacade.listGrupos();
		return listGrupos;
	}

	public void setListGrupos(List<Grupo> listGrupos) {
		this.listGrupos = listGrupos;
	}
	

	public Encargado getEncargadoActual() {
		
		return encargadoActual;
	}

	public void setEncargadoActual(Encargado encargadoActual) {
		this.encargadoActual = encargadoActual;
	}

	@SuppressWarnings("rawtypes")
	public void setEncargadosHabilitados(ArrayList encargadosHabilitados) {
		this.encargadosHabilitados = encargadosHabilitados;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList getEncargadosHabilitados() {

		List<Encargado> encargados = statelessFacade
				.listarEncargadosHabilitados();
		encargadosHabilitados.clear();
		for (int i = 0; i < encargados.size(); i++) {
			Encargado enc = new Encargado();
			enc = (Encargado) encargados.get(i);

			encargadosHabilitados.add(new SelectItem(enc.getCedula(), enc
					.getApellido()));
		}
		return encargadosHabilitados;
	}

	@SuppressWarnings("unchecked")
	public ArrayList getEncargadosSinGrupo() {
		System.out.println("Entro al metodo getEncargadosSinGrupo");
		
		List<Encargado> encargados = statelessFacade.listarEncargadosJoaquin(Long.parseLong(encargadoCed));
		encargadosSinGrupo.clear();
		for (int i = 0; i < encargados.size(); i++) {
			Encargado enc = new Encargado();
			enc = (Encargado) encargados.get(i);

			encargadosSinGrupo.add(new SelectItem(enc.getCedula(), enc
					.getApellido()));
			System.out.println(enc.getCedula() + enc.getApellido());
		}
		return encargadosSinGrupo;
	}

	public void setEncargadosSinGrupo(ArrayList encargadosSinGrupo) {

		this.encargadosSinGrupo = encargadosSinGrupo;
	}

	@SuppressWarnings("unchecked")
	public ArrayList getEncargadosSinGrupoMasEncargadoActual() {
	//	encargadosSinGrupoMasEncargadoActual.clear();
		List<Encargado> encargados = statelessFacade.listarEncargadosSinGrupo();
		
		Grupo g = statelessFacade.buscarGrupo(id);
		Encargado enc=g.getEnc();
		
		System.out.println("getEncargadosSinGrupoMasEncargadoActual " +enc.getCedula() );
		
		encargadosSinGrupoMasEncargadoActual.add(new SelectItem(enc.getCedula(),enc.getApellido()));
		
		for (int i = 0; i < encargados.size(); i++) {
			Encargado enca = new Encargado();
			enca = (Encargado) encargados.get(i);

			encargadosSinGrupoMasEncargadoActual.add(new SelectItem(enca
					.getCedula(), enca.getApellido()));
			System.out.println(enca.getCedula() + enca.getApellido());
		}
		return encargadosSinGrupoMasEncargadoActual;
	}

	public void setEncargadosSinGrupoMasEncargadoActual(
			ArrayList encargadosSinGrupoMasEncargadoActual) {
		this.encargadosSinGrupoMasEncargadoActual = encargadosSinGrupoMasEncargadoActual;
	}

	public String altaGrupo() {
		System.out.println(encargadoCed);
		Encargado encargado = (Encargado) statelessFacade.encontrarUsuario(Long
				.valueOf(encargadoCed));

		Grupo g = new Grupo();
		g.setDescripcion(getDescripcion());
		g.setEnc(encargado);

		if (statelessFacade.altaGrupo(g)) {
			evento = 1;
			return "altaGrupoOK";
		}

		return "altaGrupoFallo";
	}

	// public String listarGrupos(){
	// System.out.println("listar grupos");
	// listGrupos=statelessFacade.listGrupos();
	// for (Grupo grupo : listGrupos) {
	// System.out.println(grupo.getDescripcion());
	//
	// }
	// return "";
	//
	// }
//	public String buscarGrupo() {
//		System.out.println("id de grupo que me llega" + id);
//		// this.id = getId();
//		Grupo gr = new Grupo();
//		//encargadoActual=new Encargado();
//		try {
//			gr = statelessFacade.buscarGrupo(id);
//			System.out.println("grupo encontrado: " + gr.getDescripcion());
//			if (gr.getId() != 0) {
//				this.descripcion = gr.getDescripcion();
//				this.encargadoCed = gr.getEnc().getCedula()+"";
//				
////				this.encargadoActual.setDireccion(encargadoCed);
////				this.encargadoActual.setApellido("pepito");
//				//this.encargadoActual=gr.getEnc();
//				System.out.println(encargadoCed);
//				this.evento = 4;// encontrado
//				
//				return "grupoEncontrado";
//			} else {
//				System.out.println("grupo nulo!!");
//				this.evento = 3;// noexiste
//				return "grupoNoEncontrado";
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			this.evento = 3;// noexiste
//			return "grupoNoEncontrado";
//
//		}
//
//	}

	public String buscarGrupo() {
		System.out.println("id de grupo que me llega" + id);
		// this.id = getId();
		Grupo gr = new Grupo();
		try {
			gr = statelessFacade.buscarGrupo(id);
			System.out.println("grupo encontrado: " + gr.getDescripcion());
			if (gr.getId() != 0) {
				this.descripcion = gr.getDescripcion();
				this.encargadoCed = gr.getEnc().getCedula()+"";
				this.evento = 4;// encontrado
				System.out.println(encargadoCed);
				return "grupoEncontrado";
			} else {
				System.out.println("grupo nulo!!");
				this.evento = 3;// noexiste
				return "grupoNoEncontrado";
			}

		} catch (Exception e) {
			this.evento = 3;// noexiste
			return "grupoNoEncontrado";

		}

	}
	public String eliminarGrupo() {
		Grupo g = new Grupo();
		System.out.println(id);
		g = statelessFacade.buscarGrupo(getId());
		System.out.println(g.getDescripcion());
		if (statelessFacade.bajaGrupo(g)) {
			System.out.println("grupo eliminado");
			evento = 1;
			return "grupoEliminado";

		} else {
			System.out.println("grupo no eliminado");
			evento = 4;
			return "grupoNoEliminado";
		}
	}

//	public String modificarGrupo() {
////		System.out.println("Modificar grupo, cedula del encargado que recibo: "
////				+ selItem.getValue());
//
//		Encargado encargado = (Encargado) statelessFacade.encontrarUsuario(Long
//				.valueOf(encargadoCed));
//
//		System.out.println(encargado.getApellido());
//
//		System.out.println("id del grupo a modificar: " + id);
//		Grupo g = statelessFacade.buscarGrupo(id);
//		System.out.println("modifico el grupo: " + g.getDescripcion());
//		g.setDescripcion(getDescripcion());
//		g.setEnc(encargado);
//
//		if (statelessFacade.modificarGrupo(g) != null) {
//			evento = 1;
//			return "grupoModificado";
//		} else
//			evento = 6;
//		return "grupoNoModificado";
//	}


	public String modificarGrupo() {
		System.out.println("modificar grupo, cedula del encargado que recibo: "
				+ encargadoCed);

		Encargado encargado = (Encargado) statelessFacade.encontrarUsuario(Long
				.valueOf(encargadoCed));

		System.out.println(encargado.getApellido());

		System.out.println("id del grupo a modificar: " + id);
		Grupo g = statelessFacade.buscarGrupo(id);
		System.out.println("modifico el grupo: " + g.getDescripcion());
		g.setDescripcion(getDescripcion());
		g.setEnc(encargado);

		if (statelessFacade.modificarGrupo(g) != null) {
			evento = 1;
			return "grupoModificado";
		} else
			evento = 6;
		return "grupoNoModificado";
	}
	
	public void setSelItem(SelectItem selItem) {
		this.selItem = selItem;
	}

	public SelectItem getSelItem() {
		return selItem;
	}

}
