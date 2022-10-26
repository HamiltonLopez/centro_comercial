/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class PilaVaciaException extends RuntimeException{
    public PilaVaciaException() {
        JOptionPane.showMessageDialog(null, "La pila se encuentra vacia");
    }
}
