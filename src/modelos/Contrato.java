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
public class Contrato implements Serializable{
      
    private AdminLocal admin;
    private Date fechaInicio;
    private Date fechaFinal;

    public Contrato(String nombre, AdminLocal admin, Date fechaInicio, Date fechaFinal) {
      
        this.admin = admin;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
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
    
}
