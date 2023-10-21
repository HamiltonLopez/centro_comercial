/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import util.Lista;
import util.Queue;

/**
 *
 * @author Asus
 */
public class CentroComercial implements Serializable {

    Lista<Producto> productos;
    Lista<Concurso> concursos;
    Lista<SolicitudMantenimiento> nuevo;
    Queue<SolicitudMantenimiento> solicitudes;

    public CentroComercial() {
        nuevo = new Lista<>();
        productos = new Lista<>();

        concursos = new Lista<>();

        solicitudes = new Queue<>();

    }

    public Lista<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Lista<Producto> productos) {
        this.productos = productos;
    }

    public Lista<Concurso> getConcursos() {
        return concursos;
    }

    public void setConcursos(Lista<Concurso> concursos) {
        this.concursos = concursos;
    }

    public Queue<SolicitudMantenimiento> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(Queue<SolicitudMantenimiento> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public Lista<SolicitudMantenimiento> getNuevo() {
        return nuevo;
    }

    public void setNuevo(Lista<SolicitudMantenimiento> nuevo) {
        this.nuevo = nuevo;
    }
    

}
