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
public class CentroComercial implements Serializable{
    
    Lista<Producto> productos;

    public CentroComercial() {
        if(productos==null){
            productos = new Lista<>();
        }
       
    }

    public Lista<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Lista<Producto> productos) {
        this.productos = productos;
    }
    
    
}
