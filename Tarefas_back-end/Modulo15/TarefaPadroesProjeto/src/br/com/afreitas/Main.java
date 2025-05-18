package br.com.afreitas;

import br.com.afreitas.Factory.Car;
import br.com.afreitas.Factory.ContratosFactory;
import br.com.afreitas.Factory.Factory;
import br.com.afreitas.Factory.SemContratosFactory;

/**
 * @author arthur.freitas
 */
public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("A", true);
        Factory factory = getFactory(cliente);
        Car car = factory.create(cliente.getGradeRequest());
        car.startEngine();

        Cliente cliente1 = new Cliente("B", true);
        factory = getFactory(cliente1);
        Car car1 = factory.create(cliente1.getGradeRequest());
        car1.startEngine();

        Cliente cliente2 = new Cliente("A", false);
        factory = getFactory(cliente2);
        Car car2 = factory.create(cliente2.getGradeRequest());
        car2.startEngine();

        Cliente cliente3 = new Cliente("B", false);
        factory = getFactory(cliente3);
        Car car3 = factory.create(cliente3.getGradeRequest());
        car3.startEngine();
    }

    private static Factory getFactory(Cliente cliente) {
        if(cliente.getHasCompanyContract()==true){
            return new ContratosFactory();
        }
        else {
            return new SemContratosFactory();
        }
    }
}