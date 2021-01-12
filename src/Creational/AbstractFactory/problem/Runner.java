package Creational.AbstractFactory.problem;

public class Runner {
    public static void main(String[] args) {
        ScrollBar bar = new YellowThemeScrollBar();
        Window window = new YellowThemeWindow();
        initializeGUI(bar,window);

        bar = new YellowThemeScrollBar();
        window = new PinkThemeWindow();
        initializeGUI(bar, window);
    }

    public static void initializeGUI(ScrollBar bar, Window window){
        System.out.println("Do initialize" + bar.getClass() + " and " + window.getClass());
    }
}
