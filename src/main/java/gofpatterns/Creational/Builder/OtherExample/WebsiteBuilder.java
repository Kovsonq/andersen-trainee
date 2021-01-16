package gofpatterns.Creational.Builder.OtherExample;

/**
 * His aim is to create website we need
 */
public abstract class WebsiteBuilder {
    Website website;

    void createWebsite(){
        website = new Website();
    }

    abstract void buildName();
    abstract void buildCms();
    abstract void buildPrice();

    Website getWebsite(){
        return website;
    }
}
