/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.SingletonCasillas;
import Singleton.SingletonUsuario;
import modelos.Administrador;
import modelos.Casilla;
import modelos.Cliente;
import modelos.Empleado;

import modelos.Local;
import modelos.Usuario;
import util.Lista;

/**
 *
 * @author Asus
 */
public class ControladorLogin {

    Lista<Usuario> usuarios;
    ControladorCasilla controlador;
    Administrador admin1 = new Administrador("Hamilton", "2", "3135451977", "1", "123", "Lopez", "Armenia", "Masculino");

    public ControladorLogin() {
        usuarios = SingletonUsuario.getINSTANCIA().getUsuarios();
        if (usuarios.Size() == 0) {
            usuarios.add(admin1);
        }
        controlador = new ControladorCasilla();
    }

    /**
     * Este metodo nos permite buscar un usuario
     *
     * @param documento es con que vamos a identificar el usuario
     * @param contraseña es con que identificamos tambien a un usuario para que
     * ingrese sesion
     * @return Un usuario: AdminLocal, Empleado interno, Cliente,Administrador o
     * EmpleadoGeneral contrario null
     */
    public Usuario ValidarAcceso(String correo, String contraseña) {
        for (int i = 0; i < usuarios.Size(); i++) {

            if (usuarios.obtener(i).getCorreo().equals(correo) && usuarios.obtener(i).getContrasena().equals(contraseña)) {

                if (usuarios.obtener(i) instanceof Empleado) {
                    Empleado admin = (Empleado) usuarios.obtener(i);
                    return admin;
                } else if (usuarios.obtener(i) instanceof Cliente) {
                    Cliente cliente = (Cliente) usuarios.obtener(i);
                    return cliente;
                } else if (usuarios.obtener(i) instanceof Administrador) {
                    Administrador admin = (Administrador) usuarios.obtener(i);
                    return admin;
                }
            }
        }
        return null;
    }

    public Local retornarLocal(Empleado empleado) {
        Casilla[][] locales = SingletonCasillas.getINSTANCIA().getLista();

        if (empleado.getCargo().equalsIgnoreCase("Administrador de local")) {

            for (int i = 0; i < locales.length; i++) {
                for (int j = 0; j < locales[i].length; j++) {
                    Casilla casilla = controlador.obtenerCasilla(i, j);
                    Local local = casilla.getLocal();
                    if (local.getContrato() != null) {
                        if (local.getContrato().getAdmin().getDocumento().equalsIgnoreCase(empleado.getDocumento())) {
                            return local;
                        }
                    }

                }
            }

        } else if (empleado.getCargo().equalsIgnoreCase("Vendedor")) {
            for (int i = 0; i < locales.length; i++) {
                for (int j = 0; j < locales[i].length; j++) {
                    Casilla casilla = controlador.obtenerCasilla(i, j);
                    Local local = casilla.getLocal();
                    if (local.getEmpleados() != null) {
                        Lista<Empleado> empleados = local.getEmpleados();
                        if (empleados.Size() != 0) {
                            for (int k = 0; k < empleados.Size(); k++) {
                                if (empleados.obtener(k).getDocumento().equalsIgnoreCase(empleado.getDocumento())) {
                                    return local;
                                }
                            }
                        }
                    }

                }
            }
        } else if (empleado.getCargo().equalsIgnoreCase("Encargado de inventario")) {
            for (int i = 0; i < locales.length; i++) {
                for (int j = 0; j < locales[i].length; j++) {
                    Casilla casilla = controlador.obtenerCasilla(i, j);
                    Local local = casilla.getLocal();
                    if (local.getEmpleados() != null) {
                        Lista<Empleado> empleados = local.getEmpleados();
                        if (empleados.Size() != 0) {
                            for (int k = 0; k < empleados.Size(); k++) {
                                if (empleados.obtener(k).getDocumento().equalsIgnoreCase(empleado.getDocumento())) {
                                    return local;
                                }
                            }
                        }
                    }

                }
            }
        }

        return null;
    }
}
