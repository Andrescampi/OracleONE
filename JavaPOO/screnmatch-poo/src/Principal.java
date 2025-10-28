public class Principal {
    public static void main(String[] args) {
        Pelicula pelicula1 = new Pelicula();
        pelicula1.nombre = "cars";
        pelicula1.fecha = 2005;
        pelicula1.duracion = 2000;
        pelicula1.incluido = true;

        System.out.println("Mi pelicula es: " + pelicula1.nombre);
    }
}
