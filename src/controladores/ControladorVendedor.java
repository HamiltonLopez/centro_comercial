/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.SingletonCC;
import Singleton.SingletonCasillas;
import Singleton.SingletonUsuario;
import excepciones.StockExcedidoException;
import excepciones.UsuarioNoEncontradoException;
import modelos.CentroComercial;
import modelos.Cliente;
import modelos.Concurso;
import modelos.Local;
import modelos.Producto;
import modelos.Usuario;
import modelos.Venta;
import util.Lista;

/**
 *
 * @author Asus
 */
public class ControladorVendedor {

    Local local;

    Lista<Producto> productosGeneral;
    Lista<Producto> productosLocal;
    ControladorUsuario controlador;
    CentroComercial cComercial;
    Lista<Venta> historial;
    Lista<Usuario> clientes;
    Lista<Concurso> concursos;

    public ControladorVendedor(Local local) {
        this.local = local;
        productosLocal = local.getProductos();
        controlador = new ControladorUsuario();
        cComercial = SingletonCC.getINSTANCIA().getInstancia();
        clientes = controlador.getUsuarios();
        productosGeneral = cComercial.getProductos();
        concursos = cComercial.getConcursos();
        historial = local.getHistorial();
    }

    public Cliente buscarCliente(String documento) throws UsuarioNoEncontradoException {
        for (int i = 0; i < clientes.Size(); i++) {
            if (clientes.obtener(i).getDocumento().equals(documento) && clientes.obtener(i) instanceof Cliente) {
                Cliente cliente = (Cliente) clientes.obtener(i);
                return cliente;

            }
        }
        throw new UsuarioNoEncontradoException();
    }
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
            SingletonUsuario.getINSTANCIA().escribirUsuarios();

            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonCasillas.getINSTANCIA().escribirObjeto();
            return true;

        }

    }

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
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            SingletonCC.getINSTANCIA().escribirObjeto();
            return true;
        } else {
            cliente.limpiarCarrito();
            agregarHistorialCliente(venta);
            historial.add(venta);
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            SingletonCC.getINSTANCIA().escribirObjeto();
            return false;
        }

    }

    public int retornarCantidadProductos(Lista<Producto> productos) {
        int total = 0;
        for (int i = 0; i < productos.Size(); i++) {
            total += productos.obtener(i).getCantBodega();
        }
        return total;
    }

    public void agregarHistorialCliente(Venta venta) {
        Cliente cliente = venta.getCliente();
        cliente.getHistorial().add(venta);
        cliente.setTotalInvertido(venta.getTotalCompra());
        SingletonUsuario.getINSTANCIA().escribirUsuarios();
        SingletonCC.getINSTANCIA().escribirObjeto();
        SingletonCasillas.getINSTANCIA().escribirObjeto();
    }

    public boolean validarParticipacion(Venta venta) {
        Cliente cliente = venta.getCliente();

        for (int i = 0; i < concursos.Size(); i++) {
            if (concursos.obtener(i).getValorMinimo() >= venta.getTotalCompra()) {
                Concurso concurso = concursos.obtener(i);
                Lista<Cliente> participantes = concurso.getParticipantes();
                participantes.add(cliente);
                return true;
            }
        }
        return false;
    }

    public Local getLocal() {
        return local;
    }

    public boolean validarStock(Producto producto, int cantidad) {
        if (cantidad > producto.getCantBodega()) {
            return true;
        }
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

    public Producto buscarProductoGeneral(String identificador) {
        for (int i = 0; i < productosGeneral.Size(); i++) {
            if (productosGeneral.obtener(i) != null && productosGeneral.obtener(i).getIdentificador().equals(identificador)) {
                return productosGeneral.obtener(i);
            }
        }
        return null;
    }

}
