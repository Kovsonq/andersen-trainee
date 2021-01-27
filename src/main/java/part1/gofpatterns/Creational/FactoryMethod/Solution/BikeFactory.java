package part1.gofpatterns.Creational.FactoryMethod.Solution;


public class BikeFactory extends TransportFactory {

    @Override
    TransportNew create() {
        return new Bike();
    }
}
