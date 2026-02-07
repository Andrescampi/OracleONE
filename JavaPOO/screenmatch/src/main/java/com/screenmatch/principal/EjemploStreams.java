package com.screenmatch.principal;

import java.util.Arrays;
import java.util.List;

public class EjemploStreams {

    public void muestraEjemplo(){
        List<String> nombres = Arrays.asList("Sofia", "Mariana", "Zeus", "Linda", "Jose");
        nombres.stream()
                .sorted()
                .filter(n -> n.startsWith("S"))
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);
    }
}
