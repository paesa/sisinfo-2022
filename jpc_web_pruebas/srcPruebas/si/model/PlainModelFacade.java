package src.si.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import src.si.dao.PlainCuentaDAO;
import src.si.dao.CuentaDAO;
import src.si.vo.CuentaVO;
import src.util.exception.ErrorInterno;
import src.util.exception.CorreoYaRegistrado;
import src.util.exception.CorreoInvalido;
import src.util.db.SimpleDataSource;

public class PlainModelFacade {
	
	private DataSource dataSource;

	public PlainModelFacade() throws ErrorInterno {  
		System.out.println ("He llegado a la creación de la fachada correctamente...");
		this.dataSource = new SimpleDataSource();   
		System.out.println ("Parece que soy capaz de crear la fachada correctamente...");
	}
	
	public PlainModelFacade(String datasourceorigen) throws ErrorInterno { 
		try {
			Context initialContext = new InitialContext();
			Context envContext = (Context) initialContext.lookup("java:comp/env");
			if (envContext!=null) {System.out.println("Environmental Context" + envContext.toString());} else {System.out.println("Env context is null");}			
						this.dataSource = (DataSource) envContext.lookup("jdbc/SIDB");
			if (this.dataSource!=null) {
				System.out.println("Datasource is " + dataSource.toString());
				} else {System.out.println("DataSource.... is null");}			

		}catch (Exception e) {
			e.printStackTrace();
			throw new ErrorInterno(e);
		}		
	}
	
	public void registrarCuenta(CuentaVO cuentaVO) throws ErrorInterno, CorreoYaRegistrado{
		CuentaDAO cuentaDAO = (CuentaDAO) new PlainCuentaDAO();
		Connection connection =null;
		try {
			
		connection = this.dataSource.getConnection();
		if (connection == null) System.out.println("Conexión es: null");
		if (connection != null) System.out.println("Conexión es: not null "+ connection);
		if (cuentaDAO.existe(connection, cuentaVO.obtenerCorreo())) {
			throw new CorreoYaRegistrado();
		}else{
				cuentaDAO.crea(connection, cuentaVO);
		}
				
		}catch (SQLException e) {
			throw new ErrorInterno(e);
		}finally {
			try {
				if (connection !=null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new ErrorInterno(e);
			}
		}
	}
	
	public void cambiarPerfil(CuentaVO cuentaVO) throws ErrorInterno, CorreoInvalido{
		CuentaDAO cuentaDAO = (CuentaDAO) new PlainCuentaDAO();
		Connection connection =null;
		try {
			connection = this.dataSource.getConnection();
			if (cuentaDAO.existe(connection, cuentaVO.obtenerCorreo())) {
				cuentaDAO.actualiza(connection, cuentaVO);
			}else {
				System.out.println("No es usuario del sistema");
				throw new CorreoInvalido();				
			}
		}catch (SQLException e) {
			throw new ErrorInterno(e);
		}finally {
			try {
				if (connection !=null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new ErrorInterno(e);
			}
		}	
	}
	
	public void cambiarClave(CuentaVO cuentaVO) throws ErrorInterno, CorreoInvalido{
		cambiarPerfil(cuentaVO);
	}
	
	public Collection <CuentaVO> encontrarUsuarios() 
		throws ErrorInterno{
		Collection <CuentaVO> result = null;
		CuentaDAO cuentaDAO = (CuentaDAO) new PlainCuentaDAO();
		Connection connection =null;
		try {
			connection = this.dataSource.getConnection();
			result = cuentaDAO.muestraTodos(connection);
		}catch (SQLException e) {
			throw new ErrorInterno(e);
		}finally {
			try {
				if (connection !=null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new ErrorInterno(e);
			}
		}
		return result;
		
	}
	
	public void darBajaUsuario(String correo) throws ErrorInterno,CorreoInvalido{
		CuentaDAO cuentaDAO = (CuentaDAO) new PlainCuentaDAO();
		Connection connection =null;
		try {
			connection = this.dataSource.getConnection();
			if (cuentaDAO.existe(connection, correo)) {
				cuentaDAO.elimina(connection, correo);
			}else {
				System.out.println("No es usuario del sistema");
				throw new CorreoInvalido();				
			}
		}catch (SQLException e) {
			throw new ErrorInterno(e);
		}finally {
			try {
				if (connection !=null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new ErrorInterno(e);
			}
		}	
	}
}
