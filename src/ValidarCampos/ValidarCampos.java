/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ValidarCampos;

import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class ValidarCampos {

    public void validarNumeros(java.awt.event.KeyEvent evt) {
        char validar = evt.getKeyChar();
        if ((validar < '0' || validar > '9')&&(validar != 127)) {

            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo números");
        }
    }

    public void validarLetras(java.awt.event.KeyEvent evt) {
        char validar = evt.getKeyChar();
        if ((validar < 'a' || validar > 'z')&&(validar < 'A' || validar > 'Z') &&(validar != 127) && (validar != 32)) {

            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo letras");
        }
    }
}
