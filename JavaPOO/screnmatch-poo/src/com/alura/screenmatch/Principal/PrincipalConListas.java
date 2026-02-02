package com.alura.screenmatch.Principal;

import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;
import com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula pelicula1 = new Pelicula("cars",2005);
        pelicula1.evalua(9);
        Pelicula scaryMovie = new Pelicula("Scary Movie",2005);
        scaryMovie.evalua(5);
        var favorito = new Pelicula("favorito",2005);
        favorito.evalua(9);
        Serie theOffice = new Serie("The office",2005);
        List<Titulo> lista = new ArrayList<>();
        lista.add(pelicula1);
        lista.add(scaryMovie);
        lista.add(favorito);
        lista.add(theOffice);

        for(Titulo item : lista) {
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
                System.out.println("Clasificacion:" + pelicula.getClasificacion());
            }
        }

        ArrayList<String>listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Luiz");
        listaDeArtistas.add("Ricardo Arjona");
        listaDeArtistas.add("Andres Cepeda");
        System.out.println("Lista de Artistas Desorganizanada: "+listaDeArtistas);
        Collections.sort(listaDeArtistas);
        System.out.println("Lista de Artistas Ordenada: "+listaDeArtistas);

        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getFecha));
        System.out.println("Lista ordenada por fecha: "+lista);
    }
}
