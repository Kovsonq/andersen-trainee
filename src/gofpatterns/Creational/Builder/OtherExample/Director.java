package gofpatterns.Creational.Builder.OtherExample;

// This class accept which website exactly we will create.
public class Director {
    WebsiteBuilder builder;

    public  void setBuilder(WebsiteBuilder builder){
        this.builder = builder;
    }

    Website buildWebsite(){
        builder.createWebsite();
        builder.buildName();
        builder.buildCms();
        builder.buildPrice();

        Website website = builder.getWebsite();
        return  website;
    }

}
