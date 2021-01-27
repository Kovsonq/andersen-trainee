package part1.gofpatterns.Behavioral.Visitor.problem;

public class Wheel extends CarPart {
    @Override
    void print() {
        System.out.println("wheel");
    }

    @Override
    void render() {
        System.out.println("Render wheel");
    }

    @Override
    void upgrade() {
        System.out.println("Upgrade wheel");
    }
}
