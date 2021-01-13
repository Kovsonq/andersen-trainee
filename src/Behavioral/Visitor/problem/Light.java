package Behavioral.Visitor.problem;

public class Light extends CarPart {
    @Override
    void print() {
        System.out.println("Light");
    }

    @Override
    void render() {
        System.out.println("Render Light");
    }

    @Override
    void upgrade() {
        System.out.println("Upgrade Light");
    }
}
