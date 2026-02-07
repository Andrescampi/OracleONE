package com.screenmatch;

import com.screenmatch.principal.EjemploStreams;
import com.screenmatch.principal.Principal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
@SpringBootApplication
public class ScreenmatchApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       Principal principal = new Principal();
       principal.muestraElMenu();

        //EjemploStreams e = new EjemploStreams();
        //e.muestraEjemplo();
    }
}
