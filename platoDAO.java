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


public class platoDAO {
    List<platoVO> platos;
    private static String countByUserName = "SELECT count(*) cuenta FROM users WHERE username = ?";
    private static String findByUserName = "SELECT * FROM users WHERE username = ?";
    private static String updateDate = "UPDATE users set last_login = current_timestamp where username = ?";
    public platoDAO(){
        platos=new ArrayList<platoVO>();
    }
    public void anyadirPlato(platoVO p){
        platos.add(p);
    }
    public void eliminarPlato(platoVO p){
        platos.remove(p.obtenerIdPlato);
    }
    public platoVO obtenerPlato(int idPlato){
        return(platos.get(idPlato));
    }
    public List<platoVO> obtenerPlatos(){
        return(platos);
    }
}
