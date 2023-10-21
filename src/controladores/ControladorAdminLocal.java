/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.SingletonCC;
import Singleton.SingletonCasillas;
import Singleton.SingletonUsuario;
import excepciones.CorreoExistenteException;
import excepciones.ProductoExistenteException;
import excepciones.StockExcedidoException;
import excepciones.TelefonoInvalidoException;
import excepciones.UsuarioExistenteException;
import excepciones.UsuarioNoEncontradoException;
import modelos.Casilla;
import modelos.CentroComercial;
import modelos.Cliente;
import modelos.Compra;
import modelos.Concurso;
import modelos.Empleado;
import modelos.Local;
import modelos.Producto;
import modelos.Usuario;
import modelos.Venta;
import util.Lista;

/**
 *
 * @author Asus
 */
public class ControladorAdminLocal {

    Local local;
    Lista<Empleado> empleados;
    Lista<Producto> productosGeneral;
    Lista<Producto> productosLocal;
    ControladorUsuario controlador;
    CentroComercial cComercial;
    Lista<Venta> historial;
    Lista<Usuario> clientes;
    ControladorCasilla controladorC;
    Lista<Concurso> concursos;

    public ControladorAdminLocal(Local local) {
        this.local = local;
        productosLocal = local.getProductos();
        empleados = local.getEmpleados();
        controlador = new ControladorUsuario();
        cComercial = SingletonCC.getINSTANCIA().getInstancia();
        productosGeneral = cComercial.getProductos();
        historial = local.getHistorial();
        clientes = SingletonUsuario.getINSTANCIA().getUsuarios();
        concursos = cComercial.getConcursos();
        controladorC = new ControladorCasilla();

    }

