package part2.Service.Concurrency;

public class USDConcurrency implements Concurrency {
    String internationalCode = "USD";
    String name = "American dollar";
    Double course = 0.39;
    Double multiplicity = 1.43;

    @Override
    public double countPrice(double price) {
        return price * course * multiplicity;
    }
}
