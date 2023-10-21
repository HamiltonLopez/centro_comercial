/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Singleton.SingletonCC;
import modelos.CentroComercial;
import modelos.Cliente;
import modelos.Concurso;
import util.Lista;

/**
 *
 * @author Asus
 */
public class ControladorConcurso {

    Lista<Concurso> concursos;
    CentroComercial cComercial;

    public ControladorConcurso() {
        cComercial = SingletonCC.getINSTANCIA().getInstancia();
        concursos = cComercial.getConcursos();
    }

    /**
     * 
     * @param concurso
     * @return 
     */
    public boolean crearConcurso(Concurso concurso) {
        Concurso nuevo = asignarNumero(concurso);
        concursos.add(nuevo);

        SingletonCC.getINSTANCIA().escribirObjeto();
        return true;
    }

    /**
     * 
     * @param identi
     * @return 
     */
    public boolean eliminarConcurso(int identi) {
        for (int i = 0; i < concursos.Size(); i++) {
            if (concursos.obtener(i).getNumeroConcurso() == identi) {
                concursos.eliminar(i);
                SingletonCC.getINSTANCIA().escribirObjeto();
                return true;
            }
        }

        SingletonCC.getINSTANCIA().escribirObjeto();
        return false;
    }

    /**
     * 
     * @param numero
     * @return 
     */
    public Concurso buscarConcurso(int numero) {
        for (int i = 0; i < concursos.Size(); i++) {
            if (concursos.obtener(i).getNumeroConcurso() == numero) {
                return concursos.obtener(i);
            }
        }
        return null;
    }

    /**
     * 
     * 
     * @return 
     */
    public Lista<Concurso> getConcursos() {
        return concursos;
    }

    public Concurso asignarNumero(Concurso concurso) {
        int valor = concursos.Size();
        concurso.setNumeroConcurso(valor++);
        return concurso;
    }

    public Lista<Concurso> obtenerConcursosPorCliente(Cliente cliente) {

        Lista<Concurso> concu = new Lista<>();
        for (int i = 0; i < concursos.Size(); i++) {
            Concurso concurso = concursos.obtener(i);
            Lista<Cliente> participantes = concurso.getParticipantes();
            for (int j = 0; j < participantes.Size(); j++) {
                if (participantes.obtener(j).getDocumento().equalsIgnoreCase(cliente.getDocumento())) {
                    concu.add(concurso);
                }
            }
        }
        return concu;
    }

    public Cliente elegirCliente(Concurso concurso) {
        if (concurso.getParticipantes().Size() != 0) {
            Lista<Cliente> parti = concurso.getParticipantes();
            int numero = (int) (Math.random() * parti.Size());
            concurso.setGanador(parti.obtener(numero));
            return parti.obtener(numero);
        } else {
            return null;
        }

    }
}
