package com.alura.screenmatch.modelos;

import com.alura.screenmatch.calculos.Clasificacion;

public class Episodio implements Clasificacion {
    private String nombre;
    private int numero;
    private Serie serie;
    private int totalVisualizaciones;

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getClasificacion() {
        if (totalVisualizaciones < 50) {
            return 0;
        } else if (totalVisualizaciones > 400) {
            return 5;
        }
        return 3;
    }

    public int getTotalVisualizaciones() {
        return totalVisualizaciones;
    }

    public void setTotalVisualizaciones(int totalVisualizaciones) {
        this.totalVisualizaciones = totalVisualizaciones;
    }
}
