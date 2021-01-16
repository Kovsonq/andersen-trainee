package gofpatterns.Structural.Proxy.solution;

import java.util.ArrayList;
import java.util.List;

public class App {
    private List<Image> images = new ArrayList<>();

    public App(List<Image> images) {
        this.images = images;
    }

    public void draw(){
        for (Image image : images){
            image.draw();
        }
    }
}
