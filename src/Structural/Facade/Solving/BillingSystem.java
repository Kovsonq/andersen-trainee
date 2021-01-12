package Structural.Facade.Solving;

public class BillingSystem {
    public Bill createBill(Integer amount){
        return new Bill(amount);
    }
}
