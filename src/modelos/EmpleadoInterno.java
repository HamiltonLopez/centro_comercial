
package modelos;

/**
 *
 * @author Asus
 */
public class EmpleadoInterno extends Usuario {
    private String cargo;
    public EmpleadoInterno(String nombre, String documento, String telefono, String correo, String contrasena, String apellido, String direccion, String sexo, String cargo) {
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
