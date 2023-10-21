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
public class Compra implements Serializable{
    private Lista<Producto> productos;
    private int articulos;

    public Compra(Lista<Producto> productos) {
        this.productos = productos;
    }

    public int getArticulos() {
        return articulos;
    }

    public void setArticulos(int articulos) {
        this.articulos = articulos;
    }
    

    public Lista<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Lista<Producto> productos) {
        this.productos = productos;
    }
    
    
}
