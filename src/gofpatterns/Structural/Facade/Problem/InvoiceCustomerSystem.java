package gofpatterns.Structural.Facade.Problem;

public class InvoiceCustomerSystem {
    public void createInvoiceForBill(Bill bill){
        System.out.println("Creating invoid for bill with amount: " + bill.getAmount());
    }
}
