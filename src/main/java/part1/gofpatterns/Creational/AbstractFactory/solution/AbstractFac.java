package part1.gofpatterns.Creational.AbstractFactory.solution;



public class AbstractFac {
    public static void main(String[] args) {
        WidgetFactory factory = new YellowThemeWidgetFactory();
        initializeGui(factory);
        factory = new PinkThemeWidgetFactory();
        initializeGui(factory);

    }

    public static void initializeGui(WidgetFactory factory){
        initializeGui(factory.createScrollBar(),factory.createWindow());
    }

    public static void initializeGui(ScrollBar scrollBar, Window window){
        System.out.println("DO init with" + scrollBar.getClass().getName() +
                " and " + window.getClass().getName());
    }

}
