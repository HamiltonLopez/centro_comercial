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
public class CorreoExistenteException extends RuntimeException{

    public CorreoExistenteException() {
        JOptionPane.showMessageDialog(null, "El correo ingresado ya corresponde\na otro usuario registrado.");
    }
    
    
}
