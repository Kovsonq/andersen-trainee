package Creational.FactoryMethod.Problem;

public class Factory {

    public static void main(String[] args) {

        Transport vehicle = new Car();
        Transport vehicle2 = new Transport();

        System.out.println(vehicle.drive());
        System.out.println(vehicle2.drive());
    }
}
