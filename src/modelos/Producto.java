/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Asus
 */
public class Producto  implements Serializable{

    private String nombreProducto;
    private String identificador;
    private String materialPresentacion;
    private String precio;
    private String pesoNeto;
    private Date fechaVencimiento;

    public Producto(String nombreProducto, String identificador, String materialPresentacion, String precio, String pesoNeto, Date fechaVencimiento) {
        this.nombreProducto = nombreProducto;
        this.identificador = identificador;
        this.materialPresentacion = materialPresentacion;
        this.precio = precio;
        this.pesoNeto = pesoNeto;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getMaterialPresentacion() {
        return materialPresentacion;
    }

    public void setMaterialPresentacion(String materialPresentacion) {
        this.materialPresentacion = materialPresentacion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getPesoNeto() {
        return pesoNeto;
    }

    public void setPesoNeto(String pesoNeto) {
        this.pesoNeto = pesoNeto;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

}
