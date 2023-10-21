/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.SingletonCC;
import Singleton.SingletonCasillas;
import Singleton.SingletonUsuario;
import excepciones.ProductoExistenteException;
import excepciones.StockExcedidoException;
import modelos.CentroComercial;
import modelos.Concurso;
import modelos.Empleado;
import modelos.Local;
import modelos.Producto;
import modelos.Separado;
import modelos.Usuario;
import modelos.Venta;
import util.Lista;

/**
 *
 * @author Asus
 */
public class ControladorInventario {

    Local local;
    Lista<Producto> productosGeneral;
    Lista<Producto> productosLocal;
    CentroComercial cComercial;

    public ControladorInventario(Local local) {
        productosLocal = local.getProductos();
        cComercial = SingletonCC.getINSTANCIA().getInstancia();
        productosGeneral = cComercial.getProductos();
    }

    public Lista<Producto> getProductosLocal() {
        return productosLocal;
    }

    /* public boolean agregarDescuento(String producto,int porcentaje){
        
    }*/
    public boolean eliminarProducto(String identificador, int cantidad) throws StockExcedidoException {
        Producto producto = buscarProductoLocal(identificador);
        boolean aux = validarStock(producto, cantidad);
        if (aux) {
            throw new StockExcedidoException();
        } else {
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
                    SingletonUsuario.getINSTANCIA().escribirUsuarios();
                    SingletonCC.getINSTANCIA().escribirObjeto();
                    SingletonCasillas.getINSTANCIA().escribirObjeto();
                    return true;

                }

            }
        }

        SingletonCC.getINSTANCIA().escribirObjeto();
        SingletonUsuario.getINSTANCIA().escribirUsuarios();
        SingletonCC.getINSTANCIA().escribirObjeto();
        SingletonCasillas.getINSTANCIA().escribirObjeto();
        return false;

    }

    public boolean editarProducto(Producto producto) {
        if (producto.getDescuento() != 0) {
            int precio = precioConDescuento(producto);
            producto.setPrecio(precio);
        }
        Producto aux = buscarProductoLocal(producto.getIdentificador());
        Producto auxG = buscarProductoGeneral(producto.getIdentificador());
        if (aux != null) {
            aux.setNombreProducto(producto.getNombreProducto());
            aux.setCategoria(producto.getCategoria());
            aux.setMarca(producto.getMarca());
            aux.setPesoBruto(producto.getPesoBruto());
            aux.setCantBodega(producto.getCantBodega());
            aux.setPrecio(producto.getPrecio());
            aux.setDescuento(producto.getDescuento());

            auxG.setNombreProducto(producto.getNombreProducto());
            auxG.setCategoria(producto.getCategoria());
            auxG.setMarca(producto.getMarca());
            auxG.setPesoBruto(producto.getPesoBruto());
            auxG.setCantBodega(producto.getCantBodega());
            auxG.setPrecio(producto.getPrecio());
            auxG.setDescuento(producto.getDescuento());

            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            SingletonCasillas.getINSTANCIA().escribirObjeto();
            return true;
        }
        return false;

    }

    public boolean añadirProducto(Producto producto) throws ProductoExistenteException {
        Producto aux = buscarProductoLocal(producto.getIdentificador());
        Producto au = buscarProductoGeneral(producto.getIdentificador());
        if (aux != null || au != null) {
            throw new ProductoExistenteException();
        }
        if (producto.getDescuento() != 0) {
            int total = precioConDescuento(producto);
            producto.setPrecio(total);
        }
        productosLocal.add(producto);
        productosGeneral.add(producto);
        SingletonCC.getINSTANCIA().escribirObjeto();
        SingletonUsuario.getINSTANCIA().escribirUsuarios();
        SingletonCC.getINSTANCIA().escribirObjeto();
        SingletonCasillas.getINSTANCIA().escribirObjeto();
        return true;
    }

    private int precioConDescuento(Producto producto) {
        if (producto.getDescuento() == 0) {
            return producto.getPrecio();
        } else {
            int descu = producto.getPrecio() * producto.getDescuento() / 100;
            return descu;
        }
    }

    public boolean eliminarDescuento(String documento) {
        Producto pro = buscarProductoGeneral(documento);
        Producto producto = buscarProductoLocal(documento);
        int precio = pro.getPrecio() * 100 / pro.getDescuento();
        pro.setPrecio(precio);
        producto.setPrecio(precio);
        producto.setDescuento(0);
        pro.setDescuento(0);
        SingletonCC.getINSTANCIA().escribirObjeto();
        SingletonUsuario.getINSTANCIA().escribirUsuarios();
        SingletonCasillas.getINSTANCIA().escribirObjeto();
        return true;
    }

    public Producto buscarProductoGeneral(String identificador) {
        for (int i = 0; i < productosGeneral.Size(); i++) {
            if (productosGeneral.obtener(i) != null && productosGeneral.obtener(i).getIdentificador().equals(identificador)) {
                return productosGeneral.obtener(i);
            }
        }
        return null;
    }

    private boolean validarStock(Producto producto, int cantidad) {
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

}
