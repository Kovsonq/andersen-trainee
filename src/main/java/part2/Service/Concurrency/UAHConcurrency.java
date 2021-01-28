package part2.Service.Concurrency;

public class UAHConcurrency implements Concurrency {
    String internationalCode = "UAH";
    String name = "Ukraine hryvnia";
    Double course = 10.85;
    Double multiplicity = 1.28;


    @Override
    public double countPrice(double price) {
        return price * course * multiplicity;
    }
}
