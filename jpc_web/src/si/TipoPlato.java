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

    private String tipo;

    TipoPlato(String t) {
        this.tipo=t;
    }

    public String getTipo() {
        return tipo;
    }

}