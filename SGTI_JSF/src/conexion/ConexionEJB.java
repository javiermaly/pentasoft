package conexion;

import singleton.Singleton;
import stateless.FacadeRemote;

public class ConexionEJB {
	
	public FacadeRemote conectar(){
		
		Singleton singleton = new Singleton();//acceso al JNDI
		FacadeRemote statelessFacade=null;
		try{
			statelessFacade = singleton.conectarFacade();
		}catch(Exception e){
			e.printStackTrace();
		}
		return statelessFacade;
	
	}
	


}
