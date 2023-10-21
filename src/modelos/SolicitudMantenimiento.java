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
public class SolicitudMantenimiento implements Serializable {

    public static final String CANCELADO = "Cancelado";
    public static final String PENDIENTE = "Pendiente";
    public static final String ENPROGESO = "En progreso";
    public static final String ATENDIDA = "Atendida";
    private Local local;
    private String detallesSolicitud;
    private String estado;
    private Date fecha;

    public SolicitudMantenimiento(Local local, String detallesSolicitud, Date fecha) {
        this.local = local;
        this.detallesSolicitud = detallesSolicitud;
        this.fecha = fecha;
        this.estado = PENDIENTE;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String getDetallesSolicitud() {
        return detallesSolicitud;
    }

    public void setDetallesSolicitud(String detallesSolicitud) {
        this.detallesSolicitud = detallesSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
}
