package part1.gofpatterns.Structural.Composite.Problem;

public class Client {
    public static void main(String[] args) {
    GraphicItemGroup group = new GraphicItemGroup();

    group.getLines().add(new Line());
    group.getLines().add(new Line());
    group.getLines().add(new Line());
    group.getLines().add(new Line());

    group.getRectangulars().add(new Rectangle());
    group.getRectangulars().add(new Rectangle());
    group.getRectangulars().add(new Rectangle());
    group.getRectangulars().add(new Rectangle());

    group.draw();

    }
}
