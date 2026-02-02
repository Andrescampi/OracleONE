package com.alura.tarjetaCompras;

import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese el valor de la tarjeta: ");
        double limite = lectura.nextDouble();
        TarjetaCredito tarjetaCredito = new TarjetaCredito(limite);

        int salir = 1;
        while (salir != 0) {
            System.out.println("Escriba la descripción de la compra: ");
            String descripcion = lectura.next();

            System.out.println("Escriba el valor de la compra: ");
            double valor = lectura.nextDouble();

            Compra compra = new Compra(valor, descripcion);
            boolean compraRealizada = tarjetaCredito.lanzarCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada");
                System.out.println("Escriba 0 para salir o 1 para continuar");
                salir = lectura.nextInt();
            }
            else{
                System.out.println("Saldo insuficiente");
                salir = 0;
            }
            System.out.println("**********************************************************");
            System.out.println("COMPRAS REALIZADAS:\n");
            Collections.sort(tarjetaCredito.getListaDeCompras());
            for (Compra compra1 : tarjetaCredito.getListaDeCompras()){
                System.out.println(compra1.getDescripcion()+" - "+compra1.getValor());
            }
            System.out.println("************************************************************");
            System.out.println("\nSaldo de la tarjeta: "+tarjetaCredito.getSaldo());
        }
    }
}
