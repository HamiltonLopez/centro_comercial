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
public class ProductoExistente extends RuntimeException{

    public ProductoExistente() {
        JOptionPane.showMessageDialog(null, "El identificador ingresado ya pertenece\na un producto registrado.");
    }
    
    
}
