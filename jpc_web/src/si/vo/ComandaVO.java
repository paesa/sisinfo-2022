package src.si.vo;

import java.sql.Date;
import src.si.TipoEstado;
/**
 * Fichero: ComandaVO.java
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */

public class ComandaVO {
    private int idComanda;
    private Date fecha;
    private String comentario;
    private TipoEstado estado;
    
    //Constructor
    public ComandaVO(int idComanda, Date fecha, String comentario, String estado) {
        this.idComanda = idComanda;
        this.fecha = fecha;
        this.comentario = comentario;
        this.estado = TipoEstado.valueOf(estado);
    }
    //Constructor
    public ComandaVO(Date fecha, String comentario, String estado) {
        this.fecha = fecha;
        this.comentario = comentario;
        this.estado = TipoEstado.valueOf(estado);
    }

    public int obtenerIdComanda() {
        return idComanda;
    }
    public void establecerIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }
    public Date obtenerFecha() {
        return fecha;
    }
    public void establecerFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String obtenerComentario() {
        return comentario;
    }
    public void establecerComentario(String comentario) {
        this.comentario = comentario;
    }
    public TipoEstado obtenerEstado() {
        return estado;
    }
    public void establecerEstado(String estado) {
        this.estado = TipoEstado.valueOf(estado);
    }
}
