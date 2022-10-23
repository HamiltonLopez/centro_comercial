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
public class ListaVaciaException extends RuntimeException implements Serializable {

    public ListaVaciaException() {
        JOptionPane.showMessageDialog(null, "La lista se encuentra vacia");
    }
    
}
