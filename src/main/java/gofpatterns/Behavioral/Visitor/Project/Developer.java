package gofpatterns.Behavioral.Visitor.Project;

public interface Developer {
    void create(ProjectClass projectClass);
    void create(Database database);
    void create(Test test);
}
