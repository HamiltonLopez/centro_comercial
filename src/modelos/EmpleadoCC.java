
package modelos;

/**
 *
 * @author Asus
 */
public class EmpleadoCC extends Usuario  {
    private String cargo;
    public EmpleadoCC(String nombre, String documento, String telefono, String correo, String contrasena, String apellido, String direccion, String sexo, String cargo) {
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
