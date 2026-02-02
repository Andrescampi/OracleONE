package modelos;

import calculos.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion {
    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        return (int) promedio()/2;
    }

    @Override
    public String toString() {
        return "Pelicula: " +this.getNombre() + " (" +this.getFecha() + ")";
    }
}
