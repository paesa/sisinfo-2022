package src.si.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.ArrayList;

import src.util.exception.InternalErrorException;
import src.si.vo.PlatoVO;


/**
 * A  implementation of <code>PlatoDAO</code> that leaves
 * <code>create(Connection, AccountVO)</code> as abstract.
 */
public class PlainPlatoDAO implements PlatoDAO{
	public int idMax; // Maximo idcuenta en la tabla cuenta
    
	// Contructor
    public PlainPlatoDAO() {
		/* Create "preparedStatement". */
		String queryString = "SELECT MAX(idplato) FROM plato";
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

	public void crea(Connection connection, PlatoVO platoVO) 
		throws InternalErrorException{
	    
		PreparedStatement preparedStatement = null;
	    try {
	        /* Create "preparedStatement". */
	        String queryString = "INSERT INTO plato" +
	            " (idplato, nombre, precio, descripcion, tipo, vegano, singluten, sinlactosa) VALUES (?, ?, ?, ? ,?, ?, ?, ?)";
	        preparedStatement = connection.prepareStatement(queryString);    
	            
	        /* Fill "preparedStatement". */
	        int i = 1;
            preparedStatement.setInt(i++, idMax+1);
	        preparedStatement.setString(i++, platoVO.obtenerNombre());
	        preparedStatement.setFloat(i++, platoVO.obtenerPrecio());
	        preparedStatement.setString(i++, platoVO.obtenerDescripcion());
	        preparedStatement.setString(i++, (platoVO.obtenerTipoPlato()).getTipo());
            preparedStatement.setBoolean(i++, platoVO.esVegano());
	        preparedStatement.setBoolean(i++, !platoVO.llevaGluten());
            preparedStatement.setBoolean(i++, !platoVO.llevaLactosa());
	                        
	        /* Execute query. */
	        int insertedRows = preparedStatement.executeUpdate();
	        
	        if (insertedRows == 0) {
	            throw new SQLException("Can not add row to table" +
	                    " 'plato'");
	        } else if (insertedRows > 1) {
	           throw new SQLException("Duplicate row in table 'plato'");
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

	            
    public void actualiza(Connection connection, PlatoVO platoVO) 
        throws InternalErrorException {
        
        PreparedStatement preparedStatement = null;

        try {

            /* Create "preparedStatement". */
            String queryString = "UPDATE plato" +
                " SET nombre = ?, precio = ?, descripcion = ?, tipo = ?, vegano = ?, singluten = ?, sinlactosa = ? WHERE idplato = ?";
            preparedStatement = connection.prepareStatement(queryString);
            
            /* Fill "preparedStatement". */
            int i = 1;
            preparedStatement.setString(i++, platoVO.obtenerNombre());
	        preparedStatement.setFloat(i++, platoVO.obtenerPrecio());
	        preparedStatement.setString(i++, platoVO.obtenerDescripcion());
	        preparedStatement.setString(i++, (platoVO.obtenerTipoPlato()).getTipo());
            preparedStatement.setBoolean(i++, platoVO.esVegano());
	        preparedStatement.setBoolean(i++, !platoVO.llevaGluten());
            preparedStatement.setBoolean(i++, !platoVO.llevaLactosa());
            preparedStatement.setInt(i++, platoVO.obtenerIdPlato());

            /* Execute query. */
            int updatedRows = preparedStatement.executeUpdate();

            if (updatedRows == 0) {
                throw new InternalErrorException(new Exception());
            }

            if (updatedRows > 1) {
                throw new SQLException("Duplicate row for identifier = '" + 
                    String.valueOf(platoVO.obtenerIdPlato()) + "' in table 'plato'");
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
        
    public void elimina(Connection connection, int idplato) 
        throws InternalErrorException {
        
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        
        try {
            // ELIMINAR EL PLATO
            /* Create "preparedStatement". */
            String queryString = "DELETE FROM plato WHERE idplato = ?";
            preparedStatement = connection.prepareStatement(queryString);
            
            /* Fill "preparedStatement". */
            int i = 1;
            preparedStatement.setInt(i++, idplato);
            
            /* Execute query. */
            int removedRows = preparedStatement.executeUpdate();

            preparedStatement.close();

            if (removedRows == 0) {
                throw new SQLException(String.valueOf(idplato) +"duplicated in database");
            } else if (idplato == idMax) {
                // SI SE HA ELIMINADO EL PLATO DE ID MÁXIMO, ACTUALIZAR idMax
                /* Create "preparedStatement". */
                queryString = "SELECT MAX(idplato) FROM plato";
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

    public Collection <PlatoVO> muestraTodos(Connection connection)
        throws InternalErrorException {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            
            try {
            /* Create "preparedStatement". */
            String queryString = "SELECT idplato, nombre, precio, descripcion, tipo, vegano, singluten, sinlactosa FROM plato";
            preparedStatement = connection.prepareStatement(queryString,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    

            /* Execute query. */
            resultSet = preparedStatement.executeQuery();
            
            /* Read objects. */
            Collection<PlatoVO> platoList = new ArrayList<PlatoVO>();

            int startIndex = 1;
            if (resultSet.absolute(startIndex)) {
                
                int i;
                do {

                    i = 1;
                    PlatoVO platoVO = new PlatoVO(resultSet.getInt(i++), resultSet.getString(i++), 
                            resultSet.getFloat(i++), resultSet.getString(i++), resultSet.getString(i++), 
                            resultSet.getBoolean(i++), resultSet.getBoolean(i++), resultSet.getBoolean(i++));
                        
                    cuentaList.add(platoVO);

                } while (resultSet.next()) ;
                
                resultSet.close();
            }

            /* Return value objects. */                
            return platoList;
            
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

    public Collection <PlatoVO> muestraPorTipo(Connection connection, String tipo)
        throws InternalErrorException {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            
            try {
            /* Create "preparedStatement". */
            String queryString = "SELECT idplato, nombre, precio, descripcion, tipo, vegano, singluten, sinlactosa FROM plato WHERE tipo = ?";
            preparedStatement = connection.prepareStatement(queryString,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    

            /* Fill "preparedStatement". */
            int i = 1;
            preparedStatement.setString(i++, tipo);

            /* Execute query. */
            resultSet = preparedStatement.executeQuery();
            
            /* Read objects. */
            Collection<PlatoVO> platoList = new ArrayList<PlatoVO>();

            int startIndex = 1;
            if (resultSet.absolute(startIndex)) {
                
                do {

                    i = 1;
                    PlatoVO platoVO = new PlatoVO(resultSet.getInt(i++), resultSet.getString(i++), 
                            resultSet.getFloat(i++), resultSet.getString(i++), resultSet.getString(i++), 
                            resultSet.getBoolean(i++), resultSet.getBoolean(i++), resultSet.getBoolean(i++));
                        
                    cuentaList.add(platoVO);

                } while (resultSet.next()) ;
                
                resultSet.close();
            }

            /* Return value objects. */                
            return platoList;
            
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