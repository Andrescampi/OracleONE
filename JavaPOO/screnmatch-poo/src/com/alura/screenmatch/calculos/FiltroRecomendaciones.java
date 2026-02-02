package com.alura.screenmatch.calculos;

import static java.lang.System.out;

public class FiltroRecomendaciones {
    public void filtra(Clasificacion clasificacion){
        if(clasificacion.getClasificacion() >=4){
            out.println("Muy bien evaluado en el momento");
        } else if (clasificacion.getClasificacion() >=2) {
            out.println("Recomendadas");
        }
        else{
            out.println("Agregalas en tu lista de ver después");
        }

    }
}
