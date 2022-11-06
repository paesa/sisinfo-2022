package src.si.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.ArrayList;

import src.util.exception.InternalErrorException;
import src.si.vo.CuentaVO;


/**
 * A  implementation of <code>CuentaDAO</code> that leaves
 * <code>create(Connection, AccountVO)</code> as abstract.
 */
public class PlainCuentaDAO implements CuentaDAO{
	public int idMax; // Maximo idcuenta en la tabla cuenta
    
	// Contructor
    public PlainCuentaDAO() {
		/* Create "preparedStatement". */
		String queryString = "SELECT MAX(idcuenta) FROM cuenta";
		preparedStatement = connection.prepareStatement(queryString);
		
		/* Execute query. */
		resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next()) {
			/* Get results. */
			i = 1;
			idMax = resultSet.getInt(i++);
		} else {idMax = 0;}

		preparedStatement.close();

		resultSet.close();
	}

	public void crea(Connection connection, CuentaVO cuentaVO) 
		throws InternalErrorException{
	    
		PreparedStatement preparedStatement = null;
	    try {
	        /* Create "preparedStatement". */
	        String queryString = "INSERT INTO cuenta" +
	            " (idcuenta, correo, apodo, contrasena, tipo) VALUES (?, ?, ?, ? ,?)";
	        preparedStatement = connection.prepareStatement(queryString);    
	            
	        /* Fill "preparedStatement". */
	        int i = 1;
            preparedStatement.setInt(i++, idMax+1);
	        preparedStatement.setString(i++, cuentaVO.obtenerCorreo());
	        preparedStatement.setString(i++, cuentaVO.obtenerApodo());
	        preparedStatement.setString(i++, cuentaVO.obtenerContrasegna());
	        preparedStatement.setString(i++, (cuentaVO.obtenerTipoCuenta()).getTipo());
	                        
	        /* Execute query. */
	        int insertedRows = preparedStatement.executeUpdate();
	        
	        if (insertedRows == 0) {
	            throw new SQLException("Can not add row to table" +
	                    " 'cuenta'");
	        } else if (insertedRows > 1) {
	           throw new SQLException("Duplicate row in table 'cuenta'");
	        } else {idMax++;} // Si se ha añadido correctamente, actualizar idMax
	        preparedStatement.close();

	    } catch (SQLException e) {
	    	System.out.println("Error.." + e);		        	
	        throw new InternalErrorException(e);
	    } finally {
	      	try {
	        	preparedStatement.close();
	        } catch (SQLException e) {
	        	throw new InternalErrorException(e);
	        }	        
	    }	
	}

	public boolean existe(Connection connection, String correo) 
		throws InternalErrorException {
	        
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            /* Create "preparedStatement". */
	            String queryString = "SELECT correo FROM cuenta WHERE correo = ?";
	            preparedStatement = connection.prepareStatement(queryString);
	            
	            
	            /* Fill "preparedStatement". */
	            int i = 1;
	            preparedStatement.setString(i++, correo);

	            
	            /* Execute query. */
	            resultSet = preparedStatement.executeQuery();

				boolean result = resultSet.next();

	            return result;
	            
	        } catch (SQLException e) {
	            throw new InternalErrorException(e);    
	        } finally {
	        	try {
	        		resultSet.close();
	        		preparedStatement.close();
	        	} catch (SQLException e) {
	        		throw new InternalErrorException(e);
	        	}
	        }
	        
		}
		
		public CuentaVO encuentra(Connection connection, String correo)
			throws InternalErrorException {
			
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			CuentaVO cuentaVO = null;

			try {
				/* Create "preparedStatement". */
				String queryString = "SELECT idcuenta, apodo, contrasena, tipo FROM cuenta WHERE" +
					" correo = ?";
				preparedStatement = connection.prepareStatement(queryString);
				
				/* Fill "preparedStatement". */
				int i = 1;
				preparedStatement.setString(i++, correo);
				
				/* Execute query. */
				resultSet = preparedStatement.executeQuery();
				
				if (resultSet.next()) {
					/* Get results. */
					i = 1;
					cuentaVO = new CuentaVO(resultSet.getInt(i++), correo, resultSet.getString(i++), resultSet.getString(i++), resultSet.getString(i++));
				}

				preparedStatement.close();

				resultSet.close();            
				return cuentaVO;
				
			} catch (SQLException e) {
				throw new InternalErrorException(e);    
			} finally {
				try {
					resultSet.close();
					preparedStatement.close();
				} catch (SQLException e) {
					throw new InternalErrorException(e);
				}
			}    
			
		}
				
		public void actualiza(Connection connection, CuentaVO cuentaVO) 
			throws InternalErrorException {
			
			PreparedStatement preparedStatement = null;

			try {

				/* Create "preparedStatement". */
				String queryString = "UPDATE cuenta" +
					" SET apodo = ?, contrasena = ?, tipo = ? WHERE correo = ?";
				preparedStatement = connection.prepareStatement(queryString);
				
				/* Fill "preparedStatement". */
				int i = 1;
				preparedStatement.setString(i++, cuentaVO.obtenerApodo());
				preparedStatement.setString(i++, cuentaVO.obtenerContrasegna());
				preparedStatement.setString(i++, (cuentaVO.obtenerTipoCuenta()).getTipo());
				preparedStatement.setString(i++, cuentaVO.obtenerCorreo());

				/* Execute query. */
				int updatedRows = preparedStatement.executeUpdate();

				if (updatedRows == 0) {
					throw new InternalErrorException(new Exception());
				}

				if (updatedRows > 1) {
					throw new SQLException("Duplicate row for identifier = '" + 
							cuentaVO.obtenerCorreo() + "' in table 'cuenta'");
				} 
				
				preparedStatement.close();

			} catch (SQLException e) {
				System.out.println(e);
				throw new InternalErrorException(e);    
			} finally {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					throw new InternalErrorException(e);
				}
			}    
			
		}
			
		public void elimina(Connection connection, String correo) 
			throws InternalErrorException {
			
			PreparedStatement preparedStatement = null;
			ResultSet resultSet;
			int idcuenta = 0;
			
			try {
				// OBTENER idcuenta DE LA CUENTA A ELIMINAR
				/* Create "preparedStatement". */
				String queryString = "SELECT idcuenta FROM cuenta WHERE" +
					" correo = ?";
				preparedStatement = connection.prepareStatement(queryString);
				
				/* Fill "preparedStatement". */
				int i = 1;
				preparedStatement.setString(i++, correo);
				
				/* Execute query. */
				resultSet = preparedStatement.executeQuery();
				
				if (resultSet.next()) {
					/* Get results. */
					i = 1;
					idcuenta = resultSet.getInt(i++);
				}

				preparedStatement.close();

				resultSet.close();

				// ELIMINAR LA CUENTA
				/* Create "preparedStatement". */
				queryString = "DELETE FROM cuenta WHERE correo = ?";
				preparedStatement = connection.prepareStatement(queryString);
				
				/* Fill "preparedStatement". */
				i = 1;
				preparedStatement.setString(i++, correo);
				
				/* Execute query. */
				int removedRows = preparedStatement.executeUpdate();

				preparedStatement.close();

				if (removedRows == 0) {
					throw new SQLException(correo +"duplicated in database");
				} else if (idcuenta == idMax) {
					// SI SE HA ELIMINADO LA CUENTA DE ID MÁXIMO, ACTUALIZAR idMax
					/* Create "preparedStatement". */
					queryString = "SELECT MAX(idcuenta) FROM cuenta";
					preparedStatement = connection.prepareStatement(queryString);
					
					/* Execute query. */
					resultSet = preparedStatement.executeQuery();
					
					if (resultSet.next()) {
						/* Get results. */
						i = 1;
						idMax = resultSet.getInt(i++);
					} else {idMax = 0;}

					preparedStatement.close();

					resultSet.close();
				}
				
			} catch (SQLException e) {
				throw new InternalErrorException(e);    
			} finally {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					throw new InternalErrorException(e);
				}
			}
							
		}

		public Collection <CuentaVO> muestraTodos(Connection connection)
			throws InternalErrorException {
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				
				try {
				/* Create "preparedStatement". */
				String queryString = "SELECT idcuenta, correo, apodo, contrasena, tipo FROM cuenta";
				preparedStatement = connection.prepareStatement(queryString,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    

				/* Execute query. */
				resultSet = preparedStatement.executeQuery();
				
				/* Read objects. */
				Collection<CuentaVO> cuentaList = new ArrayList<CuentaVO>();

				int startIndex = 1;
				if (resultSet.absolute(startIndex)) {
					
					int i;
					do {

						i = 1;
						CuentaVO cuentaVO = new CuentaVO(resultSet.getInt(i++), resultSet.getString(i++), 
								resultSet.getString(i++), resultSet.getString(i++), resultSet.getString(i++));
							
						cuentaList.add(cuentaVO);

					} while (resultSet.next()) ;
					
					resultSet.close();
				}

				/* Return value objects. */                
				return cuentaList;
				
			} catch (SQLException e) {
				throw new InternalErrorException(e);    
			} finally {
				try {
					if (resultSet!=null) resultSet.close();
					if (preparedStatement!=null) preparedStatement.close();
				} catch (SQLException e) {
					throw new InternalErrorException(e);
				}
			}
		}
}