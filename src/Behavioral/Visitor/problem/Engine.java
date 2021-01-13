package Behavioral.Visitor.problem;

public class Engine extends CarPart {

    @Override
    void print() {
        System.out.println("Engine");
    }

    @Override
    void render() {
        System.out.println("Render Engine");
    }

    @Override
    void upgrade() {
        System.out.println("Update Engine");
    }

}
