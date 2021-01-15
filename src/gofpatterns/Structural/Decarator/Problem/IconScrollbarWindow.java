package gofpatterns.Structural.Decarator.Problem;

public class IconScrollbarWindow extends Window {
    @Override
    public void draw() {
        System.out.println("Draw Icon");
        System.out.println("Draw Scroll");
        super.draw();
    }
}