    public Lista<Venta> getHistorial() {
        return historial;
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
    public boolean añadirEmpleado(Empleado empleado) throws UsuarioExistenteException, TelefonoInvalidoException, CorreoExistenteException {
        Usuario usu = (Usuario) empleado;
        Empleado emple = buscarEmpleado(empleado.getDocumento());
        Usuario aux = controlador.buscarUsuario(empleado.getDocumento());
        boolean corre = controlador.ValidarCorreo(usu);
        String x = "0123456789";
        if (aux != null || emple != null) {
            throw new UsuarioExistenteException();
        } else if (corre) {
            throw new CorreoExistenteException();

        } else if (empleado.getTelefono().length() < x.length() || empleado.getTelefono().length() > x.length()) {
            throw new TelefonoInvalidoException();
        } else {
            empleados.add(empleado);
            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonCasillas.getINSTANCIA().escribirObjeto();
            return true;
        }

    }

    /**
     * Este me permite calcular el total invertido de un cliente dentro de un
     * local
     *
     * @param identificador, con el que identificaremos el cliente
     * @return total de inversion
     * @throws UsuarioNoEncontradoException
     */
    public int buscarTotal(String identificador) throws UsuarioNoEncontradoException {
        int suma = 0;
        Cliente cliente = buscarCliente(identificador);
        if (cliente == null) {
            throw new UsuarioNoEncontradoException();
        } else {
            for (int i = 0; i < historial.Size(); i++) {
                if (historial.obtener(i).getCliente().getDocumento().equalsIgnoreCase(identificador)) {
                    suma += historial.obtener(i).getTotalCompra();
                }
            }
        }
        return suma;

    }

    /**
     * Este metodo permite eliminar un producto montado en el carrito
     *
     * @param identificador, con el que identificaremos el producto
     * @return true si se eliminó, de lo contrario false
     */
    public boolean eliminarProductoCarrito(String identificador) {
        Cliente cliente = buscarCliente(identificador);
        Lista<Producto> carrito = cliente.getCarrito();
        for (int i = 0; carrito.Size() < 10; i++) {
            if (carrito.obtener(i).getIdentificador().equalsIgnoreCase(identificador)) {
                carrito.eliminar(i);
                SingletonUsuario.getINSTANCIA().escribirUsuarios();
                SingletonCC.getINSTANCIA().escribirObjeto();
                SingletonCasillas.getINSTANCIA().escribirObjeto();
                return true;
            }
        }
        return false;
    }

    /**
     * Este metodo nos permite buscar un cliente
     *
     * @param documento, con el que podremos hallar el cliente
     * @return cliente si existe, de lo contrario
     * @throws UsuarioNoEncontradoException
     */
    public Cliente buscarCliente(String documento) throws UsuarioNoEncontradoException {
        for (int i = 0; i < clientes.Size(); i++) {
            if (clientes.obtener(i).getDocumento().equals(documento) && clientes.obtener(i) instanceof Cliente) {
                Cliente cliente = (Cliente) clientes.obtener(i);
                return cliente;

            }
        }
        throw new UsuarioNoEncontradoException();
    }

    /**
     * Este metodo nos permite buscar a un empleado por su documento
     *
     * @param documento es con que vamos a identificar el usuario que queremos
     * encontrar
     * @return Un empleado si existe de lo contrario null
     *
     */
    public Empleado buscarEmpleado(String documento) {
        for (int i = 0; i < empleados.Size(); i++) {
            if (empleados.obtener(i) != null && empleados.obtener(i).getDocumento().equals(documento)) {
                return empleados.obtener(i);
            }
        }
        return null;
    }

    /**
     * Este metodo nos permite editar un empleado
     *
     * @param empleado es el objeto que vamos a editar
     * @return true si edita el usuario, de lo contrario false
     */
    public boolean editarEmpleado(Empleado empleado) {
        Empleado aux = buscarEmpleado(empleado.getDocumento());
        if (aux != null) {
            Empleado emple = (Empleado) empleado;
            aux.setApellido(empleado.getApellido());
            aux.setCargo(empleado.getCargo());
            aux.setContrasena(empleado.getContrasena());
            aux.setCorreo(empleado.getCorreo());
            aux.setDireccion(empleado.getDireccion());
            aux.setNombre(empleado.getNombre());
            aux.setSexo(empleado.getSexo());
            aux.setTelefono(empleado.getTelefono());

            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonCasillas.getINSTANCIA().escribirObjeto();
            return true;
        }
        return false;

    }

    /**
     * *
     * Este metodo nos permite agregar un producto al carrito compra
     *
     * @param cliente al que le agregaremos el producto
     * @param identificador del producto
     * @param cantidad seleccionada para ingresar
     * @return true si se agrego de lo contrario false
     * @throws StockExcedidoException
     */
    public boolean agregarCarrito(Cliente cliente, String identificador, int cantidad) throws StockExcedidoException {
        Lista<Producto> carrito = cliente.getCarrito();
        Producto producto = buscarProductoLocal(identificador);
        boolean aux1 = validarStock(producto, cantidad);
        if (producto == null) {

            return false;

        } else if (aux1) {
            throw new StockExcedidoException();
        } else {
            Producto aux;
            aux = Producto.clone(producto);
            int precio = aux.getPrecio() * cantidad;
            aux.setPrecio(precio);
            aux.setCantBodega(cantidad);
            carrito.add(aux);
            cliente.setCarrito(carrito);
            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonCasillas.getINSTANCIA().escribirObjeto();
            return true;

        }

    }

    /**
     * *
     * Este metodo nos permite finalizar una compra
     *
     * @param venta, la cual se buscará finalizar
     * @return true si se compró, de lo contrario false
     */
    public boolean comprarProducto(Venta venta) {
        Cliente cliente = venta.getCliente();
        Lista<Producto> comprados = cliente.getCarrito();

        for (int i = 0; i < comprados.Size(); i++) {
            Producto prod = buscarProductoGeneral(comprados.obtener(i).getIdentificador());
            Producto local = buscarProductoLocal(comprados.obtener(i).getIdentificador());
            if (prod != null) {
                int disminuir = prod.getCantBodega() - comprados.obtener(i).getCantBodega();
                prod.setCantBodega(disminuir);

                local.setCantBodega(disminuir);

            }

        }

        boolean aux = validarParticipacion(venta);
        if (aux) {
            cliente.limpiarCarrito();
            agregarHistorialCliente(venta);
            historial.add(venta);
            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonCasillas.getINSTANCIA().escribirObjeto();
            return true;
        } else {
            cliente.limpiarCarrito();
            agregarHistorialCliente(venta);
            historial.add(venta);
            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonCasillas.getINSTANCIA().escribirObjeto();
            return false;
        }

    }

    /**
     *
     * @param productos
     * @return
     */
    public int retornarCantidadProductos(Lista<Producto> productos) {
        int total = 0;
        for (int i = 0; i < productos.Size(); i++) {
            total += productos.obtener(i).getCantBodega();
        }
        return total;
    }

    /**
     *
     * @param venta
     */
    public void agregarHistorialCliente(Venta venta) {
        Cliente cliente = venta.getCliente();
        cliente.getHistorial().add(venta);
        cliente.setTotalInvertido(venta.getTotalCompra());
        SingletonCC.getINSTANCIA().escribirObjeto();
        SingletonUsuario.getINSTANCIA().escribirUsuarios();
        SingletonCC.getINSTANCIA().escribirObjeto();
        SingletonCasillas.getINSTANCIA().escribirObjeto();
    }

    /**
     * Permite buscar un producto mediante su identicador
     *
     * @param identificador, por el cual lo buscaremos
     * @return
     */
    public boolean validarParticipacion(Venta venta) {
        Cliente cliente = venta.getCliente();

        for (int i = 0; i < concursos.Size(); i++) {
            if (concursos.obtener(i).getValorMinimo() <= venta.getTotalCompra()) {
                Concurso concurso = concursos.obtener(i);
                Lista<Cliente> participantes = concurso.getParticipantes();
                participantes.add(cliente);
                return true;
            }
        }
        return false;
    }

    /**
     * Permite buscar un producto mediante su identicador
     *
     * @param identificador, por el cual lo buscaremos
     * @return
     */
    public Producto buscarProductoGeneral(String identificador) {
        for (int i = 0; i < productosGeneral.Size(); i++) {
            if (productosGeneral.obtener(i) != null && productosGeneral.obtener(i).getIdentificador().equals(identificador)) {
                return productosGeneral.obtener(i);
            }
        }
        return null;
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

                SingletonCC.getINSTANCIA().escribirObjeto();
                SingletonUsuario.getINSTANCIA().escribirUsuarios();
                SingletonCasillas.getINSTANCIA().escribirObjeto();
                return true;
            }
        }
        return false;
    }

    public Local getLocal() {
        return local;
    }

    public Lista<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * *
     * Metodo que permite validar que el numero en stock sea valido
     *
     * @param producto
     * @param cantidad
     * @return
     */
    public boolean validarStock(Producto producto, int cantidad) {
        if (cantidad > producto.getCantBodega()) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param identificador
     * @return
     */
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

    /**
     * *
     * Metodo que permite marcar el local como desocupado
     *
     * @return
     */
    public boolean marcarDesocupado() {
        Casilla casilla = retornarLocal(local.getContrato().getAdmin());
        casilla.setEstado(Casilla.DESOCUPADO);
        SingletonCC.getINSTANCIA().escribirObjeto();
        SingletonUsuario.getINSTANCIA().escribirUsuarios();
        SingletonCasillas.getINSTANCIA().escribirObjeto();
        return true;
    }

    /**
     * Metodo para buscar el local correspondiente basado en el administrador
     *
     * @param documento
     * @return
     */
    private Casilla retornarLocal(Empleado documento) {
        Casilla[][] locales = SingletonCasillas.getINSTANCIA().getLista();

        for (int i = 0; i < locales.length; i++) {
            for (int j = 0; j < locales[i].length; j++) {
                Casilla casilla = controladorC.obtenerCasilla(i, j);
                Local puesto = casilla.getLocal();
                if (puesto != null && puesto.getContrato()!=null && puesto.getContrato().getAdmin().equals(documento)) {

                    return casilla;

                }

            }
        }
        return null;

    }

    /**
     *
     * @param local
     * @return
     */
    public Casilla retornarCasilla(Local local) {
        Casilla[][] locales = SingletonCasillas.getINSTANCIA().getLista();

        for (int i = 0; i < locales.length; i++) {
            for (int j = 0; j < locales[i].length; j++) {
                Casilla casilla = controladorC.obtenerCasilla(i, j);
                Local puesto = casilla.getLocal();
                if (puesto != null) {
                    if (puesto.equals(local)) {
                        return casilla;
                    }
                }

            }
        }
        return null;

    }

}
