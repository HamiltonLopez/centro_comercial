/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class Casilla implements Serializable {

    public static final String DISPONIBLE = "Disponible";
    public static final String OCUPADO = "Ocupado";
    public static final String DESOCUPADO = "Desocupado";

    private String estado;
    private Local local;
    private Puesto puesto;

    public Casilla() {
        this.estado = DISPONIBLE;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

}
