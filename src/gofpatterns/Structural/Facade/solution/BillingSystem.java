package gofpatterns.Structural.Facade.solution;

public class BillingSystem {
    public Bill createBill(Integer amount){
        return new Bill(amount);
    }
}
