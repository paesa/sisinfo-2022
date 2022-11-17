package src.si.dao;

import java.sql.Connection;
import java.util.Collection;
import src.si.vo.PlatoVO;
import src.util.exception.ErrorInterno;
/**
 * Fichero: PlatoDAO.java
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */

public interface PlatoDAO {

    public void crea(Connection connection, PlatoVO platoVO) 
		throws ErrorInterno;

    public void actualiza(Connection connection, PlatoVO platoVO) 
		    throws ErrorInterno;

	public void elimina(Connection connection, int idplato)
	    throws ErrorInterno; 

	public Collection <PlatoVO> muestraTodos(Connection connection)
	    throws ErrorInterno;
	
	public Collection <PlatoVO> muestraPorTipo(Connection connection, String tipo)
	    throws ErrorInterno;
}
