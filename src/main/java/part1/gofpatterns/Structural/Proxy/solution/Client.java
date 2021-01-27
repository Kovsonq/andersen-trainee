package part1.gofpatterns.Structural.Proxy.solution;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        ImageProxy image1 = new ImageProxy("test 1");
        ImageProxy image2 = new ImageProxy("test 2");



        List<Image> images = new ArrayList<>();
        images.add(image1);
        images.add(image2);

        App app = new App(images);

        System.out.println("Setup App");

        app.draw();
    }
}
