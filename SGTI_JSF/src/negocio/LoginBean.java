package negocio;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import beans.Administrador;
import beans.Administrativo;
import beans.Encargado;
import beans.Tecnico;
import beans.Usuario;

import stateless.FacadeRemote;
import conexion.ConexionEJB;


public class LoginBean {
	UsuarioBean usuSession;
	private long cedula;
	private String pwd;
	private int evento=0;
	private String pwd2;

	ConexionEJB con = new ConexionEJB();
	FacadeRemote statelessFacade = con.conectar();

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public UsuarioBean getUsuSession() {
		return usuSession;
	}

	public void setUsuSession(UsuarioBean usuSession) {
		this.usuSession = usuSession;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}

	public int getEvento() {
		return evento;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getPwd2() {
		return pwd2;
	}

	// public int getPerfil() {
	// return perfil;
	// }
	// public void setPerfil(int perfil) {
	// this.perfil = perfil;
	// }
	public String login() {

		if (!((statelessFacade.login(cedula, pwd)) == null)) {
			Usuario u = statelessFacade.encontrarUsuario(cedula);
			usuSession.setUsuarioSession(u);// colgar usuario de la session
			System.out.println(usuSession.getUsuarioSession().getApellido());
			System.out.println("metodo login");

			if (usuSession.getUsuarioSession().isHabilitado()) {
				if (usuSession.getUsuarioSession() instanceof Administrador) {
					System.out.println("es administrador");
					usuSession.setPerfil(1);
					// perfil=1;

				} else if (usuSession.getUsuarioSession() instanceof Administrativo) {
					System.out.println("es administrativo");
					usuSession.setPerfil(2);
					// perfil=2;

				} else if (usuSession.getUsuarioSession() instanceof Encargado) {
					usuSession.setPerfil(3);
					// perfil=3;
					System.out.println("es encargado");

				} else if (usuSession.getUsuarioSession() instanceof Tecnico) {
					usuSession.setPerfil(4);
					// perfil=4;
					System.out.println("tecnico");

				}
				return "usuarioLogueado";

			} else {
				evento = 2;
				return "usuarioInhabilitado";
			}
		} else {
			System.out.println("error login");
			return "errorLogin";
		}

	}

	public String logOut() {
		System.out.println("logout: "
				+ usuSession.getUsuarioSession().getCedula());

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest myRequest = (HttpServletRequest) context
				.getExternalContext().getRequest();
		myRequest.getSession().invalidate();

		return "logout";
	}

	public String cambioContrasenia() {
		if (pwd.equalsIgnoreCase(pwd2)) {
			Usuario u = usuSession.usuarioSession;
			u.setPwd(pwd);
			if (statelessFacade.modifUsuario(u)) {
				evento=6;
				return "pwdCambiado";
			}
			else{
				evento=7;
				return "pwdNoCambiado";
			}
		}
		else{
			evento=8;
			return "pwdNoCambiado";
		}

	}

}
