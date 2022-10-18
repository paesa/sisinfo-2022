import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Fichero: ComandaDAO.java
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */


public class ComandaDAO {
    List<ComandaVO> comandas;
    public PlatoDAO(){
        comandas=new ArrayList<ComandaVO>();
    }
    public void anyadirComanda(ComandaVO c){
        comandas.add(c);
    }
    public void eliminarComanda(ComandaVO c){
        comandas.remove(p.obtenerIdComanda);
    }
    public ComandaVO obtenerComanda(int idComanda){
        return(comandas.get(idComanda));
    }
    public List<ComandaVO> obtenerComandas(){
        return(comandas);
    }
}
