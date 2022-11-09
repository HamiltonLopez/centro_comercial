/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.administrador;

import ValidarCampos.ValidarCampos;
import controladores.ControladorUsuario;
import javax.swing.JOptionPane;
import modelos.AdminLocal;
import modelos.Administrador;
import modelos.Casilla;
import modelos.Cliente;
import modelos.Usuario;

/**
 *
 * @author Asus
 */
public class EditarAdmin extends javax.swing.JFrame {

    private Casilla casilla;

    ControladorUsuario controlador;
    InfoLocal info;

    public EditarAdmin(Casilla casilla, InfoLocal info) {
        initComponents();
        setLocationRelativeTo(this);
        this.info = info;
        this.casilla = casilla;
        AdminLocal admin = casilla.getLocal().getContrato().getAdmin();
        controlador = new ControladorUsuario();
        llenar(admin);
        txtDocumento.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAsignar = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboSexo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtContra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        cbDoctores = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnEditar5 = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelAsignar.setBackground(new java.awt.Color(255, 255, 255));
        panelAsignar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("EDITAR ADMINISTRADOR");
        panelAsignar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombres:");
        panelAsignar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 43, -1, -1));

        txtNombre.setBorder(null);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        panelAsignar.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 67, 196, 19));

        jLabel10.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Apellidos:");
        panelAsignar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 108, -1, -1));

        txtApellido.setBorder(null);
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });
        panelAsignar.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 129, 196, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Documento:");
        panelAsignar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 164, -1, -1));

        txtDocumento.setBorder(null);
        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });
        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });
        panelAsignar.add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 185, 196, -1));

        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Telefono:");
        panelAsignar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 223, -1, -1));

        txtTelefono.setBorder(null);
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        panelAsignar.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 244, 196, -1));

        jLabel5.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Sexo:");
        panelAsignar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 277, -1, -1));

        comboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione ", "Masculino", "Femenino", "No especifica" }));
        comboSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSexoActionPerformed(evt);
            }
        });
        panelAsignar.add(comboSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 298, 196, -1));

        jLabel7.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Correo:");
        panelAsignar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 108, -1, -1));

        txtCorreo.setBorder(null);
        panelAsignar.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 129, 196, -1));

        txtContra.setBorder(null);
        panelAsignar.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 185, 195, -1));

        jLabel8.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Contraseña:");
        panelAsignar.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 164, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Direccion:");
        panelAsignar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 223, -1, -1));

        txtDireccion.setBorder(null);
        panelAsignar.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 244, 196, -1));
        panelAsignar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 92, 196, 10));
        panelAsignar.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 148, 196, 10));
        panelAsignar.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 148, 195, 10));
        panelAsignar.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 207, 197, 10));
        panelAsignar.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 207, 195, 10));
        panelAsignar.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 261, 196, 10));
        panelAsignar.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 261, 196, 10));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("DOCTORES REGISTRADOS:");

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbDoctores, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbDoctores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelAsignar.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 0, 0, 20));

        btnEditar5.setBackground(new java.awt.Color(0, 153, 153));
        btnEditar5.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar5.setText("EDITAR");
        btnEditar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar5ActionPerformed(evt);
            }
        });
        panelAsignar.add(btnEditar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 140, -1));

        btnRegresar.setBackground(new java.awt.Color(204, 0, 0));
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        panelAsignar.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelAsignar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelAsignar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        new ValidarCampos().validarLetras(evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        new ValidarCampos().validarLetras(evt);
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void txtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyTyped
        new ValidarCampos().validarNumeros(evt);
    }//GEN-LAST:event_txtDocumentoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        new ValidarCampos().validarNumeros(evt);
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void comboSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSexoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar5ActionPerformed
        if (txtNombre.getText().isEmpty() || txtDocumento.getText().isEmpty() || txtTelefono.getText().isEmpty() || comboSexo.getSelectedIndex() == 0
                || txtCorreo.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtContra.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");

        } else {
            String nombre = txtNombre.getText();
            String documento = txtDocumento.getText();
            String telefono = txtTelefono.getText();
            String correo = txtCorreo.getText();
            String contraseña = txtContra.getText();
            String sexo = comboSexo.getSelectedItem().toString();

            String apellido = txtApellido.getText();
            String direccion = txtDireccion.getText();

            Usuario cliente = new Cliente(nombre, documento, telefono, correo, contraseña, apellido, direccion, sexo);
            boolean es = controlador.editarUsuario(cliente);
            if (es) {
                JOptionPane.showMessageDialog(null, "El administrador se ha editado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "El administrador no se ha podido modificar");
            }
        }
    }//GEN-LAST:event_btnEditar5ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        info.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    public void llenar(AdminLocal admin) {

        txtApellido.setText(admin.getApellido());
        txtContra.setText(admin.getContrasena());
        txtCorreo.setText(admin.getCorreo());
        txtDireccion.setText(admin.getDireccion());
        txtDocumento.setText(admin.getDocumento());
        txtNombre.setText(admin.getNombre());
        txtTelefono.setText(admin.getTelefono());
        comboSexo.setSelectedItem(admin.getSexo());
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar5;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbDoctores;
    private javax.swing.JComboBox<String> comboSexo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JPanel panelAsignar;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContra;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}