package com.alura.screenmatch.calculos;

import com.alura.screenmatch.modelos.Titulo;

public class CalculadoraDeTiempo {
    private int tiempoTotal;

    public void incluye(Titulo titulo){
        this.tiempoTotal += titulo.getDuracion();
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }
}
