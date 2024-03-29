/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas.administrador;

import ValidarCampos.ValidarCampos;
import controladores.ControladorCasilla;
import controladores.ControladorUsuario;
import excepciones.AdministradorYaExisteException;
import excepciones.CorreoExistenteException;
import excepciones.TelefonoInvalidoException;
import excepciones.UsuarioExistenteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

import modelos.Casilla;
import modelos.Contrato;
import modelos.Empleado;
import modelos.Local;
import modelos.Usuario;

/**
 *
 * @author Asus
 */
public class VistaLocal extends javax.swing.JFrame {

    private int fila;
    private int columna;
    private Locales ventana;
    private ControladorCasilla controlador;
    private ControladorUsuario controladorU;

    public VistaLocal(Locales ventana, int fila, int columna) {
        initComponents();
        setLocationRelativeTo(this);
        this.ventana = ventana;
        controlador = ventana.getControlador();
        Casilla casilla = controlador.obtenerCasilla(fila, columna);
        panelAsignar.setVisible(false);
        controladorU = new ControladorUsuario();
        txtCorrAdicional.setEditable(false);

        txtPrecio.setText("$" + casilla.getLocal().getPrecioArriendo());
        txtPrecio.setEditable(false);
        this.columna = columna;
        this.fila = fila;
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
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnRegresar = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtContra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
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
        chooserFinal = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        chooser = new com.toedter.calendar.JDateChooser();
        txtNombreLocal = new javax.swing.JTextField();
        txtCorrAdicional = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("PRECIO DE RENTA :");

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ASIGNAR  LOCAL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(204, 0, 51));
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        txtPrecio.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(0, 0, 0));
        txtPrecio.setBorder(null);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnRegresar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar)
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton2)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelAsignar.setBackground(new java.awt.Color(255, 255, 255));
        panelAsignar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("ASIGNAR LOCAL");
        panelAsignar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

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

        jLabel6.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fecha Final");
        panelAsignar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Correo:");
        panelAsignar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 108, -1, -1));

        txtCorreo.setBorder(null);
        panelAsignar.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 129, 110, -1));

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

        jLabel12.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Nombre del Negocio :");
        panelAsignar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 277, -1, -1));

        btnRegistrar.setBackground(new java.awt.Color(0, 153, 153));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        panelAsignar.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 171, -1));
        panelAsignar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 92, 196, 10));
        panelAsignar.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 148, 196, 10));
        panelAsignar.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 148, 195, 10));
        panelAsignar.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 207, 197, 10));
        panelAsignar.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 207, 195, 10));
        panelAsignar.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 261, 196, 10));
        panelAsignar.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 196, 10));

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
        panelAsignar.add(chooserFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 100, -1));

        jLabel14.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Fecha Inicio");
        panelAsignar.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 43, -1, -1));
        panelAsignar.add(chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 100, -1));

        txtNombreLocal.setBorder(null);
        panelAsignar.add(txtNombreLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 190, 20));

        txtCorrAdicional.setBackground(new java.awt.Color(255, 255, 255));
        txtCorrAdicional.setForeground(new java.awt.Color(0, 0, 0));
        txtCorrAdicional.setText("@adminL.com");
        txtCorrAdicional.setBorder(null);
        panelAsignar.add(txtCorrAdicional, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 90, -1));
        panelAsignar.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 261, 196, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelAsignar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAsignar, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        if (txtNombre.getText().isEmpty() || txtDocumento.getText().isEmpty()
                || txtCorreo.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtContra.getText().isEmpty() || txtNombreLocal.getText().isEmpty()
                || comboSexo.getSelectedIndex() == 0 || txtApellido.getText().isEmpty() || chooser.getDate()==null || chooserFinal.getDate() ==null) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");

        } else {

            String nombreLocal = txtNombreLocal.getText();
            String nombre = txtNombre.getText();
            String documento = txtDocumento.getText();
            String telefono = txtTelefono.getText();
            Date inicio = chooser.getDate();
            Date fin = chooserFinal.getDate();
            String correo = txtCorreo.getText() + txtCorrAdicional.getText();
            String contraseña = txtContra.getText();
            String sexo = comboSexo.getSelectedItem().toString();
            Date fechaInicio = new Date(inicio.getYear(), inicio.getMonth(), inicio.getDay());
            Date fechaFinal = new Date(fin.getYear(), fin.getMonth(), fin.getDay());
            String cargo = "Administrador de Local";
            String apellido = txtApellido.getText();
            String direccion = txtDireccion.getText();
            String adicional = txtCorrAdicional.getText();
            Usuario admin1 = new Empleado(nombre, documento, telefono, correo, contraseña, apellido, direccion, sexo, cargo);
            Empleado admin = (Empleado) admin1;
            Contrato contrato = new Contrato(nombre, admin, fechaInicio, fechaFinal);
            Local local = new Local(nombreLocal, contrato);

            try {
                controladorU.registrarUsuario(admin1, adicional);
                controlador.agregarLocal(local, fila, columna);
                
                JOptionPane.showMessageDialog(null, "El local" + nombreLocal + " se ha registrado con éxito");
                limpiar();
                ventana.validarPosiciones();
                ventana.setVisible(true);
                this.dispose();
            } catch (UsuarioExistenteException | AdministradorYaExisteException | TelefonoInvalidoException | CorreoExistenteException ex) {

                ex.getMessage();
            }

        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        panelAsignar.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    public void limpiar() {
        txtDocumento.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtApellido.setText("");
        txtCorreo.setText("");
        txtContra.setText("");
        txtDireccion.setText("");

        comboSexo.setSelectedIndex(0);
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbDoctores;
    private com.toedter.calendar.JDateChooser chooser;
    private com.toedter.calendar.JDateChooser chooserFinal;
    private javax.swing.JComboBox<String> comboSexo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel panelAsignar;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContra;
    private javax.swing.JTextField txtCorrAdicional;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreLocal;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
