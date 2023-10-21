/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.SingletonCC;
import Singleton.SingletonCasillas;
import java.util.Date;
import modelos.Casilla;
import modelos.Local;
import modelos.Venta;
import util.Lista;

/**
 *
 * @author USER
 */
public class ControladorTopVentas {
    
    private static final Casilla[][] locales = SingletonCasillas.getINSTANCIA().getLista();
    private Lista<Venta> masVentas;
    
    public ControladorTopVentas(){
        this.masVentas = new Lista<>();
    }
    
    /**
     * 
     * @param inicio
     * @param fin
     * @return 
     */
    public Local buscarLocal(Date inicio, Date fin){
        Local masVentas = null;
        for (int i = 0; i < locales.length; i++) {
            for (int j = 0; j < locales[i].length; j++) {
                if( locales[i][j].getLocal().getContrato() != null ){
                    Lista<Venta> filtrado = filtrar(locales[i][j].getLocal(), inicio, fin);
                    if( this.masVentas.Size() < filtrado.Size() ){
                        masVentas = locales[i][j].getLocal();
                    }
                }
            }            
        }
        
        return masVentas;
    }
    
    /**
     * 
     * @param negocio
     * @param inicio
     * @param fin
     * @return 
     */
    public Lista<Venta> filtrar(Local negocio, Date inicio, Date fin){        
        Lista<Venta> ventas = new Lista<>();
        
        for (int i = 0; i < negocio.getHistorial().Size(); i++) {
            Venta venta = negocio.getHistorial().obtener(i);
            
            if( venta.getFechaVenta().after(inicio)
                && venta.getFechaVenta().before(fin) ){
                ventas.add(venta);
                
                
            }
        }
        
        return ventas;
    }

    

   
    
}
