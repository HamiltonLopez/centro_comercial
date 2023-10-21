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
public class Producto implements Serializable {

    private int cantBodega;
    private String nombreProducto;
    private String identificador;
    private String categoria;
    private int precio;
    private String pesoBruto;
    private String marca;
    private int descuento;

    public Producto(String nombreProducto, String identificador, String categoria, int precio, String pesoNeto, int cantBodega, String marca, int descuento) {
        this.nombreProducto = nombreProducto;
        this.identificador = identificador;
        this.categoria = categoria;
        this.precio = precio;
        this.pesoBruto = pesoNeto;
        this.cantBodega = cantBodega;
        this.marca = marca;
        this.descuento = descuento;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String materialPresentacion) {
        this.categoria = materialPresentacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(String pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    public int getCantBodega() {
        return cantBodega;
    }

    public void setCantBodega(int cantBodega) {
        this.cantBodega = cantBodega;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

  
    public static Producto clone(Producto producto)  {
        return new Producto(producto.getNombreProducto(), producto.getIdentificador(), producto.getCategoria(), producto.getPrecio(), producto.getPesoBruto(), producto.getCantBodega(), producto.getMarca(),producto.getDescuento());
    }

   
    
    

}
