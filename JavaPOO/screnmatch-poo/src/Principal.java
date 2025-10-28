import modelos.Pelicula;
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
    }
}
