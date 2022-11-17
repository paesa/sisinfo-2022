package src.si;

/**
 * Fichero: TipoPlato.java
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */

public enum TipoPlato {
    ENTRANTE("Entrante"), 
    PRINCIPAL("Principal"),
    POSTRE("Postre"),
    BEBIDA("Bebida");

    private String plato;

    TipoPlato(String plato) {
        this.plato=plato;
    }
    public String obtenerTipo() {
        return plato;
    }
    public void establecerTipo(String plato) {
        this.plato=plato;
    }
}