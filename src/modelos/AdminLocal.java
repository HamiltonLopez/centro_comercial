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
public class AdminLocal extends Usuario implements Serializable{
    Local local;
    public AdminLocal(String nombre, String documento, String telefono, String correo, String contrasena, String apellido, String direccion, String sexo) {
        super(nombre, documento, telefono, correo, contrasena, apellido, direccion, sexo);
        local = null;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
    
    
}
