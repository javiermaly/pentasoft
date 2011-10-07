package stateless;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import beans.Cliente;
import beans.Tarea;

import singleton.Singleton;

@WebService
@Stateless
public class FacadeExterno implements FacadeExternoRemote {

	Singleton singleton = new Singleton();
	TareaRemote statelessMTar = singleton.conectarMT();
	UsuarioRemote statelessMUsu = singleton.conectarMU();
	ClienteRemote statelessMCli = singleton.conectarMC();

	String separador = "|";

	@WebMethod
	public String buscarClienteExterno(long doc) {
		long cedRut;
		String empresa;
		String nombre_RazonSocial;
		String telefono;
		String direccion;
		String cliente;
		
		Cliente c = statelessMCli.encontrarCliente(doc);
		cedRut=c.getCedRut();
		if (c.getEmpresa() == true) {
			empresa = "Si";
		} else {
			empresa = "No";
		}
		nombre_RazonSocial=c.getNombre_RazonSocial();
		telefono=c.getTelefono();
		direccion=c.getDireccion();
		
	

		cliente = cedRut + separador + empresa + separador + nombre_RazonSocial
				+ separador + telefono + separador
				+ direccion;
		return cliente;
	}

	@WebMethod
	public String buscarTareaExterno(long idTarea) {
		String tarea = "";
		String descripcion = "";
		String esExterna = "";
		int diaFechaComprometida;
		int mesFechaComprometida;
		int anioFechaComprometida;
		String observaciones = "";
		long cedCliente;
		String tipoTarea = "";
		Tarea t = statelessMTar.encontrarTarea(idTarea);

		descripcion = t.getDescripcion();
		if (t.getEsExterna() == true) {
			esExterna = "Si";
		} else {
			esExterna = "No";
		}
		diaFechaComprometida = t.getFechaComprometida().DAY_OF_WEEK;
		mesFechaComprometida = t.getFechaComprometida().MONTH;
		anioFechaComprometida = t.getFechaComprometida().YEAR;
		observaciones = t.getObservacion();
		cedCliente = t.getCliente().getCedRut();
		tipoTarea = t.getTipo().getDescripcion();

		tarea = idTarea + separador + descripcion + separador + esExterna
				+ separador + diaFechaComprometida + separador
				+ mesFechaComprometida + separador + anioFechaComprometida
				+ separador + observaciones + separador + cedCliente
				+ separador + tipoTarea;
		return tarea;
	}

	@WebMethod
	public boolean loginExterno(long usuario, String pwd) {
		boolean logueado = false;
		System.out.println("Usuario: " + usuario + ", Pwd: " + pwd);
		if (statelessMUsu.login(usuario, pwd) != null) {
			logueado = true;
		}
		return logueado;

	}

	@WebMethod
	public boolean tomarTareaExterno(long idTarea) {
		boolean retorno = false;

		Tarea t = statelessMTar.encontrarTarea(idTarea);

		if (statelessMTar.tomarTarea(t)) {
			retorno = true;
		}

		return retorno;

	}

	@WebMethod
	public boolean finalizarTareaExterno(long idTarea) {
		boolean retorno = false;

		Tarea t = statelessMTar.encontrarTarea(idTarea);

		if (statelessMTar.finalizarTarea(t)) {
			retorno = true;
		}

		return retorno;

	}

}
