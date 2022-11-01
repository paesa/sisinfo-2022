/**
 * Fichero: TipoCuenta.java
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */

public enum TipoCuenta {
    CLIENTE("Cliente"), 
    COCINERO("Cocinero"),
    SALA("Sala"),
    ADMIN("Admin");

    private String tipo;

    TipoCuenta(String t) {
        this.tipo=t;
    }

    public String getTipo() {
        return tipo;
    }

}