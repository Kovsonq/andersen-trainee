package gofpatterns.AdiitionalPattern.IoС.solution;

public class Container {
    private ImageService imageService;

    // here is IoC - method create imageService and inject fileSystem in it
    public void init(){
        imageService = new ImageService();
        imageService.setFileSystem(new WindowsFileSystem());
    }

    public ImageService getImageService(){ return imageService; }

    public static void main(String[] args) {
        Container container = new Container();
        container.init();

        ImageService imageService = container.getImageService();
        System.out.println(imageService.readImage());
    }
}
