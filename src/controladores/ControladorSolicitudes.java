/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.SingletonCC;
import excepciones.MaximoDeSolicitudesException;
import modelos.CentroComercial;
import modelos.Empleado;
import modelos.Local;
import modelos.SolicitudMantenimiento;
import util.Lista;
import util.Queue;

/**
 *
 * @author Asus
 */
public class ControladorSolicitudes {

    CentroComercial cComercial;
    Queue<SolicitudMantenimiento> solicitudes;
    Lista<SolicitudMantenimiento> nuevo;

    public ControladorSolicitudes() {
        cComercial = SingletonCC.getINSTANCIA().getInstancia();
        solicitudes = cComercial.getSolicitudes();
        nuevo = cComercial.getNuevo();      
    }

    public Lista<SolicitudMantenimiento> getNuevo() {
        return nuevo;
    }
    

    public boolean añadirSolicitud(SolicitudMantenimiento solicitud) throws MaximoDeSolicitudesException {
        int numero = validarNumeroSolicitudes(solicitud.getLocal());
        if (numero == 3) {
            throw new MaximoDeSolicitudesException();
        } else {
            solicitudes.enqueue(solicitud);
            nuevo.add(solicitud);
            SingletonCC.getINSTANCIA().escribirObjeto();
            return true;
        }
    }

    public int validarNumeroSolicitudes(Local local) {
        int contador = 0;
        for (int i = 0; i < nuevo.Size(); i++) {
            Empleado empleado = nuevo.obtener(i).getLocal().getContrato().getAdmin();
            if (empleado.getDocumento().equals(local.getContrato().getAdmin().getDocumento()) && 
                    !nuevo.obtener(i).getEstado().equalsIgnoreCase("Atendida")) {
                contador++;
            }

        }
        return contador;

    }
    public Lista<SolicitudMantenimiento> verSolicitudesLocal(Local local){
        Lista<SolicitudMantenimiento> solici = new Lista<>();
        for (int i = 0; i < nuevo.Size(); i++) {
            if(nuevo.obtener(i)!=null ){
                Empleado empleado = nuevo.obtener(i).getLocal().getContrato().getAdmin();
                if(empleado.getDocumento().equals(local.getContrato().getAdmin().getDocumento())){
                    solici.add(nuevo.obtener(i));
                }
            }
        }
        return solici;
    }

   

    /**
     *
     * @param solicitud
     */
    public void cambiarEnProgreso() {
        SolicitudMantenimiento solicitud = solicitudes.dequeue();
        solicitud.setEstado(SolicitudMantenimiento.ENPROGESO);
        solicitudes.enqueue(solicitud);
        SingletonCC.getINSTANCIA().escribirObjeto();

    }

    /**
     *
     * @return
     */
    public SolicitudMantenimiento atenderSolicitud() {
        SolicitudMantenimiento atendido = solicitudes.dequeue();
        atendido.setEstado(SolicitudMantenimiento.ATENDIDA);
        SingletonCC.getINSTANCIA().escribirObjeto();
        return atendido;
    }

    public void cambiarACancelado() {

        SolicitudMantenimiento solicitud = solicitudes.dequeue();
        solicitud.setEstado(SolicitudMantenimiento.CANCELADO);
        solicitudes.enqueue(solicitud);
        SingletonCC.getINSTANCIA().escribirObjeto();
    }

    public void cambiarAPendiente() {
        SolicitudMantenimiento solicitud = solicitudes.dequeue();
        solicitud.setEstado(SolicitudMantenimiento.PENDIENTE);
        solicitudes.enqueue(solicitud);
        SingletonCC.getINSTANCIA().escribirObjeto();
    }

    /**
     *
     * @return
     */
    public SolicitudMantenimiento verSiguiente() {
        if (solicitudes.isEmpty()) {
            return null;
        }
        SingletonCC.getINSTANCIA().escribirObjeto();
        return solicitudes.peek();
        

    }

}
