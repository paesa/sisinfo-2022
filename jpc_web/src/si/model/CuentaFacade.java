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
        CuentaVO cuentaVO = new CuentaVO(,correo,apodo,contrasegna,) //id random y tipo cuenta
        CuentaDAO userDAO = (CuentaDAO) new CuentaDAO();
		Connection connection =null;
		try {	
            connection = this.dataSource.getConnection();
            if (connection == null) System.out.println("Conexión es: null");
            if (connection != null) System.out.println("Conexión es: not null "+ connection);
            if (CuentaDAO.exist(connection, CuentaVO.obtenerCorreo())) {
                throw new CorreoYaRegistrado();
            }else{
                CuentaDAO.create(connection, CuentaVO);
            } 
		} catch (SQLException e) {
			throw new InternalErrorException(e);
		} finally {
			try {
				if (connection !=null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new InternalErrorException(e);
			}
		}
        return null;
    }

    public CuentaVO iniciarCuenta(String correo, String contrasegna) throws CorreoInvalido, ContrasegnaInvalida {
        CuentaDAO userDAO = (CuentaDAO) new CuentaDAO();
		Connection connection =null;
		CuentaVO result = null;
		try {
			connection = this.dataSource.getConnection();
			if (CuentaDAO.exist(connection, correo)) {
                result = CuentaDAO.find(connection, correo);
				if (result.contrasegna != constrasegna) {
                    result = null;
                    System.out.println("La contraseña es incorrecta");
				    throw new ContrasegnaInvalida();		
                }
			}else {
				System.out.println("No es usuario del sistema");
				throw new CorreoInvalido();				
			}
			return result;
		}catch (SQLException e) {
			throw new InternalErrorException(e);
		}finally {
			try {
				if (connection !=null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new InternalErrorException(e);
			}
		}
        return null;
    }
}