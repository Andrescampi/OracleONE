import calculos.CalculadoraDeTiempo;
import calculos.FiltroRecomendaciones;
import modelos.Episodio;
import modelos.Pelicula;
import modelos.Serie;

import static java.lang.System.out;

public class Principal {
    public static void main(String[] args) {
        Pelicula pelicula1 = new Pelicula();
        pelicula1.setNombre("cars");
        pelicula1.setFecha(2005);
        pelicula1.setDuracion(3000);
        pelicula1.setIncluido(true);

        pelicula1.muestraFichaTecnica();
        pelicula1.evalua(8.5);
        pelicula1.evalua(2.5);
        out.println(pelicula1.getSuma());
        out.println(pelicula1.promedio());

        Serie theOffice = new Serie();
        theOffice.setNombre("The office");
        theOffice.setFecha(2005);
        theOffice.setDuracion(3000);
        theOffice.setTemporadas(8);
        theOffice.setEpisodios(22);
        theOffice.setMinutosPorEpisodios(20);
        theOffice.muestraFichaTecnica();
        out.println(theOffice.getDuracion());

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(pelicula1);
        calculadora.incluye(theOffice);
        out.println(calculadora.getTiempoTotal());

        FiltroRecomendaciones recomendacion = new FiltroRecomendaciones();
        recomendacion.filtra(pelicula1);

        Episodio episodio1 = new Episodio();
        episodio1.setNumero(1);
        episodio1.setNombre("Michael is gone");
        episodio1.setSerie(theOffice);
        episodio1.setTotalVisualizaciones(2);

        recomendacion.filtra(episodio1);

    }
}
