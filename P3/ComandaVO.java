import java.util.Date;
/**
 * Fichero: comandaVO.java
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */

public enum Estado {Creada, Preparando, Recoger, Entregado}

public class ComandaVO {
    private int idComanda;
    private Date fecha;
    private String comentario;
    private Estado estado;
    
    //Constructor
    public ComandaVO(int idComanda, Date fecha, String comentario, Estado estado) {
        this.idComanda = idComanda;
        this.fecha = fecha;
        this.comentario = comentario;
        this.estado = estado;
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
    public Estado obtenerEstado() {
        return estado;
    }
    public void establecerEstado(Estado estado) {
        this.estado = estado;
    }
}
