import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * tabla users
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */


public class comandaDAO {
    List<comandaVO> comandas;
    public platoDAO(){
        comandas=new ArrayList<comandaVO>();
    }
    public void anyadirComanda(comandaVO c){
        comandas.add(c);
    }
    public void eliminarComanda(comandaVO c){
        comandas.remove(p.obtenerIdComanda);
    }
    public comandaVO obtenerComanda(int idComanda){
        return(comandas.get(idComanda));
    }
    public List<comandaVO> obtenerComandas(){
        return(comandas);
    }
}
