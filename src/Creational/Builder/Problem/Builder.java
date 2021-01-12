package Creational.Builder.Problem;

import Creational.Builder.OtherExample.Cms;
import Creational.Builder.OtherExample.Website;

public class Builder {
    public static void main(String[] args) {
        Website website = new Website();

        website.setName("visit card");
        website.setCms(Cms.WORDPRESS);
        website.setPrice(100);

        System.out.println(website);
    }
}
