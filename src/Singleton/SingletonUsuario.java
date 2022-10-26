/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import modelos.Usuario;
import util.Lista;

/**
 *
 * @author aleca
 */
public class SingletonUsuario {
    
    Lista<Usuario> usuarios;
    private static SingletonUsuario INSTANCIA = new SingletonUsuario();

    public SingletonUsuario() {
        
        usuarios = leerUsuarios();
        
    }

    
    public static SingletonUsuario getINSTANCIA() {
        return INSTANCIA;
    }

    public Lista<Usuario> getUsuarios() {
        return usuarios;
    }
    
    /**
     * Este metodo nos permite guardar la informacion en un archivo "Usuarios.dat"
     */
      public void escribirUsuarios(){
        try{
            FileOutputStream archivo = new FileOutputStream("Usuarios.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(usuarios);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    /**
       * Este metodo lee el archiv "Usuarios.dat"
       * @return 
       */
    public Lista<Usuario> leerUsuarios(){
        try{
            FileInputStream archivo = new FileInputStream("Usuarios.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (Lista<Usuario>) lector.readObject();
        }catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
            return new Lista<>();
        }
    
    }
    
}
