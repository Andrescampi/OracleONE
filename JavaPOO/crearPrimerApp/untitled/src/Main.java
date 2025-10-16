public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenid@ a Screen Match");
        System.out.println("Película: Matrix");

        int fechaDeLanzamiento = 1999;
        boolean incluidoPlan = true;
        double nota = 8.2;

        double media = (8.2 + 6.0 + 9.0)/3;
        System.out.println("Nota: "+media);

        String sinopsis = """
                Matrix es una paradoja
                La mejor película del fin del milenio
                Fué lanzada en: 
                """+fechaDeLanzamiento;
        System.out.println(sinopsis);
        
        int clasificacion = (int) (media/2);
        System.out.println(clasificacion);
    }

}