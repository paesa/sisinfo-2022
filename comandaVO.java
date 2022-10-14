import java.util.Date;
/**
 * tabla users
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */
public class comandaVO {
    private int numComanda;
    private Date fecha;
    private String comentario;
    private String estado;
    /**
    * Constructor
    * @param userName
    * @param password
    */
    public comandaVO(int numComanda, Date fecha, String comentario, String estado) {
        this.numComanda = numComanda;
        this.fecha = fecha;
        this.comentario = comentario;
        this.estado = estado;
    }
    public int obtenerNumComanda() {
        return numComanda;
    }
    public void establecerNumComanda(int numComanda) {
        this.numComanda = numComanda;
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
    public String obtenerEstado() {
        return estado;
    }
    public void establecerEstado(String estado) {
        this.estado = estado;
    }
}