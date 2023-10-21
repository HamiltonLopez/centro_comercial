/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Asus
 */
public class Venta implements Serializable {

    private Cliente cliente;
    private Date fechaVenta;
    private int  totalCompra;
    private Compra compra;

    public Venta(Cliente cliente, Date fechaVenta, int totalCompra, Compra compra) {
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
        this.totalCompra = totalCompra;
        this.compra = compra;
    }
    

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(int totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    

}
