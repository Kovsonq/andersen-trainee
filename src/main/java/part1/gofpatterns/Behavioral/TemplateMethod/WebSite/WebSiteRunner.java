package part1.gofpatterns.Behavioral.TemplateMethod.WebSite;

public class WebSiteRunner {
    public static void main(String[] args) {
        WebsiteTemplate welcomePage = new WelcomePage();
        WebsiteTemplate newsPage = new NewsPage();

        welcomePage.showPage();

        System.out.println("----------------------");

        newsPage.showPage();
    }
}
