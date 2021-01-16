package gofpatterns.Behavioral.Visitor.Project;

public class SeniorDeveloper implements Developer {
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Write good code...");
    }

    @Override
    public void create(Database database) {
        System.out.println("Up database...");
    }

    @Override
    public void create(Test test) {
        System.out.println("Reliable test...");
    }
}
