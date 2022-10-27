/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import java.util.Date;
import util.Lista;

/**
 *
 * @author Asus
 */
public class Local implements Serializable{

    private String nombre;
    private AdminLocal admin;
    private Date fechaInicio;
    private Date fechaFinal;
    private String precioArriendo;
    private Lista<EmpleadoInterno> empleados;

    public Local(String nombre, AdminLocal admin, Date fechaInicio, Date fechaFinal) {
        this.nombre = nombre;
        this.admin = admin;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        empleados = new Lista<>();
       
    }

    public Local() {
       precioArriendo = "500.000";
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

    public String getPrecioArriendo() {
        return precioArriendo;
    }

    public void setPrecioArriendo(String precioArriendo) {
        this.precioArriendo = precioArriendo;
    }

    public Lista<EmpleadoInterno> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Lista<EmpleadoInterno> empleados) {
        this.empleados = empleados;
    }
    
    
    

}
