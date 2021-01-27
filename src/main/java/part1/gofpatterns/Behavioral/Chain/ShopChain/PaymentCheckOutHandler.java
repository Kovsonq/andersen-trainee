package part1.gofpatterns.Behavioral.Chain.ShopChain;

public class PaymentCheckOutHandler extends CheckOutHandler {
    @Override
    public void handlerCheckout() {
        System.out.println("Handling payment of the customer");

        if (nextHandler != null){
            nextHandler.handlerCheckout();
        }
    }
}
