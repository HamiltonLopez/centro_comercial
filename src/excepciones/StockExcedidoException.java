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
public class StockExcedidoException extends RuntimeException {

    public StockExcedidoException() {
        JOptionPane.showMessageDialog(null, "Ingrese una cantidad que no exceda el numero\nde productos en stock.");
    }
    
}
