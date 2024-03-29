/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas.adminLocal;

import controladores.ControladorAdminLocal;
import javax.swing.table.DefaultTableModel;
import modelos.Local;
import modelos.Venta;
import util.Lista;

/**
 *
 * @author Asus
 */
public class HistorialLocal extends javax.swing.JPanel {

    private DefaultTableModel modell;
    ControladorAdminLocal controlador;
    

    public HistorialLocal(ControladorAdminLocal controlador) {
        initComponents();
        modell = new DefaultTableModel();
        this.tablaHistorial.setModel(modell);
        modell.addColumn("Cliente CC");
        modell.addColumn("Fecha");
        modell.addColumn("Total");
        this.controlador = controlador;
        limpiar();
    }
     public void removerTablaHistorial() {

        for (int i = 0; i < modell.getRowCount(); i++) {
            modell.removeRow(i);
        }

    }
      public void llenarTablaHistorial() {
        removerTablaHistorial();
        Lista<Venta> historial = controlador.getHistorial();
        for (int i = 0; i < historial.Size(); i++) {
            Venta venta = historial.obtener(i);
            if (venta != null) {

                String[] info = new String[4];
                info[0] = String.valueOf(venta.getCliente().getDocumento());
                info[1] = String.valueOf(venta.getFechaVenta());

                info[2] = String.valueOf(venta.getTotalCompra());

                modell.addRow(info);
             

            } else {

            }

        }
    }
      public void limpiar(){
          removerTablaHistorial();
          llenarTablaHistorial();
      }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        tablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NOMBRE", "CATEGORIA", "DIA VENTA", "CLIENTE CC"
            }
        ));
        jScrollPane1.setViewportView(tablaHistorial);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaHistorial;
    // End of variables declaration//GEN-END:variables
}
