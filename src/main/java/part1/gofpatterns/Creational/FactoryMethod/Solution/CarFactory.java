package part1.gofpatterns.Creational.FactoryMethod.Solution;

public class CarFactory extends TransportFactory {
    @Override
    TransportNew create() {
        return new Car();
    }
}
