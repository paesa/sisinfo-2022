/**
 * Fichero: Estado.java
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */

public enum Estado {
    CREADA("Creada"), 
    PREPARANDO("Preparando"),
    RECOGER("Recoger"),
    ENTREGADO("Entregado");

    private String estado_interno;

    Estado(String t) {
        this.estado_interno=t;
    }

    public String getTipo() {
        return estado_interno;
    }

}