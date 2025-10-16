import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double nota = 0;
        double media = 0;
        for (int i = 0; i < 5 ; i++) {
            System.out.println("Digite uma nota que le darías a Matrix");
            nota = teclado.nextDouble();
            media += nota;
        }
        System.out.println("La media de evaluaciones para matrix es: "+media/5);
    }
}
