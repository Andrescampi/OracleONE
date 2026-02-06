package com.alura.principal;


import com.alura.modelos.Conversion;
import com.alura.servicio.CalculadoraMonedas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorMonedas {
    private static final CalculadoraMonedas calculadora = new CalculadoraMonedas();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Monedas =]");
        System.out.println("************************************************\n");

        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();

            if (opcion == 7) {
                System.out.println("\n¡Gracias por usar el Conversor de Monedas!");
                continuar = false;
            } else if (opcion >= 1 && opcion <= 6) {
                procesarConversion(opcion);
            } else {
                System.out.println("Opción no válida. Por favor, elija una opción del 1 al 7.\n");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("1) Dólar >>> Peso argentino");
        System.out.println("2) Peso argentino >>> Dólar");
        System.out.println("3) Dólar >>> Real brasileño");
        System.out.println("4) Real brasileño >>> Dólar");
        System.out.println("5) Dólar >>> Peso colombiano");
        System.out.println("6) Peso colombiano >>> Dólar");
        System.out.println("7) Salir");
        System.out.print("Elija una opción válida: ");
    }


    private static int leerOpcion() {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            return opcion;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Limpiar buffer
            return -1;
        }
    }

    private static double leerCantidad() {
        while (true) {
            try {
                System.out.print("Ingrese el valor que desea convertir: ");
                double cantidad = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer

                if (cantidad < 0) {
                    System.out.println("Por favor ingrese un valor positivo.");
                    continue;
                }

                return cantidad;
            } catch (InputMismatchException e) {
                System.out.println("Por favor ingrese un número válido.");
                scanner.nextLine(); // Limpiar buffer
            }
        }
    }


    private static void procesarConversion(int opcion) {
        double cantidad = leerCantidad();

        try {
            Conversion resultado = null;

            switch (opcion) {
                case 1: // Dólar a Peso argentino
                    resultado = calculadora.convertirDolarA(cantidad, "ARS");
                    break;
                case 2: // Peso argentino a Dólar
                    resultado = calculadora.convertirADolar(cantidad, "ARS");
                    break;
                case 3: // Dólar a Real brasileño
                    resultado = calculadora.convertirDolarA(cantidad, "BRL");
                    break;
                case 4: // Real brasileño a Dólar
                    resultado = calculadora.convertirADolar(cantidad, "BRL");
                    break;
                case 5: // Dólar a Peso colombiano
                    resultado = calculadora.convertirDolarA(cantidad, "COP");
                    break;
                case 6: // Peso colombiano a Dólar
                    resultado = calculadora.convertirADolar(cantidad, "COP");
                    break;
            }

            if (resultado != null) {
                System.out.println("El valor " + String.format("%.2f", resultado.getCantidad()) +
                        " [" + resultado.getMonedaOrigen() + "] corresponde al valor final de =>>> " +
                        String.format("%.2f", resultado.getResultado()) +
                        " [" + resultado.getMonedaDestino() + "]");
            }

        } catch (Exception e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        }

        System.out.println();
    }
}
