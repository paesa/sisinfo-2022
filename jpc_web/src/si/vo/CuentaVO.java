package src.si.vo;

import src.si.TipoCuenta;
/**
 * Fichero: CuentaVO.java
 * @author Pablo Jesús Bueno Ereza, Carlos Paesa Lía y Javier Cuesta Cocera
 *
 */

public class CuentaVO {
    private int idCuenta;
    private String correo;
    private String apodo;
    private String contrasegna;
    private TipoCuenta tipoCuenta;
    
    //Constructor
    public CuentaVO(int idCuenta, String correo, String apodo, String contrasegna, String tipoCuenta) {
        this.idCuenta = idCuenta;
        this.correo = correo;
        this.apodo = apodo;
        this.contrasegna = contrasegna;
        this.tipoCuenta = TipoCuenta.valueOf(tipoCuenta);
    }

    //Constructor
    public CuentaVO(String correo, String apodo, String contrasegna, String tipoCuenta) {
        this.correo = correo;
        this.apodo = apodo;
        this.contrasegna = contrasegna;
        this.tipoCuenta = TipoCuenta.valueOf(tipoCuenta);
    }

    //Constructor
    public CuentaVO(String correo, String apodo, String contrasegna) {
        this.correo = correo;
        this.apodo = apodo;
        this.contrasegna = contrasegna;
        this.tipoCuenta = TipoCuenta.CLIENTE;
    }
    //Constructor
    public CuentaVO(String correo, String contrasegna) {
        this.correo = correo;
        this.contrasegna = contrasegna;
        this.tipoCuenta = TipoCuenta.CLIENTE;
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
    public TipoCuenta obtenerTipoCuenta() {
        return tipoCuenta;
    }
    public void establecerTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = TipoCuenta.valueOf(tipoCuenta);
    }
}
