package Structural.Bridge.Problem;

public class LinuxWindow implements Window {
    @Override
    public void draw(int x, int y, int width, int height, String colour) {
        System.out.println("Linux x: " + x + " y:" + y + " width: " + width + " height: " + height);
    }
}
