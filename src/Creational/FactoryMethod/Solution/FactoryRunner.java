package Creational.FactoryMethod.Solution;

public class FactoryRunner {
    public static void main(String[] args) {
        TransportFactory factory = createTransportBySpeciality("cAR");
        TransportNew transportNew = factory.create();
        System.out.println(transportNew.drive());


        factory = new BikeFactory();
        transportNew = factory.create();
        System.out.println(transportNew.drive() );
    }

    static TransportFactory createTransportBySpeciality(String speciality){
        if (speciality.equalsIgnoreCase("bike")){
            return new BikeFactory();
        }  else if (speciality.equalsIgnoreCase("car")) {
            return new CarFactory();
        } else {
            throw new RuntimeException(speciality + " is unknown");
        }
    }
}
