package part2.Service.Concurrency;

public class RURConcurrency implements Concurrency {
    String internationalCode = "RUR";
    String name = "Russian ruble";
    Double course = 29.23;
    Double multiplicity = 1.33;

    @Override
    public double countPrice(double price) {
        return price * course * multiplicity;
    }
}
