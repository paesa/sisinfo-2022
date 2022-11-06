package src.si.dao;

import java.sql.Connection;
import java.util.Collection;

import src.si.vo.ComandaVO;
import src.util.exception.InternalErrorException;
/**
 * Fichero: ComandaDAO.java
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */

public interface ComandaDAO {

    public void crea(Connection connection, ComandaVO comandaVO) 
		throws InternalErrorException;

    public void actualiza(Connection connection, ComandaVO comandaVO) 
		    throws InternalErrorException;

	public void elimina(Connection connection, int idcomanda)
	    throws InternalErrorException; 

	public Collection <ComandaVO> muestraTodos(Connection connection)
	    throws InternalErrorException;
	
	public Collection <ComandaVO> muestraPorEstado(Connection connection, String estado)
	    throws InternalErrorException;
}
