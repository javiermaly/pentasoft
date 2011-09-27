package negocio;



import java.util.Date;
import java.util.Calendar;

import beans.Cliente;

public class ClienteSession {

	public Cliente clienteSession;
	
	public Date fechaGarant;
	
//	public ClienteSession() {
//		Calendar fechG= clienteSession.getFechaFinGarantia();
//		fechaGarant = fechG.getTime();
//	}

	public Cliente getClienteSession() {
		return clienteSession;
	}

	public void setClienteSession(Cliente clienteSession) {
		System.out.println("set de Cliente session");
		this.clienteSession = clienteSession;
	}
	

	public Date getFechaGarant() {
		return fechaGarant;
	}

	public void setFechaGarant(Date fechaGarant) {
		
		this.fechaGarant = fechaGarant;
	}

	public Date dameFechaDate() {
		//clienteSession= new Cliente();
		Calendar fechG= clienteSession.getFechaFinGarantia();
		Date fecha = fechG.getTime();
		return fecha;
	}
	
	
	
}
