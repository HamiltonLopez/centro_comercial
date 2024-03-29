/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.SingletonCC;
import Singleton.SingletonCasillas;
import Singleton.SingletonUsuario;
import excepciones.AdministradorYaExisteException;
import excepciones.CorreoExistenteException;
import excepciones.TelefonoInvalidoException;
import excepciones.UsuarioExistenteException;
import java.util.ArrayList;
import modelos.Administrador;
import modelos.Casilla;
import modelos.CentroComercial;
import modelos.Cliente;
import modelos.Concurso;
import modelos.Empleado;
import modelos.Local;

import modelos.Usuario;
import util.Lista;

/**
 *
 * @author aleca
 */
public class ControladorUsuario {

    Lista<Usuario> usuarios;
    ControladorCasilla controlador;
    CentroComercial cComercial;
    Lista<Concurso> concursos;

    public ControladorUsuario() {
        controlador = new ControladorCasilla();
        usuarios = SingletonUsuario.getINSTANCIA().getUsuarios();
        cComercial = SingletonCC.getINSTANCIA().getInstancia();
        concursos = cComercial.getConcursos();

    }

    public Usuario BuscarCliente(String documento) {
        for (int i = 0; i < usuarios.Size(); i++) {
            if (usuarios.obtener(i).getDocumento().equals(documento) && usuarios.obtener(i) instanceof Cliente) {
                Cliente cliente = (Cliente) usuarios.obtener(i);
                return cliente;

            }
        }
        return null;
    }

    public Lista<Empleado> getEmpleados() {
        Lista<Empleado> empleados = new Lista<>();
        for (int i = 0; i < usuarios.Size(); i++) {
            if (usuarios.obtener(i) instanceof Empleado) {
                Empleado empleado = (Empleado) usuarios.obtener(i);
                if (empleado.getCargo().equalsIgnoreCase("Administrador Parqueadero")
                        || empleado.getCargo().equalsIgnoreCase("Celador")
                        || empleado.getCargo().equalsIgnoreCase("Aseo") || empleado.getCargo().equalsIgnoreCase("Administrador de Local")) {

                    empleados.add(empleado);
                }
            }
        }
        return empleados;
    }

    public Empleado BuscarEmpleadoGeneral(String documento) {
        for (int i = 0; i < usuarios.Size(); i++) {
            if (usuarios.obtener(i) instanceof Empleado) {
                Empleado empleado = (Empleado) usuarios.obtener(i);
                if (empleado.getDocumento().equals(documento)  && empleado.getCargo().equalsIgnoreCase("Administrador Parqueadero")
                        | empleado.getCargo().equalsIgnoreCase("Celador")
                        | empleado.getCargo().equalsIgnoreCase("Aseo") | empleado.getCargo().equalsIgnoreCase("Administrador de Local")) {

                    return empleado;

                }
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

        for (int i = 0; i < usuarios.Size(); i++) {
            if (usuarios.obtener(i).getDocumento().equals(documento)) {

                if (usuarios.obtener(i) instanceof Cliente) {
                    Cliente clie = (Cliente) usuarios.obtener(i);
                    return clie;
                }
                if (usuarios.obtener(i) instanceof Empleado) {
                    Empleado emple = (Empleado) usuarios.obtener(i);
                    return emple;
                }
                if (usuarios.obtener(i) instanceof Administrador) {
                    Administrador admin = (Administrador) usuarios.obtener(i);
                    return admin;
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
    public boolean registrarUsuario(Usuario usuario, String adicional) throws UsuarioExistenteException, TelefonoInvalidoException, CorreoExistenteException, AdministradorYaExisteException {
        Usuario aux = buscarUsuario(usuario.getDocumento());
        String x = "0123456789";

        boolean validar = ValidarCorreo(usuario);
        boolean local = validarAdministrador(usuario);
        if (aux != null ) {
            throw new UsuarioExistenteException();
        } else if (local) {
            throw new AdministradorYaExisteException();
        } else if (validar) {
            throw new CorreoExistenteException();
        } else if (usuario.getTelefono().length() < x.length() || usuario.getTelefono().length() > x.length()) {
            throw new TelefonoInvalidoException();
        } else {
            usuarios.add(usuario);
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            return true;
        }
    }

    public boolean validarAdministrador(Usuario usuario) {
        Casilla[][] locales = SingletonCasillas.getINSTANCIA().getLista();
        if (usuario instanceof Empleado) {
            Empleado empleado = (Empleado) usuario;
            for (int i = 0; i < locales.length; i++) {
                for (int j = 0; j < locales[i].length; j++) {
                    Casilla casilla = controlador.obtenerCasilla(i, j);
                    Local local = casilla.getLocal();
                    if (local.getContrato() != null) {
                        if (local.getContrato().getAdmin().getDocumento().equals(empleado.getDocumento())) {
                            return true;
                        }
                    }

                }
            }
            return false;
        } else {
            return false;
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

                if (usuarios.obtener(i) instanceof Cliente) {
                    Cliente pacient = (Cliente) usuarios.obtener(i);
                    Cliente usuarioN = (Cliente) usuario;

                    SingletonUsuario.getINSTANCIA().escribirUsuarios();

                    return true;

                }
                if (usuarios.obtener(i) instanceof Empleado) {
                    Empleado empleado = (Empleado) usuarios.obtener(i);
                    Empleado usuarioN = (Empleado) usuario;
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
