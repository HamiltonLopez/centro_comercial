/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.Serializable;
import java.util.Date;

public class Vehiculo implements Serializable {

    private String tipo;
    private String placa;
    private Date horaEntrada;
    private Date horaSalida;
    private double precioTarifa;
    private double total;
    private int horasTotales;

    public Vehiculo(String tipo, String placa, Date horaEntrada) {
        this.tipo = tipo;
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        horaSalida = null;
    }

    public String getTipo() {
        return tipo;
    }

    public int getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(int horasTotales) {
        this.horasTotales = horasTotales;
    }
    

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public double getPrecioTarifa() {
        return precioTarifa;
    }

    public void setPrecioTarifa(double precio) {
        this.precioTarifa = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
