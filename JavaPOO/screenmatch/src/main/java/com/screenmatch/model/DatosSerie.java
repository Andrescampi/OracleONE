package com.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosSerie(@JsonAlias("Title") String titulo,
                         Integer totalDeTemporadas,
                         String evaluacion) {
}
