package modelos;

import calculos.Clasificacion;

public class Cancion extends Audio implements Clasificacion {
    private String cantante;
    private String genero;

    @Override
    public int getClasificacion() {
        return (int) promedio()/2;
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
