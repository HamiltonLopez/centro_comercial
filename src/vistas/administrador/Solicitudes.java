/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas.administrador;

import Singleton.SingletonCC;
import controladores.ControladorSolicitudes;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.CentroComercial;
import modelos.Empleado;
import modelos.Local;
import modelos.SolicitudMantenimiento;
import util.Lista;
import util.Queue;

/**
 *
 * @author Asus
 */
public class Solicitudes extends javax.swing.JPanel {

    CentroComercial centro;
    Queue<SolicitudMantenimiento> soli;
    private DefaultTableModel tablaP;
    ControladorSolicitudes controlador;

    public Solicitudes() {
        initComponents();
        controlador = new ControladorSolicitudes();
        tablaP = new DefaultTableModel();
        centro = SingletonCC.getINSTANCIA().getInstancia();
        soli = centro.getSolicitudes();
        txtNombreAdmin.setEditable(false);
        txtDetalle.setEditable(false);
        txtFecha.setEditable(false);
        txtEstado.setEditable(false);
        this.tablaSolicitudes.setModel(tablaP);
        tablaP.addColumn("NOMBRE DEL NEGOCIO");
        tablaP.addColumn("ADMINISTRADOR");
        tablaP.addColumn("FECHA DE RADICACIÓN");
        tablaP.addColumn("ESTADO");

        limpiar();
    }

    public void remover() {

        for (int i = 0; i < tablaP.getRowCount(); i++) {
            tablaP.removeRow(i);
        }

    }

    public void limpiar() {

        if (!soli.isEmpty()) {
            Local local = soli.peek().getLocal();
            Empleado empleado = local.getContrato().getAdmin();
            
            txtNombreAdmin.setText(empleado.getNombre());
            txtFecha.setText(String.valueOf(soli.peek().getFecha()));
            txtDetalle.setText(soli.peek().getDetallesSolicitud());
            txtEstado.setText(soli.peek().getEstado());
            txtNombreLocal.setText(local.getNombre());
        } else {
            txtNombreAdmin.setText("");
            txtFecha.setText("");
            txtDetalle.setText("");
            txtEstado.setText("");
            txtNombreLocal.setText("");
        }

        remover();
        llenarTablaSolicitudes();
    }

