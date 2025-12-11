import modelos.Cancion;
import modelos.MisFavoritos;

public class Principal {
    public static void main(String[] args) {
        Cancion cancion = new Cancion();
        cancion.setTitulo("Despacito");
        cancion.setCantante("Luis Fonsi");

        for (int i = 0; i < 100; i++) {
            cancion.darLike();
        }
        for (int i = 0; i < 2000; i++) {
            cancion.reproducir();
        }

        System.out.println("Total reproducciones: " + cancion.getTotalReproducciones());
        System.out.println("Total me gusta: " + cancion.getTotalDeMeGusta());

        MisFavoritos misFavoritos = new MisFavoritos();
        misFavoritos.adicione(cancion);
    }
}
