package AdiitionalPattern.IoС.solution;

public class ImageService {

    // problem here - we chose certain fileSystem
    private FileSystem fileSystem;

    public String readImage(){
        return fileSystem.readFile();
    }

    public void setFileSystem(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

//    public static void main(String[] args) {
//        ImageService service = new ImageService();
//        System.out.println(service.readImage());
//    }
}
