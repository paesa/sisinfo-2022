import java.util.Date;
/**
 * tabla users
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */
public class platoVO {
    private String nombre;
    private float precio;
    private String descripcion;
    private boolean vegano;
    private boolean sinGluten;
    private boolean sinLactosa;

    /**
    * Constructor
    * @param userName
    * @param password
    */
    public platoVO(String nombre, float precio, String descripcion, boolean vegano, boolean sinGluten, boolean sinLactosa) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.vegano = vegano;
        this.sinGluten = sinGluten;
        this.sinLactosa = sinLactosa;
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