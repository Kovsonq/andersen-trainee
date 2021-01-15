package gofpatterns.Structural.Bridge.solution;

public class DirectXWindowImpl extends WindowImpl {
    @Override
    public void draw(int x, int y, int width, int height, String colour) {
        System.out.println("DirectX x: " + x + " y:" + y + " width: " + width + " height: " + height + " colour: " + colour);

    }
}
