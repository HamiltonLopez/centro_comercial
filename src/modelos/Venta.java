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
public class Venta implements Serializable{
    private List<Producto> productos;
    private Cliente cliente;
    private Date fechaVenta;
    private double totalCompra;
}
