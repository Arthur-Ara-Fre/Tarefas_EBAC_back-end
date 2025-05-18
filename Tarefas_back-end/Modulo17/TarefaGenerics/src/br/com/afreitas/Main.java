package br.com.afreitas;

import br.com.afreitas.carros.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arthur.freitas
 */
public class Main {
    public static void main(String[] args) {
        List<Carros> carros = new ArrayList<>();

        carros.add(new Fiat());
        carros.add(new Ford());
        carros.add(new Volkswagen());
        carros.add(new Audi());
        carros.add(new BMW());

        System.out.println(carros);



    }
}