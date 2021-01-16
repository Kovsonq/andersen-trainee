package gofpatterns.AdiitionalPattern.IoС.problem;

public class ImageService {

    // problem here - we chose certain fileSystem
    private FileSystem fileSystem = new UnixFileSystem();

    public String readImage(){
        return fileSystem.readFile();
    }

    public static void main(String[] args) {
        ImageService service = new ImageService();
        System.out.println(service.readImage());
    }
}
