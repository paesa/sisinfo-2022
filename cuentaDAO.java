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


public class cuentaDAO {
    List<cuentaVO> cuentas;
    public cuentaDAO(){
        cuentas=new ArrayList<cuentasVO>();
    }
    public void anyadirCuenta(cuentaVO c){
        cuentas.add(c);
    }
    public void eliminarCuenta(cuentaVO c){
        cuentas.remove(p.obtenerIdCuenta);
    }
    public cuentaVO obtenerCuenta(int idCuenta){
        return(cuentas.get(idCuenta));
    }
}
