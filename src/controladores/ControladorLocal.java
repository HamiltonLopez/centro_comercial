/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.SingletonUsuario;
import excepciones.TelefonoInvalidoException;
import excepciones.UsuarioExistenteException;
import modelos.EmpleadoInterno;
import modelos.Local;
import util.Lista;

/**
 *
 * @author Asus
 */
public class ControladorLocal {

    Local local;
    Lista<EmpleadoInterno> empleados;

    public ControladorLocal(Local local) {
        this.local = local;
        empleados = local.getEmpleados();
    }

    public boolean añadirEmpleado(EmpleadoInterno empleado) throws UsuarioExistenteException, TelefonoInvalidoException {
        EmpleadoInterno aux = buscarEmpleado(empleado.getDocumento());
        String x = "0123456789";
        if (aux != null) {
            throw new UsuarioExistenteException();
        } else if (empleado.getTelefono().length() != x.length()) {
            throw new TelefonoInvalidoException();
        } else {
            empleados.add(empleado);
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            return true;
        }

    }

    public EmpleadoInterno buscarEmpleado(String documento) {
        for (int i = 0; i < empleados.Size(); i++) {
            if (empleados.obtener(i) != null && empleados.obtener(i).getDocumento().equals(documento)) {
                return empleados.obtener(i);
            }
        }
        return null;
    }
    public boolean editarEmpleado(EmpleadoInterno empleado){
        EmpleadoInterno aux = buscarEmpleado(empleado.getDocumento());
        if(aux!=null){
            aux.setApellido(empleado.getApellido());
            aux.setCargo(empleado.getCargo());
            aux.setContrasena(empleado.getContrasena());
            aux.setCorreo(empleado.getCorreo());
            aux.setDireccion(empleado.getDireccion());
            aux.setNombre(empleado.getNombre());
            aux.setSexo(empleado.getSexo());
            aux.setTelefono(empleado.getTelefono());
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            return true;
        }  return false;
        
          
    }
    public boolean eliminarEmpleado(String documento){
       for (int i = 0; i < empleados.Size(); i++) {
            if (empleados.obtener(i) != null && empleados.obtener(i).getDocumento().equals(documento)) {
                empleados.eliminar(i);
                SingletonUsuario.getINSTANCIA().escribirUsuarios();
                return true;
            }
        }
        return false;
    }

    public Local getLocal() {
        return local;
    }

    public Lista<EmpleadoInterno> getEmpleados() {
        return empleados;
    }

}
