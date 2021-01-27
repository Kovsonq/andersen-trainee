package part1.gofpatterns.Behavioral.Visitor.solution;

public class PrintCarPartVisitor implements CarPartVisitor {

    @Override
    public void visit(CarPart carPart) {
        System.out.println("Print" + carPart);
    }
}
