package modelos;

import comportamientos.Clasificacion;

public class Cancion extends Audio implements Clasificacion {
    private String cantante;
    private String genero;

    @Override
    public int getClasificacion() {
        if (getTotalDeMeGusta() >= 500) {
            return 9;
        }
        return 4;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
