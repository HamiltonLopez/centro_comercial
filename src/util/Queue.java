/*
 * To change this license primeroer, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Admin-EAM
 */
public class Queue<T> implements Serializable {
    
      int size;
    private Nodo<T> primero;    
    
    public Queue(){
        this.primero = null;
        this.size = 0;
    }

    public int Size() {
        return size;
    }
    
    
    /**
     * 
     * @return 
     */
    public boolean isEmpty(){
        return this.primero == null;
    }
    
    /**
     * 
     * @param dato 
     */
    public void enqueue(T dato){
        Nodo<T> node = new Nodo(dato);
        
        if( isEmpty() ){
            this.primero = node;
        }
        else{
            Nodo<T> aux = primero;
            while( aux.getNodoSig() != null ){
                aux = aux.nodoSig;
            }
            
            aux.setNodoSig(node);
        }
    }

    /**
     * 
     * @return
     */
    public T dequeue() {
        
        if( isEmpty() ){
            return null;            
        }
        
        T dato = primero.getDato();
        primero = primero.getNodoSig();
        return dato;
    }
    
    /**
     * 
     * @return
     */
    public T peek() {
        if( isEmpty() ){
            return null;            
        }
        
        T element = primero.getDato();
        return element;
    }
    
}
