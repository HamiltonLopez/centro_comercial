/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.SingletonCasillas;
import modelos.Casilla;
import modelos.Local;

/**
 *
 * @author Asus
 */
public class ControladorCasilla {

    Casilla[][] casillas;

    public ControladorCasilla() {
        casillas = SingletonCasillas.getINSTANCIA().getLista();

        if (casillas[0][0] == null) {
            initCasillas();
        }

    }

    /**
     * Este metodo permite agregar las casillas
     */
    private void initCasillas() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = new Casilla();
                Local local = new Local();
                casillas[i][j].setLocal(local);
                SingletonCasillas.getINSTANCIA().escribirObjeto();

            }
        }
        SingletonCasillas.getINSTANCIA().escribirObjeto();

    }

    /**
     * Este metodo nos permite agregar un local en un posicion de las casillas
     * @param local el objeto al cual vamos a agregar en las casilas
     * @param fila es la posicion vertical en la que guardaremos el local
     * @param columna es la posicion horizontal en la que guardaremos el local
     */
    public void agregarLocal(Local local, int fila, int columna) {
        casillas[fila][columna].setLocal(local);
        casillas[fila][columna].setEstado(Casilla.OCUPADO);
        SingletonCasillas.getINSTANCIA().escribirObjeto();

    }

    /**
     * Este método permite buscar u obtener una casilla dada la fila y la columna
     * @param fila
     * @param columna
     * @return retorna la casilla que buscamos
     */
    public Casilla obtenerCasilla(int fila, int columna) {
        SingletonCasillas.getINSTANCIA().escribirObjeto();
        return casillas[fila][columna];
    }
}
