package Behavioral.Memento.ProjectGithub;

public class SaveProjectRunner {
    public static void main(String[] args) {
        Project project = new Project();
        GitHubRepo gitHubRepo = new GitHubRepo();

        System.out.println("Creatin new project ver 1");
        project.setVersionAndDate("version 1");

        System.out.println(project);
        System.out.println("\n");

        System.out.println("Saving current version to github");
        gitHubRepo.setSave(project.save());

        System.out.println("Updating project to ver1");

        System.out.println("Writing poor code...");
        project.setVersionAndDate("Version 1.1");

        System.out.println(project);
        System.out.println("\n");


        System.out.println("smth went wrong");
        System.out.println("roling back");

        project.load(gitHubRepo.getSave());

        System.out.println("Project after rollback");
        System.out.println(project);
    }
}
