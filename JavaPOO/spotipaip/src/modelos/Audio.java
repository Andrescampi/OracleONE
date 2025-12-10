package modelos;

import comportamientos.AgregarPlaylist;
import comportamientos.DarLike;
import comportamientos.Reproducible;

import static java.lang.System.out;

public abstract class Audio implements DarLike, Reproducible, AgregarPlaylist{
    protected int duracion;
    protected String titulo;
    protected int totalReproducciones;
    protected int meGusta;
    protected int suma;
    protected int totalNotas;

    public void mostrarDetalles(){
        out.println("Titulo: " + titulo);
        out.println("Duracion: " + getDuracion());
        out.println("TotalReproducciones: " + getTotalReproducciones());
    }

    public  void evalua(double nota){
        suma += nota;
        totalNotas++;
    }

    public double promedio(){
        return suma/totalNotas;
    }
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
        meGusta++;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getMeGusta() {
        return meGusta;
    }

    public void setMeGusta(int meGusta) {
        this.meGusta = meGusta;
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
