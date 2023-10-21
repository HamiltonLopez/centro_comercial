/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.SingletonCC;
import Singleton.SingletonCasillas;
import Singleton.SingletonUsuario;
import excepciones.UsuarioNoEncontradoException;
import modelos.Cliente;
import modelos.Compra;
import modelos.Local;
import modelos.Multa;
import modelos.Producto;
import modelos.Separado;
import modelos.Venta;
import util.Lista;

/**
 *
 * @author Asus
 */
public class ControladorSeparados {

    Lista<Venta> historial;
    Lista<Separado> separados;
    ControladorAdminLocal controlador;
    Local local;

    public ControladorSeparados(Local local) {
        this.local = local;
        separados = local.getSeparados();
        controlador = new ControladorAdminLocal(local);
        historial = local.getHistorial();
    }

    public Lista<Separado> getSeparados() {
        return separados;
    }

    public boolean FinalizarSeparado(Separado separado) {
        Lista<Producto> productos = new Lista<>();
        Cliente cliente = separado.getCliente();
        Producto producto = separado.getProducto();
        int total = producto.getCantBodega() * producto.getPrecio();
        Compra compra = new Compra(productos);
        compra.setArticulos(producto.getCantBodega());
        Venta venta = new Venta(cliente, separado.getFechaEntrega(), total, compra);
        agregarHistorialCliente(venta);
        historial.add(venta);
        eliminarSeparado(separado);
        SingletonUsuario.getINSTANCIA().escribirUsuarios();
        SingletonCC.getINSTANCIA().escribirObjeto();
        SingletonCasillas.getINSTANCIA().escribirObjeto();
        return true;
    }

    private void agregarHistorialCliente(Venta venta) {
        Cliente cliente = venta.getCliente();
        cliente.getHistorial().add(venta);
        cliente.setTotalInvertido(venta.getTotalCompra());
        SingletonUsuario.getINSTANCIA().escribirUsuarios();
        SingletonCC.getINSTANCIA().escribirObjeto();
        SingletonCasillas.getINSTANCIA().escribirObjeto();
    }

    private void eliminarSeparado(Separado separado) {
        for (int i = 0; i < separados.Size(); i++) {
            if (separados.obtener(i) != null
                    && separados.obtener(i).getCliente().getDocumento().equalsIgnoreCase(separado.getCliente().getDocumento())) {
                separados.eliminar(i);
                SingletonUsuario.getINSTANCIA().escribirUsuarios();
                SingletonCC.getINSTANCIA().escribirObjeto();
                SingletonCasillas.getINSTANCIA().escribirObjeto();
            }
        }
    }

    public Separado buscarSeparado(String documento) {
        for (int i = 0; i < separados.Size(); i++) {
            if (separados.obtener(i) != null
                    && separados.obtener(i).getCliente().getDocumento().equalsIgnoreCase(documento)) {
                return separados.obtener(i);

            }
        }
        return null;
    }

    public Cliente buscarCliente(String documento) throws UsuarioNoEncontradoException {
        for (int i = 0; i < separados.Size(); i++) {
            if (separados.obtener(i) != null
                    && separados.obtener(i).getCliente().getDocumento().equalsIgnoreCase(documento)) {
                return separados.obtener(i).getCliente();

            }
        }
        throw new UsuarioNoEncontradoException();
    }

    public ControladorAdminLocal getControlador() {
        return controlador;
    }
    

    public boolean asignarMulta(Multa multa, Separado separado) {
        Cliente cliente = multa.getCliente();
        cliente.setMulta(multa);
        eliminarSeparado(separado);
        SingletonUsuario.getINSTANCIA().escribirUsuarios();
        SingletonCC.getINSTANCIA().escribirObjeto();
        SingletonCasillas.getINSTANCIA().escribirObjeto();
        return true;
    }

    public boolean eliminarMulta(String documento) {
        Cliente cliente = controlador.buscarCliente(documento);
        cliente.setMulta(null);
        SingletonUsuario.getINSTANCIA().escribirUsuarios();
        SingletonCC.getINSTANCIA().escribirObjeto();
        SingletonCasillas.getINSTANCIA().escribirObjeto();
        return true;
    }

}
