package gofpatterns.Creational.Builder.OtherExample;

public class EnterpriseWebsiteBuilder  extends WebsiteBuilder {
    @Override
    void buildName() {
        website.setName("Enterprise");
    }

    @Override
    void buildCms() {
        website.setCms(Cms.WORDPRESS);
    }

    @Override
    void buildPrice() {
        website.setPrice(200);
    }
}
