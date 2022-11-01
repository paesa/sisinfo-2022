import java.util.ArrayList;
import java.util.List;
/**
 * Fichero: CuentaDAO.java
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */


public class CuentaDAO {
    List<CuentaVO> cuentas;
    
    //Constructor
    public CuentaDAO(){
        cuentas=new ArrayList<CuentaVO>();
    }
    public void anyadirCuenta(CuentaVO c){
        cuentas.add(c);
    }
    public void eliminarCuenta(CuentaVO c){
        cuentas.remove(c.obtenerIdCuenta());
    }
    public CuentaVO obtenerCuenta(int idCuenta){
        return(cuentas.get(idCuenta));
    }
    public List<CuentaVO> obtenerCuentas(){
        return(cuentas);
    }
}
