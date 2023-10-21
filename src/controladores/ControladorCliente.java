/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.SingletonCC;
import Singleton.SingletonCasillas;
import Singleton.SingletonUsuario;
import excepciones.StockExcedidoException;
import java.util.Date;
import modelos.Casilla;
import modelos.CentroComercial;
import modelos.Cliente;
import modelos.Concurso;
import modelos.Local;
import modelos.Producto;
import modelos.Separado;
import modelos.Venta;
import util.Lista;

/**
 *
 * @author Asus
 */
public class ControladorCliente {

    Lista<Producto> productosGeneral;
    Cliente cliente;
    CentroComercial cComercial;
    Lista<Producto> carrito;
    ControladorCasilla controlador;
    Lista<Venta> historialCliente;
    Lista<Concurso> concursos;

    public ControladorCliente(Cliente cliente) {
        this.cliente = cliente;
        carrito = cliente.getCarrito();
        cComercial = SingletonCC.getINSTANCIA().getInstancia();
        productosGeneral = cComercial.getProductos();
        controlador = new ControladorCasilla();
        historialCliente = cliente.getHistorial();
        concursos = cComercial.getConcursos();

    }

    public Lista<Producto> getProductosGeneral() {
        return productosGeneral;
    }

    public Cliente getCliente() {
        return cliente;
    }

    /**
     * 
     * @param venta 
     */
    public void totalProductosPorVenta(Venta venta) {
        int total = retornarCantidadProductos(venta.getCompra().getProductos());
        venta.getCompra().setArticulos(total);
        SingletonUsuario.getINSTANCIA().escribirUsuarios();
        SingletonCC.getINSTANCIA().escribirObjeto();
        SingletonCasillas.getINSTANCIA().escribirObjeto();
    }

    /**
     * 
     * @param venta
     * @return 
     */
    public boolean comprarProducto(Venta venta) {
        Lista<Producto> comprados = cliente.getCarrito();

        for (int i = 0; i < comprados.Size(); i++) {
            Producto prod = buscarProductoGeneral(comprados.obtener(i).getIdentificador());
            if (prod != null) {
                int disminuir = prod.getCantBodega() - comprados.obtener(i).getCantBodega();
                prod.setCantBodega(disminuir);
                Local local = retornarLocal(prod);
                Producto producto = buscarProductoLocal(local, comprados.obtener(i).getIdentificador());
                producto.setCantBodega(disminuir);
                agregarHistorial(venta, local);
                SingletonUsuario.getINSTANCIA().escribirUsuarios();
                SingletonCC.getINSTANCIA().escribirObjeto();
                SingletonCasillas.getINSTANCIA().escribirObjeto();
                cliente.limpiarCarrito();
            }

        }

        boolean aux = validarParticipacion(venta);
        if (aux) {
            cliente.limpiarCarrito();
            agregarHistorialCliente(venta);
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonCasillas.getINSTANCIA().escribirObjeto();
            return true;
        } else {
            cliente.limpiarCarrito();
            agregarHistorialCliente(venta);
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonCasillas.getINSTANCIA().escribirObjeto();
            return false;
        }

    }

    /**
     * 
     * @param identificador
     * @param cantidad
     * @param fechaEntrega
     * @return
     * @throws StockExcedidoException 
     */
    public boolean generarSeparado(String identificador, int cantidad, Date fechaEntrega) throws StockExcedidoException {
        Producto producto = buscarProductoGeneral(identificador);
        boolean aux1 = validarStock(producto, cantidad);
        if (producto == null) {
            return false;

        } else if (aux1) {
            throw new StockExcedidoException();
        } else {
            Local local1 = retornarLocal(producto);
            Lista<Separado> separados = local1.getSeparados();
            Producto aux = Producto.clone(producto);
            aux.setCantBodega(cantidad);
            Separado separado = new Separado(aux, cliente, fechaEntrega);
            int disminuir = producto.getCantBodega() - cantidad;
            producto.setCantBodega(disminuir);
            Local local = retornarLocal(producto);
            Producto pro = buscarProductoLocal(local, identificador);
            
            pro.setCantBodega(disminuir);
            
           
            separados.add(separado);
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonCasillas.getINSTANCIA().escribirObjeto();
            return true;
        }

    }
  

