import java.util.Date;
/**
 * tabla users
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */
public class cuentaVO {
    private int idCuenta;
    private String correo;
    private String apodo;
    private String contrasegna;
    
    /**
    * Constructor
    * @param userName
    * @param password
    */
    public cuentaVO(int idCuenta, String correo, String apodo, String contrasegna) {
        this.idCuenta = idCuenta;
        this.correo = correo;
        this.apodo = apodo;
        this.contrasegna = contrasegna;
    }
    
    public int obtenerIdCuenta() {
        return idCuenta;
    }
    public void establecerIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }
    public String obtenerCorreo() {
        return correo;
    }
    public void establecerCorreo(String correo) {
        this.correo = correo;
    }
    public String obtenerApodo() {
        return apodo;
    }
    public void establecerApodo(String apodo) {
        this.apodo = apodo;
    }
    public String obtenerContrasegna() {
        return contrasegna;
    }
    public void establecerContrasegna(String contrasegna) {
        this.contrasegna = contrasegna;
    }
}
