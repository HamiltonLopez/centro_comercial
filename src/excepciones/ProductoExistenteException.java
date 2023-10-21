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
public class ProductoExistenteException extends RuntimeException{

    public ProductoExistenteException() {
        JOptionPane.showMessageDialog(null, "El identificador ingresado pertenece\na a otro producto.");
    }
    
    
}
