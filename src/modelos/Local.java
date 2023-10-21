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
    private Lista<Empleado> empleados;
    private Lista<Producto> productos;
    private Lista<Venta> historial;
    private Lista<Separado> separados;

    public Local(String nombre, Contrato contrato) {
        this.nombre = nombre;
        this.contrato = contrato;
        empleados = new Lista<>();
        productos = new Lista<>();
        historial = new Lista<>();
        separados = new Lista<>();
        precioArriendo = "500.000";
    }

    public Local() {
        precioArriendo = "500.000";
        empleados = null;
        contrato = null;
    }

    public Lista<Separado> getSeparados() {
        return separados;
    }

    public void setSeparados(Lista<Separado> separados) {
        this.separados = separados;
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

    public Lista<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Lista<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Lista<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Lista<Producto> productos) {
        this.productos = productos;
    }

    public Lista<Venta> getHistorial() {
        return historial;
    }

    public void setHistorial(Lista<Venta> historial) {
        this.historial = historial;
    }

}
