import java.util.Scanner;

import static java.lang.System.*;

public class banco {
    static Scanner sc = new Scanner(in);
    static String nombre;
    static String tipoDeCuenta;
    static double saldo;

    public static void main(String[] args) {
        out.println("Ingrese el nombre del usuario: ");
        nombre = sc.nextLine();

        out.println("Ingrese el tipo de cuenta del usuario: ");
        tipoDeCuenta = sc.nextLine();

        out.println("Ingrese el saldo del usuario: ");
        saldo = sc.nextDouble();

        int option;
       do {
           String mensaje = """
                **********************************
                
                Nombre del usuario: %s
                Tipo de cuenta: %s
                Saldo: %.2f
                
                ***********************************
                ** Escriba el número de la opción deseada **
                1. Consultar saldo
                2. Retirar
                3. Depositar
                4. salir
                """.formatted(nombre, tipoDeCuenta, saldo);
            out.println(mensaje);
            option = sc.nextInt();
            switch(option){
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    retirar();
                    break;
                case 3:
                    depositar();
                    break;
                default:
                case 4:
                    out.println("Muchas gracias por usar los servicios de Rabanitoscompany");
            }

        } while (option != 4);

    }
    public static double consultarSaldo(){
        out.println("Su saldo es: " + saldo );
        return saldo;
    }
    public static double retirar(){
        out.println("Digite el monto que desea retirar: ");
        double retiro = sc.nextDouble();
        if(retiro > saldo){
            out.println("Saldo insuficiente mi chino");
        }else {
            saldo -= retiro;
        }
        return saldo;
    }
    public static double depositar(){
        out.println("Digite el monto que desea depositar: ");
        double deposito = sc.nextDouble();
        saldo += deposito;
        return saldo;
    }
}
