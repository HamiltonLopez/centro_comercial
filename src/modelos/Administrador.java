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
public class Administrador extends Usuario implements Serializable {

    public Administrador(String nombre, String documento, String telefono, String correo, String contrasena, String apellido, String direccion, String sexo) {
        super(nombre, documento, telefono, correo, contrasena, apellido, direccion, sexo);
    }

}
