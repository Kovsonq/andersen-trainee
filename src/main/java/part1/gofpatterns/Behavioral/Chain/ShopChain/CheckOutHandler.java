package part1.gofpatterns.Behavioral.Chain.ShopChain;

public abstract class CheckOutHandler {
    protected CheckOutHandler nextHandler;

    public abstract void handlerCheckout();

    public void setNextHandler(CheckOutHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
