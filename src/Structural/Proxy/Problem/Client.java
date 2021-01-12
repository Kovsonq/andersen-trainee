package Structural.Proxy.Problem;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Image image1 = new Image("test 1");
        Image image2 = new Image("test 2");

        List<Image> images = new ArrayList<>();
        images.add(image1);
        images.add(image2);

        App app = new App(images);

        System.out.println("Setup App");

        app.draw();
    }
}
