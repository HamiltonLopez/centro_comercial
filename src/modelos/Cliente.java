/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Asus
 */
public class Cliente extends Usuario {
    private Multa multa;
    

    public Cliente(String nombre, String documento, String telefono, String correo, String contrasena, String apellido, String direccion, String sexo) {
        super(nombre, documento, telefono, correo, contrasena, apellido, direccion, sexo);
        multa = null;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }
    
}
