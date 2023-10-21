/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.SingletonParking;

import modelos.Casilla;
import modelos.Local;
import modelos.Puesto;
import modelos.Vehiculo;

import util.Cola;
import util.Lista;

/**
 *
 * @author Asus
 */
public class ControladorParking {
    Casilla[][] casillas;
    Lista<Vehiculo> vehiculos;
    Cola<Vehiculo> vehiculosCola;
    public ControladorParking() {
        casillas = SingletonParking.getINSTANCIA().getCasillas();
        vehiculos = SingletonParking.getINSTANCIA().getVehiculos();
        vehiculosCola = new Cola<>();
        if (casillas[0][0] == null) {
            initCasillas();
        }

    }

    private void initCasillas() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = new Casilla();
                //Puesto local = new Local();
                //casillas[i][j].setLocal(local);
                SingletonParking.getINSTANCIA().escribirCasilla();
                SingletonParking.getINSTANCIA().escribirVehiculo();

            }
        }
        

    }

    public void agregarPuesto(Puesto puesto, int fila, int columna) {
        casillas[fila][columna].setPuesto(puesto);
        casillas[fila][columna].setEstado(Casilla.OCUPADO);
         SingletonParking.getINSTANCIA().escribirCasilla();
         SingletonParking.getINSTANCIA().escribirVehiculo();

    }

    public Casilla obtenerCasilla(int fila, int columna) {
       SingletonParking.getINSTANCIA().escribirCasilla();
       SingletonParking.getINSTANCIA().escribirVehiculo();
        return casillas[fila][columna];
    }
    public boolean registrarEntrada(Vehiculo vehiculo){
        if(vehiculos.Size()<=50){
             if(vehiculo.getTipo().equals("Moto")){
            vehiculos.add(vehiculo);
            vehiculo.setPrecio(1000);
              SingletonParking.getINSTANCIA().escribirCasilla();
              SingletonParking.getINSTANCIA().escribirVehiculo();
            return true;
        }else{
            vehiculos.add(vehiculo);
            vehiculo.setPrecio(3000);
              SingletonParking.getINSTANCIA().escribirCasilla();
              SingletonParking.getINSTANCIA().escribirVehiculo();
            return true;
        }
        }else{
           vehiculosCola.enQueue(vehiculo);
           return false;
        }
       
    }

    public Lista<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    
}
