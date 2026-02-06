package com.alura.servicio;
import com.google.gson.Gson;
import com.alura.modelos.RespuestaAPI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ServicioAPI {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/b8526fe5bd4810c1013a8338/latest/USD";
    private final HttpClient client;
    private final Gson gson;

    public ServicioAPI() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public RespuestaAPI obtenerTasasCambio() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        try {
            return gson.fromJson(response.body(), RespuestaAPI.class);
        }catch(Exception e){
            throw new IOException("Error al obtener tasas de cambio. Código: " + response.statusCode());
        }

    }

    public double obtenerTasa(RespuestaAPI respuesta, String codigoMoneda) {
        return respuesta.getConversion_rates().getOrDefault(codigoMoneda, 0.0);
    }
}
