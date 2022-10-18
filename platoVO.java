import java.util.Date;
/**
 * Fichero: PlatoVO.java
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */

public enum TipoPlato {Entrante, Principal, Postre, Bebida}

public class platoVO {
    private int idPlato;
    private String nombre;
    private float precio;
    private String descripcion;
    private TipoPlato tipoPlato;
    private boolean vegano;
    private boolean sinGluten;
    private boolean sinLactosa;

    //Constructor
    public platoVO(int idPlato, String nombre, float precio, String descripcion, TipoPlato tipoPlato, boolean vegano, boolean sinGluten, boolean sinLactosa) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tipoPlato = tipoPlato;
        this.vegano = vegano;
        this.sinGluten = sinGluten;
        this.sinLactosa = sinLactosa;
    }
    
    public int obtenerIdPlato() {
        return idPlato;
    }
    public void establecerIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }
    public String obtenerNombre() {
        return nombre;
    }
    public void establecerNombre(String nombre) {
        this.nombre = nombre;
    }
    public float obtenerPrecio() {
        return precio;
    }
    public void establecerPrecio(float precio) {
        this.precio = precio;
    }
    public String obtenerDescripcion() {
        return descripcion;
    }
    public void establecerDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
     public TipoPlato obtenerTipoPlato() {
        return tipoPlato;
    }
    public void establecerTipoPlato(TipoPlato tipoPlato) {
        this.tipoPlato = tipoPlato;
    }
    public void establecerVegano(boolean vegano) {
        this.vegano = vegano;
    }
    public boolean esVegano() {
        return vegano;
    }
    public void establecerGluten(boolean sinGluten) {
        this.sinGluten = sinGluten;
    }
    public boolean llevaGluten() {
        return !sinGluten;
    }
    public void establecerLactosa(boolean sinLactosa) {
        this.sinLactosa = sinLactosa;
    }
    public boolean llevaLactosa() {
        return !sinLactosa;
    }
}
