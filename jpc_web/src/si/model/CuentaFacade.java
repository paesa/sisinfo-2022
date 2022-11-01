import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import es.unizar.util.db.SimpleDataSource;
import util.exception.CorreoInvalido; //-------------
import util.exception.ContrasegnaInvalida; //---------------
import util.exception.CorreoYaRegistrado; //------------------
import si.dao.CuentaDAO;
import si.vo.CuentaVO;


public class CuentaFacade {
    
    //Constructor
    public CuentaFacade() {
    }

    public CuentaVO registrarCuenta(String apodo, String correo, String contrasegna) throws CorreoYaRegistrado  {
        CuentaVO cuentaVO = new CuentaVO()
        return null;
    }

    public CuentaVO iniciarCuenta(String correo, String contrasegna) throws CorreoInvalido, ContrasegnaInvalida {
        
        return null;
    }
}