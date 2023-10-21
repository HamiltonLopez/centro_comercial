/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.adminLocal;

import ValidarCampos.ValidarCampos;
import controladores.ControladorAdminLocal;
import controladores.ControladorInventario;
import controladores.ControladorSeparados;
import controladores.ControladorUsuario;
import excepciones.CorreoExistenteException;
import excepciones.ProductoExistenteException;
import excepciones.StockExcedidoException;
import excepciones.TelefonoInvalidoException;
import excepciones.UsuarioExistenteException;
import excepciones.UsuarioNoEncontradoException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import modelos.Casilla;
import modelos.Cliente;
import modelos.Compra;
import modelos.Empleado;
import modelos.Local;
import modelos.Producto;
import modelos.Usuario;
import modelos.Venta;
import util.Lista;
import vistas.InicioSesion;
import vistas.administrador.ConsutarCliente;
import vistas.encargadoInventario.GestionarProductosEncargado;
import vistas.vendedor.RegistrarClienteV;

/**
 *
 * @author Asus
 */
public class GestionLocal extends javax.swing.JFrame {

    ControladorAdminLocal controlador;

    Empleado admin;
    Casilla casilla;

    Local local;

    public GestionLocal(Empleado admin, Local local) {
        initComponents();
        setLocationRelativeTo(this);

        this.admin = admin;
        this.local = local;

        controlador = new ControladorAdminLocal(local);
        casilla = controlador.retornarCasilla(local);
        if (casilla.getEstado().equalsIgnoreCase("Desocupado")) {
            btnDesocupado.setVisible(false);
        } else {
            btnDesocupado.setVisible(true);
        }
        lblNombre.setText(admin.getNombre() + " " + admin.getApellido());
        lblNombreLocal.setText(local.getNombre());

    }

    public void showPanel(JPanel panel) {
        panel.setSize(1073, 509);
        panel.setLocation(0, 0);
        content.removeAll();
        content.add(panel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();

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
        btnEmpleados = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnRegistrar1 = new javax.swing.JButton();
        btnRegistrar2 = new javax.swing.JButton();
        btnSolicitudes = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblNombreLocal = new javax.swing.JLabel();
        btnDesocupado = new javax.swing.JButton();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        btnEmpleados.setBackground(new java.awt.Color(0, 153, 153));
        btnEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/empleado (1).png"))); // NOI18N
        btnEmpleados.setText("EMPLEADOS");
        btnEmpleados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });

