package negocio;

import java.util.Calendar;
import java.util.Date;

import stateless.FacadeRemote;
import conexion.ConexionEJB;
import beans.Cliente;
import java.util.List;
public class ClienteBean {

	private long cedRut;
	private String nombreRazSocial;
	private String direccion;
	private String telefono;
	private Date fechaFinGarantia;
	private ClienteSession cliSession;
	private List<Cliente> listClientes;
	List<ClienteSession> listClienteSession = null;
	private boolean empresa;
	private int evento=0;//1=exito 2=error 3=noexiste 4=encontrado

	ConexionEJB con = new ConexionEJB();
	FacadeRemote statelessFacade = con.conectar();

	public long getCedRut() {
		return cedRut;
	}

	public void setCedRut(long cedRut) {
		this.cedRut = cedRut;
	}

	public ClienteSession getCliSession() {
		return cliSession;
	}

	public void setCliSession(ClienteSession cliSession) {
		this.cliSession = cliSession;
	}

	public String getNombreRazSocial() {
		return nombreRazSocial;
	}

	public void setNombreRazSocial(String nombreRazSocial) {
		this.nombreRazSocial = nombreRazSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaFinGarantia() {
		return fechaFinGarantia;
	}

	public void setFechaFinGarantia(Date fechaFinGarantia) {
		this.fechaFinGarantia = fechaFinGarantia;
	}
public List<ClienteSession> getListClienteSession() {
		return listClienteSession;
}
	public void setListClienteSession(List<ClienteSession> listClienteSession) {
	this.listClienteSession = listClienteSession;


}



	public List<Cliente> getListClientes() {
		System.out.println("listado clientes");
		listClientes=statelessFacade.listadoClientes();
		return listClientes;
	}

	public void setListClientes(List<Cliente> listClientes) {
		this.listClientes = listClientes;
	}
	public int getEvento() {
		return evento;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}	
	
	public boolean isEmpresa() {
		return empresa;
	}

	public void setEmpresa(boolean empresa) {
		this.empresa = empresa;
	}

	// buscador para Clientes
	public String buscarCliente() {
		Cliente c = new Cliente();
		c = statelessFacade.buscarCliente(cedRut);
		if (c != null) {
			cliSession.setClienteSession(null);
			cliSession.setClienteSession(c);
			if(cliSession.getClienteSession().getFechaFinGarantia()!=null){
				Calendar fechG= cliSession.getClienteSession().getFechaFinGarantia();//si tiene fechaGarantia cargada la pasamos a Date
				Date fechaGarant = fechG.getTime();
				cliSession.fechaGarant=fechaGarant;
			}else {
				
				cliSession.fechaGarant=null;
			}
			System.out.println(cliSession.getClienteSession().getNombre_RazonSocial());
			System.out.println("cliente encontrado y puesto en la session");
			evento=4;//encontrado
			return "clienteEcontrado";
		} else {
			
			cliSession.setClienteSession(null);
			System.out.println("cliente nulo!!");
			Cliente cli = new Cliente();
			cli.setCedRut(cedRut);
			cliSession.setClienteSession(cli);
			
			evento=3;//noexiste
			return "clienteNoEncontrado";
		}
	}

	public String altaCliente() {
		Long ceduln = cliSession.clienteSession.getCedRut();
		System.out.println("veo si llega la cedula: "+ceduln);
		Cliente c = new Cliente();
		// c=cliSession.getClienteSession();
		c.setCedRut(ceduln);
		c.setDireccion(getDireccion());
		c.setNombre_RazonSocial(getNombreRazSocial());
		c.setTelefono(getTelefono());
		c.setEmpresa(empresa);
	
		if (!(fechaFinGarantia == null)) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(fechaFinGarantia);
			c.setFechaFinGarantia(cal);
		}
		System.out.println("altacliente en clienteBean" + c.getCedRut());
		System.out.println(c.getNombre_RazonSocial());
		if (statelessFacade.altaCliente(c)) {
			evento=1;
			cliSession.setClienteSession(null);
			return "altaClienteOK";
		} else
			evento=2;
		cliSession.setClienteSession(null);
			return "falloAltaCliente";
	}

	public String modificarCliente() {
		System.out.println("modificar cliente");
		Long ceduln = cliSession.clienteSession.getCedRut();
		System.out.println("veo si llega la cedula: "+ceduln);
		Cliente c = statelessFacade.buscarCliente(ceduln);
		if (!(c == null)) {
			c.setCedRut(ceduln);
			c.setNombre_RazonSocial(cliSession.getClienteSession().getNombre_RazonSocial());
			c.setTelefono(cliSession.getClienteSession().getTelefono());
			c.setDireccion(cliSession.getClienteSession().getDireccion());
	
			if (cliSession.getFechaGarant()!= null){
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(cliSession.getFechaGarant());
				c.setFechaFinGarantia(cal);
				System.out.println();
			}
			
			cliSession.setClienteSession(c);
			if(!((statelessFacade.modificarCliente(c))==null)){
				evento=1;//exito
				cliSession.setClienteSession(null);
				return "clienteModificado";
				
			}
			else
				evento=2;//error
			cliSession.setClienteSession(null);
				return "errorModificarCliente";
				

		}
		else 
			evento=3;//noexiste
		cliSession.setClienteSession(null);
			return "clienteNoExiste";

	}
	
	public String bajaCliente(){
		Cliente c=cliSession.getClienteSession();
		if(statelessFacade.bajaCliente(c)){
			evento=1;
			return "bajaClienteOK";
		}
		else
			evento=2;
			return "errorBajaCliente";
	}
	public String listadoClientes(){
		System.out.println("listado");
		
		listClientes=statelessFacade.listadoClientes();
			
		
		for (Cliente cliente : listClientes) {
			System.out.println(cliente.getNombre_RazonSocial());
			
		}
		
		return "";
		
	}
}
