
package modelos;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class EmpleadoGeneral extends Usuario implements Serializable {
    private String cargo;
    public EmpleadoGeneral(String nombre, String documento, String telefono, String correo, String contrasena, String apellido, String direccion, String sexo, String cargo) {
        super(nombre, documento, telefono, correo, contrasena, apellido, direccion, sexo);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
    
}