    /**
     * 
     * @param venta
     * @return 
     */
    public boolean validarParticipacion(Venta venta) {

        for (int i = 0; i < concursos.Size(); i++) {
            if (concursos.obtener(i).getValorMinimo() <= venta.getTotalCompra()) {
                Concurso concurso = concursos.obtener(i);
                Lista<Cliente> participantes = concurso.getParticipantes();
                participantes.add(cliente);
                SingletonUsuario.getINSTANCIA().escribirUsuarios();
                SingletonCC.getINSTANCIA().escribirObjeto();
                SingletonCasillas.getINSTANCIA().escribirObjeto();
                if (i == concursos.Size() - 1) {
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * 
     * @param venta
     * @param local 
     */
    public void agregarHistorial(Venta venta, Local local) {
        Lista<Venta> ventasLocal = local.getHistorial();
        ventasLocal.add(venta);
        SingletonUsuario.getINSTANCIA().escribirUsuarios();
        SingletonCC.getINSTANCIA().escribirObjeto();
        SingletonCasillas.getINSTANCIA().escribirObjeto();

    }

    /**
     * 
     * @param venta 
     */
    public void agregarHistorialCliente(Venta venta) {
        historialCliente.add(venta);
        cliente.setTotalInvertido(venta.getTotalCompra());
        SingletonUsuario.getINSTANCIA().escribirUsuarios();
        SingletonCC.getINSTANCIA().escribirObjeto();
        SingletonCasillas.getINSTANCIA().escribirObjeto();
    }

    /**
     * 
     * @param local
     * @param identificador
     * @return 
     */
    public Producto buscarProductoLocal(Local local, String identificador) {
        Lista<Producto> productosLocal = local.getProductos();
        for (int i = 0; i < productosLocal.Size(); i++) {
            if (productosLocal.obtener(i) != null && productosLocal.obtener(i).getIdentificador().equals(identificador)) {
                return productosLocal.obtener(i);
            }
        }
        return null;
    }

    /**
     * 
     * @return 
     */
    public Lista<Venta> getHistorialCliente() {
        return historialCliente;
    }

    /**
     * 
     * @param identificador
     * @param cantidad
     * @return
     * @throws StockExcedidoException 
     */
    public boolean agregarCarrito(String identificador, int cantidad) throws StockExcedidoException {

        Producto producto = buscarProductoGeneral(identificador);
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

            SingletonUsuario.getINSTANCIA().escribirUsuarios();

            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonCasillas.getINSTANCIA().escribirObjeto();
            return true;

        }

    }

    /**
     * 
     * @param identificador
     * @return 
     */
    public boolean eliminarProductoCarrito(String identificador) {

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
     * @return 
     */
    public Lista<Producto> getCarrito() {
        return carrito;
    }

    /**
     * 
     * @return 
     */
    public Lista<Concurso> getConcursos() {
        return concursos;
    }

    /**
     * 
     * @param identificador
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
     * 
     * @param producto
     * @return 
     */
    public Local retornarLocal(Producto producto) {
        Casilla[][] locales = SingletonCasillas.getINSTANCIA().getLista();
        for (int i = 0; i < locales.length; i++) {
            for (int j = 0; j < locales[i].length; j++) {
                Casilla casilla = controlador.obtenerCasilla(i, j);
                Local local = casilla.getLocal();
                if (local.getProductos() != null) {
                    Lista<Producto> productos = local.getProductos();
                    if (productos.Size() != 0) {
                        for (int k = 0; k < productos.Size(); k++) {
                            if (productos.obtener(k).getIdentificador().equals(producto.getIdentificador())) {
                                return local;
                            }
                        }
                    }
                }

            }
        }
        return null;

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
     * @param identificador
     * @return 
     */
    public Producto buscarProductoCarrito(String identificador){
        for (int i = 0; i < carrito.Size(); i++) {
            if(carrito.obtener(i).getIdentificador().equalsIgnoreCase(identificador)){
                return carrito.obtener(i);
            }
        }
        return null;
   
    }
}
