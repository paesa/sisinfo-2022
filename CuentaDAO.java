import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import es.unizar.sisinf.grp1.db.ConnectionManager;

/**
 * Fichero: CuentaDAO.java
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */


public class CuentaDAO {
    List<CuentaVO> cuentas;
    public CuentaDAO(){
        cuentas=new ArrayList<CuentasVO>();
    }
    public void anyadirCuenta(CuentaVO c){
        cuentas.add(c);
    }
    public void eliminarCuenta(CuentaVO c){
        cuentas.remove(c.obtenerIdCuenta);
    }
    public CuentaVO obtenerCuenta(int idCuenta){
        return(cuentas.get(idCuenta));
    }
    public List<CuentaVO> obtenerCuentas(){
        return(cuentas);
    }
}