    public void llenarTablaSolicitudes() {
        remover();
        Lista<SolicitudMantenimiento> solicitudes = controlador.getNuevo();
        for (int i = 0; i < solicitudes.Size(); i++) {
            SolicitudMantenimiento solicitud = solicitudes.obtener(i);
            if (solicitud != null && !solicitud.getEstado().equalsIgnoreCase("Atendida")) {
                Empleado empleado = solicitud.getLocal().getContrato().getAdmin();
                String[] info = new String[4];
                info[0] = solicitud.getLocal().getNombre();
                info[1] = empleado.getNombre();
                info[2] = String.valueOf(solicitud.getFecha());
                info[3] = String.valueOf(solicitud.getEstado());

                tablaP.addRow(info);

            } else {

            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupEstado = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaSolicitudes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtNombreAdmin = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        radioAtendida = new javax.swing.JRadioButton();
        radioProgreso = new javax.swing.JRadioButton();
        radioCancelada = new javax.swing.JRadioButton();
        radioPendiente = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        txtEstado = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtNombreLocal = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1048, 598));

        tablaSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaSolicitudes);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SOLICITUDES ACTIVAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(122, 122, 122))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1048, 598));

        txtNombreAdmin.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreAdmin.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreAdmin.setBorder(null);
        txtNombreAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAdminActionPerformed(evt);
            }
        });
        txtNombreAdmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreAdminKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Nombre del administrador:");

        txtDetalle.setColumns(20);
        txtDetalle.setRows(5);
        jScrollPane1.setViewportView(txtDetalle);

        jLabel16.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Fecha de la solicitud");

        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setForeground(new java.awt.Color(0, 0, 0));
        txtFecha.setBorder(null);
        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaKeyTyped(evt);
            }
        });

        groupEstado.add(radioAtendida);
        radioAtendida.setForeground(new java.awt.Color(0, 0, 0));
        radioAtendida.setText("ATENDIDA");

        groupEstado.add(radioProgreso);
        radioProgreso.setForeground(new java.awt.Color(0, 0, 0));
        radioProgreso.setText("EN PROGRESO");

        groupEstado.add(radioCancelada);
        radioCancelada.setForeground(new java.awt.Color(0, 0, 0));
        radioCancelada.setText("CANCELADA");

        groupEstado.add(radioPendiente);
        radioPendiente.setForeground(new java.awt.Color(0, 0, 0));
        radioPendiente.setText("PENDIENTE");

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("FINALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtEstado.setBackground(new java.awt.Color(255, 255, 255));
        txtEstado.setForeground(new java.awt.Color(0, 0, 0));
        txtEstado.setBorder(null);
        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });
        txtEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEstadoKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Estado actual :");

        jLabel18.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Nombre del negocio :");

        txtNombreLocal.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreLocal.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreLocal.setBorder(null);
        txtNombreLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreLocalActionPerformed(evt);
            }
        });
        txtNombreLocal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreLocalKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radioPendiente)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(radioProgreso)
                        .addGap(53, 53, 53)
                        .addComponent(radioCancelada))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addComponent(radioAtendida)))
                .addGap(78, 78, 78))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNombreAdmin)
                        .addGap(40, 40, 40)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(121, 121, 121))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(jSeparator2)
                                    .addGap(12, 12, 12)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtNombreLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 39, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioProgreso)
                    .addComponent(radioCancelada)
                    .addComponent(radioPendiente))
                .addGap(18, 18, 18)
                .addComponent(radioAtendida)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreAdminActionPerformed

    private void txtNombreAdminKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreAdminKeyTyped
        //   new ValidarCampos().validarLetras(evt);
    }//GEN-LAST:event_txtNombreAdminKeyTyped

    private void txtFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyTyped
        // new ValidarCampos().validarLetras(evt);
    }//GEN-LAST:event_txtFechaKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (groupEstado.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        } else if (txtDetalle.getText().equalsIgnoreCase("")) {
             JOptionPane.showMessageDialog(null, "No hay solicitudes para atender");
        } else {
            if (radioPendiente.isSelected()) {
                controlador.cambiarAPendiente();
                JOptionPane.showMessageDialog(null, "La solicitud a cambiado a estado de pendiente");
                limpiar();
            } else if (radioCancelada.isSelected()) {
                controlador.cambiarACancelado();
                JOptionPane.showMessageDialog(null, "La solicitud a cambiado a estado de pendiente");
                limpiar();
            } else if (radioProgreso.isSelected()) {
                controlador.cambiarEnProgreso();
                JOptionPane.showMessageDialog(null, "La solicitud a cambiado a estado en progreso");
                limpiar();
            } else {
                SolicitudMantenimiento soli = controlador.atenderSolicitud();
                new CuentaCobro(soli).setVisible(true);
                //JOptionPane.showMessageDialog(null, "La solicitud ha sido atendida satisfactoriamente");
                limpiar();
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void txtEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstadoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoKeyTyped

    private void txtNombreLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreLocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreLocalActionPerformed

    private void txtNombreLocalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreLocalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreLocalKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup groupEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JRadioButton radioAtendida;
    private javax.swing.JRadioButton radioCancelada;
    private javax.swing.JRadioButton radioPendiente;
    private javax.swing.JRadioButton radioProgreso;
    private javax.swing.JTable tablaSolicitudes;
    private javax.swing.JTextArea txtDetalle;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombreAdmin;
    private javax.swing.JTextField txtNombreLocal;
    // End of variables declaration//GEN-END:variables
}