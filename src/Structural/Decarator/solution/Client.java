package Structural.Decarator.solution;

public class Client {
    public static void main(String[] args) {

        Window window = new Window();
        IconWindowDecorator iconWindowDecorator = new IconWindowDecorator(window);
        ScrollbarWindowDecorator scrollbarWindowDecorator = new ScrollbarWindowDecorator(iconWindowDecorator);
        scrollbarWindowDecorator.draw();

        Window window1 = new ScrollbarWindowDecorator(new Window());
        window1.draw();

    }
}
