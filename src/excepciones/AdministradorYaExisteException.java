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
public class AdministradorYaExisteException extends RuntimeException{

    public AdministradorYaExisteException() {
          JOptionPane.showMessageDialog(null, "El documento que intenta ingresar ya corresponde.\na otro administrador. Intente nuevamente ");
    }
    
}
