package gofpatterns.Creational.Prototype.Solution;

public class GraphiTool {
    private Graphic prototype;

    public GraphiTool(Graphic prototype) {
        this.prototype = prototype;
    }

    protected Graphic createGraphic(){
        return prototype.clone();
    }
}
