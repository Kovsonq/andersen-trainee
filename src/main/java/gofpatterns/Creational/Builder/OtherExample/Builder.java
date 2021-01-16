package gofpatterns.Creational.Builder.OtherExample;

import gofpatterns.Creational.Builder.OtherExample.Cms;
import gofpatterns.Creational.Builder.OtherExample.Website;

public class Builder {
    public static void main(String[] args) {
        Website website = new Website();

        website.setName("visit card");
        website.setCms(Cms.WORDPRESS);
        website.setPrice(100);

        System.out.println(website);
    }
}
