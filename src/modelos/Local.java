/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.Date;
import util.Lista;

/**
 *
 * @author Asus
 */
public class Local {

    private String nombre;
    private AdminLocal admin;
    private Date fechaInicio;
    private Date fechaFinal;
    private double precioArriendo;

    public Local(String nombre, AdminLocal admin, Date fechaInicio, Date fechaFinal) {
        this.nombre = nombre;
        this.admin = admin;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        precioArriendo = 500.000;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public AdminLocal getAdmin() {
        return admin;
    }

    public void setAdmin(AdminLocal admin) {
        this.admin = admin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public double getPrecioArriendo() {
        return precioArriendo;
    }

    public void setPrecioArriendo(double precioArriendo) {
        this.precioArriendo = precioArriendo;
    }
    
    

}
