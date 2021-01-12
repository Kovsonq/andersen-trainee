package Creational.Builder.OtherExample;

public class VisitCardWebsiteBuilder extends WebsiteBuilder {
    @Override
    void buildName() {
        website.setName("VisitCard");
    }

    @Override
    void buildCms() {
        website.setCms(Cms.OTHERPRESS);
    }

    @Override
    void buildPrice() {
        website.setPrice(100);
    }
}
