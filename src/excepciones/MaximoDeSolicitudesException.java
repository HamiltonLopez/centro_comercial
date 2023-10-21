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
public class MaximoDeSolicitudesException extends RuntimeException{

    public MaximoDeSolicitudesException() {
        JOptionPane.showMessageDialog(null, "Usted ya ha hecho el máximo de solicitudes permitidas");
    }
    
}
