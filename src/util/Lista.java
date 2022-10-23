package util;

import exepciones.ListaVaciaException;

import java.io.Serializable;



/**
 *
 * @author lenovo
 */
public class Lista<T> implements Serializable{

    private Nodo<T> primero;
    private int size;

    public Lista() {
        this.primero = null;
        this.size = 0;
    }

    public int Size() {
        return this.size;
    }

    public void add(T dato) {
        Nodo<T> nuevo = new Nodo(dato);
        if (primero == null) {
            primero = nuevo;
            size++;
        } else {
            Nodo<T> aux = primero;
            while (aux.getNodoSig() != null) {
                aux = aux.getNodoSig();
            }
            aux.setNodoSig(nuevo);
            size++;
        }
    }

    public T obtener(int index)throws ListaVaciaException {
        if (primero == null) {
          
                    
            throw new ListaVaciaException();
        } else {
          
                Nodo<T> aux = primero;
                int contador = 0;
                while (contador < index && aux.getNodoSig() != null) {
                    aux = aux.getNodoSig();
                    contador++;
                }
                return aux.getDato();
            

        }
    }

    public void eliminar(int index) throws ListaVaciaException{
        if (primero == null) {
            throw new ListaVaciaException();
        } else if (index == 0) {

            primero = primero.getNodoSig();
            size--;

        } else {
            int contador = 0;
            Nodo<T> aux = primero;
            while (contador < index - 1) {
                aux = aux.getNodoSig();
                contador++;
            }
            aux.setNodoSig(aux.getNodoSig().getNodoSig());
            size--;
        }
    }

    public void agregarPosicion(T dato, int index) throws ListaVaciaException{
        Nodo<T> nuevo = new Nodo(dato);
        if (primero == null) {
            throw new ListaVaciaException();
        } else if (index == 0) {
            nuevo.setNodoSig(primero);
            primero = nuevo;
            size++;

        } else {
            Nodo<T> aux = primero;
            int contador = 0;
            while (contador < index) {
                aux = aux.getNodoSig();
                contador++;
            }
            nuevo.setNodoSig(aux.getNodoSig());
            aux.setNodoSig(nuevo);
            size++;
        }
    }
}