        btnVenta.setBackground(new java.awt.Color(0, 153, 153));
        btnVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas (1).png"))); // NOI18N
        btnVenta.setText("VENTA");
        btnVenta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });

        btnProductos.setBackground(new java.awt.Color(0, 153, 153));
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inventario (1).png"))); // NOI18N
        btnProductos.setText("INVENTARIO");
        btnProductos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

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

        btnRegistrar.setBackground(new java.awt.Color(0, 153, 153));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo (1).png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR CLIENTE");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnRegistrar1.setBackground(new java.awt.Color(0, 153, 153));
        btnRegistrar1.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/caja (21).png"))); // NOI18N
        btnRegistrar1.setText("SEPARADOS");
        btnRegistrar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar1ActionPerformed(evt);
            }
        });

        btnRegistrar2.setBackground(new java.awt.Color(0, 153, 153));
        btnRegistrar2.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/multa (2).png"))); // NOI18N
        btnRegistrar2.setText("LIBERAR MULTA");
        btnRegistrar2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar2ActionPerformed(evt);
            }
        });

        btnSolicitudes.setBackground(new java.awt.Color(0, 153, 153));
        btnSolicitudes.setForeground(new java.awt.Color(255, 255, 255));
        btnSolicitudes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/multa (2).png"))); // NOI18N
        btnSolicitudes.setText("SOLICITUDES");
        btnSolicitudes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitudesActionPerformed(evt);
            }
        });

        btnConsultar.setBackground(new java.awt.Color(0, 153, 153));
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/clasificacion (1).png"))); // NOI18N
        btnConsultar.setText("CONSULTAR CLIENTE");
        btnConsultar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
            .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRegistrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRegistrar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSolicitudes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnConsultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSolicitudes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 213, 170, 420));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setText("Name");
        jPanel2.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/administrador/punto verde.jpg"))); // NOI18N
        jLabel2.setText("Conectado");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 90, -1));

        btnRegresar.setBackground(new java.awt.Color(204, 0, 51));
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("CERRAR SESIÓN");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/perfil (1).png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 90, 90));

        jLabel4.setBackground(new java.awt.Color(0, 204, 204));
        jLabel4.setForeground(new java.awt.Color(153, 0, 153));
        jLabel4.setText("ADMIN. LOCAL");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 210));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        lblNombreLocal.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        lblNombreLocal.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreLocal.setText("jLabel5");

        btnDesocupado.setBackground(new java.awt.Color(255, 255, 255));
        btnDesocupado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDesocupado.setForeground(new java.awt.Color(0, 0, 0));
        btnDesocupado.setText("MARCAR COMO DESOCUPADO");
        btnDesocupado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesocupadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(lblNombreLocal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                .addComponent(btnDesocupado)
                .addGap(118, 118, 118))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblNombreLocal))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnDesocupado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 0, 1070, 120));

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1073, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        getContentPane().add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 119, 1073, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        InicioSesion ventana = new InicioSesion();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        if (casilla.getEstado().equalsIgnoreCase("Desocupado")) {
            JOptionPane.showMessageDialog(null, "El negocio se encuentra desocupado.");
        } else {
            GestionarEmpleadosLocal gestion = new GestionarEmpleadosLocal(controlador);
            showPanel(gestion);
        }

    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed

        if (casilla.getEstado().equalsIgnoreCase("Desocupado")) {
            JOptionPane.showMessageDialog(null, "El negocio se encuentra desocupado.");
        } else {
            VentaLocal venta = new VentaLocal(controlador);
            showPanel(venta);
        }

    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        if (casilla.getEstado().equalsIgnoreCase("Desocupado")) {
            JOptionPane.showMessageDialog(null, "El negocio se encuentra desocupado.");
        } else {
            GestionarProductos gestion = new GestionarProductos(local);
            showPanel(gestion);
        }
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        if (casilla.getEstado().equalsIgnoreCase("Desocupado")) {
            JOptionPane.showMessageDialog(null, "El negocio se encuentra desocupado.");
        } else {
            HistorialLocal historial = new HistorialLocal(controlador);
            showPanel(historial);
        }
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (casilla.getEstado().equalsIgnoreCase("Desocupado")) {
            JOptionPane.showMessageDialog(null, "El negocio se encuentra desocupado.");
        } else {
            RegistrarClienteV registrar = new RegistrarClienteV();
            showPanel(registrar);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar1ActionPerformed
        if (casilla.getEstado().equalsIgnoreCase("Desocupado")) {
            JOptionPane.showMessageDialog(null, "El negocio se encuentra desocupado.");
        } else {
            SeparadosNuevo sepa = new SeparadosNuevo(local);
            showPanel(sepa);

        }
    }//GEN-LAST:event_btnRegistrar1ActionPerformed

    private void btnRegistrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar2ActionPerformed
        if (casilla.getEstado().equalsIgnoreCase("Desocupado")) {
            JOptionPane.showMessageDialog(null, "El negocio se encuentra desocupado.");
        } else {
            new LiberarMulta(local).setVisible(true);
        }

    }//GEN-LAST:event_btnRegistrar2ActionPerformed

    private void btnDesocupadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesocupadoActionPerformed
        int resultado = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere marcar el negocio como desocupado?"
                + "\nuna vez realizado no podrá rehacer su acción", "ALERTA", JOptionPane.YES_NO_OPTION);
        if (resultado == JOptionPane.YES_OPTION) {
            controlador.marcarDesocupado();
            InicioSesion ventana = new InicioSesion();
            ventana.setVisible(true);
            this.dispose();

        } else {

        }
    }//GEN-LAST:event_btnDesocupadoActionPerformed

    private void btnSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitudesActionPerformed

        if (casilla.getEstado().equalsIgnoreCase("Desocupado")) {
            JOptionPane.showMessageDialog(null, "El negocio se encuentra desocupado.");
        } else {
            GenerarSolicitud generar = new GenerarSolicitud(local);
            showPanel(generar);
        }
    }//GEN-LAST:event_btnSolicitudesActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        if (casilla.getEstado().equalsIgnoreCase("Desocupado")) {
            JOptionPane.showMessageDialog(null, "El negocio se encuentra desocupado.");
        } else {
            new ConsutarCliente(controlador).setVisible(true);
        }

    }//GEN-LAST:event_btnConsultarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnDesocupado;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrar1;
    private javax.swing.JButton btnRegistrar2;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSolicitudes;
    private javax.swing.JButton btnVenta;
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreLocal;
    // End of variables declaration//GEN-END:variables
}