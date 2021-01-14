package Structural.Decarator.solution;

public class ScrollbarWindowDecorator extends WindowDecorator {
    public ScrollbarWindowDecorator(Window window) {
        super(window);
    }

    @Override
    public void draw() {
        System.out.println("Draw scrollbar");
        window.draw();
    }
}
