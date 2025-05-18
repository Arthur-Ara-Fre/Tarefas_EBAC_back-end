package br.com.afreitas.Factory;

import br.com.afreitas.Cars.MercedesBenz;
import br.com.afreitas.Cars.Toyota;

/**
 * @author arthur.freitas
 */
public class ContratosFactory extends Factory {

    @Override
    Car retrieveCar(String requestGrade) {
        if ("A".equals(requestGrade)){
            return new MercedesBenz(120, "full", "red");
        }
        else if ("B".equals(requestGrade)){
            return new Toyota(100, "full", "white");
        }
        else
        {
            return null;
        }
    }
}