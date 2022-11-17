package src.si.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.ArrayList;
import src.si.vo.ComandaVO;
import src.util.exception.ErrorInterno;


/**
 * A  implementation of <code>comandaDAO</code> that leaves
 * <code>create(Connection, AccountVO)</code> as abstract.
 */
public class PlainComandaDAO implements ComandaDAO{    
	// Contructor
    public PlainComandaDAO() {}

	public void crea(Connection connection, ComandaVO comandaVO) 
		throws ErrorInterno{
	    
		PreparedStatement preparedStatement = null;
	    try {
	        /* Create "preparedStatement". */
	        String queryString = "INSERT INTO comanda" +
	            " (fecha, comentario, estado) VALUES (?, ?, ?)";
	        preparedStatement = connection.prepareStatement(queryString);    
	            
	        /* Fill "preparedStatement". */
	        int i = 1;
	        preparedStatement.setDate(i++, comandaVO.obtenerFecha());
	        preparedStatement.setString(i++, comandaVO.obtenerComentario());
	        preparedStatement.setString(i++, (comandaVO.obtenerEstado()).obtenerTipo());
	                        
	        /* Execute query. */
	        int insertedRows = preparedStatement.executeUpdate();
	        
	        if (insertedRows == 0) {
	            throw new SQLException("Can not add row to table" +
	                    " 'comanda'");
	        } else if (insertedRows > 1) {
	           throw new SQLException("Duplicate row in table 'comanda'");
	        }
	        preparedStatement.close();

	    } catch (SQLException e) {
	    	System.out.println("Error.." + e);		        	
	        throw new ErrorInterno(e);
	    } finally {
	      	try {
	        	preparedStatement.close();
	        } catch (SQLException e) {
	        	throw new ErrorInterno(e);
	        }	        
	    }	
	}

	            
    public void actualiza(Connection connection, ComandaVO comandaVO) 
        throws ErrorInterno {
        
        PreparedStatement preparedStatement = null;

        try {

            /* Create "preparedStatement". */
            String queryString = "UPDATE comanda" +
                " SET fecha = ?, comentario = ?, estado = ? WHERE idcomanda = ?";
            preparedStatement = connection.prepareStatement(queryString);
            
            /* Fill "preparedStatement". */
            int i = 1;
            preparedStatement.setDate(i++, comandaVO.obtenerFecha());
	        preparedStatement.setString(i++, comandaVO.obtenerComentario());
	        preparedStatement.setString(i++, (comandaVO.obtenerEstado()).obtenerTipo());
            preparedStatement.setInt(i++, comandaVO.obtenerIdComanda());

            /* Execute query. */
            int updatedRows = preparedStatement.executeUpdate();

            if (updatedRows == 0) {
                throw new ErrorInterno(new Exception());
            }

            if (updatedRows > 1) {
                throw new SQLException("Duplicate row for identifier = '" + 
                    String.valueOf(comandaVO.obtenerIdComanda()) + "' in table 'comanda'");
            } 
            
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e);
            throw new ErrorInterno(e);    
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new ErrorInterno(e);
            }
        }    
        
    }
        
    public void elimina(Connection connection, int idcomanda) 
        throws ErrorInterno {
        
        PreparedStatement preparedStatement = null;
        
        try {
            // ELIMINAR EL comanda
            /* Create "preparedStatement". */
            String queryString = "DELETE FROM comanda WHERE idcomanda = ?";
            preparedStatement = connection.prepareStatement(queryString);
            
            /* Fill "preparedStatement". */
            int i = 1;
            preparedStatement.setInt(i++, idcomanda);
            
            /* Execute query. */
            int removedRows = preparedStatement.executeUpdate();

            preparedStatement.close();

            if (removedRows == 0) {
                throw new SQLException(String.valueOf(idcomanda) +"duplicated in database");
            }
            
        } catch (SQLException e) {
            throw new ErrorInterno(e);    
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new ErrorInterno(e);
            }
        }
                        
    }

    public Collection <ComandaVO> muestraTodos(Connection connection)
        throws ErrorInterno {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            
            try {
            /* Create "preparedStatement". */
            String queryString = "SELECT idcomanda, fecha, comentario, estado FROM comanda";
            preparedStatement = connection.prepareStatement(queryString,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    

            /* Execute query. */
            resultSet = preparedStatement.executeQuery();
            
            /* Read objects. */
            Collection<ComandaVO> comandaList = new ArrayList<ComandaVO>();

            int startIndex = 1;
            if (resultSet.absolute(startIndex)) {
                
                int i;
                do {

                    i = 1;
                    ComandaVO comandaVO = new ComandaVO(resultSet.getInt(i++), resultSet.getDate(i++), 
                            resultSet.getString(i++), resultSet.getString(i++));
                        
                    comandaList.add(comandaVO);

                } while (resultSet.next()) ;
                
                resultSet.close();
            }

            /* Return value objects. */                
            return comandaList;
            
        } catch (SQLException e) {
            throw new ErrorInterno(e);    
        } finally {
            try {
                if (resultSet!=null) resultSet.close();
                if (preparedStatement!=null) preparedStatement.close();
            } catch (SQLException e) {
                throw new ErrorInterno(e);
            }
        }
    }

    public Collection <ComandaVO> muestraPorEstado(Connection connection, String estado)
        throws ErrorInterno {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            
            try {
            /* Create "preparedStatement". */
            String queryString = "SELECT idcomanda, fecha, comentario, estado FROM comanda WHERE estado = ?";
            preparedStatement = connection.prepareStatement(queryString,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);  
                
            /* Fill "preparedStatement". */
            int i = 1;
            preparedStatement.setString(i++, estado);

            /* Execute query. */
            resultSet = preparedStatement.executeQuery();
            
            /* Read objects. */
            Collection<ComandaVO> comandaList = new ArrayList<ComandaVO>();

            int startIndex = 1;
            if (resultSet.absolute(startIndex)) {
                
                do {

                    i = 1;
                    ComandaVO comandaVO = new ComandaVO(resultSet.getInt(i++), resultSet.getDate(i++), 
                            resultSet.getString(i++), resultSet.getString(i++));
                        
                    comandaList.add(comandaVO);

                } while (resultSet.next()) ;
                
                resultSet.close();
            }

            /* Return value objects. */                
            return comandaList;
            
        } catch (SQLException e) {
            throw new ErrorInterno(e);    
        } finally {
            try {
                if (resultSet!=null) resultSet.close();
                if (preparedStatement!=null) preparedStatement.close();
            } catch (SQLException e) {
                throw new ErrorInterno(e);
            }
        }
    }
}