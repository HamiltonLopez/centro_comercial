/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

import javax.swing.JOptionPane;

/**
 *
 * @author aleca
 */
public class TelefonoInvalidoException extends RuntimeException {
    
    public TelefonoInvalidoException(){
        JOptionPane.showMessageDialog(null, "Numero invalido.\nVerifique que contenga 10 digitos");
    }
    
}
