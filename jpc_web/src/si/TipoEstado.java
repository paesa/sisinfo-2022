package src.si;


/**
 * Fichero: TipoEstado.java
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */

public enum TipoEstado {
    CREADA("Creada"), 
    PREPARANDO("Preparando"),
    RECOGER("Recoger"),
    ENTREGADO("Entregado");	
    
    private String estado;

    TipoEstado(String estado){
        this.estado=estado;
    }
    public void establecerTipo(String estado){
        this.estado=estado;
    }
    public String obtenerTipo(){
        return estado;
    }
}

