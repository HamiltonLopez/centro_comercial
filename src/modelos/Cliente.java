/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import util.Lista;

/**
 *
 * @author Asus
 */
public class Cliente extends Usuario implements Serializable{
    private Multa multa;
    private int totalInvertido;
    private Lista<Venta> historial;
    private Lista<Producto> carrito;
    

    public Cliente(String nombre, String documento, String telefono, String correo, String contrasena, String apellido, String direccion, String sexo) {
        super(nombre, documento, telefono, correo, contrasena, apellido, direccion, sexo);
        multa = null;
        totalInvertido =0;
        historial = new Lista<>();
        carrito = new Lista<>();
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public int getTotalInvertido() {
        return totalInvertido;
    }

    public void setTotalInvertido(int totalInvertido) {
        this.totalInvertido += totalInvertido;
    }

    public Lista<Venta> getHistorial() {
        return historial;
    }

    public void setHistorial(Lista<Venta> historial) {
        this.historial = historial;
    }

   
    public Lista<Producto> getCarrito() {
        return carrito;
    }

    public void setCarrito(Lista<Producto> carrito) {
        this.carrito = carrito;
    }
    public void limpiarCarrito(){
        carrito = new Lista<>();
    }
  

    
    
    
    
    
}
