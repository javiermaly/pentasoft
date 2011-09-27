package stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.Cliente;
import beans.Tipo;




@Stateless
public class ManagerC implements ClienteRemote {

        @PersistenceContext(unitName = "SGTI_JPA")
        private EntityManager em;       
                
        public boolean agregarCliente(Cliente c){               
                        
                try {
                	System.out.println("agregar cliente");
                	System.out.println("EJB: doc del cliente: "+c.getCedRut());
                	if(encontrarCliente(c.getCedRut())==null){
                		System.out.println("EJB: no ta el cliente");
                        em.persist(c);  
                        return true;
                	}
                	else {
                		System.out.println("EJB: ta el cliente");
                		return false;
                	}
                } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                }
        }
        
        public boolean eliminarCliente(long cedRut){
                Cliente c;
                c = encontrarCliente(cedRut);              
                if (c!=null){   
                        try{
                                em.remove(c);
                                return true;
                        }
                        catch(Exception e){
                                e.printStackTrace();
                                return false;
                        }
                        
                }else{
                        return false;
                }               
        }               
        
        public List<Cliente> listarClientes() {         
                @SuppressWarnings(value="unchecked")//para que deje de mostrar advertencia List need unchecked convertion
                List<Cliente> listaClientes = em.createNamedQuery("todosClientes").getResultList();
                return listaClientes;
        }
                
        public Cliente encontrarCliente(long cedRut){
        	System.out.println("EJB encontrarCliente: "+cedRut);
                Cliente p = em.find(Cliente.class, cedRut);
                return p;
        }
        
        public Cliente actualizarCliente(Cliente u){
        		u = em.merge(u);
                return u;       
        }
        
   
        
}