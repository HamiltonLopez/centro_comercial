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
public class PacienteConMultaException extends RuntimeException {

    public PacienteConMultaException() {
        JOptionPane.showMessageDialog(null, "El paciente posee una multa por inasistencia.\nPongase al dia y vuelva a intentar ");
    }
    
    
}
