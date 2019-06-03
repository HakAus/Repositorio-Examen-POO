package Modelo;

import java.util.Date;

public class Prestamo {

    // Atributos
    private static int numeroPrestamos = 1;

    private int NumeroPrestamo;
    private Persona Solicitante;
    private float ValorPrestamo;
    private Date[] FechasDePago;
    private Date FechaAutorizacion;
    private Date FechaTentEntrega;
    private Date FechaLimite;
    private int cuotasPagadas;
    // Constructor

    public Prestamo(Persona pPersona, float pValorPrestamo) {

        NumeroPrestamo = numeroPrestamos;
        ValorPrestamo = pValorPrestamo;
        cuotasPagadas = 0;
        numeroPrestamos++;
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

    public int getCuotasPagadas() {
        return cuotasPagadas;
    }

    public void setCuotasPagadas(int cuotasPagadas) {
        this.cuotasPagadas = cuotasPagadas;
    }

    public Date getFechaLimite() {
        return FechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        FechaLimite = fechaLimite;
    }
}
