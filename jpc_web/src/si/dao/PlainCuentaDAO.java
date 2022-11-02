package src.si.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

import src.util.exception.InternalErrorException;
import src.si.vo.CuentaVO;


/**
 * A  implementation of <code>CuentaDAO</code> that leaves
 * <code>create(Connection, AccountVO)</code> as abstract.
 */
public class PlainCuentaDAO implements CuentaDAO{
	public int idMax = 0; // Maximo idcuenta en la tabla cuenta
    
    public PlainCuentaDAO() {}

	public void crea(Connection connection, CuentaVO cuentaVO) 
		throws InternalErrorException{
	    
		PreparedStatement preparedStatement = null;
	    try {
	        /* Create "preparedStatement". */
	        String queryString = "INSERT INTO cuenta" +
	            " (idcuenta, correo, apodo, contrasena, tipo) VALUES (?, ?, ?, ? ,?)";
	        preparedStatement = connection.prepareStatement(queryString);    
	            
	        /* Fill "preparedStatement". */
            idMax++;
	        int i = 1;
            preparedStatement.setInt(i++, idMax);
	        preparedStatement.setString(i++, cuentaVO.obtenerCorreo());
	        preparedStatement.setString(i++, cuentaVO.obtenerApodo());
	        preparedStatement.setString(i++, cuentaVO.obtenerContrasegna());
	        preparedStatement.setString(i++, (cuentaVO.obtenerTipoCuenta()).getTipo());
	                        
	        /* Execute query. */
	        int insertedRows = preparedStatement.executeUpdate();
	        
	        if (insertedRows == 0) {
	            throw new SQLException("Can not add row to table" +
	                    " 'cuenta'");
	        }
	        if (insertedRows > 1) {
	           throw new SQLException("Duplicate row in table 'cuenta'");
	        }
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
            ResultSet resultSet = null;
            int idcuenta = 0;
	        
	        try {
                String queryString = "SELECT idcuenta FROM cuenta WHERE correo = ?";
                preparedStatement = connection.prepareStatement(queryString);
                i = 1;
		        preparedStatement.setString(i++, correo);

                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    i = 1;
                    idcuenta = resultSet.getInt(i++);
                }
                
                preparedStatement.close();

	            /* Create "preparedStatement". */
	            queryString = "DELETE FROM cuenta WHERE correo = ?";
	            preparedStatement = connection.prepareStatement(queryString);
	            
	            /* Fill "preparedStatement". */
	            int i = 1;
	            preparedStatement.setString(i++, correo);
	            
	            /* Execute query. */
	            int removedRows = preparedStatement.executeUpdate();

	            if (removedRows == 0) {
	                throw new SQLException(correo +"duplicated in database");
	            }
                if (idcuenta == idMax) idMax--;

	            preparedStatement.close();
	            

	            queryString = "DELETE FROM comandacreadapor WHERE" +
		                " idcuenta = ?";
		        preparedStatement = connection.prepareStatement(queryString);
		            
		        /* Fill "preparedStatement". */
		        i = 1;
		        preparedStatement.setInt(i++, idcuenta);
		        removedRows = preparedStatement.executeUpdate();


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
}