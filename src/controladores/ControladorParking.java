/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.SingletonCasillas;
import Singleton.SingletonParking;
import excepciones.PlacaYaRegistradaException;
import java.util.Date;

import modelos.Casilla;
import modelos.Empleado;
import modelos.Local;
import modelos.Puesto;
import modelos.Vehiculo;

import util.Lista;
import util.Queue;

/**
 *
 * @author Asus
 */
public class ControladorParking {

    Casilla[][] casillas;
    Lista<Vehiculo> vehiculos;
    Queue<Vehiculo> vehiculosCola;

    public ControladorParking() {
        casillas = SingletonParking.getINSTANCIA().getCasillas();
        vehiculos = SingletonParking.getINSTANCIA().getVehiculos();
        vehiculosCola = SingletonParking.getINSTANCIA().getVehi();
        if (casillas[0][0] == null) {
            initCasillas();
        }

    }

    private void initCasillas() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = new Casilla();
                SingletonParking.getINSTANCIA().escribirCasilla();
                SingletonParking.getINSTANCIA().escribirVehiculo();

            }
        }

    }

    public Queue<Vehiculo> getVehiculosCola() {
        return vehiculosCola;
    }

    public void agregarPuesto(Puesto puesto, int fila, int columna) {
        casillas[fila][columna].setPuesto(puesto);
        casillas[fila][columna].setEstado(Casilla.OCUPADO);
        registrarEntrada(puesto.getVehiculo());
        SingletonParking.getINSTANCIA().escribirCasilla();
        SingletonParking.getINSTANCIA().escribirVehiculo();

    }

    public boolean agregarAutoCliente(Puesto puesto) throws PlacaYaRegistradaException {
        Vehiculo aux = buscarVehiculo(puesto.getVehiculo().getPlaca());
        if (aux != null) {
            throw new PlacaYaRegistradaException();
        } else {
            for (int i = 0; i < casillas.length; i++) {
                for (int j = 0; j < casillas[i].length; j++) {
                    if (casillas[i][j].getEstado().equalsIgnoreCase(Casilla.DISPONIBLE)) {
                        casillas[i][j].setPuesto(puesto);
                        casillas[i][j].setEstado(Casilla.OCUPADO);
                        registrarEntrada(puesto.getVehiculo());
                        SingletonParking.getINSTANCIA().escribirCasilla();
                        SingletonParking.getINSTANCIA().escribirVehiculo();
                        return true;
                    }
                }
            }
            registrarEntrada(puesto.getVehiculo());
            return false;
        }

    }

    public void cancelarAsiento(Casilla casilla) {
        casilla.setEstado(Casilla.DISPONIBLE);
        casilla = new Casilla();
        SingletonParking.getINSTANCIA().escribirCasilla();
        SingletonParking.getINSTANCIA().escribirVehiculo();
    }

    public Casilla obtenerCasilla(int fila, int columna) {
        SingletonParking.getINSTANCIA().escribirCasilla();
        SingletonParking.getINSTANCIA().escribirVehiculo();
        return casillas[fila][columna];
    }

    public boolean registrarEntrada(Vehiculo vehiculo) throws PlacaYaRegistradaException {
        Vehiculo aux = buscarVehiculo(vehiculo.getPlaca());
        if (aux != null) {
            throw new PlacaYaRegistradaException();
        } else {
            if (vehiculos.Size() <= 50) {
                if (vehiculo.getTipo().equalsIgnoreCase("Motocicleta")) {
                    vehiculos.add(vehiculo);
                    vehiculo.setPrecioTarifa(1000);
                    SingletonParking.getINSTANCIA().escribirCasilla();
                    SingletonParking.getINSTANCIA().escribirVehiculo();
                    return true;
                } else {
                    vehiculos.add(vehiculo);
                    vehiculo.setPrecioTarifa(3000);
                    SingletonParking.getINSTANCIA().escribirCasilla();
                    SingletonParking.getINSTANCIA().escribirVehiculo();
                    return true;
                }
            } else {
                vehiculosCola.enqueue(vehiculo);
                SingletonParking.getINSTANCIA().escribirCasilla();
                SingletonParking.getINSTANCIA().escribirVehiculo();
                SingletonParking.getINSTANCIA().escribirCola();
                return false;
            }
        }

    }

    public Vehiculo buscarVehiculo(String placa) {
        for (int i = 0; i < vehiculos.Size(); i++) {
            if (vehiculos.obtener(i).getPlaca().equalsIgnoreCase(placa)) {
                return vehiculos.obtener(i);
            }
        }
        return null;

    }

    public Lista<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public boolean registrarSalida(String placa) {
        for (int i = 0; i < vehiculos.Size(); i++) {
            if (vehiculos.obtener(i) != null && vehiculos.obtener(i).getPlaca().equalsIgnoreCase(placa)) {
                if (vehiculos.Size() == 50) {
                    vehiculos.eliminar(i);
                    int[] indices = retornarLocal(placa);
                    Vehiculo vehi = vehiculosCola.dequeue();
                    Puesto puesto = new Puesto(vehi);
                    agregarPuesto(puesto, indices[0], indices[1]);

                    SingletonParking.getINSTANCIA().escribirCasilla();
                    SingletonParking.getINSTANCIA().escribirVehiculo();
                    return true;
                }
                vehiculos.eliminar(i);
                retornarLocal(placa);

                SingletonParking.getINSTANCIA().escribirCasilla();
                SingletonParking.getINSTANCIA().escribirVehiculo();
                return true;
            }
        }
        return false;
    }

    public int[] retornarLocal(String placa) {
        Casilla[][] locales = SingletonParking.getINSTANCIA().getCasillas();
        int[] nuevo = new int[2];
        for (int i = 0; i < locales.length; i++) {
            for (int j = 0; j < locales[i].length; j++) {
                Casilla casilla = obtenerCasilla(i, j);
                Puesto puesto = casilla.getPuesto();
                if (puesto != null) {
                    if (puesto.getVehiculo().getPlaca().equalsIgnoreCase(placa)) {
                        cancelarAsiento(casilla);
                        nuevo[0] = i;
                        nuevo[1] = j;

                        SingletonParking.getINSTANCIA().escribirCasilla();
                        SingletonParking.getINSTANCIA().escribirVehiculo();
                        return nuevo;
                    }
                }

            }
        }
        return null;

    }

    public Vehiculo calcularTiquete(Vehiculo vehiculo) {
        Date fecha = new Date();
        int horas = fecha.getHours() - vehiculo.getHoraEntrada().getHours();
        if (horas == 0) {
            vehiculo.setHorasTotales(1);
        } else {
            vehiculo.setHorasTotales(horas);
        }
        double total = vehiculo.getHorasTotales() * vehiculo.getPrecioTarifa();
        vehiculo.setTotal(total);
        return vehiculo;
    }

}
