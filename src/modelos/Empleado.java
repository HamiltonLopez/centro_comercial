/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class Empleado extends Usuario implements Serializable{
    String cargo;
    
    public Empleado(String nombre, String documento, String telefono, String correo, String contrasena, String apellido, String direccion, String sexo,String cargo) {
        super(nombre, documento, telefono, correo, contrasena, apellido, direccion, sexo);
        this.cargo =cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
