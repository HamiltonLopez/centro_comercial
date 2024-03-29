/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas.cliente;

import Singleton.SingletonCC;
import controladores.ControladorCliente;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.CentroComercial;
import modelos.Producto;
import modelos.Separado;
import util.Lista;

/**
 *
 * @author Asus
 */
public class GenerarSeparado extends javax.swing.JPanel {

    CentroComercial centro;
    private DefaultTableModel modelo;
    ControladorCliente controlador;

    public GenerarSeparado(ControladorCliente controlador) {
        initComponents();
        this.controlador = controlador;
        modelo = new DefaultTableModel();
        this.tablaProductos.setModel(modelo);
        modelo.addColumn("Cantidad");
        modelo.addColumn("Nombre");
        modelo.addColumn("Identificador");
        modelo.addColumn("Precio");
        centro = SingletonCC.getINSTANCIA().getInstancia();
        limpiarFiltro();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        comboFiltro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        spinCantidad = new javax.swing.JSpinner();
        chooser = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        btnSeparar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(895, 593));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaProductos);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 22, 646, 537));

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Mercado", "Electrodomesticos", "Hogar y muebles", "Deportes", "Licores" }));
        comboFiltro.setBorder(null);
        comboFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiltroActionPerformed(evt);
            }
        });
        jPanel1.add(comboFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 85, 211, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("FILTRAR POR TIPO DE ARTICULO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(706, 51, -1, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Seleccione la cantidad");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 126, -1, -1));

        spinCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        jPanel1.add(spinCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 123, 76, -1));
        jPanel1.add(chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, -1, -1));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Fecha para recoger");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, -1, -1));

        btnSeparar.setBackground(new java.awt.Color(0, 153, 153));
        btnSeparar.setForeground(new java.awt.Color(255, 255, 255));
        btnSeparar.setText("CONFIRMAR SEPARADO");
        btnSeparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSepararActionPerformed(evt);
            }
        });
        jPanel1.add(btnSeparar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, 213, 54));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        //        int seleccionar = tablaProductos.rowAtPoint(evt.getPoint());
        //        JOptionPane.showMessageDialog(null, tablaProductos.getValueAt(seleccionar, 1));
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void comboFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiltroActionPerformed
        limpiarFiltro();
    }//GEN-LAST:event_comboFiltroActionPerformed

    private void btnSepararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSepararActionPerformed
        if (tablaProductos.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione el producto que desea comprar");
        } else if (chooser.getDate()==null) {
            JOptionPane.showMessageDialog(null, "Ingrese la fecha en la recogerá el producto");
        } else {

            
            Date fecha = chooser.getDate();
            int fila = tablaProductos.getSelectedRow();
            String identificador = tablaProductos.getValueAt(fila, 2).toString();
            int cantidad = Integer.parseInt(spinCantidad.getValue().toString());
            Date fechaEntrega = new Date(fecha.getYear(), fecha.getMonth(), fecha.getDay());

            boolean aux = controlador.generarSeparado(identificador, cantidad, fechaEntrega);
            if (aux) {
                JOptionPane.showMessageDialog(null, "Su separado se ha realizado con éxito");
                limpiarFiltro();

            } else {
                JOptionPane.showMessageDialog(null, "No se agregó al carrito");
            }

        }
    }//GEN-LAST:event_btnSepararActionPerformed

    public void removerTablaProductos() {

        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
        }

    }

    public void llenarFiltro() {
        if (comboFiltro.getSelectedIndex() == 0) {
            removerTablaProductos();

            Lista<Producto> productos = centro.getProductos();
            for (int i = 0; i < productos.Size(); i++) {
                Producto producto = productos.obtener(i);

                String[] info = new String[4];
                info[0] = String.valueOf(producto.getCantBodega());
                info[1] = producto.getNombreProducto();
                info[2] = producto.getIdentificador();
                info[3] = String.valueOf(producto.getPrecio());

                modelo.addRow(info);

            }
        } else {
            removerTablaProductos();
            String filtro = comboFiltro.getSelectedItem().toString();
            Lista<Producto> productos = centro.getProductos();
            for (int i = 0; i < productos.Size(); i++) {
                Producto producto = productos.obtener(i);
                if (producto != null && producto.getCategoria().equals(filtro)) {

                    String[] info = new String[4];
                    info[0] = String.valueOf(producto.getCantBodega());
                    info[1] = producto.getNombreProducto();
                    info[2] = producto.getIdentificador();
                    info[3] = String.valueOf(producto.getPrecio());

                    modelo.addRow(info);

                }
            }
        }

    }

    public void limpiarFiltro() {
        removerTablaProductos();
        llenarFiltro();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeparar;
    private com.toedter.calendar.JDateChooser chooser;
    private javax.swing.JComboBox<String> comboFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner spinCantidad;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
