/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.SingletonCC;
import Singleton.SingletonCasillas;
import Singleton.SingletonUsuario;
import excepciones.ProductoExistenteException;
import javax.swing.JOptionPane;
import modelos.CentroComercial;
import modelos.Local;
import modelos.Producto;
import util.Lista;

/**
 *
 * @author Asus
 */
public class ControladorEncargadoI {

    Local local;
    Lista<Producto> productosGeneral;
    Lista<Producto> productosLocal;
    CentroComercial cComercial;

    public ControladorEncargadoI(Local local) {
        this.local = local;
        if (local != null) {
            productosLocal = local.getProductos();
        } else {
            JOptionPane.showMessageDialog(null, "Local vacio");
        }

        cComercial = SingletonCC.getINSTANCIA().getInstancia();
        productosGeneral = cComercial.getProductos();
    }

    public boolean añadirProducto(Producto producto) throws ProductoExistenteException {
        Producto aux = buscarProductoLocal(producto.getIdentificador());
        Producto au = buscarProductoGeneral(producto.getIdentificador());
        if (aux != null || au != null) {
            throw new ProductoExistenteException();
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

    public Producto buscarProductoGeneral(String identificador) {
        for (int i = 0; i < productosGeneral.Size(); i++) {
            if (productosGeneral.obtener(i) != null && productosGeneral.obtener(i).getIdentificador().equals(identificador)) {
                return productosGeneral.obtener(i);
            }
        }
        return null;
    }

    public boolean editarProducto(Producto producto) {
        Producto aux = buscarProductoLocal(producto.getIdentificador());
        Producto auxG = buscarProductoGeneral(producto.getIdentificador());
        if (aux != null) {
            aux.setNombreProducto(producto.getNombreProducto());
            aux.setCategoria(producto.getCategoria());
            aux.setMarca(producto.getMarca());
            aux.setPesoBruto(producto.getPesoBruto());
            aux.setCantBodega(producto.getCantBodega());
            aux.setPrecio(producto.getPrecio());

            auxG.setNombreProducto(producto.getNombreProducto());
            auxG.setCategoria(producto.getCategoria());
            auxG.setMarca(producto.getMarca());
            auxG.setPesoBruto(producto.getPesoBruto());
            auxG.setCantBodega(producto.getCantBodega());
            auxG.setPrecio(producto.getPrecio());

            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonUsuario.getINSTANCIA().escribirUsuarios();
            SingletonCC.getINSTANCIA().escribirObjeto();
            SingletonCasillas.getINSTANCIA().escribirObjeto();
            return true;
        }
        return false;

    }
}
