import java.util.ArrayList;
import java.util.List;

/**
 * Fichero: PlatoDAO.java
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */


public class PlatoDAO {
    List<PlatoVO> platos;
    
    //Constructor
    public PlatoDAO(){
        platos=new ArrayList<PlatoVO>();
    }
    public void anyadirPlato(PlatoVO p){
        platos.add(p);
    }
    public void eliminarPlato(PlatoVO p){
        platos.remove(p.obtenerIdPlato());
    }
    public PlatoVO obtenerPlato(int idPlato){
        return(platos.get(idPlato));
    }
    public List<PlatoVO> obtenerPlatos(){
        return(platos);
    }
}
