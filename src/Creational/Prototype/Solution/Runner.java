package Creational.Prototype.Solution;

public class Runner {
    public static void main(String[] args) {
        Image image = new Image();
        image.setUrl("http://test.com");

        GraphiTool tool = new GraphiTool(image);


        Graphic graphic = tool.createGraphic();
        System.out.println(graphic.getUrl());
        System.out.println(graphic.getClass());

        Video video = new Video();
        video.setUrl("http://test.video");

        tool = new GraphiTool(video);
        graphic = tool.createGraphic();
        System.out.println(graphic.getUrl());
        System.out.println(graphic.getClass());
    }
}
