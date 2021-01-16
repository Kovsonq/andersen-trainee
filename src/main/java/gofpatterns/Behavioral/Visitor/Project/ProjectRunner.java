package gofpatterns.Behavioral.Visitor.Project;

public class ProjectRunner {
    public static void main(String[] args) {
        Project project = new Project();

        Developer junior = new JuniorDeveloper();
        Developer senior = new SeniorDeveloper();

        System.out.println("June");
        project.beWritten(junior);

        System.out.println("Senior");
        project.beWritten(senior);
    }
}
