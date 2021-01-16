package gofpatterns.Structural.Facade.Problem;

public class Bill {
    private Integer amount;

    public Bill(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }
}
