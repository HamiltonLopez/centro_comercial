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
public class SolicitudMantenimiento implements Serializable{
    private AdminLocal admin;
    private String detallesSolicitud;

    public SolicitudMantenimiento(AdminLocal admin, String detallesSolicitud) {
        this.admin = admin;
        this.detallesSolicitud = detallesSolicitud;
    }

    public AdminLocal getAdmin() {
        return admin;
    }

    public void setAdmin(AdminLocal admin) {
        this.admin = admin;
    }

    public String getDetallesSolicitud() {
        return detallesSolicitud;
    }

    public void setDetallesSolicitud(String detallesSolicitud) {
        this.detallesSolicitud = detallesSolicitud;
    }
    
}
