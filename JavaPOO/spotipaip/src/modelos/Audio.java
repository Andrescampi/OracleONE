package modelos;

import comportamientos.AgregarPlaylist;
import comportamientos.DarLike;
import comportamientos.Reproducible;

import static java.lang.System.out;

public abstract class Audio implements DarLike, Reproducible, AgregarPlaylist {
    protected String titulo;
    protected int totalReproducciones;
    protected int totalDeMeGusta;
    protected int clasificacion;


    @Override
    public void reproducir() {
        totalReproducciones++;
    }

    @Override
    public void agregarPlaylist() {
        out.println("Agregando playlist...");
    }

    @Override
    public void darLike() {
        totalDeMeGusta++;
    }

    public int getTotalDeMeGusta() {
        return totalDeMeGusta;
    }

    public void setTotalDeMeGusta(int totalDeMeGusta) {
        this.totalDeMeGusta = totalDeMeGusta;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getTotalReproducciones() {
        return totalReproducciones;
    }

    public void setTotalReproducciones(int totalReproducciones) {
        this.totalReproducciones = totalReproducciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
