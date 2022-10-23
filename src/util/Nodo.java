package util;

import java.io.Serializable;



/**
 *
 * @author lenovo
 */
public class Nodo<T> implements Serializable{

    T dato;
   Nodo<T> nodoSig;

    public Nodo(T dato) {
        this.dato = dato;
        nodoSig = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getNodoSig() {
        return nodoSig;
    }

    public void setNodoSig(Nodo<T> nodoSig) {
        this.nodoSig = nodoSig;
    }

    @Override
    public String toString() {
        return dato+"\n";
    }
    

}
