package gofpatterns.Behavioral.Chain.ShopChain;

public class CustomerInfoCheckoutHandle extends CheckOutHandler {
    @Override
    public void handlerCheckout() {
        System.out.println("Adding extra info to checkout of the customer");

        if (nextHandler != null){
            nextHandler.handlerCheckout();
        }
    }
}
