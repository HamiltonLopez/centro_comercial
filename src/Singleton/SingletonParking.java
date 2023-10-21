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
import modelos.Vehiculo;
import util.Lista;
import util.Queue;

/**
 *
 * @author Asus
 */
public class SingletonParking {
    Queue<Vehiculo> vehi;
    Casilla[][] puestos;
    Lista<Vehiculo> vehiculos;
    private static SingletonParking INSTANCIA = new SingletonParking();

    public SingletonParking() {
        vehiculos = leerVehiculo();
        puestos = leerCasilla();
        vehi = leerCola();

    }

    public static SingletonParking getINSTANCIA() {
        return INSTANCIA;
    }

    public Casilla[][] getCasillas() {
        return puestos;
    }

    public Lista<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public Queue<Vehiculo> getVehi() {
        return vehi;
    }

    
    /**
     * Este metodo nos permite guardar la informacion en un archivo
     * "Usuarios.dat"
     */
    public void escribirCasilla() {
        try {
            FileOutputStream archivo = new FileOutputStream("CasillasUno.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(puestos);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Este metodo lee el archiv "Usuarios.dat"
     *
     * @return
     */
    public Casilla[][] leerCasilla() {
        try {
            FileInputStream archivo = new FileInputStream("CasillasUno.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (Casilla[][]) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return new Casilla[7][15];
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void escribirVehiculo() {
        try {
            FileOutputStream archivo = new FileOutputStream("Vehiculos.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(vehiculos);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Este metodo lee el archiv "Usuarios.dat"
     *
     * @return
     */
    public Lista<Vehiculo> leerVehiculo() {
        try {
            FileInputStream archivo = new FileInputStream("Vehiculos.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (Lista<Vehiculo>) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return new Lista<>();
        }

    }
    
     ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void escribirCola() {
        try {
            FileOutputStream archivo = new FileOutputStream("VehiculosC.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(vehi);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Este metodo lee el archiv "Usuarios.dat"
     *
     * @return
     */
    public Queue<Vehiculo> leerCola() {
        try {
            FileInputStream archivo = new FileInputStream("VehiculosC.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (Queue<Vehiculo>) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return new Queue<>();
        }

    }

}
