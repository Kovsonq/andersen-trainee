package Creational.FactoryMethod.Solution;


public class BikeFactory extends TransportFactory {

    @Override
    TransportNew create() {
        return new Bike();
    }
}
