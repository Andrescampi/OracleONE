package com.screenmatch.principal;

import com.screenmatch.model.DatosEpisodio;
import com.screenmatch.model.DatosSerie;
import com.screenmatch.model.DatosTemporada;
import com.screenmatch.model.Episodio;
import com.screenmatch.service.ConsumoAPI;
import com.screenmatch.service.ConvierteDatos;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    Scanner teclado = new Scanner(System.in);

    private final String URL_BASE = "https://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=4fc7c187";

    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    public void muestraElMenu(){
        System.out.println("Escribe el nombre de la série que deseas buscar");
        var nombreSerie = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
       // System.out.println(datos);

        List<DatosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= datos.totalTemporadas(); i++) {
            json = consumoAPI.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
            DatosTemporada datosTemporada = conversor.obtenerDatos(json, DatosTemporada.class);
            temporadas.add(datosTemporada);
        }
        //temporadas.forEach(System.out::println);

        for (int i = 0; i < datos.totalTemporadas(); i++) {
            List<DatosEpisodio> episodiosTemporadas = temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporadas.size(); j++) {
               // System.out.println(episodiosTemporadas.get(j).titulo());
            }
        }

        //Mejoria usando funciones lambda
        //temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        //Convertir todas las informaciones a una lista de tipo DatosEpisodios

        List<DatosEpisodio> datosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        //Top 5 episodios
//        System.out.println("Top 5 episodios");
//        datosEpisodios.stream()
//                .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
//                .peek(e -> System.out.println("Primer filtro N/A"+e))
//                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
//                .peek(e -> System.out.println("Segunda ordenación (M>m)"+e))
//                .map(e -> e.titulo().toUpperCase())
//                .peek(e -> System.out.println("Tercer filtro Mayuscula"+e))
//                .limit(5)
//                .forEach(System.out::println);

        //Conviritiendo los datos a una lista del tipo Episodio
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toList());

        //episodios.forEach(System.out::println);

//        System.out.println("a partir de que año deseas ver los episodios?");
//        var fecha = teclado.nextInt();
//        teclado.nextLine();
//
//        LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        episodios.stream()
//                .filter(e -> e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
//                .forEach(e -> System.out.println(
//                        "Temporada: " + e.getTemporada() +
//                                " Episodio: " + e.getTitulo() +
//                                " Fecha de Lanzamiento: " + e.getFechaDeLanzamiento().format(formatter)
//                ));

        //Busca episodios por pedazo del titulo
//        System.out.println("Digite el titulo del episodio que desea ver");
//        var pedazoTitulo = teclado.nextLine();
//        Optional<Episodio> episodioBuscado = episodios.stream()
//                .filter(e -> e.getTitulo().contains(pedazoTitulo))
//                .findFirst();
//        if (episodioBuscado.isPresent()) {
//            System.out.println("El episodio se encontró, es el siguiente: " + episodioBuscado.get());
//        }
//        else{
//            System.out.println("Episodio no encotrado :(");
//        }

        Map<Integer, Double> evaluacionesPorTemporada = episodios.stream()
                .filter(e -> e.getEvaluacion() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getEvaluacion)));
        System.out.println(evaluacionesPorTemporada);

        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getEvaluacion() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
        System.out.println("Media " + est.getAverage());
        System.out.println("Mejor episódio: " + est.getMax());
        System.out.println("Peor episódio: " + est.getMin());
        System.out.println("Cantidad " + est.getCount());
    }
}
