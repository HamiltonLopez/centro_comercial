/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.SingletonUsuario;
import excepciones.CorreoExistenteException;
import excepciones.TelefonoInvalidoException;
import excepciones.UsuarioExistenteException;
import java.util.ArrayList;
import modelos.AdminLocal;
import modelos.Administrador;
import modelos.Cliente;
import modelos.EmpleadoGeneral;
import modelos.EmpleadoInterno;

import modelos.Usuario;
import util.Lista;

/**
 *
 * @author aleca
 */
public class ControladorUsuario {

    Lista<Usuario> usuarios;

    Administrador admin1 = new Administrador("Alejandro", "1", "313529085", "alejandro@gmail.com", "123", "Cañón", "Quimbaya", "Viudo");
    Administrador admin2 = new Administrador("Hamilton", "2", "3135451977", "hamilton@gmail.com", "123", "Lopez", "Armenia", "Soltero");

    public ControladorUsuario() {

        usuarios = SingletonUsuario.getINSTANCIA().getUsuarios();

        usuarios.add(admin1);
        usuarios.add(admin2);
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
    public Usuario ValidarAcceso(String documento, String contraseña) {
        for (int i = 0; i < usuarios.Size(); i++) {

            if (usuarios.obtener(i).getDocumento().equals(documento) && usuarios.obtener(i).getContrasena().equals(contraseña)) {

                if (usuarios.obtener(i) instanceof AdminLocal) {
                    AdminLocal admin = (AdminLocal) usuarios.obtener(i);
                    return admin;
                } else if (usuarios.obtener(i) instanceof EmpleadoInterno) {
                    EmpleadoInterno interno = (EmpleadoInterno) usuarios.obtener(i);
                    return interno;
                } else if (usuarios.obtener(i) instanceof Cliente) {
                    Cliente cliente = (Cliente) usuarios.obtener(i);
                    return cliente;
                } else if (usuarios.obtener(i) instanceof Administrador) {
                    Administrador admin = (Administrador) usuarios.obtener(i);
                    return admin;
                } else if (usuarios.obtener(i) instanceof EmpleadoGeneral) {
                    EmpleadoGeneral empleado = (EmpleadoGeneral) usuarios.obtener(i);
                    return empleado;
                }
            }
        }
        return null;
    }

    /*public Lista<Usuario> validarAccesoLista(String documento, String contraseña) {
        Lista<Usuario> lista = new Lista<>();
        for (int i = 0; i < usuarios.Size(); i++) {

            if (usuarios.obtener(i).getDocumento().equals(documento) && usuarios.obtener(i).getContrasena().equals(contraseña)) {

                if (usuarios.obtener(i) instanceof EmpleadoInterno) {
                    EmpleadoInterno interno = (EmpleadoInterno) usuarios.obtener(i);
                    lista.add(interno);
                } else if (usuarios.obtener(i) instanceof Cliente) {
                    Cliente cliente = (Cliente) usuarios.obtener(i);
                    lista.add(admin1);

                } else if (usuarios.obtener(i) instanceof EmpleadoGeneral) {
                    EmpleadoGeneral empleado = (EmpleadoGeneral) usuarios.obtener(i);
                    lista.add(admin1);

                }
            }
        }
        return lista;
    }*/

    public Usuario validarCliente(String documento) {
        for (int i = 0; i < usuarios.Size(); i++) {
            if (usuarios.obtener(i).getDocumento().equals(documento) && usuarios.obtener(i) instanceof Cliente) {
                Cliente cliente = (Cliente) usuarios.obtener(i);
                return cliente;

            }
        }
        return null;
    }
      public Usuario validarEmpleadoGeneral(String documento) {
        for (int i = 0; i < usuarios.Size(); i++) {
            if (usuarios.obtener(i).getDocumento().equals(documento) && usuarios.obtener(i) instanceof EmpleadoGeneral) {
                EmpleadoGeneral empleado = (EmpleadoGeneral) usuarios.obtener(i);
                return empleado;

            }
        }
        return null;
    }

    /**
     * Este metodo nos permite buscar a un usuario por su documento
     *
     * @param documento es con que vamos a identificar el usuario que queremos
     * encontrar
     * @return Un usuario: Docto, paciente, secretario o administrador, de lo
     * contrario null
     */
    public Usuario buscarUsuario(String documento) {
        /*for (int i = 0; i < usuarios.Size(); i++) {
            if (usuarios.obtener(i).getDocumento().equals(documento) && usuarios.obtener(i) instanceof Cliente) {
                Cliente pac = (Cliente) usuarios.obtener(i);
                return pac;
            }
        }*/
       
        for (int i = 0; i < usuarios.Size(); i++) {
            if (usuarios.obtener(i).getDocumento().equals(documento)) {
                if (usuarios.obtener(i) instanceof AdminLocal) {
                    AdminLocal doc = (AdminLocal) usuarios.obtener(i);
                    return doc;
                }
                if (usuarios.obtener(i) instanceof Cliente) {
                    Cliente clie = (Cliente) usuarios.obtener(i);
                    return clie;
                }
                if (usuarios.obtener(i) instanceof EmpleadoInterno) {
                    EmpleadoInterno emple = (EmpleadoInterno) usuarios.obtener(i);
                    return emple;
                }

                if (usuarios.obtener(i) instanceof Administrador) {
                    Administrador admin = (Administrador) usuarios.obtener(i);
                    return admin;
                }
                if (usuarios.obtener(i) instanceof EmpleadoGeneral) {
                    EmpleadoGeneral empleado = (EmpleadoGeneral) usuarios.obtener(i);
                    return empleado;
                }
            }
        }

        return null;
    }

    /**
     * Este metodo nos permite registrar un usuario
     *
     * @param usuario es el objeto que vamos a registrar
     * @return true si registra el usuario
     * @throws UsuarioExistenteException esta excepcion le permite al uuario dar
     * un manejo cuando intenta registrar un usuario existente
     * @throws TelefonoInvalidoException esta excepcion le permite al usuario
     * dar un manejo cuando ingresa un numero de telefono invalido
     * @throws CorreoExistenteException esta excepcion le permite al usuario dar
     * un manejo cuando ingresa mal un correo
     */
    public boolean registrarUsuario(Usuario usuario) throws UsuarioExistenteException, TelefonoInvalidoException, CorreoExistenteException {
        Usuario aux = buscarUsuario(usuario.getDocumento());
        String x = "0123456789";

        /* if (aux instanceof EmpleadoGeneral || aux instanceof EmpleadoInterno && usuario instanceof Cliente) {
            if (usuario.getTelefono().length() != x.length()) {
                throw new TelefonoInvalidoException();
            } else {
                usuarios.add(usuario);
                SingletonUsuario.getINSTANCIA().escribirUsuarios();
                return true;
            }
        }*/
        boolean validar = ValidarCorreo(usuario);

        if (aux != null) {
            throw new UsuarioExistenteException();
        } else if (validar) {
            throw new CorreoExistenteException();
        } else if (usuario.getTelefono().length() != x.length()) {
            throw new TelefonoInvalidoException();
        } else {
            usuarios.add(usuario);
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            return true;
        }
    }

    /**
     * Este metodo nos permite eliminar un usuario
     *
     * @param documento es con que vamos a identificar el usuario que vamos a
     * eliminar
     * @return true si lo elimina, de lo contrario false
     */
    public boolean eliminarUsuario(String documento) {
        for (int i = 0; i < usuarios.Size(); i++) {

            if (usuarios.obtener(i).getDocumento().equals(documento)) {
                usuarios.eliminar(i);
                SingletonUsuario.getINSTANCIA().escribirUsuarios();
                return true;
            }
        }
        return false;
    }

    public Lista<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Este metodo nos permite editar un usuario
     *
     * @param usuario es el objeto que vamos a editar
     * @return true si edita el usuario, de lo contrario false
     */
    public boolean editarUsuario(Usuario usuario) {

        for (int i = 0; i < usuarios.Size(); i++) {
            if (usuarios.obtener(i).getDocumento().equals(usuario.getDocumento())) {

                usuarios.obtener(i).setNombre(usuario.getNombre());
                usuarios.obtener(i).setDocumento(usuario.getDocumento());
                usuarios.obtener(i).setContrasena(usuario.getContrasena());
                usuarios.obtener(i).setCorreo(usuario.getCorreo());
                usuarios.obtener(i).setTelefono(usuario.getTelefono());
                usuarios.obtener(i).setDocumento(usuario.getDocumento());
                usuarios.obtener(i).setDireccion(usuario.getDireccion());
                usuarios.obtener(i).setSexo(usuario.getSexo());
                usuarios.obtener(i).setApellido(usuario.getApellido());

                if (usuarios.obtener(i) instanceof AdminLocal) {
                    AdminLocal admin = (AdminLocal) usuarios.obtener(i);

                    SingletonUsuario.getINSTANCIA().escribirUsuarios();

                    return true;
                }
                if (usuarios.obtener(i) instanceof EmpleadoInterno) {
                    EmpleadoInterno empleado = (EmpleadoInterno) usuarios.obtener(i);
                    EmpleadoInterno usuarioN = (EmpleadoInterno) usuario;
                    empleado.setCargo(usuarioN.getCargo());

                    SingletonUsuario.getINSTANCIA().escribirUsuarios();

                    return true;
                }

                if (usuarios.obtener(i) instanceof Cliente) {
                    Cliente pacient = (Cliente) usuarios.obtener(i);
                    Cliente usuarioN = (Cliente) usuario;

                    SingletonUsuario.getINSTANCIA().escribirUsuarios();

                    return true;

                }
                if (usuarios.obtener(i) instanceof EmpleadoGeneral) {
                    EmpleadoGeneral empleado = (EmpleadoGeneral) usuarios.obtener(i);
                    EmpleadoGeneral usuarioN = (EmpleadoGeneral) usuario;
                    empleado.setCargo(usuarioN.getCargo());
                    SingletonUsuario.getINSTANCIA().escribirUsuarios();
                    return true;
                }
                SingletonUsuario.getINSTANCIA().escribirUsuarios();
                return true;

            }
        }
        return false;

    }

    /**
     * Este metodo permite validar que un usuario no ingrese un correo ya
     * existente
     *
     * @param usuario, al usuario al que le validaremos el correo
     * @return true si el correo coincide con uno registrado, de lo contrario
     * false
     */
    public boolean ValidarCorreo(Usuario usuario) {
        for (int i = 0; i < usuarios.Size(); i++) {
            if (usuarios.obtener(i).getCorreo().equals(usuario.getCorreo())) {
                return true;
            }
        }
        return false;
    }

}
