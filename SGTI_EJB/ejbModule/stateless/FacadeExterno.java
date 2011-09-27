package stateless;

import javax.ejb.Stateless;
import javax.jws.WebMethod;

import beans.Tarea;

import singleton.Singleton;

@Stateless
public class FacadeExterno implements FacadeExternoRemote {
	
	

    Singleton singleton = new Singleton();
    TareaRemote statelessMTar = singleton.conectarMT();
    UsuarioRemote statelessMUsu = singleton.conectarMU();
    ClienteRemote statelessMCli = singleton.conectarMC(); 
	
    String separador="#";

    @WebMethod
	public String buscarTareaExterno(long idTarea){
		String tarea="";
		String descripcion="";
		String esExterna="";
		int diaFechaComprometida;
		int mesFechaComprometida;
		int anioFechaComprometida;
		String observaciones="";
		long cedCliente;
		String tipoTarea="";
		Tarea t = statelessMTar.encontrarTarea(idTarea);
		
		descripcion=t.getDescripcion();
		if(t.getEsExterna()==true){
			esExterna="Si";
		}
		else{
			esExterna="No";
		}
		diaFechaComprometida=t.getFechaComprometida().DAY_OF_WEEK;
		mesFechaComprometida=t.getFechaComprometida().MONTH;
		anioFechaComprometida=t.getFechaComprometida().YEAR;
		observaciones=t.getObservacion();
		cedCliente=t.getCliente().getCedRut();
		tipoTarea=t.getTipo().getDescripcion();
		
		tarea=idTarea+separador+descripcion+separador+esExterna+separador+diaFechaComprometida+separador+mesFechaComprometida+separador+anioFechaComprometida+separador+observaciones+separador+cedCliente+separador+tipoTarea;
		return tarea;
	}
	
	@WebMethod
	public boolean loginExterno(long usuario, String pwd){
		boolean logueado=false;
		
		if(statelessMUsu.login(usuario, pwd)!=null){
			logueado=true;
		}
		return logueado;
		
	}
	@WebMethod
	public boolean tomarTareaExterno(long idTarea){
		boolean retorno=false;
		
		Tarea t=statelessMTar.encontrarTarea(idTarea);
		
		if(statelessMTar.tomarTarea(t)){
			retorno=true;
		}
		
		
		return retorno;
		
	}
}
