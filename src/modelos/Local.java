/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import java.util.Date;
import util.Lista;

/**
 *
 * @author Asus
 */
public class Local implements Serializable {

    private String nombre;
    private Contrato contrato;
    private String precioArriendo;
    private Lista<EmpleadoInterno> empleados;
    private Lista<Producto> productos;

    public Local(String nombre, Contrato contrato) {
        this.nombre = nombre;
        this.contrato = contrato;
        empleados = new Lista<>();
        productos = new Lista<>();
        precioArriendo = "500.000";
    }

    public Local() {
        precioArriendo = "500.000";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public String getPrecioArriendo() {
        return precioArriendo;
    }

    public void setPrecioArriendo(String precioArriendo) {
        this.precioArriendo = precioArriendo;
    }

    public Lista<EmpleadoInterno> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Lista<EmpleadoInterno> empleados) {
        this.empleados = empleados;
    }

    public Lista<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Lista<Producto> productos) {
        this.productos = productos;
    }

}
