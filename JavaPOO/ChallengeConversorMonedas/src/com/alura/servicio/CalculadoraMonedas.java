package com.alura.servicio;

import com.alura.modelos.Conversion;
import com.alura.modelos.RespuestaAPI;

public class CalculadoraMonedas {
    private final ServicioAPI servicioAPI;

    public CalculadoraMonedas() {
        this.servicioAPI = new ServicioAPI();
    }

    public Conversion convertirDolarA(double cantidad, String monedaDestino) throws Exception {
        RespuestaAPI respuesta = servicioAPI.obtenerTasasCambio();
        double tasa = servicioAPI.obtenerTasa(respuesta, monedaDestino);

        if (tasa == 0.0) {
            throw new IllegalArgumentException("Moneda no encontrada: " + monedaDestino);
        }

        return new Conversion("USD", monedaDestino, cantidad, tasa);
    }

    public Conversion convertirADolar(double cantidad, String monedaOrigen) throws Exception {
        RespuestaAPI respuesta = servicioAPI.obtenerTasasCambio();
        double tasaOrigen = servicioAPI.obtenerTasa(respuesta, monedaOrigen);

        if (tasaOrigen == 0.0) {
            throw new IllegalArgumentException("Moneda no encontrada: " + monedaOrigen);
        }

        // Para convertir a dólar, dividimos por la tasa
        double tasaInversa = 1.0 / tasaOrigen;
        return new Conversion(monedaOrigen, "USD", cantidad, tasaInversa);
    }

    public Conversion convertirEntre(double cantidad, String monedaOrigen, String monedaDestino) throws Exception {
        RespuestaAPI respuesta = servicioAPI.obtenerTasasCambio();
        double tasaOrigen = servicioAPI.obtenerTasa(respuesta, monedaOrigen);
        double tasaDestino = servicioAPI.obtenerTasa(respuesta, monedaDestino);

        if (tasaOrigen == 0.0) {
            throw new IllegalArgumentException("Moneda origen no encontrada: " + monedaOrigen);
        }
        if (tasaDestino == 0.0) {
            throw new IllegalArgumentException("Moneda destino no encontrada: " + monedaDestino);
        }

        double cantidadEnDolares = cantidad / tasaOrigen;
        double tasaCruzada = tasaDestino / tasaOrigen;

        return new Conversion(monedaOrigen, monedaDestino, cantidad, tasaCruzada);
    }
}

