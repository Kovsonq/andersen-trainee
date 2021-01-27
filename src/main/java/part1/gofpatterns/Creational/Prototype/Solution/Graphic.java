package part1.gofpatterns.Creational.Prototype.Solution;

public abstract class Graphic {
    private String url;

    public abstract Graphic clone();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
