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
public class UsuarioExistenteException extends RuntimeException{
      public UsuarioExistenteException(){
        JOptionPane.showMessageDialog(null, "El documento ya se encuentra registrado");
    }
}
