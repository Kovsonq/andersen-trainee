package gofpatterns.Creational.Prototype.Solution;

public class Video extends Graphic {

    private String url;

    @Override
    public Graphic clone() {
        Video clone = new Video();
        clone.setUrl(this.url);
        return clone;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
