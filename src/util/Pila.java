/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import excepciones.PilaVaciaException;

public class Pila<T> {

    Nodo<T> ultimo;

    public Pila() {
        ultimo = null;
    }
    public boolean isEmpty(){
        return ultimo ==null;
    }
    public T pop()throws PilaVaciaException{
        if(isEmpty()){
           throw new PilaVaciaException();
        }else{
            T dato = ultimo.getDato();
            Nodo<T> aux = ultimo.getNodoSig();
            ultimo = null;
            ultimo = aux;
            return dato;
        }
    }
    public void push(T dato){
        Nodo<T> nuevo = new Nodo(dato);
        
        nuevo.nodoSig=ultimo;
        ultimo = nuevo;
               
        
    }
    public T ultimo() throws PilaVaciaException{
        if(isEmpty()){
            throw new PilaVaciaException();
        }else{
            return ultimo.getDato();
        }
    }
     @Override
    public String toString() {
        if(isEmpty()){
            return "Pila vacia";
        }else{
            String resultado = ""; 
            Nodo<T> aux = ultimo;
            while(aux!=null){
                resultado += aux.toString();
                aux = aux.getNodoSig();
                
            }
            return resultado;
        }
    }

}
