/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas.encargadoInventario;

import ValidarCampos.ValidarCampos;
import controladores.ControladorAdminLocal;
import controladores.ControladorEncargadoI;
import excepciones.ProductoExistenteException;
import excepciones.StockExcedidoException;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Empleado;
import modelos.Local;
import modelos.Producto;
import util.Lista;

/**
 *
 * @author Asus
 */
public class GestionarProductosEncargado extends javax.swing.JPanel {

    ControladorEncargadoI controlador;
    
    Local local;
    private DefaultTableModel modelo;

    public GestionarProductosEncargado( Local local) {
        initComponents();
      
        this.local = local;
        controlador = new ControladorEncargadoI(local);
        modelo = new DefaultTableModel();
        this.tablaProductos.setModel(modelo);
        modelo.addColumn("Cantidad");
        modelo.addColumn("Nombre");
        modelo.addColumn("Identificador");
        modelo.addColumn("Precio");
        limpiar();
    }

    public void limpiar() {

        ////////////////////////////////
        ////////////////////////////////
        txtPrecio.setText("");
        txtIdentificador.setText("");
        txtMarca.setText("");
        txtCantidad.setText("");
        txtNombreProducto.setText("");
        txtPeso.setText("");
        comboCategoria.setSelectedIndex(0);
        removerTablaProductosInventario();
        llenarTablaProductos();

    }

