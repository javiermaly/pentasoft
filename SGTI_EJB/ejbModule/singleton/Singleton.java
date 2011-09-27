package singleton;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import stateless.ClienteRemote;
import stateless.FacadeRemote;
import stateless.TareaRemote;
import stateless.UsuarioRemote;

public class Singleton {

	public Singleton() {

	}

	public UsuarioRemote conectarMU() {

		try {
			// Acceso a JNDI
			Properties properties = new Properties();
			properties.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.URL_PKG_PREFIXES,
					"org.jboss.naming:org.jnp.interfaces");
			properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			Context ctx = new InitialContext(properties);

			// Llamada al Stateless
			// System.out.println("########\nVoy a llamar al Stateless EJB.\n########");
			UsuarioRemote statelessUsuario = (UsuarioRemote) ctx
					.lookup("SGTI_EAR/ManagerU/remote");// /???????????
			return statelessUsuario;

		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}

	}

	public ClienteRemote conectarMC() {

		try {
			// Acceso a JNDI
			Properties properties = new Properties();
			properties.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.URL_PKG_PREFIXES,
					"org.jboss.naming:org.jnp.interfaces");
			properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			Context ctx = new InitialContext(properties);

			// Llamada al Stateless
			// System.out.println("########\nVoy a llamar al Stateless EJB.\n########");
			ClienteRemote statelessCliente = (ClienteRemote) ctx
					.lookup("SGTI_EAR/ManagerC/remote");// /???????????
			return statelessCliente;

		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}

	}

	public TareaRemote conectarMT() {

		try {
			// Acceso a JNDI
			Properties properties = new Properties();
			properties.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.URL_PKG_PREFIXES,
					"org.jboss.naming:org.jnp.interfaces");
			properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			Context ctx = new InitialContext(properties);

			// Llamada al Stateless
			// System.out.println("########\nVoy a llamar al Stateless EJB.\n########");
			TareaRemote statelessTarea = (TareaRemote) ctx
					.lookup("SGTI_EAR/ManagerT/remote");// /???????????
			return statelessTarea;

		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}

	}

	public FacadeRemote conectarFacade() {

		try {
			// Acceso a JNDI
			Properties properties = new Properties();
			properties.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.URL_PKG_PREFIXES,
					"org.jboss.naming:org.jnp.interfaces");
			properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			Context ctx = new InitialContext(properties);

			// Llamada al Stateless
			// System.out.println("########\nVoy a llamar al Stateless EJB.\n########");
			FacadeRemote statelessFacade = (FacadeRemote) ctx
					.lookup("SGTI_EAR/FacadeMain/remote");// /???????????
			return statelessFacade;

		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}

	}

}
