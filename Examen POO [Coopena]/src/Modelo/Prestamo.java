package Modelo;

import java.util.Date;

public class Prestamo {

    // Atributos

    private int NumeroPrestamo;
    private Persona Solicitante;
    private float ValorPrestamo;
    private Date[] FechasDePago;
    private Date FechaAutorizacion;
    private Date FechaTentEntrega;
    private float ValorMaximo;

    // Constructor

    public Prestamo(float pValorPrestamo, float pValorMáximo ) {

        ValorPrestamo = pValorPrestamo;
        ValorMaximo = pValorMáximo;

    }

    // Metodos


    public int getNumeroPrestamo() {
        return NumeroPrestamo;
    }

    public void setNumeroPrestamo(int numeroPrestamo) {
        NumeroPrestamo = numeroPrestamo;
    }

    public Persona getSolicitante() {
        return Solicitante;
    }

    public void setSolicitante(Persona solicitante) {
        Solicitante = solicitante;
    }

    public float getValorPrestamo() {
        return ValorPrestamo;
    }

    public void setValorPrestamo(float valorPrestamo) {
        ValorPrestamo = valorPrestamo;
    }

    public Date[] getFechasDePago() {
        return FechasDePago;
    }

    public void setFechasDePago(Date[] fechasDePago) {
        FechasDePago = fechasDePago;
    }

    public Date getFechaAutorizacion() {
        return FechaAutorizacion;
    }

    public void setFechaAutorizacion(Date fechaAutorizacion) {
        FechaAutorizacion = fechaAutorizacion;
    }

    public Date getFechaTentEntrega() {
        return FechaTentEntrega;
    }

    public void setFechaTentEntrega(Date fachaTentEntrega) {
        FechaTentEntrega = fachaTentEntrega;
    }

    public float getValorMaximo() {
        return ValorMaximo;
    }

    public void setValorMaximo(float valorMaximo) {
        ValorMaximo = valorMaximo;
    }
}
