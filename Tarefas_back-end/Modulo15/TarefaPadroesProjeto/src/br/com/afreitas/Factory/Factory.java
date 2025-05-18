package br.com.afreitas.Factory;

/**
 * @author arthur.freitas
 */
public abstract class Factory {

    public Car create(String requestGrade){
        Car car = retrieveCar(requestGrade);
        prepareCar(car);
        return car;
    }

    private void prepareCar(Car car){
        car.clean();
        car.mechanicCheck();
        car.fuelCar();
    }

    abstract Car retrieveCar(String requestGrade);
}
