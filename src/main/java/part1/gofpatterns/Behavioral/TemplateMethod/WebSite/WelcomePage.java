package part1.gofpatterns.Behavioral.TemplateMethod.WebSite;


public class WelcomePage extends WebsiteTemplate {

    @Override
    public void showPageContent() {
        System.out.println("Welcome");
    }
}
