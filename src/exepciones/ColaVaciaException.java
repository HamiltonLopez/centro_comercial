/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exepciones;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class ColaVaciaException extends RuntimeException implements Serializable {
    public ColaVaciaException() {
        JOptionPane.showMessageDialog(null, "La fila se encuentra vacia");
    }
}
