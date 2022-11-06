package src.si.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import src.si.dao.PlainSQLCuentaDAO;
import src.si.dao.CuentaDAO;
import src.si.vo.CuentaVO;
import src.util.exception.InternalErrorException;
import srcc.util.exception.CorreoYaRegistrado;
import srcc.util.exception.CorreoInvalido;
import src.util.db.SimpleDataSource;

public class PlainModelFacade {
	
	private DataSource dataSource;

	public PlainModelFacade() throws InternalErrorException {  
		System.out.println ("He llegado a la creación de la fachada correctamente...");
		this.dataSource = new SimpleDataSource();   
		System.out.println ("Parece que soy capaz de crear la fachada correctamente...");
	}
	
	public PlainModelFacade(String datasourceorigen) throws InternalErrorException { 
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
			throw new InternalErrorException(e);
		}		
	}
	
	public void registrarCuenta(CuentaVO cuentaVO) throws InternalErrorException, CorreoYaRegistrado{
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
	}
	
	public void cambiarPerfil(CuentaVO cuentaVO) throws InternalErrorException, CorreoInvalido{
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
	}
	
	public void cambiarClave(CuentaVO cuentaVO) throws InternalErrorException, CorreoInvalido{
		cambiarPerfil(cuentaVO);
	}
	
	public Collection <CuentaVO> encontrarUsuarios() 
		throws InternalErrorException{
		Collection <CuentaVO> result = null;
		CuentaDAO cuentaDAO = (CuentaDAO) new PlainCuentaDAO();
		Connection connection =null;
		try {
			connection = this.dataSource.getConnection();
			result = cuentaDAO.muestraTodos(connection);
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
		return result;
		
	}
	
	public void darBajaUsuario(String correo) throws InternalErrorException{
		CuentaDAO cuentaDAO = (CuentaDAO) new PlainCuentaDAO();
		Connection connection =null;
		try {
			connection = this.dataSource.getConnection();
			if (cuentaDAO.existe(connection, correo)) {
				cuentaDAO.elimina(connection, correo);
			}
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
	}
}
