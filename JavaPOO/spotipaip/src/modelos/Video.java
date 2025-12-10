package modelos;

import calculos.Clasificacion;

public class Video extends Audio implements Clasificacion{
    private int artista;
    @Override
    public int getClasificacion() {
        return (int) promedio()/2;
    }

    public int getArtista() {
        return artista;
    }

    public void setArtista(int artista) {
        this.artista = artista;
    }
}
