package part1.gofpatterns.Structural.Composite.solution;


public class Client {
    public static void main(String[] args) {
        Line line = new Line();
        Rectangle rectangle = new Rectangle();

        GraphicItemGroup group = new GraphicItemGroup();

        group.getGraphics().add(line);
        group.getGraphics().add(new Line());
        group.getGraphics().add(rectangle);

        group.draw();

    }
}
