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
public class Separado implements Serializable{
    
    private Producto producto;
    private Cliente cliente;
    private Date fechaEntrega;

    public Separado(Producto producto, Cliente cliente, Date fechaEntrega) {
        this.producto = producto;
        this.cliente = cliente;
        this.fechaEntrega = fechaEntrega;
    }

  
    

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
    
    
}
