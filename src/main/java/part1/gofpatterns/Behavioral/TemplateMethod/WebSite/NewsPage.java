package part1.gofpatterns.Behavioral.TemplateMethod.WebSite;

public class NewsPage extends WebsiteTemplate {

    @Override
    public void showPageContent() {
        System.out.println("News");
    }
}
