package part1.gofpatterns.Creational.Builder.OtherExample;

public class Builder {
    public static void main(String[] args) {
        Website website = new Website();

        website.setName("visit card");
        website.setCms(Cms.WORDPRESS);
        website.setPrice(100);

        System.out.println(website);
    }
}
