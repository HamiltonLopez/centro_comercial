/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas.administrador;

import controladores.ControladorCasilla;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import modelos.Casilla;

/**
 *
 * @author Asus
 */
public class Locales extends javax.swing.JPanel implements ActionListener {

    JButton[][] botones;
    ControladorCasilla controlador;

    public Locales() {
        initComponents();
        controlador = new ControladorCasilla();
        botones = new JButton[5][4];
        cargarBotones();
        validarPosiciones();

    }

    public ControladorCasilla getControlador() {
        return controlador;
    }
    

    public void cargarBotones() {
        int ancho = 180;
        int alto = 80;
        int separado = 90;
        int num = 1;
        char texto = 'A';
        for (int i = 0; i < botones.length; i++) {

            for (int j = 0; j < botones[i].length; j++) {

                botones[i][j] = new JButton();
                botones[i][j].setBounds((j * ancho + separado), (i * alto + separado), ancho, alto);
                botones[i][j].setText(String.valueOf("Local " + num));
                botones[i][j].setForeground(Color.white);
                botones[i][j].addActionListener(this);
                panelBotones2.add(botones[i][j]);
                num++;

            }

        }

    }
     public void validarPosiciones() {
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                Casilla casilla = controlador.obtenerCasilla(i, j);
                if (casilla.getEstado().equals(Casilla.DISPONIBLE)) {
                    botones[i][j].setBackground(new Color(73, 156, 61));
                    botones[i][j].setForeground(Color.white);
                } else {

                    botones[i][j].setBackground(new Color(204, 0, 51));
                    botones[i][j].setText(casilla.getLocal().getNombre());
                }
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

        panelBotones2 = new javax.swing.JPanel();

        panelBotones2.setBackground(new java.awt.Color(255, 255, 255));
        panelBotones2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelBotones2Layout = new javax.swing.GroupLayout(panelBotones2);
        panelBotones2.setLayout(panelBotones2Layout);
        panelBotones2Layout.setHorizontalGroup(
            panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1079, Short.MAX_VALUE)
        );
        panelBotones2Layout.setVerticalGroup(
            panelBotones2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1079, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelBotones2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelBotones2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelBotones2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                if (e.getSource().equals(botones[i][j])) {
                    Casilla casilla = controlador.obtenerCasilla(i, j);
                    if (casilla.getEstado().equals(Casilla.DISPONIBLE)) {
                           VistaLocal vista = new VistaLocal(this, i, j);
                         vista.setVisible(true);

                    } else {
                            InfoLocal ventana = new InfoLocal(this, casilla);

                         ventana.setVisible(true);
                    }
                }
            }

        }
    }
}
