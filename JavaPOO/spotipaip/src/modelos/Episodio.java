package modelos;

import calculos.Clasificacion;

public class Episodio implements Clasificacion {
    private String nombre;
    private int numero;
    private Podcast podcast;
    private int totalVisualizaciones;

    @Override
    public int getClasificacion() {
        if (totalVisualizaciones < 50) {
            return 0;
        } else if (totalVisualizaciones > 400) {
            return 5;
        }
        return 3;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotalVisualizaciones() {
        return totalVisualizaciones;
    }

    public void setTotalVisualizaciones(int totalVisualizaciones) {
        this.totalVisualizaciones = totalVisualizaciones;
    }

    public Podcast getPodcast() {
        return podcast;
    }

    public void setPodcast(Podcast podcast) {
        this.podcast = podcast;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
