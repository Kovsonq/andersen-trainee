package Behavioral.Visitor.solving;

public class PrintCarPartVisitor implements CarPartVisitor {

    @Override
    public void visit(CarPart carPart) {
        System.out.println("Print" + carPart);
    }
}
