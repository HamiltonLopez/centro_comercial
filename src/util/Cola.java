/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import exepciones.ColaVaciaException;
import java.io.Serializable;

public class Cola<T> implements Serializable {

    Nodo<T> primero;

    public Cola() {
        this.primero = null;
    }

    public void enQueve(T dato) {
        Nodo<T> nuevo = new Nodo(dato);
        if (isEmpty()) {
            primero = nuevo;

        } else {
            Nodo<T> aux = primero;
            while (aux.getNodoSig() != null) {
                aux = aux.getNodoSig();
            }
            aux.setNodoSig(nuevo);

        }
    }

    public T deQueve() throws ColaVaciaException {
        if (isEmpty()) {
            throw new ColaVaciaException();
        }
        T dato = primero.getDato();
        Nodo<T> aux = primero;
        primero = aux.getNodoSig();

        return dato;
    }

    public T peak() throws ColaVaciaException {
        if (isEmpty()) {
            return null;
        }
        return primero.getDato();
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public T siguiente() {
        if (isEmpty()) {
            throw new ColaVaciaException();
        }
        return primero.getNodoSig().getDato();
    }

}
