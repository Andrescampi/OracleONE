import java.util.Scanner;

public class Evaluaciones {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double nota = 0;
        double media = 0;
        int total = 0;
        while (nota != -1) {
            System.out.println("Digite uma nota que le darías a Matrix");
            nota = teclado.nextDouble();
            if (nota != -1) {
                media += nota;
                total++;
            }
        }
        System.out.println("La media de evaluaciones para matrix es: "+media/5);
    }
}
