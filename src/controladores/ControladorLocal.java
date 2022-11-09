/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.SingletonCC;
import Singleton.SingletonCasillas;
import Singleton.SingletonUsuario;
import excepciones.CorreoExistenteException;
import excepciones.ProductoExistente;
import excepciones.TelefonoInvalidoException;
import excepciones.UsuarioExistenteException;
import modelos.CentroComercial;
import modelos.EmpleadoInterno;
import modelos.Local;
import modelos.Producto;
import modelos.Usuario;
import util.Lista;

/**
 *
 * @author Asus
 */
public class ControladorLocal {

    Local local;
    Lista<EmpleadoInterno> empleados;
    Lista<Producto> productosGeneral;
    Lista<Producto> productosLocal;
    ControladorUsuario controlador;
    CentroComercial cComercial;

    public ControladorLocal(Local local) {
        this.local = local;
        productosLocal = local.getProductos();
        empleados = local.getEmpleados();
        controlador = new ControladorUsuario();

        cComercial = SingletonCC.getINSTANCIA().getInstancia();
        productosGeneral = cComercial.getProductos();

    }

    /**
     * Este metodo nos permite registrar un usuario
     *
     * @param empleado es el objeto que vamos a registrar
     * @return true si registra el usuario
     * @throws UsuarioExistenteException esta excepcion le permite al uuario dar
     * un manejo cuando intenta registrar un usuario existente
     * @throws TelefonoInvalidoException esta excepcion le permite al usuario
     * dar un manejo cuando ingresa un numero de telefono invalido
     */
    public boolean añadirEmpleado(EmpleadoInterno empleado) throws UsuarioExistenteException, TelefonoInvalidoException, CorreoExistenteException {
        Usuario usu = (Usuario) empleado;
        Usuario aux = controlador.buscarUsuario(empleado.getDocumento());
        boolean corre = controlador.ValidarCorreo(usu);
        String x = "0123456789";
        if (aux != null) {
            throw new UsuarioExistenteException();
        } else if (corre) {
            throw new CorreoExistenteException();

        } else if (empleado.getTelefono().length() != x.length()) {
            throw new TelefonoInvalidoException();
        } else {
            empleados.add(empleado);
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            return true;
        }

    }

    /**
     * Este metodo nos permite buscar a un empleado por su documento
     *
     * @param documento es con que vamos a identificar el usuario que queremos
     * encontrar
     * @return Un empleado si existe de lo contrario null
     *
     */
    public EmpleadoInterno buscarEmpleado(String documento) {
        for (int i = 0; i < empleados.Size(); i++) {
            if (empleados.obtener(i) != null && empleados.obtener(i).getDocumento().equals(documento)) {
                return empleados.obtener(i);
            }
        }
        return null;
    }

    /*public EmpleadoInterno validarAcceso(String documento, String contraseña) {
        for (int i = 0; i < empleados.Size(); i++) {
            if (empleados.obtener(i) != null && empleados.obtener(i).getDocumento().equals(documento) && empleados.obtener(i).getContrasena().equals(contraseña)) {
                return empleados.obtener(i);
            }
        }
        return null;
    }*/
    /**
     * Este metodo nos permite editar un empleado
     *
     * @param empleado es el objeto que vamos a editar
     * @return true si edita el usuario, de lo contrario false
     */
    public boolean editarEmpleado(EmpleadoInterno empleado) {
        EmpleadoInterno aux = buscarEmpleado(empleado.getDocumento());
        if (aux != null) {
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
        }
        return false;

    }

    /**
     * Este metodo nos permite eliminar un empleado
     *
     * @param documento es con que vamos a identificar el usuario que vamos a
     * eliminar
     * @return true si lo elimina, de lo contrario false
     */
    public boolean eliminarEmpleado(String documento) {
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
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean añadirProducto(Producto producto) throws ProductoExistente {
        Producto aux = buscarProductoLocal(producto.getIdentificador());
        if (aux != null) {
            throw new ProductoExistente();
        }

        productosLocal.add(producto);
        productosGeneral.add(producto);
        SingletonCasillas.getINSTANCIA().escribirObjeto();
        SingletonUsuario.getINSTANCIA().escribirUsuarios();
        SingletonCC.getINSTANCIA().escribirObjeto();
        return true;
    }

    public boolean eliminarProducto(String identificador, int cantidad) {
        for (int i = 0; i < productosLocal.Size(); i++) {
            if (productosLocal.obtener(i) != null && productosLocal.obtener(i).getIdentificador().equals(identificador)) {
                int total = productosLocal.obtener(i).getCantBodega() - cantidad;
                productosLocal.obtener(i).setCantBodega(total);
                if (productosLocal.obtener(i).getCantBodega() <= 0) {
                    productosLocal.eliminar(i);
                }
                ////////////////////////////
                for (int j = 0; j < productosGeneral.Size(); j++) {
                    if (productosGeneral.obtener(j) != null && productosGeneral.obtener(j).getIdentificador().equals(identificador)) {
                        int tota = productosGeneral.obtener(j).getCantBodega() - cantidad;
                        productosGeneral.obtener(i).setCantBodega(total);
                        if (productosGeneral.obtener(i).getCantBodega() <= 0) {
                            productosGeneral.eliminar(i);

                        }

                    }
                }
                SingletonCC.getINSTANCIA().escribirObjeto();
                SingletonCasillas.getINSTANCIA().escribirObjeto();
                SingletonUsuario.getINSTANCIA().escribirUsuarios();
                return true;

            }

        }
        SingletonCC.getINSTANCIA().escribirObjeto();
        SingletonCasillas.getINSTANCIA().escribirObjeto();
        SingletonUsuario.getINSTANCIA().escribirUsuarios();
        return false;

    }

    public Producto buscarProductoLocal(String identificador) {
        for (int i = 0; i < productosLocal.Size(); i++) {
            if (productosLocal.obtener(i) != null && productosLocal.obtener(i).getIdentificador().equals(identificador)) {
                return productosLocal.obtener(i);
            }
        }
        return null;
    }

    public Lista<Producto> getProductosLocal() {
        return productosLocal;
    }

    public boolean editarProducto(Producto producto) {
        Producto aux = buscarProductoLocal(producto.getIdentificador());
        if (aux != null) {
            aux.setNombreProducto(producto.getNombreProducto());
            aux.setCategoria(producto.getCategoria());
            aux.setMarca(producto.getMarca());
            aux.setPesoBruto(producto.getPesoBruto());
            aux.setCantBodega(producto.getCantBodega());
            aux.setPrecio(producto.getPrecio());
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            SingletonCC.getINSTANCIA().escribirObjeto();
            return true;
        }
        return false;

    }

}
