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
public class PlacaYaRegistradaException extends RuntimeException {

    public PlacaYaRegistradaException() {
        JOptionPane.showMessageDialog(null, "La placa corresponde a un vehiculo que ya está\nen el parqueadero. Registre su salida primero.");
    }
    
    
}
