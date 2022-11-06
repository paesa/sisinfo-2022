package src.si.dao;

import java.sql.Connection;
import java.util.Collection;

import src.si.vo.PlatoVO;
import src.util.exception.InternalErrorException;
/**
 * Fichero: PlatoDAO.java
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */

public interface PlatoDAO {

    public void crea(Connection connection, PlatoVO platoVO) 
		throws InternalErrorException;

    public void actualiza(Connection connection, PlatoVO platoVO) 
		    throws InternalErrorException;

	public void elimina(Connection connection, int idplato)
	    throws InternalErrorException; 

	public Collection <PlatoVO> muestraTodos(Connection connection)
	    throws InternalErrorException;
	
	public Collection <PlatoVO> muestraPorTipo(Connection connection, String tipo)
	    throws InternalErrorException;
}
