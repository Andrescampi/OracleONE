package com.alura.screenmatch.modelos;

public class Serie extends Titulo {
    int temporadas;
    int episodios;
    int minutosPorEpisodios;

    public Serie(String nombre, int fecha) {
        super(nombre, fecha);
    }

    public int getMinutosPorEpisodios() {
        return minutosPorEpisodios;
    }

    public void setMinutosPorEpisodios(int minutosPorEpisodios) {
        this.minutosPorEpisodios = minutosPorEpisodios;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    @Override
    public int getDuracion(){
        return temporadas * minutosPorEpisodios * episodios;
    }

    @Override
    public String toString() {
        return "Serie: " +this.getNombre() + " (" +this.getFecha() + ")";
    }
}
