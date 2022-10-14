import java.util.Date;
/**
 * tabla users
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */
public class cuentaVO {
    private String correo;
    private String apodo;
    private String contrasegna;
    private Date lastLogin;
    /**
    * Constructor
    * @param userName
    * @param password
    */
    public cuentaVO(String correo, String apodo, String contrasegna) {
        this.correo = correo;
        this.apodo = apodo;
        this.contrasegna = contrasegna;
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

    public Date getLastLogin() {
        return lastLogin;
    }
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}