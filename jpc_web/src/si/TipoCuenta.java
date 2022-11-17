package src.si;


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

    private String cuenta;

    TipoCuenta(String cuenta) {
        this.cuenta=cuenta;
    }
    public String obtenerTipo() {
        return cuenta;
    }
    public void establecerTipo(String cuenta){
        this.cuenta=cuenta;
    }
}