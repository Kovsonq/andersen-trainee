package part1.gofpatterns.Creational.Prototype.Solution;

public class Image extends Graphic {
    private String url;

    @Override
    public Graphic clone() {
        Image clone = new Image();
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
