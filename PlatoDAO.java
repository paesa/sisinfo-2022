import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import es.unizar.sisinf.grp1.db.ConnectionManager;

/**
 * tabla users
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */


public class PlatoDAO {
    List<PlatoVO> platos;
    private static String countByUserName = "SELECT count(*) cuenta FROM users WHERE username = ?";
    private static String findByUserName = "SELECT * FROM users WHERE username = ?";
    private static String updateDate = "UPDATE users set last_login = current_timestamp where username = ?";
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
