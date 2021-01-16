package gofpatterns.Structural.Composite.Problem;

import java.util.ArrayList;
import java.util.List;

public class GraphicItemGroup {
    private List<Line> lines = new ArrayList<>();

    private List<Rectangle> rectangulars = new ArrayList<>();

    public List<Line> getLines() {
        return lines;
    }

    public List<Rectangle> getRectangulars() {
        return rectangulars;
    }

    public void draw(){
        for (Line line : lines) {
            line.draw();
        }
        for (Rectangle rec : rectangulars){
            rec.draw();
        }
    }
}
