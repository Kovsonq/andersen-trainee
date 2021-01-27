package part1.gofpatterns.Structural.Bridge.Problem;

public class LinuxIconWindow implements Window {
    @Override
    public void draw(int x, int y, int width, int height, String colour) {
        System.out.println("Linux x: " + x + " y:" + y + " width: " + width + " height: " + height);
    }

    public void drawIcon(){
        draw(0,0,10,10,"white");
        draw(0,10,10,10,"Black");
    }
}
