/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import java.util.Date;
import util.Lista;

/**
 *
 * @author Asus
 */
public class Concurso implements Serializable {

    private int numeroConcurso;
    private Date fechaInicio;
    private Date fechaFinal;
    private Lista<Cliente> participantes;
    private int valorMinimo;
    private String detalleConcurso;
    private Cliente ganador;

    public Concurso(Date fechaInicio, Date fechaFinal, int valorMinimo, String detalleConcurso) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        participantes = new Lista<>();
        this.valorMinimo = valorMinimo;
        this.detalleConcurso = detalleConcurso;
        numeroConcurso = 0;

    }

    public Cliente getGanador() {
        return ganador;
    }

    public void setGanador(Cliente ganador) {
        this.ganador = ganador;
    }
    

    public int getNumeroConcurso() {
        return numeroConcurso;
    }

    public void setNumeroConcurso(int numeroConcurso) {
        this.numeroConcurso += numeroConcurso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Lista<Cliente> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Lista<Cliente> participantes) {
        this.participantes = participantes;
    }

    public int getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(int valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public String getDetalleConcurso() {
        return detalleConcurso;
    }

    public void setDetalleConcurso(String detalleConcurso) {
        this.detalleConcurso = detalleConcurso;
    }

}
