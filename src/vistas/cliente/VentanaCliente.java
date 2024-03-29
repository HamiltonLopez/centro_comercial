/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.cliente;

import Singleton.SingletonCC;
import controladores.ControladorCliente;
import controladores.ControladorConcurso;
import excepciones.StockExcedidoException;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import modelos.CentroComercial;
import modelos.Cliente;
import modelos.Compra;
import modelos.Concurso;
import modelos.Producto;
import modelos.Venta;
import util.Lista;
import vistas.InicioSesion;

/**
 *
 * @author Asus
 */
public class VentanaCliente extends javax.swing.JFrame {

    Cliente cliente;

    ControladorCliente controlador;

    ControladorConcurso controladorC;

    public VentanaCliente(Cliente cliente) {
        initComponents();
        setLocationRelativeTo(this);
        controladorC = new ControladorConcurso();

        this.cliente = cliente;
        /////////////////////////////////////////////
        controlador = new ControladorCliente(cliente);
        /////////////////////////////////////////////

        txtFecha.setText(fechaActual());

        lblNombre.setText(cliente.getNombre() + " " + cliente.getApellido());
    }

    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);

    }

    public Cliente getCliente() {
        return cliente;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        grupo = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        btnSeparados = new javax.swing.JButton();
        btnCarrito = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        btnConcursos1 = new javax.swing.JButton();
        btnSeparados1 = new javax.swing.JButton();
        content = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("FECHA DE HOY :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, -1, -1));

        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 80, -1));

        btnSeparados.setBackground(new java.awt.Color(0, 153, 153));
        btnSeparados.setForeground(new java.awt.Color(255, 255, 255));
        btnSeparados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/caja (2).png"))); // NOI18N
        btnSeparados.setText("SEPARADOS");
        btnSeparados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSeparados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeparadosActionPerformed(evt);
            }
        });
        jPanel2.add(btnSeparados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 170, 37));

        btnCarrito.setBackground(new java.awt.Color(0, 153, 153));
        btnCarrito.setForeground(new java.awt.Color(255, 255, 255));
        btnCarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas (1).png"))); // NOI18N
        btnCarrito.setText("CARRITO");
        btnCarrito.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarritoActionPerformed(evt);
            }
        });
        jPanel2.add(btnCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 170, 40));

        btnVenta.setBackground(new java.awt.Color(0, 153, 153));
        btnVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/economia-local (1).png"))); // NOI18N
        btnVenta.setText("IR A TIENDAS");
        btnVenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });
        jPanel2.add(btnVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 17, 170, 40));

        btnHistorial.setBackground(new java.awt.Color(0, 153, 153));
        btnHistorial.setForeground(new java.awt.Color(255, 255, 255));
        btnHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tiempo (1).png"))); // NOI18N
        btnHistorial.setText("HISTORIAL");
        btnHistorial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        jPanel2.add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 127, 170, 40));

        btnConcursos1.setBackground(new java.awt.Color(0, 153, 153));
        btnConcursos1.setForeground(new java.awt.Color(255, 255, 255));
        btnConcursos1.setText("CONCURSOS");
        btnConcursos1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConcursos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcursos1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnConcursos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 170, 37));

        btnSeparados1.setBackground(new java.awt.Color(0, 153, 153));
        btnSeparados1.setForeground(new java.awt.Color(255, 255, 255));
        btnSeparados1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/coche (2).png"))); // NOI18N
        btnSeparados1.setText("REGISTRAR VEHICULO");
        btnSeparados1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSeparados1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeparados1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnSeparados1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 170, 37));

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 895, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/administrador/punto verde.jpg"))); // NOI18N
        jLabel2.setText("Conectado");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 90, -1));

        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setText("Name");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/perfil (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 135));

        jLabel4.setBackground(new java.awt.Color(0, 204, 204));
        jLabel4.setForeground(new java.awt.Color(153, 0, 153));
        jLabel4.setText("CLIENTE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        btnRegresar.setBackground(new java.awt.Color(204, 0, 51));
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("CERRAR SESIÓN");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        InicioSesion ventana = new InicioSesion();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnSeparadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeparadosActionPerformed
        if (cliente.getMulta() != null) {
            JOptionPane.showMessageDialog(null, "Por el momento no puedes ingresar a esta sección\na causa de una multa activa.\nComunicate con atención al cliente");
        } else {
            GenerarSeparado gestion = new GenerarSeparado(controlador);
            showPanel(gestion);
        }

    }//GEN-LAST:event_btnSeparadosActionPerformed

    private void btnCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarritoActionPerformed
        CarritoDeCompra carrito = new CarritoDeCompra(controlador);
        showPanel(carrito);
    }//GEN-LAST:event_btnCarritoActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        if (cliente.getMulta() != null) {
            JOptionPane.showMessageDialog(null, "Por el momento no puedes ingresar a esta sección\na causa de una multa activa.\nComunicate con atención al cliente");
        } else {
            CompraVirtual compra = new CompraVirtual(controlador);
            showPanel(compra);
        }

    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        HistorialCliente histo = new HistorialCliente(controlador);
        showPanel(histo);
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnConcursos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcursos1ActionPerformed
       ConcursosVigentes con = new ConcursosVigentes(controladorC, controlador);
        showPanel(con);
    }//GEN-LAST:event_btnConcursos1ActionPerformed

    private void btnSeparados1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeparados1ActionPerformed
      new RegistrarVehiculoCliente().setVisible(true);
    }//GEN-LAST:event_btnSeparados1ActionPerformed

    public void showPanel(JPanel panel) {
        panel.setSize(895, 593);
        panel.setLocation(0, 0);
        content.removeAll();
        content.add(panel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();

    }

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarrito;
    private javax.swing.JButton btnConcursos1;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSeparados;
    private javax.swing.JButton btnSeparados1;
    private javax.swing.JButton btnVenta;
    private javax.swing.JPanel content;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
