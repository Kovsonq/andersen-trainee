package part1.gofpatterns.Behavioral.Visitor.solution;

public class RenderCarPartVisitor implements CarPartVisitor {

    @Override
    public void visit(CarPart carPart) {
        System.out.println("Render" + carPart);
    }
}
