package part1.gofpatterns.Structural.Bridge.Problem;

public class DirectXWindow implements Window {
    @Override
    public void draw(int x, int y, int width, int height, String colour) {
        System.out.println("DirectX x: " + x + " y:" + y + " width: " + width + " height: " + height);

    }
}
