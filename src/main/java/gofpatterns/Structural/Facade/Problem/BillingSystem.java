package gofpatterns.Structural.Facade.Problem;

public class BillingSystem {
    public Bill createBill(Integer amount){
        return new Bill(amount);
    }
}
