package part1.gofpatterns.Behavioral.Visitor.solution;

public abstract class CarPart {
void acceptCarPartVisitor(CarPartVisitor visitor){
    visitor.visit(this);
}
}