    public void removerTablaProductosInventario() {

        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
        }

    }

    public void llenarTablaProductos() {
        removerTablaProductosInventario();
        Lista<Producto> productos = controlador.getProductosLocal();
        for (int i = 0; i < productos.Size(); i++) {
            Producto producto = productos.obtener(i);
            if (producto != null) {
                if (producto.getCantBodega() <= 0) {
                    String[] info = new String[4];
                    info[0] = String.valueOf("SIN STOCK");
                    info[1] = producto.getNombreProducto();
                    info[2] = producto.getIdentificador();
                    info[3] = String.valueOf(producto.getPrecio());

                    modelo.addRow(info);
                    //tablaP.addRow(info);
                } else {
                    String[] info = new String[4];
                    info[0] = String.valueOf(producto.getCantBodega());
                    info[1] = producto.getNombreProducto();
                    info[2] = producto.getIdentificador();
                    info[3] = String.valueOf(producto.getPrecio());

                    modelo.addRow(info);
                    //tablaP.addRow(info);
                }

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

        jPanel20 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        txtIdentificador = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnRegistrar7 = new javax.swing.JButton();
        btnEditar7 = new javax.swing.JButton();
        btnEliminar7 = new javax.swing.JButton();
        jLabel91 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        btnBuscar6 = new javax.swing.JButton();
        txtProductoEliminar = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        lblError1 = new javax.swing.JLabel();
        lblError2 = new javax.swing.JLabel();
        jSeparator29 = new javax.swing.JSeparator();
        jSeparator30 = new javax.swing.JSeparator();
        jSeparator31 = new javax.swing.JSeparator();
        jSeparator32 = new javax.swing.JSeparator();
        jSeparator33 = new javax.swing.JSeparator();
        jSeparator35 = new javax.swing.JSeparator();
        comboCategoria = new javax.swing.JComboBox<>();
        jLabel94 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jSeparator34 = new javax.swing.JSeparator();
        txtCantiEliminar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator36 = new javax.swing.JSeparator();

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel69.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 0, 0));
        jLabel69.setText("Nombre del producto:");

        txtNombreProducto.setBorder(null);
        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyTyped(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 0, 0));
        jLabel73.setText("Identificador :");

        txtIdentificador.setBorder(null);
        txtIdentificador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificadorKeyTyped(evt);
            }
        });

        jLabel85.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 0, 0));
        jLabel85.setText("Peso bruto:");

        txtPeso.setBorder(null);
        txtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoActionPerformed(evt);
            }
        });
        txtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesoKeyTyped(evt);
            }
        });

        jLabel86.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 0, 0));
        jLabel86.setText("Precio:");

        txtPrecio.setBorder(null);
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel88.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 0, 0));
        jLabel88.setText("Marca :");

        txtMarca.setBorder(null);

        jLabel89.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(0, 0, 0));
        jLabel89.setText("Cantidad ingresada :");

        txtCantidad.setBorder(null);
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        btnRegistrar7.setBackground(new java.awt.Color(0, 153, 153));
        btnRegistrar7.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar7.setText("AGREGAR PRODUCTO");
        btnRegistrar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar7ActionPerformed(evt);
            }
        });

        btnEditar7.setBackground(new java.awt.Color(0, 153, 153));
        btnEditar7.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar7.setText("EDITAR");
        btnEditar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar7ActionPerformed(evt);
            }
        });

        btnEliminar7.setBackground(new java.awt.Color(0, 153, 153));
        btnEliminar7.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar7.setText("ELIMINAR n Cantidad");
        btnEliminar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar7ActionPerformed(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(0, 0, 0));
        jLabel91.setText("GESTION DE INVENTARIO");

        jPanel21.setBackground(new java.awt.Color(0, 153, 153));

        btnBuscar6.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar6.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar6.setText("BUSCAR");
        btnBuscar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar6ActionPerformed(evt);
            }
        });

        txtProductoEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductoEliminarKeyTyped(evt);
            }
        });

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
        jScrollPane3.setViewportView(tablaProductos);

        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setText("PRODUCTOS DEL LOCAL");

        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setText("INGRESE EL NUMERO IDENTIFICADOR A BUSCAR :");

        lblError1.setBackground(new java.awt.Color(0, 153, 153));
        lblError1.setForeground(new java.awt.Color(0, 153, 153));
        lblError1.setText("jLabel5");

        lblError2.setBackground(new java.awt.Color(0, 153, 153));
        lblError2.setForeground(new java.awt.Color(0, 153, 153));
        lblError2.setText("jLabel5");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBuscar6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(lblError2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(txtProductoEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(lblError1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel93))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel92))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel93)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblError1)
                    .addComponent(txtProductoEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblError2)
                    .addComponent(btnBuscar6))
                .addGap(136, 136, 136))
        );

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la categoria", "Mercado", "Electrodomesticos", "Hogar y muebles", "Deportes", "Licores" }));

        jLabel94.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 0, 0));
        jLabel94.setText("Categoria :");

        jLabel87.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 0, 0));
        jLabel87.setText("$ :");

        jLabel90.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(0, 0, 0));
        jLabel90.setText("KG :");

        txtCantiEliminar.setBorder(null);
        txtCantiEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantiEliminarKeyTyped(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("n =");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegistrar7, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(btnEditar7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator34, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator36, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCantiEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jLabel91))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel87))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel90)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(txtPeso)
                                    .addComponent(txtIdentificador)
                                    .addComponent(jLabel86)
                                    .addComponent(jLabel85)
                                    .addComponent(txtNombreProducto)
                                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel69))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator32, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel88, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMarca, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel94, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel89, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator33, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(jLabel94))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jSeparator35, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(jLabel88))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator33, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel85)
                            .addComponent(jLabel89))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel90))
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator30, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator32, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel86)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87))
                .addGap(2, 2, 2)
                .addComponent(jSeparator31, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(btnRegistrar7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar7)
                        .addComponent(jLabel11))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(txtCantiEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProductoKeyTyped

    private void txtIdentificadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificadorKeyTyped
       new ValidarCampos().validarNumeros(evt);
    }//GEN-LAST:event_txtIdentificadorKeyTyped

    private void txtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoActionPerformed

    private void txtPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoKeyTyped
 new ValidarCampos().validarNumeros(evt);
    }//GEN-LAST:event_txtPesoKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
       new ValidarCampos().validarNumeros(evt);
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void btnRegistrar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar7ActionPerformed

        if (txtNombreProducto.getText().isEmpty() || txtMarca.getText().isEmpty() || txtPeso.getText().isEmpty() || txtIdentificador.getText().isEmpty()
                || comboCategoria.getSelectedIndex() == 0
                || txtCantidad.getText().isEmpty() || txtPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
        } else {

            String nombre = txtNombreProducto.getText();
            String marca = txtMarca.getText();
            String identificador = txtIdentificador.getText();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            String peso = txtPeso.getText();
            String categoria = comboCategoria.getSelectedItem().toString();
            int precio = Integer.parseInt(txtPrecio.getText());
            Producto producto = new Producto(nombre, identificador, categoria, precio, peso, cantidad, marca,0);

            try {
                controlador.añadirProducto(producto);
                JOptionPane.showMessageDialog(null, "Se registró");
                limpiar();
            } catch (ProductoExistenteException ex) {
                ex.getMessage();
            }
        }

    }//GEN-LAST:event_btnRegistrar7ActionPerformed

    private void btnEditar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar7ActionPerformed
        if (txtNombreProducto.getText().isEmpty() || txtMarca.getText().isEmpty() || txtPeso.getText().isEmpty() || txtIdentificador.getText().isEmpty()
                || comboCategoria.getSelectedIndex() == 0
                || txtCantidad.getText().isEmpty() || txtPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
        } else {
            String nombre = txtNombreProducto.getText();
            String marca = txtMarca.getText();
            String identificador = txtIdentificador.getText();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            String peso = txtPeso.getText();
            String categoria = comboCategoria.getSelectedItem().toString();
            int precio = Integer.parseInt(txtPrecio.getText());
            Producto producto = new Producto(nombre, identificador, categoria, precio, peso, cantidad, marca,0);
            boolean aux = controlador.editarProducto(producto);
            if (aux) {
                JOptionPane.showMessageDialog(null, "Se editó con éxito");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se editó");
            }
        }
    }//GEN-LAST:event_btnEditar7ActionPerformed

    private void btnEliminar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar7ActionPerformed

        if (txtCantiEliminar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la cantidad que desea eliminar");
        } else {
            String identificador = txtIdentificador.getText();
            int cantidad = Integer.parseInt(txtCantiEliminar.getText());
            try {
                boolean aux = controlador.eliminarProducto(identificador, cantidad);
                if (aux) {
                    JOptionPane.showMessageDialog(null, "Se actualizó");
                    limpiar();
                    txtIdentificador.setEditable(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar ");
                }
            } catch (StockExcedidoException ex) {
                ex.getMessage();
            }
        }

    }//GEN-LAST:event_btnEliminar7ActionPerformed

    private void btnBuscar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar6ActionPerformed
        if (txtProductoEliminar.getText().isEmpty()) {
            lblError2.setText("Ingrese el número de identificador");
            lblError2.setForeground(Color.red);
        } else {
            String identificador = txtProductoEliminar.getText();
            Producto producto = controlador.buscarProductoLocal(identificador);
            if (producto != null) {
                txtNombreProducto.setText(producto.getNombreProducto());
                txtCantidad.setText(String.valueOf(producto.getCantBodega()));
                txtPrecio.setText(String.valueOf(producto.getPrecio()));
                txtPeso.setText(producto.getPesoBruto());
                comboCategoria.setSelectedItem(producto.getCategoria());
                txtMarca.setText(producto.getMarca());
                txtIdentificador.setText(producto.getIdentificador());
                txtIdentificador.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto");
            }

        }
    }//GEN-LAST:event_btnBuscar6ActionPerformed

    private void txtCantiEliminarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantiEliminarKeyTyped
         new ValidarCampos().validarNumeros(evt);
    }//GEN-LAST:event_txtCantiEliminarKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
      new ValidarCampos().validarNumeros(evt);
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtProductoEliminarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoEliminarKeyTyped
       new ValidarCampos().validarNumeros(evt);
    }//GEN-LAST:event_txtProductoEliminarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar6;
    private javax.swing.JButton btnEditar7;
    private javax.swing.JButton btnEliminar7;
    private javax.swing.JButton btnRegistrar7;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator30;
    private javax.swing.JSeparator jSeparator31;
    private javax.swing.JSeparator jSeparator32;
    private javax.swing.JSeparator jSeparator33;
    private javax.swing.JSeparator jSeparator34;
    private javax.swing.JSeparator jSeparator35;
    private javax.swing.JSeparator jSeparator36;
    private javax.swing.JLabel lblError1;
    private javax.swing.JLabel lblError2;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtCantiEliminar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtIdentificador;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProductoEliminar;
    // End of variables declaration//GEN-END:variables
}
