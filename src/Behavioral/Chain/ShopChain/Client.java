package Behavioral.Chain.ShopChain;

public class Client {
    public static void main(String[] args) {
        PaymentCheckOutHandler paymentCheckOutHandler = new PaymentCheckOutHandler();
        CustomerInfoCheckoutHandle customerInfoCheckoutHandle = new CustomerInfoCheckoutHandle();

        paymentCheckOutHandler.setNextHandler(customerInfoCheckoutHandle);
        paymentCheckOutHandler.handlerCheckout();

    }
}
