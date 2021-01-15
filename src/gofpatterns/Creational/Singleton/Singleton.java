package gofpatterns.Creational.Singleton;

public class Singleton {
    public static void main(String[] args) {
        PreferencesAsSingleton.getInstance().helloSingleton();

        PreferencesAsSingleton.getInstance().helloSingleton();

        /*
        мы можем наследоваться от нашего класса синглтон,
        при этом будет создан только 1 экземпляр класса в любом случае
         */
        MyPreferences.getInstance().helloSingleton();
    }
}

class PreferencesAsSingleton {
    // переменная для хранения 1го экземплара синглтона
    private static PreferencesAsSingleton instance = null;

    /**
     *  No other class can instantiate a singleton
     */
    protected PreferencesAsSingleton(){}

    /**
     * Create a singleton instance
     *
     * Use synchronized to allow one instance when using multiple threads
     */
    private synchronized static void createInstance(){
        if (instance == null) instance = new PreferencesAsSingleton();
    }

    /**
     * Access method to get hold of singleton instance
     * @return the one singleton instance
     */
    public static PreferencesAsSingleton getInstance(){
        if (instance == null) createInstance();
        return instance;
    }

    public void helloSingleton(){
        System.out.println("Hello I'm singleton!");
    }
}
