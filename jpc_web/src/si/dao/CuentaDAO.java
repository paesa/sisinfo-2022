package src.si.dao;

import java.sql.Connection;
import java.util.Collection;

import src.si.vo.CuentaVO;
import src.util.exception.ErrorInterno;
/**
 * Fichero: CuentaDAO.java
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */

public interface CuentaDAO {
    public boolean existe(Connection connection, String correo) 
		throws ErrorInterno;

    public void crea(Connection connection, CuentaVO cuentaVO) 
		throws ErrorInterno;

    public CuentaVO encuentra(Connection connection, String correo) 
	    throws ErrorInterno;

    public void actualiza(Connection connection, CuentaVO user) 
		    throws ErrorInterno;

	public void elimina(Connection connection, String correo)
	    throws ErrorInterno;

	public Collection <CuentaVO> muestraTodos(Connection connection)
	    throws ErrorInterno;
}