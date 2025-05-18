package br.com.afreitas.Factory;

import br.com.afreitas.Cars.Fiat;
import br.com.afreitas.Cars.Volkswagen;

/**
 * @author arthur.freitas
 */
public class SemContratosFactory extends Factory{
    @Override
    Car retrieveCar(String requestGrade) {
        if ("A".equals(requestGrade)){
            return new Volkswagen(110, "full", "black");
        } else if ("B".equals(requestGrade)){
            return new Fiat(90, "full", "silver");
        }
        else {
            return null;
        }
    }
}