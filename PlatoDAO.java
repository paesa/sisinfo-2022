import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import es.unizar.sisinf.grp1.db.ConnectionManager;

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
        platos.remove(p.obtenerIdPlato);
    }
    public PlatoVO obtenerPlato(int idPlato){
        return(platos.get(idPlato));
    }
    public List<PlatoVO> obtenerPlatos(){
        return(platos);
    }
}
