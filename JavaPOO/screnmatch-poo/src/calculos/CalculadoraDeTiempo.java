package calculos;

import modelos.Pelicula;
import modelos.Titulo;

public class CalculadoraDeTiempo {
    private int tiempoTotal;

    public void incluye(Titulo titulo){
        this.tiempoTotal += titulo.getDuracion();
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }
}
