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
import java.io.Serializable;
import modelos.CentroComercial;


/**
 *
 * @author Asus
 */
public class SingletonCC implements Serializable {

    CentroComercial centroC;
    private static SingletonCC INSTANCIA = new SingletonCC();

    public SingletonCC() {

        centroC = leer();

    }

    public static SingletonCC getINSTANCIA() {
        return INSTANCIA;
    }

    public CentroComercial getInstancia() {
        return centroC;
    }

    /**
     * Este metodo nos permite guardar la informacion en un archivo
     * "Usuarios.dat"
     */
    public void escribirObjeto() {
        try {
            FileOutputStream archivo = new FileOutputStream("CentroComercial.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(centroC);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Este metodo lee el archiv "Usuarios.dat"
     *
     * @return
     */
    public CentroComercial leer() {
        try {
            FileInputStream archivo = new FileInputStream("CentroComercial.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (CentroComercial) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return new CentroComercial();
        }

    }
}
