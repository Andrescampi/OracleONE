package com.alura.screenmatch.modelos;

import com.alura.screenmatch.exepcion.ErrorEnConversionDeDuracionException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    private String nombre;
    private int fecha;
    private int duracion;
    private boolean incluido;
    private double suma;
    private int totalNotas;

    public Titulo(String nombre, int fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        this.fecha = Integer.valueOf(miTituloOmdb.year());
        if (miTituloOmdb.runtime().contains("N/A")) {
            throw new ErrorEnConversionDeDuracionException("No puedo convertir la duración," + "Porque contiene un N/A");
        }
        this.duracion = Integer.valueOf(miTituloOmdb.runtime().substring(0, 3).replace(" ", ""));
    }

    public void muestraFichaTecnica(){
        System.out.println("El nombre de la pelicula es: " + nombre);
        System.out.println("Su fecha de lanzamiento fue: "+fecha);
        System.out.println("Su duracion de lanzamiento fue: "+ getDuracion());
    }

    public  void evalua(double nota){
        suma += nota;
        totalNotas++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean isIncluido() {
        return incluido;
    }

    public void setIncluido(boolean incluido) {
        this.incluido = incluido;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public int getTotalNotas() {
        return totalNotas;
    }

    public void setTotalNotas(int totalNotas) {
        this.totalNotas = totalNotas;
    }

    public double promedio(){
        return suma/totalNotas;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "(nombre= " + nombre +
                ", fecha=" + fecha + "Duracion: " + duracion;
    }
}
