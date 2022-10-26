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

import modelos.Casilla;


/**
 *
 * @author aleca
 */
public class SingletonCasillas {
    
    Casilla[][] productos;
    private static SingletonCasillas INSTANCIA = new SingletonCasillas();

    public SingletonCasillas() {
        
        productos = leer();
        
    }

    
    public static SingletonCasillas getINSTANCIA() {
        return INSTANCIA;
    }

    public Casilla[][] getLista() {
        return productos;
    }
    
    /**
     * Este metodo nos permite guardar la informacion en un archivo "Usuarios.dat"
     */
      public void escribirObjeto(){
        try{
            FileOutputStream archivo = new FileOutputStream("Casillas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(productos);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    /**
       * Este metodo lee el archiv "Usuarios.dat"
       * @return 
       */
    public Casilla[][] leer(){
        try{
            FileInputStream archivo = new FileInputStream("Casillas.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (Casilla[][]) lector.readObject();
        }catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
            return new Casilla[5][4];
        }
    
    }
    
}
