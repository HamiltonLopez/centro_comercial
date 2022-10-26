/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.Casilla;
import modelos.Local;

/**
 *
 * @author Asus
 */
public class ControladorCasilla {

    Casilla[][] casillas;

    public ControladorCasilla() {
        // casillas = SingletonCasillas.getINSTANCIA().getLista();   
        casillas = new Casilla[5][4];
        if (casillas[0][0] == null) {
            initCasillas();
        }

    }

    private void initCasillas() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = new Casilla();
               Local local = new Local();
                casillas[i][j].setLocal(local);
               // SingletonCasillas.getINSTANCIA().escribirObjeto();

            }
        }
        //SingletonCasillas.getINSTANCIA().escribirObjeto();

    }
     public void agregarLocal(Local local, int fila, int columna){
        casillas[fila][columna].setLocal(local);
        casillas[fila][columna].setEstado(Casilla.OCUPADO);
       // SingletonCasillas.getINSTANCIA().escribirObjeto();
     
    }
    public Casilla obtenerCasilla(int fila, int columna){
        //SingletonCasillas.getINSTANCIA().escribirObjeto();

        return casillas[fila][columna];
        
    }
}
