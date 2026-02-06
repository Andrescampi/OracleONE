package com.alura.modelos;

public class Conversion {
    private String monedaOrigen;
    private String monedaDestino;
    private double cantidad;
    private double tasaCambio;
    private double resultado;

    public Conversion(String monedaOrigen, String monedaDestino, double cantidad, double tasaCambio) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.cantidad = cantidad;
        this.tasaCambio = tasaCambio;
        this.resultado = cantidad * tasaCambio;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getTasaCambio() {
        return tasaCambio;
    }

    public double getResultado() {
        return resultado;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s = %.2f %s (Tasa: %.4f)",
                cantidad, monedaOrigen, resultado, monedaDestino, tasaCambio);
    }
}