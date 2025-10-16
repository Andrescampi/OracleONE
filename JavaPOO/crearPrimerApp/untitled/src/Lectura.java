import java.util.Scanner;

public class Lectura {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el nobre de tu película favorita");
        String pelicula = teclado.nextLine();

        System.out.println("Escribe la fecha de lanzamiento");
        int fecha = teclado.nextInt();

        System.out.println("Escribe la calificación");
        double calificacion = teclado.nextDouble();

        System.out.println(pelicula);
        System.out.println(fecha);
        System.out.println(calificacion);
    }
}
