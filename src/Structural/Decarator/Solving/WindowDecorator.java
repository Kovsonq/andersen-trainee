package Structural.Decarator.Solving;



public class WindowDecorator extends Window {
    protected Window window;

    public WindowDecorator(Window window) {
        this.window = window;
    }

    @Override
    public void draw() {
        super.draw();
    }
}
