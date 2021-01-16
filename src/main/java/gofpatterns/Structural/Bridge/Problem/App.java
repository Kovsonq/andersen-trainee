package gofpatterns.Structural.Bridge.Problem;


public class App {
    public static void main(String[] args) {
        Window iconWindow = new DirectXIconWindow();
        iconWindow.draw(0,0,10,10,"white");
        Window iconWindow2 = new LinuxIconWindow();
        iconWindow2.draw(0,0,10,10,"black");
        Window iconWindow3 = new DirectXWindow();
        iconWindow3.draw(0,0,10,10,"white");
        Window iconWindow4 = new LinuxWindow();
        iconWindow4.draw(0,0,10,10,"black");
    }
}
