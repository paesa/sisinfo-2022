package src.si.dao;

import java.sql.Connection;

import src.si.vo.CuentaVO;
import src.util.exception.InternalErrorException;
/**
 * Fichero: CuentaDAO.java
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */

public interface CuentaDAO {
    public boolean existe(Connection connection, String correo) 
		throws InternalErrorException;

    public void crea(Connection connection, CuentaVO cuentaVO) 
		throws InternalErrorException;

    public CuentaVO encuentra(Connection connection, String correo) 
	    throws InternalErrorException;

    public void actualiza(Connection connection, CuentaVO user) 
		    throws InternalErrorException;

	public void elimina(Connection connection, String correo)
	    throws InternalErrorException; 
}